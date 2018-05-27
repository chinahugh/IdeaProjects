package com.wll.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * @Auther HUGH
 * @Date 2018/5/19
 * @Description test
 */
public class MyTest {

    @Autowired
    private DruidDataSource dataSource;

    @Test
    public void test() throws SQLException {
        DruidPooledConnection connection = dataSource.getConnection();
    }
}
