package com.info.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.bll.BookManage;
import com.info.bll.HelpManage;
import com.info.bll.MachineManage;
import com.info.bll.ServiceManage;

/**
 * Servlet implementation class InfoPublish
 */
@WebServlet("/InfoPublish")
public class InfoPublish extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoPublish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO 
		//设置编码，防止页面跳转 后乱码现象
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String option=request.getParameter("column");
		String title=request.getParameter("title");
		String pusher=request.getParameter("author");
		String text=request.getParameter("wysiwyg");
		switch(option)
		{
		case "book":
			bookPush(title,text,pusher,response);
			break;
		case "machine":
			machinePush(title,text,pusher,response);
			break;
		case "help":
			helpPush(title,text,pusher,response);
			break;
		case "service":
			servicePush(title,text,pusher,response);
			break;
		default:
			response.getWriter().write("<html><h1>Publish Failure</h1></html>");	
			break;
		}	
	}
	
	//图书信息
	protected void bookPush(String title,String text,String pusher,HttpServletResponse response)
	{	
		BookManage bkm=new BookManage();
		if(bkm.bookInsert(title, text, pusher) > 0)
		{
			try {
				response.getWriter().write("<html><h1>Publish Success</h1></html>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//电器信息
	protected void machinePush(String title,String text,String pusher,HttpServletResponse response)
	{
		MachineManage mcm=new MachineManage();
		if(mcm.machineInsert(title, text, pusher) > 0)
		{
			try {
				response.getWriter().write("<html><h1>Publish Success</h1></html>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	protected void helpPush(String title,String text,String pusher,HttpServletResponse response)
	{
		HelpManage hpm=new HelpManage();
		if(hpm.helpInsert(title, text, pusher) >0)
		{	
			try {
				response.getWriter().write("<html><h1>Publish Success</h1></html>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	protected void servicePush(String title,String text,String pusher,HttpServletResponse response)
	{
		ServiceManage svm=new ServiceManage();
		if(svm.serviceInsert(title, text, pusher) >0)
		{
			try {
				response.getWriter().write("<html><h1>Publish Success</h1></html>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
