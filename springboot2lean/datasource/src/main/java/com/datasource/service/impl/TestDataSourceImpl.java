package com.datasource.service.impl;

import com.datasource.common.DB;
import com.datasource.common.Page;
import com.datasource.common.R;
import com.datasource.entity.User;
import com.datasource.service.TestDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class TestDataSourceImpl implements TestDataSource {
    Logger logger = LoggerFactory.getLogger(TestDataSource.class);
    @Autowired
    private DB db;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public R test(Page page) {
        RowMapper<User> rm = BeanPropertyRowMapper.newInstance(User.class);
        String sql = "select * from testdatasource ";
        String[] params = new String[]{"hugh"};

//        List<User> users = db.jdbcTemplate.query(sql, params, rm);

     //   db.page(page, sql);
        List<Map<String, Object>> users = db.queryForList(page, sql);
//        List<User> users = db.queryForList(page,sql, User.class);
        return R.ok(users).put("page", page);
    }
}
