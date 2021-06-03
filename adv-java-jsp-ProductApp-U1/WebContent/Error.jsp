<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product App</title>
</head>
<body>
	<h1>Error: Something went Wrong!</h1> <hr><br>
	<p> <%= exception %> <p>
	<a href="index.jsp">Go to Home</a>
</body>
</html>