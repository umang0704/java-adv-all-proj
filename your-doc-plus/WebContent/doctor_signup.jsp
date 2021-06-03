<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Doc+|Doctor Sign Up</title>
</head>
<body>
	
	<div id='d_signup_nav'>
		<a href = 'index.jsp'>Home</a>
		|<a href='index.jsp#doctor_login'>Doctors LogIn</a>
		<h1>Your Doc+</h1>  
		<h2>Doctor Sign Up:</h2>
	</div>
	<hr>
	<div id='d_signup_form'>
		<form action="createDoctorAccount" method='POST'>
			Email: <input type="email" placeholder="Enter Email Id" name='email'required="required" /><br><br>
			Password: <input type="password" placeholder="Enter Password" name='password'	required="required" /><br><br>
			Confirmation-Password: <input type="password" placeholder="Re-Enter Password" name='repassword'	required="required" />
			<hr>
			Name: <input type="text" placeholder="Name"name='name' required="required" /> <br><br>
			Specialization : <input type="text" placeholder="Specialization" name='specialization' required="required" /> <br><br>
			Phone: <input type="tel" placeholder="Phone" name='ph' required="required" /> <br><br>
			Address: <input type="text" placeholder="Address" name='address' required="required" /> <br><br>
			Qualification: <input type="text" placeholder="Qualification"name='qualification' required="required" /> <br><br>
<!-- 			Clinic List:<br><br> -->
<!-- 				<input type='text' placeholder='Clinic 1'name='c1' required="required"/> <br> <br> -->
<!-- 				<input type='text' placeholder='Clinic 1'name='c1'/> <br> <br> -->
<!-- 				<input type='text' placeholder='Clinic 2'name='c2'/> <br> <br> -->
<!-- 				<input type='text' placeholder='Clinic 3'name='c3'/> <br> <br> -->
			
<!-- 			Hospital Affiliated:<br><br> -->
<!-- 				<div id = 'hospital_list'> -->
					
<!-- 					<input type="checkbox" name='' value=''> <br> -->
					
<!-- 				</div> -->
			
			Gender: <select name='gender'>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
				<option value="Other">Other</option>
			</select><br><br>
			 <input type="submit" value="Sign Up"> 
			 <input type="reset" value="Reset">
		</form>
	</div>
</body>
</html>