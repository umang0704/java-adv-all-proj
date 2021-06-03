<%@page import="dbUtil.HospitalUtil"%>
<%@page import="java.util.*"%>
<%
	ArrayList<String> tiers = HospitalUtil.getHospitalTier();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Doc+| Hospital Sign Up</title>
</head>
<body>
	<div id='d_signup_nav'>
			<a href = 'index.jsp'>Home</a>
			|<a href='index.jsp#hospital_login'>Hospital LogIn</a>
			<h1>Your Doc+</h1>  
			<h2>Hospital Sign Up:</h2>
		</div>
		<hr>
		<div id='d_signup_form' method='POST'>
			<form action="createHospitalAccount" method='POST'>
				Email: <input type="email" placeholder="Enter Email Id" name='email'required="required" /><br><br>
				Password: <input type="password" placeholder="Enter Password" name='password'	required="required" /><br><br>
				Confirmation-Password: <input type="password" placeholder="Re-Enter Password" name='repassword'	required="required" />
				<hr>
				Name: <input type="text" placeholder="Name"name='name' required="required" /> <br><br>
				Phone: <input type="text" placeholder="Phone" name='ph' required="required" /> <br><br>
				Address: <input type="text" placeholder="Address"name='address' required="required" /> <br><br>
				Hospital Care Facility: <a href = 'hospital_tier.html' target='_blank'  > Read Details </a> <br><br>
				<%
				if(!tiers.isEmpty()){
					for(String t : tiers){
					%>
						<input type="checkbox" name=<%=t %> value=<%=t %>> <%=t %> <br><br>
					<%	
					}
				}
				%>				
				
				 <input type="submit" value="Sign Up"> 
				 <input type="reset" value="Reset">
			</form>
	</div>
</body>
</html>