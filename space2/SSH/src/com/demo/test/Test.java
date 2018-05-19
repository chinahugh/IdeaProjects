package com.demo.test;

import com.ssh.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: hugh
 * @Date: 17-11-24:下午4:08
 * @Description: test
 */
public class Test {
    private ClassPathXmlApplicationContext context;
    private SessionFactory factory;

    public static void main(String[] args) {

        Test test = new Test();
        test.sessionFaction();
//        test.test1();
        test.test2();
    }

    public void sessionFaction() {
        context = new ClassPathXmlApplicationContext("conf/spring-context.xml");

        factory = (SessionFactory) context.getBean("sessionFactory");
        System.out.println(context);
        System.out.println(factory);
    }

    public void test1() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                ResultSet resultSet =
                        connection.prepareStatement("select * from web.test")
                                .executeQuery();

                for (; resultSet.next(); ) {
                    System.out.println(resultSet.getString(1));
                    System.out.println(resultSet.getString(2));
                }
            }
        });

        transaction.commit();
        session.close();
    }

    private void test2() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new Person("123","123","123","123"));
        transaction.commit();
        session.close();
    }

}
