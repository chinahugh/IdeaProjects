package springboot.com.mvc.service;

import com.github.pagehelper.Page;
//import net.sf.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.com.mvc.entity.XmMainMonth;
import springboot.template.global.util.UUIDUtils;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmMainMonthServiceTest {
    @Resource
    private XmMainMonthService xmMainMonthService;



    @Test
    public void select() throws Exception {
    }

    @Test
    public void deleteByKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        XmMainMonth xmMainMonth = new XmMainMonth(UUIDUtils.getUUid());
        xmMainMonth.setUserId("1");
        xmMainMonth.setSysMonth(2);
        xmMainMonth.setSysYear(2);
        xmMainMonthService.insert(xmMainMonth);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void list() throws Exception {
        XmMainMonth xmMainMonth = new XmMainMonth();
        xmMainMonth.setUserId("1");
//        xmMainMonth.setIsDisable(null);
        List<XmMainMonth> list = xmMainMonthService.list(xmMainMonth,new Page<>()).getList();
//        System.out.println(JSONArray.fromObject(list));
    }

    @Test
    public void list1() throws Exception {
    }
}