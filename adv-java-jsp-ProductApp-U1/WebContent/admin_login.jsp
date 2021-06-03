<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%
String id = request.getParameter("id");
String pass = request.getParameter("password");
Connection connection = (Connection) application.getAttribute("con");
Statement statement = connection.createStatement();
ResultSet rs = statement.executeQuery("select * from admin where admin_id='" + id + "' and password='" + pass  + "'");
if(rs.next()){
	session.setAttribute("name", rs.getString("name"));
	response.sendRedirect("admin_home.jsp");
}else{
	session.setAttribute("msg", "Wrong Credentials..!");
	response.sendRedirect("admin.jsp");
}
	
%>
