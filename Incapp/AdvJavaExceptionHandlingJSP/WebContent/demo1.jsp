<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int a=90,b=0,r=0;
		try{
			r=a/b;
		}catch(Exception e){
	%>
			<%=e%>
	<%
		}
	%>
	Division: <%=r %>
</body>
</html>