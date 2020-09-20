package com.datasource.controller;

import com.datasource.common.Page;
import com.datasource.common.R;
import com.datasource.service.TestDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDataSourceController {
    @Autowired
    private TestDataSource testDataSource;

    @GetMapping("/test")
    public R test(Page page) {
        System.out.println(page);
        return testDataSource.test(page);
    }
}
