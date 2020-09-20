package com.springboot.security.service.impl;

import com.springboot.security.common.R;
import com.springboot.security.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public R list() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");

        return R.ok().put("data", maps);
    }
}
