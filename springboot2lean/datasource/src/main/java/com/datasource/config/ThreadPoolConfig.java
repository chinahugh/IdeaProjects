package com.datasource.config;

import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;

@Configuration
public class ThreadPoolConfig {
//    @Autowired
    ExecutorService executorService;


    public ThreadPoolConfig() {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("--------------------------");
        System.out.println(executorService);
        System.out.println("--------------------------");
    }

}
