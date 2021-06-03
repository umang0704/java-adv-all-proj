<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String name=(String)session.getAttribute("name");
	if(name!=null){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product App</title>
</head>
<body>
	<h1>Admin Page</h1><hr/>
	<p>Welcome <%=name %> <a href='Logout.jsp'>LOGOUT</a></p>
	<p> <a href='ShowAllProduct.jsp'>Show All Products</a> </p><hr/>
	<h2>Add Product.</h2>
	<%
		String msg=(String)session.getAttribute("msg");
		if(msg!=null){
			if(msg.equalsIgnoreCase("success")){
	%>
				<p style="color:green"> Product Added Successfully !  </p>
	<%			
			}else{
	%>
				<p style="color:red"> Product Already Exist ! </p>
	<%			
			}	
			session.setAttribute("msg", null);
		}
	%>
	<form action='AddProduct.jsp' method='post'>
    Name: <input type='text' name='pname' required/><br/><br/>
    Price: <input type='number' name='price' required/><br/><br/>
    Info: <textarea rows='3' name='info' required></textarea><br/><br/>
    <input type='submit' value='ADD Product'/>
    </form>
    
</body>
</html>
<%
	}else{
		session.setAttribute("msg", "Plz Login first!");
		response.sendRedirect("admin.jsp");
	}
%>