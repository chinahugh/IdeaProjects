package springboot.template.mvc.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.template.mvc.entity.SysDict;
import springboot.template.mvc.service.SysDictService;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SysDictServiceImplTest {
    @Resource
    private SysDictService sysDictService;
    @Test
    public void get() throws Exception {
    }

    @Test
    public void select() throws Exception {
    }

    @Test
    public void deleteByKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void list() throws Exception {
        SysDict sysDict = new SysDict();
//        sysDict.setType("1");
        List<SysDict> list = sysDictService.list(sysDict);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setName("打卡标识");
            sysDictService.update( list.get(i));
        }
    }

    @Test
    public void list1() throws Exception {
    }
}