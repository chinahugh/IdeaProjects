package com.datasource.dao;

import com.datasource.common.Page;
import com.datasource.entity.Testdatasource;
import com.datasource.service.TestDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class UserMapperTest {
    @Autowired
    private TestDataSource testDataSource;
  @Test
    public void test2() {
       Testdatasource user=new Testdatasource();
      Page page = new Page();
      user.setId(1);
      System.out.println(" = " + testDataSource.test(page,user));
    }
}