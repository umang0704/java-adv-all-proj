<%
String h_name = (String)session.getAttribute("h_name");
if(h_name!=null){
%>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Your Doc+ | <%= h_name %></title>
	</head>
	<body>
		<div>
			<a href='doctor_affliations.jsp'>Doctor Affiliations</a>
			<h1>Welcome<b> <%= h_name %></b></h1>
			<form action="logout_h" method='POST'>
				<input type="submit" value='Logout'>
			</form>
		</div>
		
		<hr>
		
	</body>
	</html>
<%
}else{
	application.setAttribute("msg_h", "Please login first..!");
	response.sendRedirect("index.jsp#hospitak_login");
}
%>
