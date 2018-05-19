package com.lyq.dao;

import com.lyq.persistence.Category;
import com.lyq.util.HibernateFilter;

import java.util.List;

/**
 * ҩƷ������ݿ������
 *
 * @author Li Yong Qiang
 */
public class CategoryDao extends SupperDao {

    /**
     * ����id��ѯ���
     *
     * @param id
     * @return Category
     */
    public Category loadCategory(int id) {
        Category c = null;
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            //���������Ϣ
            c = (Category) session.load(Category.class, new Integer(id));
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
        return c;
    }

    /**
     * ��ѯ�������
     *
     * @return List
     */
    public List findAllCategory() {
        List list = null;
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            list = session.createQuery("from Category c")//����Query����
                    .list();                        //��ȡ�����
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
        return list;
    }

    /**
     * ͳ��ҩƷ�������
     *
     * @return
     */
    public List findCategoryAndCount() {
        List list = null;
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            // �����Ӳ�ѯ���
            String hql = "select c.name,count(*) from Medicine m join m.category c group by c";
            list = session.createQuery(hql)//����Query����
                    .list();                        //��ȡ�����
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
        return list;
    }
}
