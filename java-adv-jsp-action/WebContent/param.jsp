<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP: Action -> Param</title>
</head>
<body>
	<p>Hello from param page</p>
	<br>
	<jsp:forward page='param_recieve.jsp'>
		<jsp:param value="xyz@email.com" name="email" /></jsp:forward>
	<p>Bye from param page</p>
</body>
</html>