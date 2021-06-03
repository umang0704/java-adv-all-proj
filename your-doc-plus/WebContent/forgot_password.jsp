<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Doc+|Password Retrieval</title>
</head>
<body>
	<h1>Your Doc+</h1>
	<hr>
	<h3>Forgot Password</h3>
	<%String type = request.getParameter("type"); %>
	<form action="resetPassword">
		Email:<input type="text" placeholder="Enter email to retrieve password" required="required"/> <br> <br>
		<input type="hidden" name='type' value=<%= type %>/>
		<input type="submit" value="Send Email">
		<input type="reset"/>
	</form>
</body>
</html>