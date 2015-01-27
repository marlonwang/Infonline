package com.info.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.info.sql.SqlAction;

public class ServiceManage {

	public ServiceManage() {
		// TODO Auto-generated constructor stub
	}
	
	/*************************************
	 * 查询指定 service 信息 
	 * @param title
	 * @param pusher
	 * @return s_id
	 *************************************/
	private int getServicebyID(String title,String pusher)
	{
		Map<String, Object> service;
		String sql="select * from b_service where s_kind ='"+title+"' and s_pusher='"+pusher+"'";
		service=SqlAction.sqlQueryUnique(sql);
		return (int) service.get("s_id");
	}
	
	/*************************************
	 * 向服务信息表插入 记录
	 * @param title
	 * @param text
	 * @param pusher
	 * @return 受影响行数
	 *************************************/
	public int serviceInsert(String title,String text,String pusher)
	{
		int num=0;
		String sql="insert into b_service (s_kind,s_text,s_pusher) values" +
				"('"+title+"','"+text+"','"+pusher+"')";
		if(title != "")
			num=SqlAction.operate(sql);
		return num;
	}
	
	/**********************************
	 * 从服务信息表插入记录
	 * @param title
	 * @param pusher
	 * @return 受影响行数
	 **********************************/
	public int serviceDelete(String title,String pusher)
	{
		int num=0;
		String sql="delete from b_service where s_id='"+getServicebyID(title,pusher)+"'";
		num=SqlAction.operate(sql);
		return num;
	}
	
	/**************************************
	 * 修改 b_service 表项中信息
	 * @param title
	 * @param pusher
	 * @param newTitle
	 * @param newText
	 * @return 受影响行数
	 **************************************/
	public int serviceUpdate(String title,String pusher,String newText) 
	{
		int num=0;
		String sql="update b_service set s_text='"+newText+"'" +
				"where s_id='"+getServicebyID(title,pusher)+"'";
		num=SqlAction.operate(sql);
		return num;
	}
	
	/**************************************
	 * 获取 b_service表所有记录
	 * @return List<Map<String, Object>>
	 **************************************/
	public List<Map<String, Object>> getAllService()
	{
		List<Map<String, Object>> slist = new ArrayList<>();
		String sql="select * from b_service";
		slist=SqlAction.query(sql);
		return slist;
	}
}
 