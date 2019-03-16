package springboot.com.mvc.service;

import com.github.pagehelper.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.com.mvc.entity.XmMainDay;
import springboot.template.global.util.UUIDUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmMainDayServiceTest {
    @Resource
    private XmMainDayService xmMainDayService;
    @Resource
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
        XmMainDay xmMainDay = new XmMainDay();
//        xmMainDay.setIsDisable(1);
        List<XmMainDay> list = xmMainDayService.list(xmMainDay, new Page<>()).getList();

        Set<XmMainDay> set=new HashSet<>(list);
//        list.stream().forEach(x->xmMainDayService.deleteByKey(x.getId()));
        for (XmMainDay xd : set) {
            xd.setId(UUIDUtils.getUUid());
            xd.setMainMonthId("14f8f2cc10904c3fb200b67060a01ac82");
            xmMainDayService.insert(xd);
        }
        System.out.println(set.size());
    }

    @Test
    public void list1() throws Exception {
    }
}