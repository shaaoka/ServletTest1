package com.test1;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/c2")
public class C2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C2() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url ="jdbc:sqlserver://localhost:1433;DatabaseName=servdb;encrypt=false";
			String user ="shaaoka";
			String password="123456";
			conn = DriverManager.getConnection(url,user,password);
			boolean status = !conn.isClosed();
			System.out.println(status);
			
			char a = 'i';
			switch (a) {
				case 'i':
					String pk = "1009";
					
					insert(conn, pk);
					
					break;
				case 'd':
					String pk = "1009";
					
					delete(conn, pk);					
					
					break;
				case 'u':
					String pk = "1009";
					
					update(conn, pk);
					
					break;
				default:
					
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
			    try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
		




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private int insert(Connection conn, String pk) throws SQLException
	{
//		String sql = "INSERT INTO employee(empno, ename, hiredate, salary, deptno, title) VALUES(?, ?, getDATE(), ?,?,?)";
		String sql = "INSERT INTO employee(empno, ename, hiredate, salary, deptno, title) VALUES(?, ?, getDATE(), ?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, pk);
		stm.setString(2, "Andy");
		stm.setString(3, "100");
		stm.setString(4, "100");
		stm.setString(5, "boss");
		stm.executeUpdate();				
	
		return 1;
	}

	
	private void update(Connection conn, String pk)
	{
		//
	}
	
	
	private void delete(Connection conn, String pk) 
	{
		//
	}
}
