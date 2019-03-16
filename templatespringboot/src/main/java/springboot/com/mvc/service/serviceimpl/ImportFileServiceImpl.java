package springboot.com.mvc.service.serviceimpl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import springboot.com.mvc.entity.XmMainDay;
import springboot.com.mvc.entity.XmMainMonth;
import springboot.com.mvc.service.ImportFileService;
import springboot.com.mvc.service.XmMainDayService;
import springboot.com.mvc.service.XmMainMonthService;
import springboot.com.mvc.util.TimeTagUtils;
import springboot.com.mvc.util.UpLoadExcelUtils;
import springboot.template.global.exception.ServiceException;
import springboot.template.mvc.entity.SysDepartment;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.service.SysDepartmentService;
import springboot.template.mvc.service.UserInfoService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HUGH
 * @Date 2019/1/9 22:45
 * @Description ImportFileServiceImpl
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class ImportFileServiceImpl implements ImportFileService {
    Logger logger = LoggerFactory.getLogger(ImportFileServiceImpl.class);
    @Resource
    private XmMainDayService xmMainDayService;
    @Resource
    private XmMainMonthService xmMainMonthService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private SysDepartmentService sysDepartmentService;
    @Value("${myconfig.excel.sheetPage:3}")
    private int sheetPage;
    @Value("${myconfig.excel.startRow:4}")
    private int startRow;
    @Value("${myconfig.excel.keySet:考勤时间:3,姓名：5,工号:9}")
    private String keySet;
    private int noIDRow = 2;
    private int nameRow = 10;
    private int departmentRow = 20;
    private int cqDateRow = 2;

    /**
     * 上传考勤数据文件处理
     *
     * @param uploadfile
     */
    @Override
    public void importFile(MultipartFile uploadfile) {
        Workbook workBook = UpLoadExcelUtils.getWorkBook(uploadfile);
        Sheet sheetAt = workBook.getSheetAt(sheetPage);
        List<String[]> list = new ArrayList<>();
        UpLoadExcelUtils.list(sheetAt, startRow, list);
        //  list.forEach(x -> System.out.println(Arrays.toString(x)));
        int length = list.get(0).length;
        Row row = sheetAt.getRow(2);
        Cell cell = row.getCell(cqDateRow);
        String[] date = cell.getStringCellValue().split("[-]");
        int sysYear = Integer.parseInt(date[0]);
        int sysMonth = Integer.parseInt(date[1]);
        for (int i = 0; i < list.size(); i++) {
            //月数据处理
            String[] person = list.get(i);
            //System.out.println(Arrays.toString(person) + " " + Arrays.toString(cqData));
            String name = person[nameRow];
            String noID = person[noIDRow];
            String department = person[departmentRow];
            UserInfo userInfo = new UserInfo();
            userInfo.setIsDisable(null);
            userInfo.setName(name);
            userInfo.setNoId(Integer.parseInt(noID));
            UserInfo user = userInfoService.select(userInfo);
            XmMainMonth xmMainMonth = new XmMainMonth();
            xmMainMonth.setUserId(user.getId());//TODO 空指针异常
            xmMainMonth.setSysYear(sysYear);
            xmMainMonth.setSysMonth(sysMonth);
            System.out.println(xmMainMonth);
            xmMainMonthService.insert(xmMainMonth);
            //考情数据处理
            String[] cqData = list.get(++i);
            for (int j = 0; j < cqData.length; j++) {
                if (cqData[j] != null) {
                    String[] cqDatum = TimeTagUtils.decomposition(cqData[j].trim());
                    if (cqDatum != null) {
                        XmMainDay xmMainDay = new XmMainDay();
                        xmMainDay.setMainMonthId(xmMainMonth.getId());
                        xmMainDay.setSysDay(j + 1);
                        xmMainDay.setmData(cqDatum[0]);
                        xmMainDay.setpData(cqDatum[1]);

                        xmMainDayService.insert(xmMainDay);
                    }
                }

            }
        }
    }

    /**
     * 上传用户列表
     *
     * @param file
     */
    @Override
    public void importPerson(MultipartFile file) {
        int startRow = 3;
        //excel中名字第几列
        int nameCom = 1;
        //excel中员工编号第几列
        int noIDRow = 0;
        //excel中，部门名称第几列
        int deptRow = 2;
        Workbook workBook = UpLoadExcelUtils.getWorkBook(file);
        Sheet sheetAt = workBook.getSheetAt(0);
        List<String[]> list = new ArrayList<>();
        UpLoadExcelUtils.list(sheetAt, startRow, list);
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfos = new UserInfo();
            userInfos.setName(list.get(i)[nameCom]);
            userInfos.setUserPassword("123456");
            userInfos.setUserName("fsdz"+list.get(i)[noIDRow]);
            userInfos.setNoId(Integer.parseInt(list.get(i)[noIDRow]));
            SysDepartment sysDepartment = new SysDepartment();
            sysDepartment.setDepartmentName(list.get(i)[deptRow]);
            SysDepartment select = sysDepartmentService.select(sysDepartment);
            if (select != null) {
                userInfos.setDepartmentId(select.getId());
            } else {
                userInfos.setDepartmentId("0");
            }
            userInfoService.insert(userInfos);
        }
    }
}
