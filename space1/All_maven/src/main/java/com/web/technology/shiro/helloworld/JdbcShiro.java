package com.web.technology.shiro.helloworld;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther HUGH
 * @Date 2018/6/13
 * @Description JdbcShiro
 */
public class JdbcShiro {
    /**
     * jdbc 登录验证
     */
    @Test
    public void testAuthentication5() throws IOException, SQLException {
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/ssm");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        JdbcRealm jdbcRealm=new JdbcRealm();
        jdbcRealm.setAuthenticationQuery("select password from user_t where user_name = ?");
        jdbcRealm.setPermissionsQuery("select age from user_t where user_name = ? ");
        jdbcRealm.setDataSource(dataSource);
        //构建securityManger环境
        DefaultSecurityManager manager=new DefaultSecurityManager();
        manager.setRealm(jdbcRealm);
        //主体提交认证请求
        SecurityUtils.setSecurityManager(manager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            //4、登录，即身份验证
            subject.login(token);
            System.out.println("是否登录成功 " + subject.isAuthenticated());
            //   System.out.println("是否是admin "+subject.hasRole("admin"));

            System.out.println("是否是具有delete权限 "+subject.isPermitted("delete"));
            //  System.out.println("是否是具有update权限 "+subject.isPermitted("update"));
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
//        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }
}
