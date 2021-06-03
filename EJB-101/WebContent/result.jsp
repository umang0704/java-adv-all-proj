 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<style type="text/css">
	body{
		background-image: linear-gradient(to right, #538FFB , #5B54FA);
	}
</style>
</head>
<body>
<%
	float n1 = Float.parseFloat(request.getParameter("n1"));
	float n2 = Float.parseFloat(request.getParameter("n2"));
	float res = 0.0f;
	String op = request.getParameter("op");
	if(op.equals("add"))
		res = n1+n2;
	if(op.equals("sub"))
		res = n1-n2;
	if(op.equals("mul"))
		res = n1*n2;
	if(op.equals("div"))
		res = n1/n2;
%>
<div class="jumbotron jumbotron-fluid" style=' text-align:center;background: #b3d1ff !important;padding:10px;margin: 10px 10% 10px 10%;border-radius: 15px'>
	  <div class="container">
	    <h1 class="display-4">Calculator</h1>
	    <p class="lead">Result n-1 and n-2 for operations.</p>
	  </div>
	</div> 
	<div class="card" style='text-align:center; background: #b3ffb3;padding:10px;margin: 10px 10% 10px 10%;border-radius: 15px'>
		  <div class="card-header">
		    <%= op %>
		  </div>
		  <div class="card-body">
		    <h5 class="card-title">Result for the operation:</h5>
		    <p class="card-text"><%= n1 %>  <%= op %>  <%=n2 %> = <%=res %> </p>
		    <a href="index.jsp" class="btn btn-primary">Go  Home</a>
		  </div>
		</div>
</body>
</html>