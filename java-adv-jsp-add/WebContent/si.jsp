<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
int p = Integer.parseInt(request.getParameter("principle"));
int r = Integer.parseInt(request.getParameter("rate"));
int t = Integer.parseInt(request.getParameter("time"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SI</title>
</head>
<body>
	<a href="index.html">Home</a><hr>
	<h1>Simple Interest.</h1> <br>
	<h3>Simple interest of P = <%=p %>, R = <%=r %> and T= <%=t %> is <%= p*r*t/1000 %> </h3>
</body>
</html>