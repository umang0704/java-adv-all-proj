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
			<h1 class="display-4">Entity Beans: EJB.</h1> 
		</div>
	</div>
	<form action='WebClient2.jsp' method='POSt' style=' background: #FF9347;padding:100px;margin: 10px 10% 10px 10%;border-radius: 15px'>
		  <div class="form-group">
		    <label for="exampleInputEmail1">UserId</label>
		    <input type="text" name='usn' class="form-control" placeholder="Enter The USN"> 
		  </div> 
		  <div class="form-group">
		    <label for="exampleInputEmail1">Name</label>
		    <input type="text" name='name' class="form-control" placeholder="Enter The name"> 
		  </div> 
		  <br>
		  <button type="submit" class="btn btn-success">Submit</button>
	</form>
</body>
</html>