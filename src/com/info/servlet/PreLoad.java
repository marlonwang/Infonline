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
 * Servlet implementation class PreLoad
 */
@WebServlet("/PreLoad")
public class PreLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreLoad() {
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
		
		//访问图书表
		BookManage bkManage=new BookManage(); 
		List<Map<String, Object>> allbooks;
		allbooks=bkManage.getAllBook();
		request.setAttribute("allbooks", allbooks);
		//System.out.println(allbooks);
		
		//访问机器表
		MachineManage mcManage=new MachineManage();
		List<Map<String, Object>> allmachines;
		allmachines=mcManage.getAllMachine();
		request.setAttribute("allmachines", allmachines);
		
		//访问服务表
		ServiceManage svManage=new ServiceManage();
		List<Map<String, Object>> allservice;
		allservice=svManage.getAllService();
		request.setAttribute("allservice", allservice);
		
		//访问帮助表
		HelpManage hpManage=new HelpManage();
		List<Map<String, Object>> allhelp;
		allhelp=hpManage.getAllHelp();
		request.setAttribute("allhelp", allhelp);
		
		try {		
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
	
	BookManage bkManage=new BookManage(); 
	List<Map<String, Object>> allbooks;
	allbooks=bkManage.getAllBook();
	System.out.println(allbooks.get(0).get("b_name"));
}*/

}
