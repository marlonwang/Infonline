package com.info.bll;
import java.util.Map;

import com.info.sql.SqlAction;

public class UserProcess {

	public UserProcess() {
		// TODO Auto-generated constructor stub
	}
	
	//sign up 是注册,sign in 是登录
	
	/*********************************************************
	 * 用户或管理员注册
	 * @param name
	 * @param password
	 * @param isadmin
	 * @return 写用户表成败
	 *********************************************************/
	private boolean signUp(String name,String password,int isadmin)
	{
		String sql=null;
		sql="insert into b_user (u_name,u_password,u_admin) values ('"+name+"','"+password+"','"+isadmin+"')";
		if(name!="" && password!="")
		{
			if(SqlAction.operate(sql) > 0)
			{
				return true;
			}
		}
		return false;
	}
	
	/*******************************************************
	 * 普通用户注册
	 * @param name
	 * @param password
	 * @return 注册成败
	 *******************************************************/
	public boolean userSignUp(String name,String password)
	{
		if(signUp(name,password,0))
		{
			return true;
		}
		return false;
	}

	/*******************************************************
	 * 管理员注册
	 * @param name
	 * @param password
	 * @return 注册成败
	 *******************************************************/
	public boolean adminSignUp(String name,String password)
	{
		if(signUp(name,password,1)){
			return true;
		}
		return false;
	}
	
	/*******************************************************
	 * 用户登录
	 * @param name
	 * @param password
	 * @return 用户全部信息
	 *******************************************************/
	public Map<String, Object> userSignIn(String name,String password)
	{
		Map<String, Object> user;
		String sqlfind="select * from b_user where u_name='"+name+"' and u_password='"+password+"'";
		user=SqlAction.sqlQueryUnique(sqlfind);
		return user;
	}
	
	/*******************************************************
	 * 删除用户表中用户
	 * @param name
	 * @return 删除成败
	 *******************************************************/
	public boolean deleteUser(String name)
	{
		String sql="delete * from b_user where u_name='"+name+"'";
		if(SqlAction.operate(sql) > 0){
			return true;
		}
		return false;
	}
	
	
	public int checkUserNum(String name)
	{
		int num=0;
		String sql="select count(*) from b_user where u_name='"+name+"' "; 
		num=SqlAction.operate(sql);
		return num;
	}

	/********测试用例***********/
	/*public static void main(String[] args) {
		String name="way";
		String password="123456";
		System.out.println(userSignIn(name,password).get("u_name"));
	}*/
}