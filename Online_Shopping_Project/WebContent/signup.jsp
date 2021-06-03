<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup-style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@700&display=swap" rel="stylesheet"> 
<title> SignUp </title>
</head>
<body>
<div id='container'>
  <div class='signup'>
  	<form action="signupAction.jsp" method="POST">
  	<input type="text" name="name" placeholder="Enter Name" required>
  	<input type="email" name="email" placeholder="Enter Email" required>
  	<input type="number" name="mobilenumber" placeholder="Enter Mobile No." required>
  	<select name="securityQuestion" required>
  	<option value="What was your First Car?">What was your First Car?</option>
  	<option value="What is the name of your First pet?">What is the name of your First pet?</option>
  	<option value="What elementry school do you attend?">What elementary school do you attend?</option>
  	<option value="What is the name of the town where you were born?">What is the name of the town where you were born?</option>
  	</select>
  	<input type="text" name="answer" placeholder="Enter answer" required>
  	<input type="password" name="password" placeholder="Enter Password" required>
  	<input type="submit" value="Sign Up">
  	</form>
      <h2><a href="login.jsp">Login</a></h2>
  </div>
  <div class='whysign'>
  <h1>Online Shopping</h1>
    <p>The Online Shopping System is the application that allows the users to shop online without going to the shops to buy them.</p>
<%
String msg=request.getParameter("msg");
if("valid".equals(msg)){
	%>
	<h2>Successfully Registered!!</h2>
<% } %>
<%
if("invalid".equals(msg))
{
%>
<h2>Some thing Went Wrong! Try Again !</h2>
<% } %>
    </div>
</div>

</body>
</html>