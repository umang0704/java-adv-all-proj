<%@page import="java.sql.*"%>
<%
String name=(String)session.getAttribute("name");
if(name!=null){
	String pname=request.getParameter("pname");
	Connection c=(Connection)application.getAttribute("con");
	Statement st=c.createStatement();
	st.executeUpdate("delete from product where name='"+pname+"'");
	session.setAttribute("msg","Product Deleted Successfully !");
	response.sendRedirect("ShowAllProduct.jsp");
}else{
	session.setAttribute("msg", "Plz Login first!");
	response.sendRedirect("admin.jsp");
}
%>