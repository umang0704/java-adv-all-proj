
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup-style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@700&display=swap" rel="stylesheet"> 
<title>Login</title>
</head>
<body>
<div id='container'>
<div class="login-signup">
  <div class='signup'>
  <form action="loginAction.jsp" method="POST">
  <input type="email" name="email" placeholder="Enter Email" required>
    <input type="password" name="password" placeholder="Enter Password" required>
    <input type="submit" value="Login">
  </form>
       <h2><a href="signup.jsp">SignUp</a></h2>
  </div>
  <div class='whysignLogin'>
  <h1>Online Shopping</h1>
    <p>The Online Shopping System is the application that allows the users to shop online without going to the shops to buy them.</p>
  
  <%
  String msg=request.getParameter("msg");
  if("notexist".equals(msg)){
		%>
	<h1>Incorrect Username or Password</h1>
	<% } %>
	<%
	if("invalid".equals(msg))
	{
	%>
	<h1>Some thing Went Wrong! Try Again !</h1>
	<% } %>

    </div>
    </div>
</div>

</body>
</html>