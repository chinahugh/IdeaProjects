package com.lyq.dao;

import com.lyq.persistence.SellDetail;
import com.lyq.persistence.SellSeq;
import com.lyq.util.HibernateFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * ҩƷ�������ݿ������
 *
 * @author Li Yong Qiang
 */
public class SellDao extends SupperDao {
    /**
     * ����������ϸ
     *
     * @param sd SellDetail����
     */
    public void saveSellDetail(SellDetail sd) {
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            session.save(sd);                            //����������Ϣ
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
    }

    /**
     * ��ѯ��������
     *
     * @return List
     */
    public List sellSeq() {
        List list = null;
        try {
            session = HibernateFilter.getSession();        //��ȡSession����
            session.beginTransaction();                    //��������
            //HQL��ѯ���
            String hql = "select s.sellName,sum(s.sellPrice),sum(s.sellCount)," +
                    "m.id from SellDetail s join s.med m " +
                    "group by m order by sum(s.sellCount) desc";
            List temp = session.createQuery(hql)        //����Query����
                    .setFirstResult(0)        //��ʼλ��
                    .setMaxResults(10)        //ƫ����
                    .list();                    //��ȡ�����
            if (temp != null && temp.size() > 0) {
                list = new ArrayList();
                for (int i = 0; i < temp.size(); i++) {
                    Object[] obj = (Object[]) temp.get(i);
                    SellSeq s = new SellSeq();
                    s.setName(obj[0].toString());
                    s.setTotalPrice((Double) obj[1]);
                    s.setTotalCount((Long) obj[2]);
                    s.setMedId(((Integer) obj[3]));
                    list.add(s);
                }
            }
            session.getTransaction().commit();            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();                        //��ӡ�쳣��Ϣ
            session.getTransaction().rollback();        //�ع�����
        }
        return list;
    }
}
