<%@page import="dbUtil.HospitalUtil,java.util.*"%>
<%
String h_name = (String)session.getAttribute("h_name");
if(h_name!=null){
%>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Your Doc+ | Doctor Affiliations</title>
	</head>
	<body>
		<div>
			<a href='hospital_home.jsp'>Back</a>
			|<a href='pending_request_hospitals.jsp'>Pending Requests</a>  <span style='color:white;background:black;padding:2px'><%= HospitalUtil.getPendingRequest(Integer.parseInt((String)session.getAttribute("h_id"))) %></span>
			<h1>Welcome<b> <%= h_name %></b></h1>
			<form action="logout_h" method='POST'>
				<input type="submit" value='Logout'>
			</form>
		</div>
		<%
				String msg_doc_aff =(String) application.getAttribute("msg_doc_aff");
				if(msg_doc_aff != null){
					%>
					<p style='color: red; background-color: yellow'> <%= msg_doc_aff %> </p>
					<%
					application.setAttribute("msg_doc_aff", null);
				}
			%>
		<h1><%= h_name %> Affiliations</h1>
		<hr>
		<h2>Request Affiliations</h2> 	
		<p>Hospitals can request the doctors to be a part of their hospital.</p>
		
		<form action="sendCodeToDoctor" method = 'POST'>
			<select name="d_id">
				<%
					ArrayList<HashMap<String,Object>> d_list_un_aff = HospitalUtil.getUnAffiliatedDictors(Integer.parseInt((String)session.getAttribute("h_id")));
					for(HashMap<String,Object> d_details : d_list_un_aff){
					%>
						<option value='<%= d_details.get("d_id")%>'> 
								Name:<%= d_details.get("d_name")%>  
								| Email:<%= d_details.get("d_email")%> 
								| Specialization:<%= d_details.get("d_specialization")%> 
								| Qualification:<%= d_details.get("d_qualification")%> 
								
						</option>
					<%	
					}
				%>	
			
			</select>
			<input type="submit" value="Send Code">
		</form>
		<hr>
		<h1>My Affiliation</h1>
		<p>Currently affiliated doctors</p> 
				<%
					ArrayList<HashMap<String,Object>> d_list_aff = HospitalUtil.getAffiliatedDictors(Integer.parseInt((String)session.getAttribute("h_id")));
					for(HashMap<String,Object> d_details : d_list_aff){
						%>
						<form action="callOfAffiliation" method = 'POST' style='background: aqua;margin:5px;padding:5px'> 
										<b>Name:</b><%= d_details.get("d_name")%>  
										<b>| Email:</b><%= d_details.get("d_email")%><br>
										<b>Specialization:</b><%= d_details.get("d_specialization")%> 
										<b>| Qualification:</b><%= d_details.get("d_qualification")%><br>
										<b>Address:</b><%= d_details.get("d_address")%> 
									<input type="hidden" name = "d_id" value = '<%= d_details.get("d_id")%> %>'>
							<input type="submit" value="CLose Affiliation">
						</form> 
						<% 
					}
				%>	
		<hr>
	</body>
	</html>
<%
}else{
	application.setAttribute("msg_h", "Please login first..!");
	response.sendRedirect("index.jsp#hospitak_login");
}
%>