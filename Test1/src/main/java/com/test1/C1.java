package com.test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/c1")
public class C1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C1() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		PrintWriter out = response.getWriter();
		if (name.equals("peter") && pwd.equals("123") ) {
			// 原網址			
			//request.getRequestDispatcher("main2.jsp").forward(request, response);
        	response.sendRedirect("main.jsp?name=" + name + "&" + "userpwd=" + pwd + "&a=1"); //
		} else {
			//out.write("失敗");
        	response.sendRedirect("fail.html"); //
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
