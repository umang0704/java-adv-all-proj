<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	User name: <%=request.getParameter("user") %> <br/>
	User name: ${param.user} <br/>
	User name: ${param["user"]} <br/>
	User name: ${applicationScope.cname} <br/>
</body>
</html>