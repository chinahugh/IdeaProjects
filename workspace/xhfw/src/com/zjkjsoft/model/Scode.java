package com.zjkjsoft.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
/**
 * 数据字典.
 */
@SuppressWarnings("serial")
public class Scode extends Model<Scode> {
	public static final Scode dao = new Scode();
	
	/** 根据 fid 查询子类的SQL */
	public static final String codefidSQL="SELECT id, mc, xh,ms FROM scode WHERE fid=? ORDER BY xh";
	/** 根据 fid 查询子类的SQL */
	public static final String codedmSQL="SELECT id, mc, xh FROM scode WHERE fid=(SELECT id FROM scode WHERE dm=?) ORDER BY xh";
	/** 根据 fid 查询子类的SQL */
	public static final String codebydmSQL="SELECT * FROM scode WHERE dm=?";
	/** 根据 fid 查询子类的SQL */
	public static final String codemcbyfidSQL="SELECT mc FROM scode WHERE fid=?";
	/**
	 * 根据父编号返回数据列表
	 * @param fid
	 * @return
	 */
		public static List<Scode> getListMcbyFid(Integer fid)
		{
			return dao.find(codemcbyfidSQL, fid);
		}	
	
/**
 * 根据父编号返回数据列表
 * @param fid
 * @return
 */
	public static List<Scode> getListbyFid(int fid)
	{
		return dao.find(codefidSQL, fid);
	}
	
	/**
	 * 根据编码返回数据类
	 * @param dm
	 * @return
	 */
	public static Scode getScodebyDm(String dm)
	{
		return dao.findFirst(codebydmSQL, dm);
	}
	
	/**
	 * 根据编码返回数据列表
	 * @param dm
	 * @return
	 */
	public static List<Scode> getListbyDm(String dm)
	{
		return dao.find(codedmSQL, dm);
	}

	
}
