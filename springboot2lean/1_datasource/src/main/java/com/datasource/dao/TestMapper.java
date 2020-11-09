package com.datasource.dao;

import com.datasource.common.Page;
import com.datasource.common.aop.CatcheA;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TestMapper extends Mapper {

    @CatcheA(name="list",time = 300)
    public List<Map<String, Object>> queryForList(Page page, String sql, @Nullable Object... args) {
        List<Map<String, Object>> maps = db.queryForList(page, sql, args);
        return maps;
    }
}
