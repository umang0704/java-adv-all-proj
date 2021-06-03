<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product App</title>
</head>
<body>
	<h1>Product App</h1>
	<br>
	<hr>
	<a href="index.jsp">Home</a> |
	<a href="admin.jsp">Admin Login</a>
	<hr>
	<h2>Admin LogIn</h2>
	<%
	String msg = (String) session.getAttribute("msg");
	if (msg != null) {
	%>
	<p style="color: red; background: pink">
		<%=msg%>
	</p>
	<%
	session.setAttribute("msg", null);
	}
	%>
	<form action="admin_login.jsp" method="post">
		<input type="text" required="required" placeholder="Admin Id"
			name='id'> <br> <br>
			 <input type="password"required="required" placeholder="Admin Password" name='password'>
		<br> <br> <input type="submit" value="Log In">
	</form>
</body>
</html>