<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="b" class="pck.Employee" scope="session">
You have entered the below details
<jsp:getProperty property="name" name="b"/>
<jsp:getProperty property="salary" name="b" />
</jsp:useBean>
</body>
</html>