package com.lyq.util;

import com.lyq.struts.form.MedicineForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ������ѯ������
 *
 * @author Li Yong Qiang
 */
public class QueryUtil {
    /**
     * ��������ѯҩƷ
     *
     * @param form
     * @param currPage
     * @param action
     * @return Map����
     */
    public static Map queryMedicine(MedicineForm form, String currPage, String action) {
        //����Map����
        Map map = new HashMap();
        //HQL���
        String hql = "from Medicine d where 1=1";
        //����List���ϣ�����װ�ز�ѯ����
        List temp = new ArrayList();
        //���������봦��
        boolean flag = false;
        String s;
        if (currPage != null && !currPage.isEmpty()) {
            flag = true;
        }
        //���ҩƷid���ڣ�����id����
        if (form.getId() > 0) {
            hql += " and d.id = ?";
            temp.add(new Integer(form.getId()));
            action += "&id=" + form.getId();
        }
        //���ҩƷ��Ŵ��ڣ�����ҩƷ�������
        if (form.getMedNo() != null && !form.getMedNo().isEmpty()) {
            hql += " and d.medNo = ?";
            s = form.getMedNo();
            if (flag) {
                s = StringUtil.encodeZh(s);
            }
            temp.add(s);
            action += "&medNo=" + StringUtil.encodeURL(s);
        }
        //���ҩƷ���ƴ��ڣ�����ҩƷ��������
        if (form.getName() != null && !form.getName().isEmpty()) {
            hql += " and d.name = ?";
            s = form.getName();
            if (flag) {
                s = StringUtil.encodeZh(s);
            }
            temp.add(s);
            action += "&name=" + StringUtil.encodeURL(s);
        }
        //���ҩƷ��ַ���ڣ�����ҩƷ��ַ����
        if (form.getFactoryAdd() != null && !form.getFactoryAdd().isEmpty()) {
            hql += " and d.factoryAdd = ?";
            s = form.getFactoryAdd();
            if (flag) {
                s = StringUtil.encodeZh(s);
            }
            temp.add(s);
            action += "&factoryAdd=" + StringUtil.encodeURL(s);
        }
        //���ҩƷ������Ϣ���ڣ�����ҩƷ������Ϣ����
        if (form.getDescription() != null && !form.getDescription().isEmpty()) {
            hql += " and d.description like ?";
            s = form.getDescription();
            if (flag) {
                s = StringUtil.encodeZh(s);
            }
            temp.add("%" + s + "%");
            action += "&description=" + StringUtil.encodeURL(s);
        }
        //��HQL��ѯ�����뵽map��
        map.put("hql", hql);
        //��action���뵽map��
        map.put("action", action);
        //����ѯ������������뵽map��
        map.put("where", temp.toArray());
        return map;
    }
}
