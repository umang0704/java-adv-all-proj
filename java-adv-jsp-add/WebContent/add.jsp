<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	int n1=Integer.parseInt(request.getParameter("n1"));
	int n2=Integer.parseInt(request.getParameter("n2"));
	int s=n1+n1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="index.html">Home</a> <hr>
	<h1>Sum:</h1><br><br>
	<hr>
	<h2>Sum of <%=n1 %> and <%=n2 %> is <%=s %></h2>
</body>
</html>