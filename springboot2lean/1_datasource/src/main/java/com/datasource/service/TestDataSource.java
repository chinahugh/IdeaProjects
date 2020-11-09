package com.datasource.service;

import com.datasource.common.Page;
import com.datasource.common.R;
import com.datasource.entity.Testdatasource;

public interface TestDataSource {
    R test(Page page);

    R test(Page page, Testdatasource user);
}
