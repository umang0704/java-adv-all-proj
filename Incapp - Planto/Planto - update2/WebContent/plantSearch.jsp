<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planto</title>
</head>
<body>
	<h1>Planto App</h1>
	<hr/>
	<form action="SearchPlant" method="post">
		<label>Search Plant: </label>
		<input type="search" name="plant_name" required />
		<button type="submit">Search</button>
	</form>
	<a href="">login</a> | <a href="adminLogin.jsp">admin login</a>
	Cart: <b>0</b>
	<hr/>
	<div>
		<img src="images/plant1.jpg" height="130px">
		<p><b>Ficus Bonsai - Plant</b></p>
		<p><b>&#x20B9; 250/-</b></p>
	</div>
	<div>
		<img src="images/plant2.jpg" height="130px">
		<p><b>Ficus Bonsai - Plant</b></p>
		<p><b>&#x20B9; 250/-</b></p>
	</div>
</body>
</html>