<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String name = (String) session.getAttribute("name");
if (name != null) {
	String pname = request.getParameter("pname");
	int price = Integer.parseInt(request.getParameter("price"));
	String info = request.getParameter("info");
	Connection c = (Connection) application.getAttribute("con");
	Statement st = c.createStatement();
	try {
		st.executeUpdate("insert into products values ('" + pname + "'," + price + ",'" + info + "')");
		session.setAttribute("msg", "success");
	} catch (SQLIntegrityConstraintViolationException e) {
		session.setAttribute("msg", "failed");
	}
	response.sendRedirect("admin_home.jsp");
} else {
	session.setAttribute("msg", "Please Login first..!");
	response.sendRedirect("admin.jsp");
}
%>