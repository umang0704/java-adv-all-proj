<%@page import="java.sql.*"%>
<% 
String aid=request.getParameter("aid");
String password=request.getParameter("password");
Connection c=(Connection)application.getAttribute("con");
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select * from admin where aid='"+aid+"' and password='"+password+"'");
if(rs.next()){
	session.setAttribute("name",rs.getString("name"));
    response.sendRedirect("AdminHome.jsp");
}else{
	session.setAttribute("msg", "Wrong Entries!");
	response.sendRedirect("admin.jsp");
}
%>