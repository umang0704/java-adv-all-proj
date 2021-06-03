<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   	<%
   		int n=Integer.parseInt(request.getParameter("n"));
   	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Square</title>
</head>
<body>
	<a href="index.html">Home</a> <hr>
	<h1>Square</h1><br>
	<h3>Square of <%=n %> is <b><%=n*n %></b></h3>
</body>
</html>