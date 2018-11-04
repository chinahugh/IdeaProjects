package com.zjkjsoft.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.zjkjsoft.util.MD5;
/**
 * 用户
 */
@SuppressWarnings("serial")
public class Suser extends Model<Suser> {
	public static final Suser dao = new Suser();
	
	
	/**
	 * 根据登录的登录名判断用户是否存在。
	 * @return
	 */
	public boolean hasUser()
	{
		String loginname=getStr("loginname");
		List<String> list=Db.query("SELECT loginname FROM suser WHERE loginname=?", loginname);	
		if(list!=null&&!list.isEmpty())
			return true;
		else
			return false;
	}
	
	/**
	 * 判断用户的密码是否发生变化
	 * @return
	 */
	public boolean passwordIsChanged()
	{
		Suser user=dao.findById(getInt("id"));
		if(user.getStr("password").equals(this.getStr("password")))
			return false;
		else
			return true;
	}
	
	/**
	 * 把密码转换为32位MD5
	 */
	public void convertPasswordToMD5()
	{
		String password=get("password");
		password=MD5.toMD5(password);
		set("password", password);
	}


}
