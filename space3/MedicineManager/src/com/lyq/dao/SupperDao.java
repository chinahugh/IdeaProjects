package com.lyq.dao;

import com.lyq.util.HibernateFilter;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * �������ݿ�����࣬���ò������ݿ�ĳ��÷���
 * ��Ҫ���ڼ̳�
 *
 * @author Li Yong Qiang
 */
public class SupperDao {
    //Session����
    protected Session session = null;

    /**
     * ������Ϣ
     *
     * @param obj ����
     */
    public void save(Object obj) {
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            session.save(obj);                            //�������
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
    }

    /**
     * ����/������Ϣ
     *
     * @param obj ����
     */
    public void saveOrUpdate(Object obj) {
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            session.saveOrUpdate(obj);                    //������޸Ķ���
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
    }

    /**
     * ɾ����Ϣ
     *
     * @param obj ����
     */
    public void delete(Object obj) {
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            session.delete(obj);                        //ɾ������
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
    }

    /**
     * ��hql��ѯ������Ϣ
     *
     * @param hql hql���
     */
    public List findByHQL(String hql) {
        List list = null;
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            list = session.createQuery(hql)                //����Query����
                    .list();                        //���ؽ����
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
        return list;
    }

    /**
     * ��hqlɾ����Ϣ
     *
     * @param hql hql���
     */
    public void deleteByHQL(String hql) {
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            session.createQuery(hql)                    //����Query����
                    .executeUpdate();                    //����
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
    }

    /**
     * ��ֵ����
     *
     * @param hql   hql���
     * @param where ��ѯ��������
     * @return Object
     */
    public Object uniqueResult(String hql, Object[] where) {
        Object obj = null;
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            Query query = session.createQuery(hql);        //����Query����
            //���where��Ϊ�գ����HQL�����ж�̬��ֵ
            if (where != null && where.length > 0) {
                for (int i = 0; i < where.length; i++) {
                    if (where[i] != null) {
                        query = query.setParameter(i, where[i]);
                    }
                }
            }
            obj = query.uniqueResult();                    //��ֵ����
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
        return obj;
    }

    /**
     * ��ҳ��ѯ
     *
     * @param hql    hql���
     * @param offset ��ʼλ��
     * @param length ƫ����
     * @param where  ��ѯ����,Object��������
     * @return List����
     */
    public List findPaging(String hql, int offset, int length, Object[] where) {
        List list = null;
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            Query query = session.createQuery(hql);        //����Query����
            //������ѯ����
            if (where != null && where.length > 0) {
                for (int i = 0; i < where.length; i++) {
                    if (where[i] != null) {
                        query = query.setParameter(i, where[i]);
                    }
                }
            }
            list = query.setFirstResult(offset)            //������ʼλ��
                    .setMaxResults(length)            //ƫ����
                    .list();                        //��ȡ�����
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
        return list;
    }
}
