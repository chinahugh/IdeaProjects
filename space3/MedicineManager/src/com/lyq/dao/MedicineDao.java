package com.lyq.dao;

import com.lyq.persistence.Medicine;
import com.lyq.util.HibernateFilter;

/**
 * ҩƷ���ݿ������
 *
 * @author Li Yong Qiang
 */
public class MedicineDao extends SupperDao {
    /**
     * ��ѯҩƷ��Ϣ
     *
     * @param id
     * @return Medicine
     */
    public Medicine loadMedicine(int id) {
        Medicine med = null;
        try {
            session = HibernateFilter.getSession(); // ��ȡSession����
            session.beginTransaction(); // ��������
            // ����ҩƷ��Ϣ
            med = (Medicine) session.load(Medicine.class, new Integer(id));
            session.getTransaction().commit(); // �ύ����
        } catch (Exception e) {
            e.printStackTrace(); // ��ӡ�쳣��Ϣ
            session.getTransaction().rollback(); // �ع�����
        }
        return med;
    }

    /**
     * ͨ��fetchͬʱץȡҩƷ�����
     *
     * @param id
     * @return Medicine
     */
    public Medicine loadMedicineAndCategory(int id) {
        Medicine med = null;
        try {
            session = HibernateFilter.getSession(); // ��ȡSession����
            session.beginTransaction(); // ��������
            // HQL��ѯ���
            String hql = "select a from Medicine a join fetch a.category b where a.id = "
                    + id;
            med = (Medicine) session.createQuery(hql) // ����Query����
                    .uniqueResult(); // ��ֵ����
            session.getTransaction().commit(); // �ύ����
        } catch (Exception e) {
            e.printStackTrace(); // ��ӡ�쳣��Ϣ
            session.getTransaction().rollback(); // �ع�����
        }
        return med;
    }

    /**
     * ����medNo��ѯ
     *
     * @param medNo
     * @return Medicine
     */
    public Medicine findMedicineByMedNo(String medNo) {
        Medicine med = null;
        try {
            session = HibernateFilter.getSession(); // ��ȡSession����
            session.beginTransaction(); // ��������
            // HQL��ѯ���
            String hql = "from Medicine d where d.medNo = ?";
            med = (Medicine) session.createQuery(hql) // ����Query����
                    .setParameter(0, medNo) // ��HQL��̬��ֵ
                    .uniqueResult(); // ���ص�������
            session.getTransaction().commit(); // �ύ����
        } catch (Exception e) {
            e.printStackTrace(); // ��ӡ�쳣��Ϣ
            session.getTransaction().rollback(); // �ع�����
        }
        return med;
    }
}
