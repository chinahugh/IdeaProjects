package com.datasource.controller;

import com.datasource.common.Page;
import com.datasource.common.R;
import com.datasource.entity.Testdatasource;
import com.datasource.service.TestDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping(path = "/test")//,headers={"application/json;charset=utf-8"}
    public R test(@RequestBody Page page, Testdatasource user) {
        //Page page, @RequestBody Testdatasource user
//        System.out.println("user = " + o);
        return testDataSource.test(page);
//        return R.ok();
    }
    @GetMapping(value = "/test2",headers= {"Content-Type=application/json;charset=utf-8"})
    public R test2(Page page, Testdatasource user) {
        System.out.println("user = " + user);
        return testDataSource.test(page,user);
    }
}
