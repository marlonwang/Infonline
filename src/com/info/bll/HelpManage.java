package com.info.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.info.sql.SqlAction;

public class HelpManage {

	public HelpManage() {
		// TODO Auto-generated constructor stub
	}
		
	/*************************************
	 * 返回指定 help 的 id 
	 * @param title
	 * @param pusher
	 * @return
	 *************************************/
	private int getHelpbyID(String title,String pusher)
	{
		Map<String, Object> help;
		String sql="select * from b_help where h_title ='"+title+"' and h_pusher='"+pusher+"'";
		help=SqlAction.sqlQueryUnique(sql);
		return (int) help.get("h_id");
	}

	/***************************************
	 * 向b_help表中添加 help info
	 * @param title
	 * @param text
	 * @param pusher
	 * @return
	 ***************************************/
	public int helpInsert(String title,String text,String pusher)
	{
		int num=0;
		String sql="insert into b_help (h_title,h_text,h_pusher) values" +
				"('"+title+"','"+text+"','"+pusher+"')";
		if(title != "")
			num=SqlAction.operate(sql);
		return num;
	}
	
	/**********************************************
	 * 删除 b_help 表记录
	 * @param title
	 * @param pusher
	 * @return
	 **********************************************/
	public int helpDelete(String title,String pusher)
	{
		int num=0;
		String sql="delete from b_help where h_id='"+getHelpbyID(title,pusher)+"'";
		num=SqlAction.operate(sql);
		return num;
	}
	
	/******************************************
	 * 修改 b_help 表项
	 * @param title
	 * @param pusher
	 * @param newTitle
	 * @param newText
	 * @return
	 ******************************************/
	public int helpUpdate(String title,String pusher,String newText) 
	{
		int num=0;
		String sql="update b_help set h_text='"+newText+"'" +
				"where h_id='"+getHelpbyID(title,pusher)+"'";
		num=SqlAction.operate(sql);
		return num;
	}
	
	/*******************************************
	 * 返回help表所有表项
	 * @return book list
	 *******************************************/
	public List<Map<String, Object>> getAllHelp()
	{
		List<Map<String, Object>> hlist = new ArrayList<>();
		String sql="select * from b_help";
		hlist=SqlAction.query(sql);
		return hlist;
	}

}
