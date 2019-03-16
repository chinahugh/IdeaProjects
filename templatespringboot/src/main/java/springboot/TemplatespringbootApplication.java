package springboot;

import com.didispace.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
@MapperScan(basePackages = {"springboot.template.mvc.mapper.base", "springboot.com.mvc.mapper"})  //扫描mapper包位置
/**@EnableScheduling //定时任务*/
public class TemplatespringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(TemplatespringbootApplication.class, args);
    }
}
