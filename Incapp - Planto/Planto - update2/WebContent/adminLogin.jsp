<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planto</title>
</head>
<body>
	<h1>Admin Login Page</h1>
	<hr/>
	<%
		String msg=(String)session.getAttribute("msg");
		if(msg!=null){
	%>
			<p style="color:red"> <%=msg %> </p>
	<%		
			session.setAttribute("msg",null);
		}
	%>
	<form action="AdminLogin" method="post">
		<label>Admin Id: </label>
		<input type="text" name="aid" required /><br/><br/>
		<label>Admin Password: </label>
		<input type="text" name="password" required /><br/><br/>
		<button type="submit">Login</button>
	</form>
</body>
</html>