<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
float balance = 0.0f;
String a = request.getParameter("amount");
Integer amount = Integer.parseInt(a);
String op = request.getParameter("op");
if (op.equals("dep"))
	balance += amount;
if (op.equals("withdraw"))
	balance -= amount;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: linear-gradient(to right, #538FFB, #5B54FA);
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

</head>
<body>
	<div class="jumbotron jumbotron-fluid"
		style='color: white; text-align: center; size: 25%; background: #5737D6 !important; padding: 10px; margin: 10px 10% 10px 10%; border-radius: 15px'>
		<div class="container">
			<h1 class="display-4">Bank Transaction Request Form.</h1>
		</div>
	</div>
	<hr>
	<div style='background-image: linear-gradient(to right, #EFF54D ,#FF9F4A);text-align:center; padding:150px;margin:5% 15% 5% 15%; border-radius: 50px'>
		<h1>The transaction is compelete.</h1>
		<hr style='color: white;'>
		<h2 style="color:white;background: green;padding:10px;margin:10px 10px 10px 10px;border-radius: 20px">Your balance is : <%= balance %></h2>
	</div>
</body>
</html>