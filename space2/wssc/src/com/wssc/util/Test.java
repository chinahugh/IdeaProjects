package com.wssc.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: hugh
 * @Time: 2017/12/31 12:53 PM
 * @Discraption:
 */
public class Test {
    public static void main(String[] args) {
        ResultSet resultSet = JDBCUtils.executeQuery("select * from dd ");
        System.out.println(resultSet);
        try {
            for (int i = 0; resultSet.next(); i++) {
                System.out.println(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close();
    }
}
