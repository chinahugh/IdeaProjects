package springboot.template.mvc.mapper;

import net.sf.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.com.mvc.entity.ProData;
import springboot.com.mvc.entity.ProMain;
import springboot.com.mvc.mapper.ProMainMapper;
import springboot.template.global.util.UUIDUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/8/4
 * @Description ProMainMapperTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProMainMapperTest {
    @Resource
    private ProMainMapper proMainMapper;

    @Test
    public void get() {
        System.out.println(JSONArray.fromObject(proMainMapper.get("1")));

    }

    @Test
    public void select() {
        ProMain proMain = new ProMain();
        proMain.setIsDisable(0);
        proMain.setD1(new ProData("3"));
        proMain.setSort(3);
        proMain.setD2(new ProData("12"));
        proMain.setD3(new ProData("13"));
        proMain.setD4(new ProData("3"));
        System.out.println(JSONArray.fromObject(proMainMapper.select(proMain)));
    }

    @Test
    public void deleteByKey() {
        System.out.println(JSONArray.fromObject(proMainMapper.deleteByKey("2")));
    }

    @Test
    public void insert() {
        ProMain proMain = new ProMain(UUIDUtils.getUUid());
        proMain.setIsDisable(1);
        proMain.setUserId("123");
        proMain.setD1(new ProData("3"));
        proMain.setSort(3);
        proMain.setCreateTime(new Date());
        proMain.setYear(2018);
        proMain.setMonth(22);
        proMain.setDay(12);
        proMain.setD2(new ProData("12"));
        proMain.setD3(new ProData("13"));
        proMain.setD4(new ProData("3"));
        System.out.println(JSONArray.fromObject(proMainMapper.insert(proMain)));
    }

    @Test
    public void update() {
        ProMain proMain = new ProMain("14f8f2cc10904c3fb200b67060a01ac8");
        proMain.setIsDisable(1);
        proMain.setUserId("23112312312312312");
        proMain.setD1(new ProData("3"));
        proMain.setSort(3);
        proMain.setCreateTime(new Date());
        proMain.setYear(2018);
        proMain.setMonth(22);
        proMain.setDay(12);
        proMain.setD2(new ProData("12"));
        proMain.setD3(new ProData("13"));
        proMain.setD4(new ProData("3"));
        System.out.println(JSONArray.fromObject(proMainMapper.update(proMain)));
    }

    @Test
    public void list() {
        ProMain proMain = new ProMain();
        proMain.setIsDisable(1);
//        proMain.setUserId("123");
        proMain.setD1(new ProData("3"));
        proMain.setSort(3);
//        proMain.setCreateTime(new Date());
        proMain.setYear(2018);
        proMain.setMonth(22);
        proMain.setDay(12);
        proMain.setD2(new ProData("12"));
        proMain.setD3(new ProData("13"));
        proMain.setD4(new ProData("3"));
        System.out.println(JSONArray.fromObject(proMainMapper.list(proMain)));
    }
}
