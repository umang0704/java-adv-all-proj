<%@page import="java.sql.*"%>
<%
String name=(String)session.getAttribute("name");
if(name!=null){
	String pname=request.getParameter("pname");
	int price=Integer.parseInt(request.getParameter("price"));
	String info=request.getParameter("info");
	Connection c=(Connection)application.getAttribute("con");
	Statement st=c.createStatement();
	try{
		st.executeUpdate("insert into product values ('"+pname+"',"+price+",'"+info+"')");
		session.setAttribute("msg","success");
	}catch(SQLIntegrityConstraintViolationException ex){
		session.setAttribute("msg","failed");
	}
	response.sendRedirect("AdminHome.jsp");
}else{
	session.setAttribute("msg", "Plz Login first!");
	response.sendRedirect("admin.jsp");
}
%>