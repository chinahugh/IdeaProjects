package com.datasource.dao;

import com.datasource.common.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Autowired
      DB db;
}
