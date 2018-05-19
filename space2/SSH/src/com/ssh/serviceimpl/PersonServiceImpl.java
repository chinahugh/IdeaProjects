package com.ssh.serviceimpl;

import com.ssh.daoimpl.PersonDaoImpl;
import com.ssh.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hugh
 * @Date: 17-11-24:下午8:56
 * @Description:
 */
@Service
public class PersonServiceImpl {
    public final PersonDaoImpl personDAO;

    @Autowired
    public PersonServiceImpl(PersonDaoImpl personDAO) {
        this.personDAO = personDAO;
    }

    /**
     * 添加
     * @param person
     */
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Person getPersonById(String id){
        return personDAO.getPersonById(id);
    }
    /**
     * 更新
     * @param person
     */
    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }
    /**
     * 删除
     * @param id
     */
    public void deletePersonById(String  id) {
        personDAO.deletePersonById(id);
    }
    /**
     * 查询所有
     * @return
     */
    public List<Person> getPersons() {
        return personDAO.getPersons();
    }
}
