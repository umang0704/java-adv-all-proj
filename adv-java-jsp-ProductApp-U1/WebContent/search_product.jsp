<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%
String prod = (String) request.getParameter("pname");
Connection connection = (Connection) application.getAttribute("con");
Statement statement = connection.createStatement();
ResultSet rs = statement.executeQuery("select * from products where name like '%" + prod + "%'");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product App</title>
</head>
<body>

	<h1>Product App</h1>
	<br>
	<a href="index.jsp">Home</a> |
	<a href="admin.jsp">Admin Login</a>
	<hr>
	<%
	int x = 0;
	while (rs.next()) {
		x++;
	%>
	<p>
		Name:
		<%=rs.getString("name")%></p>
	<p>
		Price:
		<%=rs.getInt("price")%></p>
	<p>
		Information:
		<%=rs.getString("info")%></p>
	<hr />
	<%
	}
	if (x == 0) {
	%>
	<p style="color: red;background: pink;">No Products Found !</p>
	<%
	}
	%>
</body>
</html>