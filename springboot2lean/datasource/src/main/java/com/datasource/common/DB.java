package com.datasource.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author HGH
 */
@Component
public class DB {
    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void page(Page page, String sql, @Nullable Object... args) {
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, args);
//        page.setTotalRows(maps.size());
    }

    public List<Map<String, Object>> queryForList(Page page, String sql, @Nullable Object... args) {
        String sqlpage = "select * from (" + sql + ") a limit " + (page.getPage() - 1) * page.getDefaultRows() + "," + page.getDefaultRows();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sqlpage, args);
        page.setCurrentRows(maps.size());
        return maps;
    }

    public <T> List<T> queryForList(Page page, String sql, Class<T> mappedClass, @Nullable Object... args) {
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(mappedClass), args);
    }

    public int update(String sql, @Nullable Object... args) {
        return jdbcTemplate.update(sql, args);
    }
}
