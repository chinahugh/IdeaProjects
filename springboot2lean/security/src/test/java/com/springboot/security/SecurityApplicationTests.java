package com.springboot.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootTest
class SecurityApplicationTests {

    //    @Test
//    void contextLoads() {
//    }
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement = connection
                .prepareStatement("select * from user where id='2'");
        ResultSet resultSet = prepareStatement.executeQuery();
        while (resultSet.next()) {
            String cityName = resultSet.getString("username");
            System.out.println(cityName);
        }
        Class<? extends Connection> aClass = dataSource.getConnection().getClass();
        System.out.println(aClass);
//        DruidDataSourceBuilder.create().build();
    }
    public void test(){
//        namedParameterJdbcTemplate.queryForObject();
//        jdbcTemplate.query();
//        PlatformTransactionManager

    }

}
