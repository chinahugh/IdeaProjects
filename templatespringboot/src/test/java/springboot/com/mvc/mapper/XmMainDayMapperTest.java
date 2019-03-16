package springboot.com.mvc.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.com.mvc.entity.MapperParameterType;
import springboot.com.mvc.entity.MapperResultType;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmMainDayMapperTest {
    @Resource
    private XmMainDayMapper xmMainDayMapper;
    @Test
    public void count() {
        MapperParameterType mapperParameterType = new MapperParameterType();
        mapperParameterType.setmTag(new int[]{0,1,2});
        mapperParameterType.setpTag(new int[]{0,1,2});
        mapperParameterType.setSysMonth(1);
        mapperParameterType.setSysYear(2018);
        List<MapperResultType> count = xmMainDayMapper.count(mapperParameterType);

       count.forEach(System.out::println);
    }
}