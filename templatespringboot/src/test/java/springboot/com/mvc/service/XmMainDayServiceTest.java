package springboot.com.mvc.service;

import com.github.pagehelper.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.com.mvc.entity.XmMainDay;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmMainDayServiceTest {
    @Autowired
    private XmMainDayService xmMainDayService;
    @Autowired
    private XmMainMonthService xmMainMonthService;

    @Test
    public void get() throws Exception {
        System.out.println(xmMainDayService.get("1"));
        System.out.println(xmMainMonthService.get("1"));
    }

    @Test
    public void select() throws Exception {
    }

    @Test
    public void deleteByKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        XmMainDay xmMainDay = xmMainDayService.get("fcf5d991930e48898e973c984a745de2");
        xmMainDayService.update(xmMainDay);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void list() throws Exception {
        List<XmMainDay> list = xmMainDayService.list(new XmMainDay(), new Page<>()).getList();
        int i = 0;
        for (XmMainDay xd : list) {

xmMainDayService.update(xd);
        }
        System.out.println();
    }

    @Test
    public void list1() throws Exception {
    }
}