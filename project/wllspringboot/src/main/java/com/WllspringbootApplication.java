package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.wll.pro.dao")  //扫描dao包位置
@EnableScheduling
@EnableCaching
public class WllspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WllspringbootApplication.class, args);
	}
}
