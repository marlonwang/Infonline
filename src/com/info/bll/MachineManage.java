package com.info.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.info.sql.SqlAction;

public class MachineManage {

	public MachineManage() {
		// TODO Auto-generated constructor stub
	}
	
	/*****************************************
	 * 获取 对应的机器发布信息
	 * @param title
	 * @param pusher
	 * @return 机器信息m_id
	 *****************************************/
	private int getMachinebyID(String title,String pusher)
	{
		Map<String, Object> machine;
		String sql="select * from b_machine where m_title ='"+title+"' and m_pusher='"+pusher+"'";
		machine=SqlAction.sqlQueryUnique(sql);
		return (int) machine.get("m_id");
	}
	
	/*****************************************
	 * 机器信息表添加发布信息
	 * @param title
	 * @param text
	 * @param pusher
	 * @return 受影响行数
	 *****************************************/
	public int machineInsert(String title,String text,String pusher)
	{
		int num=0;
		String sql="insert into b_machine (m_title,m_text,m_pusher) values" +
				"('"+title+"','"+text+"','"+pusher+"')";
		if(title != "")
			num=SqlAction.operate(sql);
		return num;
	}
	
	/****************************************
	 * 机器信息表删除发布信息
	 * @param title
	 * @param pusher
	 * @return
	 ****************************************/
	public int machineDelete(String title,String pusher)
	{
		int num=0;
		String sql="delete from b_machine where m_id='"+getMachinebyID(title,pusher)+"'";
		num=SqlAction.operate(sql);
		return num;
	}
	
	/***************************************
	 * 机器信息表  修改发布信息
	 * @param title
	 * @param pusher
	 * @param newTitle
	 * @param newText
	 * @return
	 ***************************************/
	public int machineUpdate(String title,String pusher,String newText) 
	{
		int num=0;
		String sql="update b_machine set m_text='"+newText+"'" +
				"where m_id='"+getMachinebyID(title,pusher)+"'";
		num=SqlAction.operate(sql);
		return num;
	}
	
	/****************************************
	 * 返回 b_machine表所有表项
	 * @return
	 ****************************************/
	public List<Map<String, Object>> getAllMachine()
	{
		List<Map<String, Object>> mlist = new ArrayList<>();
		String sql="select * from b_machine";
		mlist=SqlAction.query(sql);
		return mlist;
	}
	/*public static void main(String[] args) {
	//if(bookInsert("数字图像处理","Matlab冈萨雷斯版,二手出售","way")>0)
		System.out.println(machineDelete("风中劲草","way"));
	}*/

}
