<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Index JSP</h1>
	
<%-- 	<jsp:include page="demo.jsp" > --%>
<%-- 		<jsp:param name="cname" value="Incapp" /> --%>
<%-- 		<jsp:param name="age" value="10" /> --%>
<%-- 	</jsp:include> --%>

	<jsp:forward page="demo.jsp" >
		<jsp:param name="cname" value="Incapp" />
		<jsp:param name="age" value="10" />
	</jsp:forward>
	<p>Bye Index Jsp</p>
</body>
</html>