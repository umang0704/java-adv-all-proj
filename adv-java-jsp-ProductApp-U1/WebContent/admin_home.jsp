<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String name = (String) session.getAttribute("name");
if (name != null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product App</title>
</head>
<body>
	<h1>Product App</h1>
	<hr>
	<a href="index.jsp">Home</a> |
	<a href="logout.jsp">Logout</a>
	<hr>
	<h1>Admin Home</h1>
	<p>
		Welcome:
		<%=name%>
	</p>
	<hr>
	<a href="show_all_products.jsp">Show All Products </a>
	<br>
	<h2>Add Products</h2>
	<%
	String msg = (String) session.getAttribute("msg");
	if (msg != null) {
		if (msg.equalsIgnoreCase("success")) {
	%>
	<p style="color: green; background: yellow">Product Added
		Successfully !</p>
	<%
	} else {
	%>
	<p style="color: red; background: pink">Product Already Exist !</p>
	<%
	}
	session.setAttribute("msg", null);
	}
	%>
	<form action="add_product.jsp" method='post'>
		Name: <input type='text' name='pname' required /><br /> <br />
		Price: <input type='number' name='price' required /><br /> <br />
		Info:
		<textarea rows='3' name='info' required></textarea>
		<br /> <br /> <input type='submit' value='ADD Product' />
	</form>

</body>
</html>

<%
} else {
session.setAttribute("msg", "Please Login first..!");
response.sendRedirect("admin.jsp");
}
%>
