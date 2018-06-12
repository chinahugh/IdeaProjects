package springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("springboot.**.mapper")  //扫描dao包位置
//@EnableScheduling //定时任务
public class TemplatespringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplatespringbootApplication.class, args);
	}
}
