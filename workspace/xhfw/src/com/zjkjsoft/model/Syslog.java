package com.zjkjsoft.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
/**
 *系统日志.
 */
@SuppressWarnings("serial")
public class Syslog extends Model<Syslog> {
	public static final Syslog dao = new Syslog();
	public static final String selectSQL=" SELECT a.*, b.loginname, b.username ";
	public static final String whereSQL=" FROM syslog a, suser b WHERE a.userid=b.id ";
	
	/**
	 * 插入日志到数据库
	 * @param userid 用户ID
	 * @param ip 请求的Ip
	 * @param mc 模块
	 * @param ms 结果
	 * @return 受影响的行数
	 */
	public static int insertLog(int userid, String ip, String mc, String ms)
	{
		//String sql="INSERT INTO syslog(userid, ip, mc, ms, ctime) VALUES(?, ?, ?, ?, getdate())";
		String sql="INSERT INTO syslog(userid, ip, mc, ms, ctime) VALUES(?, ?, ?, ?, now())";
// myql  now()
		return Db.update(sql, userid, ip, mc, ms);
	}
	
	/**
	 * 根据ID获取Log的详细信息
	 * @param id
	 * @return
	 */
	public static Syslog logDetails(int id)
	{
		String sql=Syslog.selectSQL+Syslog.whereSQL+" AND a.id=?";
		return dao.findFirst(sql, id);
	}
}
