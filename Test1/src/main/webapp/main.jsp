<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.io.*"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="javax.servlet.ServletException,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<h1>main.jsp</h1>
<%
if (request.getParameter("a").equals("1")) {
%>
<%=request.getParameter("name")%>
<%=request.getParameter("userpwd")%>
<p>帳號登入成功<p>
<%
} else {
%>	
<p>帳號登入失敗<p>
<%
}
%>
<% 
	Connection conn = null;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url ="jdbc:sqlserver://localhost:1433;DatabaseName=servdb;encrypt=false";
		String user ="shaaoka";
		String password="123456";
		conn = DriverManager.getConnection(url,user,password);
		
		boolean status = !conn.isClosed();
		//System.out.println("連線狀態" + status);
		
		
		Statement stmt = conn.createStatement();
		String sql1 = "SELECT * FROM employee";
		ResultSet rs = stmt.executeQuery(sql1);
		
		
		String table = "";
		String body = "";
		String title = "";
		
		title = "<tr>" +
				"<th>" + "部門" + "</th>" + 
				"<th>" + "薪水" + "</th>" +	
				"</tr>";
        title = "<thead>" + title + "</thead>";				
 
		
		while (rs.next()) {
			String empno = rs.getString("empno");
			String salary = rs.getString("salary"); 	
			
			String row = 
					"<td>" + empno + "</td>" + 
					"<td>" + salary + "</td>";
			
			row = "<tr>" + row + "</tr>";
			body = body + row; 
		}
		body = "<tbody>" + body + "</tbody>";
		
		table =  "<caption>table1</caption>" +
				 title + 
				 body;
		table = "<table>" + table + "</table>";
		
		out.write(table);		
    } catch (Exception e) {
        e.printStackTrace(); 
    } finally {
		if (conn != null) {
		    conn.close();
		}
	}	

%>

<form action="/Test1/c2" method="post" >
<input type="text" name="user" value="<%=request.getParameter("name")%>" >
<input type="text" name="pwd" value="<%=request.getParameter("userpwd")%>" >


<input type="submit" id="btn1" value="傳送" >
</form>
<script>


$("#btn1").click(function (e) {
	alert("btn1");
	//e.preventDefault();
});

</script>
</body>
</html>