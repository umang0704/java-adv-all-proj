<%@page import="javax.naming.InitialContext,ejb.HelloLocal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.html" %> 
 <%!
  private HelloLocal h ;
  float result=0;

  public void jspInit() {
  try {
  
  InitialContext ic = new InitialContext();
  
  h = (HelloLocal) ic
  .lookup("java:global/Lab-10-Web/ejb/Hello");

  System.out.println("Loaded Calculator Bean");
//CalculatorBean

  } catch (Exception ex) {
  System.out.println("Error:"+
  ex.getMessage());
  }
  }
  public void jspDestroy() {
  h = null;
  }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator using EJB</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron jumbotron-fluid" style='size:25%;background: #b3d1ff !important;padding:10px;margin:10px;border-radius: 15px'>
	  <div class="container">
	    <h1 class="display-4">Calculator</h1>
	    <p class="lead">Enter n-1 and n-2 for operations.</p>
	  </div>
	</div>
	<form action='result.jsp' method='POSt' style='background: #ffcc99;padding:10px;margin: 10px;border-radius: 15px'>
		  <div class="form-group">
		    <label for="exampleInputEmail1">N-1</label>
		    <input type="number" name='n1' class="form-control" placeholder="Enter n-1"> 
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">N-2</label>
		    <input type="number" name="n2" class="form-control" placeholder="Enter n-1">
		  </div> 
		  <div class='form-group'>
		  <label for="exampleInputPassword1">Select Operation</label>
			  <select class="form-select" name='op' aria-label="Default select example">
				 <option selected>Open this select menu</option>
				  <option value="add">Add</option>
				  <option value="sub">Subtract</option>
				  <option value="mul">Multiply</option>
				  <option value="div">Divide</option>
				</select>
		  </div>
		  <br>
		  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>