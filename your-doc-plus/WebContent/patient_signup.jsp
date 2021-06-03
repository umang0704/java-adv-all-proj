<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Doc+: Sign Up</title>
</head>
<body>
	<jsp:include page="header_home.jsp"></jsp:include>
	<h2>Patient Sign Up</h2>
	<%
				String msg =(String) application.getAttribute("msg");
				if(msg != null){
					%>
					<p style='color: red; background-color: yellow'> <%= msg %> </p>
					<%
					application.setAttribute("msg", null);
				}
			%>
	<form action="create_patient_account.jsp">
		Email: <input type="email" placeholder="Enter Email Id" name='email'required="required" /><br><br>
		Password: <input type="password" placeholder="Enter Password" name='password'	required="required" /><br><br>
		Password: <input type="password" placeholder="Re-Enter Password" name='repassword'	required="required" />
		<hr>
		Name: <input type="text" placeholder="Name"name='name' required="required" /> <br><br>
		Age: <input type="number" placeholder="Age" name='age' required="required" /> <br><br>
		Phone: <input type="tel" placeholder="Phone" name='ph' required="required" /> <br><br>
		Address: <input type="text" placeholder="Name"name='address' required="required" /> <br><br>
		Gender: <select name='gender'>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Other">Other</option>
		</select><br><br>
		 <input type="submit" value="Sign Up"> 
		 <input type="reset" value="Reset">
	</form>

</body>
</html>