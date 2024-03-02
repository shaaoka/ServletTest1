<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>main.jsp</h1>
<%=request.getParameter("username")%>
<%=request.getParameter("userpwd")%>
<%
for (int i = 0; i < 10; i++) {
%>
	ABC
<%
}
%>

</body>
</html>