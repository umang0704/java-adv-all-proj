<%@page import="dbUtil.Doctor_DbUtil,java.util.*" %>
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
<title>Your Doc+|<%= d_name %> Account Settings</title>
<style type="text/css"> 
	h2 {
	background: yellow;
}
h1{
background: grey;
}
h3{
background: green;
}
</style>
</head>
<body>
	<a href='doctor_home.jsp'>Home</a> 
		<form action="logout_1">
			<input type="hidden" name="msg_type" value="msg_d"/>
			<input type="submit" value="Logout">
		</form>
	 
	<h1><%= d_name %>'s Account</h1>
	<hr>
	<h2>My Account</h2>
	<%
				String msg_ae =(String) session.getAttribute("msg_ae");
				if(msg_ae != null){
					%>
					<p style='color: red; background-color: yellow'> <%= msg_ae %> </p>
					<%
					session.setAttribute("msg_ae", null);
				}
	%>
	<%
	try{

		ArrayList<String> det = Doctor_DbUtil.getAccountDetails((String)session.getAttribute("d_id"));
		%>
		
				
			<form action="editPersonalDetails" method='POST'> 
				Name:
				<input type="text" placeholder='<%= det.get(0) %>' value='<%= det.get(0) %>' name='name' required><br><br> 
				
				Email:
				<input type="text" placeholder='<%= det.get(1) %>' value='<%= det.get(1) %>' name='email' required><br><br>
				
				Phone:
				<input type="text" placeholder='<%= det.get(2) %>' value='<%= det.get(2) %>' name='phone' required><br><br>
				
				Specialization:
				<input type="text" placeholder='<%= det.get(3) %>' value='<%= det.get(3) %>' name='specialization' required><br><br>
				
				Qualification:
				<input type="text" placeholder='<%= det.get(4) %>' value='<%= det.get(4) %>' name='qualification' required><br><br>
				
				Gender:
				<input type="text" placeholder='<%= det.get(5) %>' value='<%= det.get(5) %>' name='gender' required><br><br>
				
				Address:
				<input type="text" placeholder='<%= det.get(6) %>' value='<%= det.get(6) %>' name='address' required><br><br>
				
				 
				<input type="submit" value='Save Changes' /> 
				<input type="reset" value='Reset' />
			</form>
		
		<%
	}catch(Exception ex){
		ex.printStackTrace();
	}
	%>
	<hr>
	<h2>Clinics</h2>
	<%
				String msg_c =(String) session.getAttribute("msg_c");
				if(msg_c != null){
					%>
					<p style='color: red; background-color: yellow'> <%= msg_c %> </p>
					<%
					session.setAttribute("msg_c", null);
				}
	%>
	<form action="addClinic" method='POST'>
		<h3>Add Clinics</h3>
		<input type="text" placeholder="Clinic Name" name="cname"	required="required" />
		<input type="text" placeholder="Address" name="address"	required="required" /> 
		<input type='hidden' name='id' value='<%= session.getAttribute("d_id")%>'>
		<input type="text" placeholder="Time (Ex: 9am-12pm)" name="gfromto"/> 
		<input type="submit" value='Add' /> 
		<input type="reset" value='Reset' />
	</form>
	<h3>My Clinics</h3>
	
	<%
	try{

		ArrayList<ArrayList<String>> clinics = Doctor_DbUtil.getClinicList((String)session.getAttribute("d_id")); 	
		if(!clinics.isEmpty()){ 
			for(ArrayList<String> i : clinics){ 
				%>
				<div>
					<table>
						<tr>
							<td> 
								<form action="editClinic.jsp" method='POST'  > 
									<input type='hidden' name='cname' value='<%= i.get(0) %>'>
									<input type='hidden' name='address' value='<%= i.get(1) %>'>
									<input type='hidden' name='gfromto' value='<%= i.get(2) %>'>
									<p>  <%= i.get(0) %> | <%=i.get(1)  %> | <%=i.get(2)  + "\t"%><input type="submit" value='Edit' /> </p> 
								</form>
							</td>
							<td>
								<form action="deleteClinic" method='POST'> 
									<input type='hidden' name='cname' value='<%= i.get(0) %>'>
									<input type='hidden' name='address' value='<%= i.get(1) %>'>
									<input type='hidden' name='gfromto' value='<%= i.get(2) %>'>
									<input type="submit" value='Delete' />
								</form>
							</td>
						</tr>
					</table>
				</div>
			<%
			}
		} 
	}catch(Exception ex1){
		ex1.printStackTrace();
	}
	%> 
	<hr>
	<h2>Hospital Affiliation</h2>
	<h3>Request Affiliation</h3>
	<form action="requestAffiliation">
		<select name="hospital">
			<option value=""> </option>
		</select>
	</form>
	<h3>My Affiliation</h3>
	<form action="revokeAffiliation">
		Name:
		<input type="submit" value='Revoke'>
	</form>
</body>
</html>
<%
}else{
	response.sendRedirect("index.jsp#doctor_login");
}
%>