<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Demo.jsp">
	<input type="text" name="user" placeholder="enter user name">
	<button type="submit">Go</button>
</form>
<%
application.setAttribute("cname","incapp");
%>
</body>
</html>