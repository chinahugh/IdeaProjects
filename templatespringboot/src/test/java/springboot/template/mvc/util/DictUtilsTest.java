package springboot.template.mvc.util;

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
public class DictUtilsTest {
    @Resource
    private  SysDictService sysDictService;
    public static final String MAIN_DAY_TAG = "main_day_tag";

    @Test
    public void getpTags() {
        SysDict sysDict = new SysDict();
        sysDict.setType(MAIN_DAY_TAG);
        List<SysDict> list = sysDictService.list(sysDict);
        System.out.println(list.size());
    }
}