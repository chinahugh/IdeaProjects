package com.datasource.service.impl;

import com.datasource.common.Page;
import com.datasource.common.R;
import com.datasource.dao.TestMapper;
import com.datasource.dao.UserMapper;
import com.datasource.entity.Testdatasource;
import com.datasource.service.TestDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author HGH
 */
@Service
public class TestDataSourceImpl implements TestDataSource {
    Logger logger = LoggerFactory.getLogger(TestDataSource.class);
    @Autowired
    private TestMapper testMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public R test(Page page) {
        String sql = "select  * from testdatasource where id  between ? and ? ";
        List<Map<String, Object>> users = testMapper.queryForList(page, sql, 1, 800);
        // String sql2 = "select count(*) from testdatasource";
        return R.ok(users).put("page", page);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public R test(Page page, Testdatasource testdatasource) {
        Testdatasource us = userMapper.findById(testdatasource.getId());
        return R.ok(us).put("page", page);
    }
}
