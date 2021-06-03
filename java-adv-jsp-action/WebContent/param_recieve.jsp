<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP: Action -> Param</title>
</head>
<body>
	<p>Hello from param_recieve page</p>
	<br>
	<%=request.getParameter("email")%>
	<p>Bye from param_recieve page</p>
</body>
</html>