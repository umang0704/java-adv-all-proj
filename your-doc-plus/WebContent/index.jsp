<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@ page import="dbUtil.PatientUtil"%>
<%

Integer view = (Integer) application.getAttribute("view");
if (view == null) {
	view = 0; 
} 

application.setAttribute("view",++view);
// Cookie ck[] = request.getCookies();
// for (Cookie c : ck) { 
// 	if(!c.getName().equals("name")){
// 		Cookie c1 = new Cookie("name",session.getId());
// 	}
// }
int users = PatientUtil.getUserCount();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Your Doc +</title>
<!-- 	<style type="text/css"> 
		body {font-family: Arial, Helvetica, sans-serif;}
		form {border: 3px solid #f1f1f1;}
		input[type=text], input[type=password] {
		  width: 100%;
		  padding: 12px 20px;
		  margin: 8px 0;
		  display: inline-block;
		  border: 1px solid #ccc;
		  box-sizing: border-box;
		}
		.container {
	  		padding: 16px;
	  		back-ground:
		}
		input[type=submit], input[type=reset]{
		  background-color: #4CAF50;
		  color: white;
		  padding: 14px 20px;
		  margin: 8px 0;
		  border: none;
		  cursor: pointer;
		  width: 100%;
		}
		.imgcontainer {
		  text-align: center;
		  margin: 24px 0 12px 0;
		}
		​
		img.avatar {
		  width: 40%;
		  border-radius: 50%;
		} 
	</style>-->
</head>
<body>
	<jsp:include page="header_home.jsp"></jsp:include>
 	<p>
		Page hit:
		<%= view%>
		| Users:
		<%= users%>
	</p>
	<!--Patient Login -->
	<section id='patient_login'>
		
		<div>
			<h2>Patient Login:</h2>
			<br>
			<%
				String msg =(String) application.getAttribute("msg");
				if(msg != null){
					%>
					<p style='color: red; background-color: yellow'> <%= msg %> </p>
					<%
					application.setAttribute("msg", null);
				}
			%>
			<form action="patientLogInAuth" method='POST'>
				<div class="container">
					<input type="text" placeholder="Patient Id" name="p_email" required="required" /> <br> 
					<input type="password"	placeholder="Patient Password" name="p_password" required="required" /><br>
					<input type="submit" value='Sign In' /> 
					<input type="reset" value='Reset' />
				</div>

			</form>
			
			
			<a href='forgot_password.jsp?type=patient'>Forgot Password</a>
			<a href='patient_signup.jsp'>Sign Up</a>
		</div>
		<div>
			<img alt="doc1.png" src="images/doc1.png">
		</div>
	</section>
	<hr>
	<!-- Doctors logIn -->
	<%
				String msg_d =(String) session.getAttribute("msg_d");
				if(msg_d != null){
					%>
					<p style='color: red; background-color: yellow'> <%= msg_d %> </p>
					<%
					session.setAttribute("msg_d", null);
				}
	%>
	<section id='doctor_login'>
		<div>
			<h2>Doctor Login:</h2>
			<br>
			<form action="doctortLogInAuth" method='POST'>
				<input type="email" placeholder="Doctor Id" name="d_email"required="required" /> <br> 
				<input type="password"placeholder="Doctor Password" name="d_password" required="required" /><br>
				<input type="submit" value='Sign In' /> 
				<input type="reset" value='Reset' />
			</form>
			<a href='doctor_signup.jsp'>Sign Up</a>
		</div>
		<div>
			<img alt="doc1.png" src="images/doc1.png">
		</div>
	</section>
	<hr>
	
	<!-- Hospital logIn -->
	<%
				String msg_h =(String) application.getAttribute("msg_h");
				if(msg_h != null){
					%>
					<p style='color: red; background-color: yellow'> <%= msg_h %> </p>
					<%
					application.setAttribute("msg_h", null);
				}
	%>
	<section id='hospital_login'>
		<div>
			<h2>Hospital Login:</h2>
			<br>
			<form action="hospitalLogInAuth" method='POST'>
				<input type="email" placeholder="Hospital Id" name="h_email" required="required" /> <br> 
				<input type="password" placeholder="Hospital Password" name="h_password" required="required" /> <br> 
				<input type="submit" value='Sign In' /> 
				<input type="reset" value='Reset' />
			</form>
			<a href='hospital_signup.jsp'>Sign Up</a>
		</div>
		<div>
			<img alt="doc1.png" src="images/doc1.png">
		</div>
	</section>
	<!-- About -->
	<section id='about'>
	</section>
</body>
</html>