<%@page import="javax.naming.InitialContext,beans.*,javax.ejb.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.html" %>
<%! public OperationsLocal calc;
	float res = 0.0f;

	public void jspInit() {
		try {
			InitialContext ic = new InitialContext(); 
			calc = (OperationsLocal)ic.lookup("java:global/java-adv-proj/Lab-10/ejbModule/beans/Operations");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<%
	float n1 = Float.parseFloat(request.getParameter("n1"));
	float n2 = Float.parseFloat(request.getParameter("n2"));
	String op = request.getParameter("op");
	if(op.equals("add"))
		res = calc.add(n1, n2);
	if(op.equals("sub"))
		res = calc.subtract(n1, n2);
	if(op.equals("mul"))
		res = calc.multiply(n1, n2);
	if(op.equals("div"))
		res = calc.divide(n1, n2);
%>
<div class="jumbotron jumbotron-fluid" style='size:25%;background: #b3d1ff !important;padding:10px;margin:10px;border-radius: 15px'>
	  <div class="container">
	    <h1 class="display-4">Calculator</h1>
	    <p class="lead">Result n-1 and n-2 for operations.</p>
	  </div>
	</div> 
	<div class="card" style='background: #b3ffb3;padding:10px;margin: 10px;border-radius: 15px'>
		  <div class="card-header">
		    <%= op %>
		  </div>
		  <div class="card-body">
		    <h5 class="card-title">Result for the operation:</h5>
		    <p class="card-text"><%= n1 %><%= op %><%=n2 %> = <%=res %> </p>
		    <a href="index.jsp" class="btn btn-primary">Go  Home</a>
		  </div>
		</div>
</body>
</html>