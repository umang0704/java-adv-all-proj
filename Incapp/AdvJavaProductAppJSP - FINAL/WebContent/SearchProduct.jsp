<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String pname=request.getParameter("pname");
	Connection c=(Connection)application.getAttribute("con");
	Statement st=c.createStatement();
	ResultSet rs=st.executeQuery("select * from product where name like '%"+pname+"%'");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product App</title>
</head>
<body>
	<%
		int x=0;
		while(rs.next()){
			x++;
	%>
			<p>Name: <%=rs.getString("name") %></p>	
			<p>Price: <%=rs.getInt("price") %></p>	
			<p>Information: <%=rs.getString("info") %></p>
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