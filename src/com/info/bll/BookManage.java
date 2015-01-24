package com.info.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.info.sql.SqlAction;

public class BookManage {

	public BookManage() {
		// TODO Auto-generated constructor stub
	}
	
	/************************************
	 * 获取	b_id
	 * @param title
	 * @param pusher
	 * @return
	 ************************************/
	private int getBookbyID(String title,String pusher)
	{
		Map<String, Object> book;
		String sql="select * from b_book where b_name ='"+title+"' and b_pusher='"+pusher+"'";
		book=SqlAction.sqlQueryUnique(sql);
		return (int) book.get("b_id");
	}
	
	/*************************************
	 * 图书表中添加图书信息
	 * @param title
	 * @param text
	 * @param pusher
	 * @param day
	 * @return 影响行数
	 *************************************/
	public int bookInsert(String title,String text,String pusher)
	{
		int num=0;
		String sql="insert into b_book (b_name,b_describe,b_pusher) values" +
				"('"+title+"','"+text+"','"+pusher+"')";
		if(title != "")
			num=SqlAction.operate(sql);
		return num;
	}
	
	/**********************************************
	 * 删除表中指定项
	 * @param title
	 * @param pusher
	 * @return
	 **********************************************/
	public int bookDelete(String title,String pusher)
	{
		int num=0;
		String sql="delete from b_book where b_id='"+getBookbyID(title,pusher)+"'";
		num=SqlAction.operate(sql);
		return num;
	}
	
	/***********************************************
	 * 修改图书 描述信息, 图书主题
	 * @param title
	 * @param pusher
	 * @param newTitle
	 * @param newText
	 * @return 受影响行数
	 ************************************************/
	public int bookUpdate(String title,String pusher,String newText) 
	{
		int num=0;
		String sql="update b_book set b_describe='"+newText+"'" +
				"where b_id='"+getBookbyID(title,pusher)+"'";
		num=SqlAction.operate(sql);
		return num;
	}
	
	/*******************************************
	 * 返回图书表所有信息
	 * @return book list
	 *******************************************/
	public List<Map<String, Object>> getAllBook()
	{
		List<Map<String, Object>> blist = new ArrayList<>();
		String sql="select * from b_book";
		blist=SqlAction.query(sql);
		return blist;
	}
	
	/*public static void main(String[] args) {
		//if(bookInsert("数字图像处理","Matlab冈萨雷斯版,二手出售","way")>0)
			System.out.println(getBookbyID("风中劲草","way"));
	}*/
}
