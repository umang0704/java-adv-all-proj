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
		String n=request.getParameter("name");
		int s=Integer.parseInt(request.getParameter("salary"));
	%>
	<jsp:useBean id="b" class="pck.Employee" scope="session">
	<jsp:setProperty name="b" property="name" value="<%=n %>"/>
	<jsp:setProperty name="b" property="salary" value="<%=s %>"/>	
	</jsp:useBean>
	<a href="show_bean.jsp">show bean</a>
</body>
</html>