package com.wssc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

/**
 * @Author: hugh
 * @Time: 2017/12/27 10:11 PM
 * @Discraption:
 */
public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String name;
    private static String password;

    private static Connection connection;
    private static PreparedStatement ps;
    private static ResultSet resultSet;
    private static int resultInt;


    private static final String file = "wssc/src/conf/jdbc.properties";

    static {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        name = properties.getProperty("name");
        password = properties.getProperty("password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 建立Connection
     *
     * @return Connection
     */
    private static Connection getConn() {
        try {
            return DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 查询
     *
     * @param sql
     * @return ResultSet
     * @throws SQLException
     */
    public static ResultSet executeQuery(String sql) {
        connection = getConn();
        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 执行一次修改、删除、增加
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public static int executeUpdate(String sql) {
         connection = getConn();

        try {
            ps = connection.prepareStatement(sql);
            resultInt = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultInt;
    }


    public static void close() {

        try {
            if (Objects.nonNull(connection)) {
                connection.close();
            }
            if (Objects.nonNull(ps)) {
                ps.close();
            }
            if (Objects.nonNull(resultSet)) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Connection conn = getConn();
        System.out.println(conn);
        close();
    }
}
