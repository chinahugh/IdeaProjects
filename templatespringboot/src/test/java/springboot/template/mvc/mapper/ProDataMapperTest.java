package springboot.template.mvc.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.com.mvc.entity.ProData;
import springboot.com.mvc.mapper.ProDataMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/8/4
 * @Description ProDataMapperTest
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProDataMapperTest {
    @Resource
    private ProDataMapper proDataMapper;

    @Test
    public ProData get() {
        System.out.println(net.sf.json.JSONArray.fromObject(proDataMapper.get("1")));
        return null;
    }

    @Test
    public ProData select() {
        return null;
    }

    @Test
    public int deleteByKey() {
        return 0;
    }

    @Test
    public int insert() {
        return 0;
    }

    @Test
    public int update() {
        return 0;
    }

    @Test
    public List<ProData> list() {
        return null;
    }
}
