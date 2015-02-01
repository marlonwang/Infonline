package com.info.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class InfoManage
 */
@WebServlet("/InfoManage")
public class InfoManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//设置编码，防止页面跳转 后乱码现象
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String type = request.getParameter("block");
		String function = request.getParameter("func");
		String title = request.getParameter("mtitle");
		String pusher = request.getParameter("mauthor");
		String newtext = request.getParameter("newtext");
		
		request.setAttribute("kind", type);
		
		if(type!="" && function!="")
		{
			switch("function")
			{
			case "slt":
				doselect(request,type);
				break;
			case "chg":
				doupdate(type,title,pusher,newtext);
				break;
			case "del":
				dodelete(type,title,pusher);
				break;
			}
		}
		request.getRequestDispatcher("manage.jsp").forward(request, response);
		
	}
	
	/*********************************************
	 * 查询操作
	 * @param request
	 * @param type
	 *********************************************/
	protected void doselect(HttpServletRequest request,String type)
	{
		List<Map<String, Object>> comlist;
		if(type!="")
		{
			switch(type)
			{
			case "book":
				BookManage bkManage=new BookManage(); 
				comlist=bkManage.getAllBook();
				request.setAttribute("comlist", comlist);
				break;
			case "machine":
				MachineManage mcManage=new MachineManage();
				comlist=mcManage.getAllMachine();
				request.setAttribute("comlist", comlist);
				break;
			case "help":
				ServiceManage svManage=new ServiceManage();
				comlist=svManage.getAllService();
				request.setAttribute("comlist", comlist);
				break;
			case "service":
				HelpManage hpManage=new HelpManage();
				comlist=hpManage.getAllHelp();
				request.setAttribute("comlist", comlist);
				break;
			default:
				break;	
			}
		}
	}
	
	/*******************************************
	 * 修改操作
	 * @param type
	 * @param title
	 * @param pusher
	 * @param newtext
	 *******************************************/
	protected void doupdate(String type,String title,String pusher,String newtext)
	{
		switch(type)
		{
		case "book":
			BookManage bkManage=new BookManage();
			bkManage.bookUpdate(title, pusher, newtext);
			break;
		case "machine":
			MachineManage mcManage=new MachineManage();
			mcManage.machineUpdate(title, pusher, newtext);
			break;
		case "help":
			HelpManage hpManage=new HelpManage();
			hpManage.helpUpdate(title, pusher, newtext);
			break;
		case "service":
			ServiceManage svManage=new ServiceManage();
			svManage.serviceUpdate(title, pusher,  newtext);
			break;
		default:
			break;
		}
	}
	/**************************************
	 * 删除操作
	 * @param type
	 * @param title
	 * @param pusher
	 *************************************/
	protected void dodelete(String type,String title,String pusher)
	{
		switch(type)
		{
		case "book":
			BookManage bkManage=new BookManage();
			bkManage.bookDelete(title, pusher);
			break;
		case "machine":
			MachineManage mcManage=new MachineManage();
			mcManage.machineDelete(title, pusher);
			break;
		case "help":
			HelpManage hpManage=new HelpManage();
			hpManage.helpDelete(title, pusher);
			break;
		case "service":
			ServiceManage svManage=new ServiceManage();
			svManage.serviceDelete(title, pusher);
			break;
		default:
			break;
		}
	}

}
