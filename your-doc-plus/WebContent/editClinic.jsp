<%
String d_name = (String) session.getAttribute("d_name");
if (d_name != null) {
%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Doc+ | Edit</title>
</head>
<body>
	<a href='doctor_home.jsp'>Home</a> 
	|<a href='doctorAccountSetting.jsp'>Back</a> 
	<form action="logout_1">
		<input type="hidden" name="msg_type" value="msg_d"/>
		<input type="submit" value="Logout">
	</form>
	<h1>Edit Clinic : <%= request.getParameter("cname") %></h1> 
	<p>by : <b><%=session.getAttribute("d_name") %></b>
	<hr>
	<form action="editClinicDetails" method='POST'>
		Name:
		<input type="text" name = 'cname'placeholder='<%= request.getParameter("cname") %>' required="required"><br><br>
		<input type="hidden" name = 'cname0' value='<%= request.getParameter("cname") %>'>
		
		Address:
		<input type="text" name ='address' placeholder='<%= request.getParameter("address")%>' required="required"><br><br>
		<input type="hidden" name ='address0' value='<%= request.getParameter("address") %>'>
		
		Timing:
		<input type="text" name ='gfromto' placeholder='<%= request.getParameter("gfromto") %>' required="required"><br><br>
		<input type="hidden" name ='gfromto0' value='<%= request.getParameter("address") %>'>
		
		<input type='submit' value='Save Changes'>
		<input type="reset" value='Reset Fields'>
	</form>
</body>
</html>
<%
}else{
	response.sendRedirect("index.jsp#doctor_login");
}
%>