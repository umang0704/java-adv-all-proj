<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String name=(String)session.getAttribute("name");
if(name!=null){
	String pname=request.getParameter("pname");
	Connection c=(Connection)application.getAttribute("con");
	Statement st=c.createStatement();
	ResultSet rs=st.executeQuery("select * from product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product App</title>
</head>
<body>
	<h1>All Product Page</h1><hr/>
	<p>Welcome <%=name %> <a href='AdminHome.jsp'>Home</a> <a href='Logout.jsp'>LOGOUT</a></p>
	<hr/>
	<%
		String msg=(String)session.getAttribute("msg");
		if(msg!=null){
	%>
		<p style="color:red"> <%=msg %> </p>
<%-- 	<script>alert(" <%=msg%> ");</script>   --%>
	<%	
			session.setAttribute("msg", null);
		}
	%>
	<%
		int x=0;
		while(rs.next()){
			x++;
	%>
			<p>Name: <%=rs.getString("name") %></p>	
			<p>Price: <%=rs.getInt("price") %></p>	
			<p>Information: <%=rs.getString("info") %></p>
			<form action='DeleteProduct.jsp' method='post'>
            <input type='hidden' name='pname' value='<%=rs.getString("name")%>'/>
            <button type='submit'>Delete</button>
            </form>
			<hr/>	
	<%		
		}
		if(x==0){
	%>
		<p style="color:red"> No Product Found !</p>
	<%		
		}
	%>
</body>
</html>
<%
}else{
	session.setAttribute("msg", "Plz Login first!");
	response.sendRedirect("admin.jsp");
}
 %>