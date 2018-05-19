package com.zjkjsoft.util;

import java.text.SimpleDateFormat;

/**
 * 身份证校验工具类
 * 
 * @author Administrator
 * 
 */
public class IdcodeUtil {
	public static final int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
	public static final int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
	/**
	 * * ���У��λ1 * *
	 * 
	 * @param certiCode *
	 * @return
	 */
	private static boolean checkIDParityBit(String certiCode) {
		boolean flag = false;
		if (certiCode == null || "".equals(certiCode))
			return false;
		//int ai[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
		if (certiCode.length() == 18) {
			int i = 0;
			for (int k = 0; k < 18; k++) {
				char c = certiCode.charAt(k);
				int j;
				if (c == 'X')
					j = 10;
				else if (c <= '9' || c >= '0')
					j = c - 48;
				else
					return flag;
				i += j * wi[k];
			}
			if (i % 11 == 1)
				flag = true;
		}
		return flag;
	}

	/**
	 * * ������ڸ�ʽ * *
	 * 
	 * @param year *
	 * @param month *
	 * @param day *
	 * @return
	 */
	private static boolean checkDate(String year, String month, String day) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd");
		try {
			String s3 = year + month + day;
			System.out.println(s3);
			simpledateformat.setLenient(false);
			simpledateformat.parse(s3);
		} catch (java.text.ParseException parseexception) {
			return false;
		}
		return true;
	}

	/**
	 * * У�����֤ * *
	 * 
	 * @param certiCode *
	 *            ��У�����֤ *
	 * @return 0--У��ɹ�; 1--λ���; 2--���ո�ʽ���� ; 3--У��λ���� ; 4--�����쳣;5--�ַ��쳣; *
	 * @param certiCode *
	 * @return
	 */
	private static int checkCertiCode(String certiCode) {
		try {
			if (certiCode == null || certiCode.length() != 15
					&& certiCode.length() != 18)
				return 1;
			String s1;
			String s2;
			String s3;
			if (certiCode.length() == 15) {
				if (!checkFigure(certiCode)) {
					return 5;
				}
				s1 = "19" + certiCode.substring(6, 8);
				s2 = certiCode.substring(8, 10);
				s3 = certiCode.substring(10, 12);
				if (!checkDate(s1, s2, s3))
					return 2;
			}
			if (certiCode.length() == 18) {
				if (!checkFigure(certiCode.substring(0, 17))) {
					return 5;
				}
				s1 = certiCode.substring(6, 10);
				s2 = certiCode.substring(10, 12);
				s3 = certiCode.substring(12, 14);
				if (!checkDate(s1, s2, s3))
					return 2;
				if (!checkIDParityBit(certiCode))
					return 3;
			}
		} catch (Exception exception) {
			return 4;
		}
		return 0;
	}

	/**
	 * * �ж����֤�����Ƿ���Ч * *
	 * 
	 * @param idCard *
	 * @return
	 */
	public static boolean isIdCard(String idCard) {
		if (checkCertiCode(idCard) == 0)
			return true;
		else
			return false;
	}

	/**
	 * * ����ַ��Ƿ�ȫΪ���� * *
	 * 
	 * @param certiCode *
	 * @return
	 */
	public static boolean checkFigure(String certiCode) {
		try {
			Long.parseLong(certiCode);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}



	// ��֤15λ18λ
	public static boolean Verify(String idcard) {
		if (idcard.length() == 15) {
			idcard = uptoeighteen(idcard);
		}
		if (idcard.length() != 18) {
			return false;
		}
		String verify = idcard.substring(17, 18);
		if (verify.equals(getVerify(idcard))) {
			return true;
		}
		return false;
	}// �õ�����λУ����

	public static String getVerify(String eightcardid) {
		int remaining = 0;
		int[] ai = new int[18];
		if (eightcardid.length() == 18) {
			eightcardid = eightcardid.substring(0, 17);
		}
		if (eightcardid.length() == 17) {
			int sum = 0;
			for (int i = 0; i < 17; i++) {
				String k = eightcardid.substring(i, i + 1);
				ai[i] = Integer.parseInt(k);
			}
			for (int i = 0; i < 17; i++) {
				sum = sum + wi[i] * (ai[i]);
			}
			remaining = sum % 11;
		}
		return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
	} 
	// 15ת18λ public String

	public static String  uptoeighteen(String fifteencardid) {
		String eightcardid = fifteencardid.substring(0, 6);
		eightcardid = eightcardid + "19";
		eightcardid = eightcardid + fifteencardid.substring(6, 15);
		eightcardid = eightcardid + getVerify(eightcardid);
		return eightcardid;
	}
	// 18ת15λ public String

	public static String  downtoeighteen(String fifteencardid) {
		String eightcardid = fifteencardid.substring(0, 6)+fifteencardid.substring(8, 17);
		return eightcardid;
	}
	
	public static String  getSqlStr(String code) {
		String str="";
		if(code.length()==15){
			str="code ='" + code + "' or code ='" + uptoeighteen(code) + "'";
		}else{
			str="code ='" + code + "' or code ='" + downtoeighteen(code) + "'";
		}
		return str;
	}
	/**
	 * * {method description} * *
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(IdcodeUtil.uptoeighteen("610112750716203"));
	}
}
