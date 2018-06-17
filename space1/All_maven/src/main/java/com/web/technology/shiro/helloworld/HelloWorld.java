package com.web.technology.shiro.helloworld;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Auther HUGH
 * @Date 2018/4/29
 * @Description HelloWorld
 * init file path  web/technology/shiro/helloworld/shiro.ini
 */
public class HelloWorld {
    private SimpleAccountRealm realm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        realm.addAccount("Mark", "123456", "admin");
    }

    /**
     * 登录1
     */
    @Test
    public void testAuthentication() {
        //构建securityManger环境
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(realm);
        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
        subject.login(token);
        System.out.println("是否登录成功：" + subject.isAuthenticated());

        subject.logout();
        System.out.println("是否登录成功：" + subject.isAuthenticated());
    }


    /**
     * 登录2
     */
    @Test
    public void testAuthentication2() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:web/technology/shiro/helloworld/shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            //4、登录，即身份验证
            subject.login(token);
            System.out.println("是否登录成功" + subject.isAuthenticated());
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }

    /**
     * 登录 权限检查
     */
    @Test
    public void testAuthentication3() {
        //构建securityManger环境
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(realm);
        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
        subject.login(token);
        System.out.println("是否登录成功：" + subject.isAuthenticated());
        //权限检查
        subject.checkRoles("admin");
        System.out.println("是否具有该权限" + subject.hasRole("admin"));
    }

    /**
     * 权限认证
     */
    @Test
    public void testAuthentication4() {
        IniRealm realm =new IniRealm("classpath:web/technology/shiro/helloworld/shiro.ini");

        DefaultSecurityManager manager=new DefaultSecurityManager();
        manager.setRealm(realm);
        SecurityUtils.setSecurityManager(manager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            //4、登录，即身份验证
            subject.login(token);
            System.out.println("是否登录成功 " + subject.isAuthenticated());
            System.out.println("是否是admin "+subject.hasRole("admin"));

            System.out.println("是否是具有delete权限 "+subject.isPermitted("delete"));
            System.out.println("是否是具有update权限 "+subject.isPermitted("update"));
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }


}
