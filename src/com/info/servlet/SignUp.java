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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//设置编码，防止页面跳转 后乱码现象
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String password=request.getParameter("pwd");
				
		
		UserProcess uPro=new UserProcess();
		if(name!="" && password!="")
		{
			if(uPro.checkUserNum(name) == 0)	//用户名是否被用
			{
				if(uPro.userSignUp(name, password)){
					out.write("Congratulations sign up succeed!");
				}
				else{
					out.println("<html><body><script>");
					out.println("alert('sign up failed !')");
					out.println("</script></body></html>");
				}
			}
			else{
				out.write("This name has already been used. ");
			}
		}
		else{
			out.println("empty user's name or password ");
		}
	}

}
