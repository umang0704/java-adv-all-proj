<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
   		Integer count=(Integer) session.getAttribute("count");
    	if(count==null){
    		count=0;
    	}
    	session.setAttribute("count",++count);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product App</title>
</head>
<body>
	<h1>Product App</h1> <br>
	<a href="index.jsp">Home</a>
	| <a href="admin.jsp">Admin Login</a>
	<hr>
	<form action="search_product.jsp" method="post">
		<input type="text" required="required" placeholder="Search Product" name=''>
		<input type="submit" value="Search">
	</form>
</body>
</html>