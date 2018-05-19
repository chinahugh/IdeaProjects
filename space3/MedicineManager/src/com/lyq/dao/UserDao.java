package com.lyq.dao;

import com.lyq.persistence.Category;
import com.lyq.persistence.Medicine;
import com.lyq.persistence.User;
import com.lyq.util.HibernateFilter;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.util.Date;

/**
 * �û����ݿ������
 * ���ڲ�ѯ�û���ϵͳ��ʼ��
 *
 * @author Li Yong Qiang
 */
public class UserDao extends SupperDao {
    /**
     * ��ѯ�û�
     *
     * @param userName
     * @param password
     * @return User
     */
    public User login(String userName, String password) {
        User user = null;
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            //HQL��ѯ���
            String hql = "from User u where u.username=? and u.password=?";
            Query query = session.createQuery(hql)        //����Query����
                    .setParameter(0, userName)//��̬��ֵ
                    .setParameter(1, password);//��̬��ֵ
            user = (User) query.uniqueResult();            //����User����
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
        return user;
    }

    /**
     * ����id��ѯ�û�
     *
     * @param id
     * @return User
     */
    public User loadUser(int id) {
        User user = null;
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            //����id�����û�
            user = (User) session.load(User.class, new Integer(id));
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
        return user;
    }

    /**
     * ϵͳ��ʼ������
     */
    public void initialization() {
        try {
            Configuration cfg = new Configuration().configure();
            SchemaExport export = new SchemaExport(cfg);
            export.create(true, true);
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������

            Category c1 = new Category();
            c1.setName("��ð��ҩ");
            c1.setDescription("���θ�ð�����ա�ͷʹ��");
            c1.setCreateTime(new Date());

            Category c2 = new Category();
            c2.setName("θ����ҩ");
            c2.setDescription("θ�ס�����ר��ҩ��");
            c2.setCreateTime(new Date());

            Category c3 = new Category();
            c3.setName("��ͯ��ҩ");
            c3.setDescription("���ã���ͯ��ҩ��");
            c3.setCreateTime(new Date());

            Medicine d1 = new Medicine();
            d1.setName("��ð����A");
            d1.setPrice(2.5);
            d1.setMedCount(3);
            d1.setCategory(c1);
            d1.setFactoryAdd("��ҩһ��");
            d1.setDescription("Ч���ܺ�");
            d1.setMedNo("abc001");

            Medicine d2 = new Medicine();
            d2.setName("��ð����B");
            d2.setPrice(10.05);
            d2.setMedCount(10);
            d2.setCategory(c1);
            d2.setFactoryAdd("��ҩһ��");
            d2.setDescription("�����˷硢ͷʹЧ���ܺ�");
            d2.setMedNo("abc002");

            Medicine d3 = new Medicine();
            d3.setName("xx������");
            d3.setPrice(5.8);
            d3.setMedCount(100);
            d3.setCategory(c2);
            d3.setFactoryAdd("��ҩ����");
            d3.setDescription("����������");
            d3.setMedNo("abc003");

            Medicine d4 = new Medicine();
            d4.setName("С����ð���");
            d4.setPrice(5.8);
            d4.setMedCount(100);
            d4.setCategory(c3);
            d4.setFactoryAdd("��ҩ����");
            d4.setDescription("Ч���ܺ�");
            d4.setMedNo("abc004");

            User u = new User();
            u.setUsername("admin");
            u.setPassword("admin");
            u.setCreateTime(new Date());

            session.save(d1);
            session.save(d2);
            session.save(d3);
            session.save(d4);
            session.save(u);

            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            session.getTransaction().rollback();        //�ع�����
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
    }
}
