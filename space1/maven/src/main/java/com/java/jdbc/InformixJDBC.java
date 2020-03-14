package com.java.jdbc;

import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InformixJDBC extends TestCase {
    public void testInformixConn() {
        String RL = "jdbc:informix-sqli://10.119.218.30:60001/dbName:informixserver=serverName;user=cms;password=cms";
        String sqlStr = "select  ACD from haglog ";
        try {     //这里的异常处理语句是必需的.否则不能通过编译!
            Class.forName("com.informix.jdbc.IfxDriver");
            System.out.println("类实例化成功!");
            System.out.println("slkdjf");
            Connection con = DriverManager.getConnection(RL);
            System.out.println("创建连接对像成功!");
            Statement st = con.createStatement();
            System.out.println("创建Statement成功!");
            ResultSet rs = st.executeQuery(sqlStr);
            System.out.println("操作数据表成功!");
            System.out.println("----------------!");
            while (rs.next()) {
                System.out.println("conn success");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception err) {
            err.printStackTrace(System.out);
        }
    }
}
