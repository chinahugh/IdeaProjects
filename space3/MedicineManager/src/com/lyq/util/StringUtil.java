package com.lyq.util;

import java.net.URLEncoder;

/**
 * �ַ���������,���ڶ���Ŀ�е��ַ������д���
 *
 * @author Li Yong Qiang
 */
public class StringUtil {
    /**
     * ���ַ�������ת�����ַ���
     *
     * @param arr String����
     * @return String
     */
    public static String arr2Str(String[] arr) {
        String temp = "";        // �ַ�������
        if (arr != null && arr.length > 0) {
            // ѭ����ȡ�����е�ֵ
            for (int i = 0; i < arr.length; i++) {
                // �ж������±��Ƿ񵽴�ĩβ
                if (i != (arr.length - 1)) {
                    // ����µ��ַ�������,�Ž�β
                    temp = temp + arr[i] + ",";
                } else {
                    // ����µ��ַ���
                    temp = temp + arr[i];
                }
            }
        }
        return temp;
    }

    /**
     * ���ַ�������URL����
     *
     * @param s �ַ���
     * @return String
     */
    public static String encodeURL(String s) {
        try {
            //�����ӽ���URL����
            s = URLEncoder.encode(s, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * ���ַ�������gbk����
     *
     * @param s �ַ���
     * @return �������ַ���
     */
    public static String encodeZh(String s) {
        try {
            // ���ַ�������gbk����
            s = new String(s.getBytes("iso-8859-1"), "gbk");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
