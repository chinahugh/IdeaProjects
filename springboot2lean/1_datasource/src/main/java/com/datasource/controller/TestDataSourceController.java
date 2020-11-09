package com.datasource.controller;

import com.datasource.common.Page;
import com.datasource.common.R;
import com.datasource.entity.User;
import com.datasource.service.TestDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author HGH
 */
@RestController
public class TestDataSourceController {
    @Autowired
    private TestDataSource testDataSource;

    @PostMapping("/test")
    public R test(@RequestBody Page page, User user) {
        System.out.println("user = " + user);
        return testDataSource.test(page);
    }
}
