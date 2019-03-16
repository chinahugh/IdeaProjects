package springboot.com.mvc.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import springboot.template.global.exception.EN;
import springboot.template.global.exception.ServiceException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author HUGH
 * @Date 2019/1/11 22:26
 * @Description UpLoadExcelUtils
 */
public class UpLoadExcelUtils {
    Logger logger = LoggerFactory.getLogger(UpLoadExcelUtils.class);
    @Value("${myconfig.sheet.sheetPage:0}")
    private int sheetPage;
    @Value("${myconfig.sheet.startRow:0}")
    private static int startRow;
    private int noidRow = 3;
    private int nameRow = 11;
    public static String xls = "xls";
    public static String xlsx = "xlsx";

    public static void list(Sheet sheetAt,int startRow ,List<String[]> list) {
        //获得当前sheet的开始行
        int firstRowNum = sheetAt.getFirstRowNum();
        //获得当前sheet的结束行
        int lastRowNum = sheetAt.getLastRowNum();
        //循环除了第一行的所有行
        for (int rowNum = startRow; rowNum <= lastRowNum; rowNum++) {
            //获得当前行
            Row row = sheetAt.getRow(rowNum);
            if (row == null) {
                continue;
            }
            //获得当前行的开始列
            int firstCellNum = row.getFirstCellNum();
            //获得当前行的列数
            int lastCellNum = row.getPhysicalNumberOfCells();
            String[] cells = new String[row.getPhysicalNumberOfCells()];
            //循环当前行
            for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                Cell cell = row.getCell(cellNum);
                cells[cellNum] = getCellValue(cell);

            }
            list.add(cells);
        }
    }

    private static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    public static Workbook getWorkBook(MultipartFile uploadfile) {
        Workbook workbook = null;
        String originalFilename = uploadfile.getOriginalFilename();
        try {
            InputStream is = uploadfile.getInputStream();
            if (originalFilename != null && !"".equals(originalFilename)) {
                //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
                if (originalFilename.endsWith(xls)) {
                    //2003
                    workbook = new HSSFWorkbook(is);
                } else if (originalFilename.endsWith(xlsx)) {
                    //2007
                    workbook = new XSSFWorkbook(is);
                }
            }
        } catch (IOException e) {
           throw  new ServiceException(EN.UP_LOAD_FILE_FAIL,e);
        }
        return workbook;
    }
}
