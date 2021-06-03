<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/CustomTag.tld" prefix="ct"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Doc+: Sign Up</title>
</head>
<body>

	<h2>Patient Sign Up</h2>
	<ct:authMessageCreate message="hello" style="color:red"></ct:authMessageShow>
	<form action="create_patient_account.jsp">
		Email: <input type="email" placeholder="Email Id" required="required" />
		<br> Password: <input type="password" placeholder="Password"
			required="required" />
		<hr>
		Name: <input type="text" placeholder="Name" required="required" /> <br>
		Age: <input type="number" placeholder="Age" required="required" /> <br>
		Phone: <input type="tel" placeholder="Phone" required="required" /> <br>
		Gender: <select>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Other">Other</option>
		</select><br>
		 <input type="submit" value="Sign Up"> 
		 <input type="reset" value="Reset">
	</form>

</body>
</html>