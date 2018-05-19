package com.userms.util;

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


    private static final String file = "UserMS/src/conf/jdbc.properties";

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
     * @param parameters
     * @return ResultSet
     * @throws SQLException
     */
    public static ResultSet executeQuery(String sql, String... parameters) throws SQLException {
        connection = getConn();
        ps = connection.prepareStatement(sql);
        if (Objects.nonNull(parameters) && !Objects.equals(parameters, "")) {
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
        }
        return ps.executeQuery();
    }

    /**
     * 执行一次修改、删除、增加
     *
     * @param sql
     * @param parameters
     * @return
     * @throws SQLException
     */
    public static int executeUpdate(String sql, String... parameters) throws SQLException {
        connection = getConn();
        ps = connection.prepareStatement(sql);
        return ps.executeUpdate();
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
