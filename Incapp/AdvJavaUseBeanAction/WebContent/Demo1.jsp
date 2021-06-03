
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Demo 1</h1>
<%-- 
	<% 
 		my.Employee e=new my.Employee();
 		e.setName("Pankaj Gupta");
 		e.setSalary(450000);
 		e.setAge(21);
 		e.setCname("ABC");
 		session.setAttribute("e",e);
 	%> 
 --%>
	
	<jsp:useBean id="e" class="my.Employee" scope="session" />
	<jsp:setProperty property="name" name="e" value="Pankaj Gupta"/>
	<jsp:setProperty property="cname" name="e" value="ABC"/>
	<jsp:setProperty property="age" name="e" value="21"/>
	<jsp:setProperty property="salary" name="e" value="450000"/>
</body>
</html>