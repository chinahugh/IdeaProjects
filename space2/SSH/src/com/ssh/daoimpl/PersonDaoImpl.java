package com.ssh.daoimpl;

import com.ssh.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: hugh
 * @Date: 17-11-24:下午7:03
 * @Description:
 */
@Repository
public class PersonDaoImpl {
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return Person
     */
    public Person getPersonById(String id) {
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();
        Person person = (Person) session.createQuery("from Person where id=?").setParameter(0, id).uniqueResult();
        transaction.commit();
        session.close();
        return person;
    }

    /**
     * 添加
     *
     * @param person
     */
    public void addPerson(Person person) {
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    /**
     * 更新
     *
     * @param person
     */
    public void updatePerson(Person person) {
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
        session.close();
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deletePersonById(String id) {
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete Person where id=?").setParameter(0, id).executeUpdate();
        transaction.commit();
        session.close();
    }

    /**
     * 查询所有
     *
     * @return List
     */
    @SuppressWarnings("unchecked")
    public List<Person> getPersons() {
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();
        List list = (List<Person>) session.createCriteria(Person.class).list();
        transaction.commit();
        session.close();
        return list;
    }
}
