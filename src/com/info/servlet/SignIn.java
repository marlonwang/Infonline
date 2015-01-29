package com.info.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.bll.UserProcess;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public SignIn() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//设置编码，防止页面跳转 后乱码现象
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	  
	    //用于下面输出<alert></alert>
	    PrintWriter out=response.getWriter();
	    
	    String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
	   
	   /* List<Map<String, Object>> lsit = SqlAction.sqlQuery(sql);
	    for (Map<String, Object> map : lsit) {
		}*/
	    
	    UserProcess uPro = new UserProcess();
	    
	    //获取查询后的第一条记录
	    if(uPro.userSignIn(name, pwd) != null)
	    {
	    	request.getSession().setAttribute("name", uPro.userSignIn(name, pwd).get("u_name"));
	    	//判断是否为管理员
	    	request.getSession().setAttribute("isadmin", uPro.userSignIn(name, pwd).get("u_admin"));
	    	request.getRequestDispatcher("default.jsp").forward(request, response);
	    }
	    else
	    {
	    	out.println("<html><body><script>");
			out.println("alert('login failed!')");
			out.println("</script></body></html>");
	    }
	      
	    //request.getRequestDispatcher("test.jsp").forward(request, response);		
	}

}
