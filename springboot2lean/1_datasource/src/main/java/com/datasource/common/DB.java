package com.datasource.common;

import cn.hutool.core.util.StrUtil;
import com.datasource.common.aop.DBAnno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author HGH
 */
@Component
public class DB {
    private final Logger logger = LoggerFactory.getLogger(DB.class);

    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * 查询列表
     *
     * @param page
     * @param sql
     * @param args
     * @return
     */
    @DBAnno
    public List<Map<String, Object>> queryForList(Page page, String sql, @Nullable Object... args) {
        int start = (page.getPage() - 1) * page.getDefaultRows();
        int end = page.getDefaultRows();
        StringBuilder order = new StringBuilder();
        for (int i = 0; i < page.getOrders().length; i++) {
            String field = page.getOrders()[i].getField();
            String desc = page.getOrders()[i].getDesc();
            order.append(field).append(" ").append(desc).append(",");
        }
        String sqlorder = "";
        if (StrUtil.isNotEmpty(order)) {
            sqlorder = " order by " + order.substring(0, order.length() - 1);
        }
        String sqlpage = " select * from ( " + sql + " ) a " + sqlorder + " limit " + start + " , " + end;
        try {
            return jdbcTemplate.queryForList(sqlpage, args);
        } catch (DataAccessException e) {
            String msg = "sql运行失败,sql:" + sql + ",args:" + Arrays.toString(args);
            logger.error(msg);
            throw new E(msg, e);
        }
    }

    /**
     * 查询列表
     *
     * @param page
     * @param sql
     * @param mappedClass
     * @param args
     * @param <T>
     * @return
     */
    @DBAnno
    public <T> List<T> queryForT(Page page, String sql, Class<T> mappedClass, @Nullable Object... args) {
        int start = (page.getPage() - 1) * page.getDefaultRows();
        int end = page.getDefaultRows();
        String sqlpage = "select * from (" + sql + ") a limit " + start + "," + end;
        try {
            return jdbcTemplate.queryForList(sqlpage, mappedClass, args);
        } catch (DataAccessException e) {
            String msg = "sql运行失败,sql:" + sql + ",args:" + Arrays.toString(args);
            logger.error(msg);
            throw new E(msg, e);
        }
    }

    /**
     * 执行update、insert等修改语句
     *
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, @Nullable Object... args) {
        try {
            return jdbcTemplate.update(sql, args);
        } catch (DataAccessException e) {
            String msg = "sql运行失败,sql: " + sql + ",args: " + Arrays.toString(args);
            logger.error(msg);
            throw new E(msg, e);
        }
    }
}
