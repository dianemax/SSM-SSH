package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dologin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取表单数据
    	String userName = request.getParameter("userName");
    	String pwd = request.getParameter("pwd");
    	
    	//处理业务逻辑
    	//分发转向
    	if("tom".equals(userName) && "123".equals(pwd)){
    		//request.setAttribute("name", userName);
    		request.getRequestDispatcher("/success.jsp").forward(request, response);
    	}else{
    		request.setAttribute("msg", "用户名或者密码不正确！");
    		request.getRequestDispatcher("/login.jsp").forward(request, response);
    	}
	
    	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
