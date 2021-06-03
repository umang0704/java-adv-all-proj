<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Demo 2</h1>
<%-- 	
	<% 
 		my.Employee e=(my.Employee)session.getAttribute("e");
 	%> 
 	Name: <%= e.getName() %> <br/> 
 	Age: <%= e.getAge() %> <br/>
 	Company Name: <%= e.getCname() %> <br/> 
 	Salary: <%= e.getSalary() %> <br/> 
--%>
		<jsp:useBean id="e" class="my.Employee" scope="session" />
		Name: <jsp:getProperty property="name" name="e"/> <br/>
		Age: <jsp:getProperty property="age" name="e"/> <br/>
		Company Name: <jsp:getProperty property="cname" name="e"/> <br/>
		Salary: <jsp:getProperty property="salary" name="e"/> <br/>
</body>
</html>