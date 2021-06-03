<%@page import="java.sql.*"%>
<%
String name = (String) session.getAttribute("name");
if (name != null) {
	String pname = request.getParameter("pname");
	Connection c = (Connection) application.getAttribute("con");
	Statement st = c.createStatement();
	st.executeUpdate("delete from products where name='" + pname + "'");
	session.setAttribute("msg", "Product Deleted Successfully !");
	response.sendRedirect("show_all_products.jsp");
} else {
	session.setAttribute("msg", "Plz Login first!");
	response.sendRedirect("admin.jsp");
}
%>