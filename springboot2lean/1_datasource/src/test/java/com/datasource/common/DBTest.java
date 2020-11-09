package com.datasource.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DBTest {
    @Autowired
    DB db;

    @Test
    void page() {
        for (int i = 0; i < 100; i++) {
            // db.update("insert into testdatasource (name,insertime) values(?,NOW())", "hugh" + i);
            // try {
            //     Thread.sleep(1000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }
    }

}