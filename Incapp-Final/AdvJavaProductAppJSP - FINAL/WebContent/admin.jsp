<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product App</title>
</head>
<body>
	<h1>Admin login:</h1>
	<hr/>
	<%
		String msg=(String)session.getAttribute("msg");
		if(msg!=null){
	%>
		<p style="color:red"> <%=msg %> </p>
<%-- 	<script>alert(" <%=msg%> ");</script>   --%>
	<%	
			session.setAttribute("msg", null);
		}
	%>
    <form action="LoginAdmin.jsp" method="post">
        <label>Admin ID </label>
        <input type="text" name='aid'/><br/><br/>
        <label>Admin Password </label>
        <input type="password" name='password'/><br/><br/>
        <button type="submit">LOGIN</button>
    </form>
    <hr/>
    <a href='index.jsp'>Go Home</a>
</body>
</html>