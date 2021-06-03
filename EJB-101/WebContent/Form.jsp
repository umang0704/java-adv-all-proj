<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body{
		background-image: linear-gradient(to right, #538FFB, #5B54FA);
	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	
</head>
<body>
	<div class="jumbotron jumbotron-fluid"
		style='color:white;text-align: center; size: 25%; background: #00BC40 !important; padding: 10px; margin: 10px 10% 10px 10%; border-radius: 15px'>
		<div class="container">
			<h1 class="display-4">Bank Transaction Request Form.</h1> 
		</div>
	</div>
	<form action='WebClient.jsp' method='POSt' style=' background: #FF9347;padding:100px;margin: 10px 10% 10px 10%;border-radius: 15px'>
		  <div class="form-group">
		    <label for="exampleInputEmail1">Enter the Amount:</label>
		    <input type="number" name='amount' class="form-control" placeholder="Enter The Amount"> 
		  </div> 
		  <div class='form-group'>
		  <label for="exampleInputPassword1">Select Operation</label>
			  <select class="form-select" name='op' aria-label="Default select example">
				 <option selected>Open this select menu</option>
				  <option value="dep"> Deposit</option>
				  <option value="withdraw">Withdraw</option> 
				</select>
		  </div>
		  <br>
		  <button type="submit" class="btn btn-success">Submit</button>
	</form>
</body>
</html>