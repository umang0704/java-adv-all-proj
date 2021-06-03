<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planto</title>
</head>
<body>
	<h1>Planto App</h1>
	<hr/>
	<form action="plantSearch.jsp" method="post">
		<label>Search Plant: </label>
		<input type="search" name="name" required />
		<button type="submit">Search</button>
	</form>
	<%
		String name=(String)session.getAttribute("name");
		if(name==null){
	%>
			<a href="signIn.jsp">SignIn</a> | <a href="adminLogin.jsp">admin login</a>
	<%		
		}else{
	%>
			Welcome: <b><%=name %></b> <a href="Logout">Logout</a>
	<%		
		}
	%>
	Cart: <b>0</b>
	<hr/>
	<div>
		<img src="images/banner.jpg" width="800px" height="300px">
		
	</div>
</body>
</html>