<%
String d_name = (String) session.getAttribute("d_name");
if (d_name != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Doc+| <%= d_name %> </title>
</head>
<body>
	<div id = 'doctor_menu'> 
			 <a href = 'all_doctors_plist.jsp'>All Doctors</a>
			| <a href = 'all_hospitals_plist.jsp'>All Hospitals</a>
			| <a href = 'all_hospitals_plist.jsp'>Scheduled Appointment</a>
			| <a href = 'all_hospitals_plist.jsp'>Canceled Appointment</a>
			| <a href = 'all_hospitals_plist.jsp'>Visited Appointment</a>
	</div>
	<hr>
	
	<div id='p_nav'>
		<h1>Your Doc +</h1>  
		<p>
			Welcome:<b><%=d_name%></b>
			
		</p> 
		<form action="logout_1">
			<input type="hidden" name="msg_type" value="msg_d"/>
			<input type="submit" value="Logout">
		</form>
		<form action="doctorAccountSetting.jsp">
			<input type="hidden" name="id" value='<%= session.getAttribute("d_id")%>'/> 
			<input type="submit" value="Account Settings">
		</form> 
	</div>
	<hr>
	<div id = 'appointments'>
		
	</div>
	
	<hr> 
</body>
</html>
<%
}else{
	response.sendRedirect("index.jsp#doctor_login");
}
%>