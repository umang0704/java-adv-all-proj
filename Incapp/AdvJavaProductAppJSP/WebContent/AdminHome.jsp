<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String name=(String)session.getAttribute("name");
	if(name!=null){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product App</title>
</head>
<body>
	<h1>Admin Page</h1><hr/>
	<p>Welcome <%=name %> </p>
</body>
</html>
<%
	}else{
		session.setAttribute("msg", "Plz Login first!");
		response.sendRedirect("admin.jsp");
	}
%>