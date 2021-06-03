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
	<title>Your Doc + | Pending Requests</title>
	</head>
	<body>
		<div>
			<a href='doctor_affliations.jsp'>Back</a>
			<h1>Welcome<b> <%= h_name %></b></h1>
			<form action="logout_h" method='POST'>
				<input type="submit" value='Logout'>
			</form>
		</div>
		
		<h2>Pending Request</h2>
		<%
				String msg_doc_aff =(String) application.getAttribute("msg_doc_aff");
				if(msg_doc_aff != null){
					%>
					<p style='color: red; background-color: yellow'> <%= msg_doc_aff %> </p>
					<%
					application.setAttribute("msg_doc_aff", null);
				}
		try{
			ArrayList<HashMap<String, Object>> p_list = HospitalUtil.getRecievedPendingRequest((Integer.parseInt((String) session.getAttribute("h_id"))));
			for(HashMap<String, Object> p : p_list ){
				%>							
					<form action="acceptAffiliationRequest" style='background: aqua;margin:5px' method = 'POST'>
						Name:<b><%= p.get("d_name") %></b><br>
						Specialization:<b><%= p.get("d_specialization") %></b><br>
						Qualifications:<b><%= p.get("d_qualification") %></b><br>
						Email:<b><%= p.get("d_email") %></b><br>
						Phone:<b><%= p.get("d_phone") %></b><br>
						Address:<b><%= p.get("d_address") %></b><br>
						<input type="hidden" name = "d_email" value='<%= p.get("d_email")%>'>
						<input type="hidden" name = "d_id" value='<%= p.get("d_id")%>'>
						<input type="submit" value='Accept'>
					</form>
				<%
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		} 
		%> 
		<h2>Sent Request</h2>
		<%
		try{
			ArrayList<HashMap<String, Object>> p_list = HospitalUtil.getSentPendingRequest((Integer.parseInt((String) session.getAttribute("h_id"))));
			for(HashMap<String, Object> p : p_list ){
				%>							
					<form action="" style='background: gray;;;margin:5px'>
						Name:<b><%= p.get("d_name") %></b><br>
						Specialization:<b><%= p.get("d_specialization") %></b><br>
						Qualifications:<b><%= p.get("d_qualification") %></b><br>
						Email:<b><%= p.get("d_email") %></b><br>
						Phone:<b><%= p.get("d_phone") %></b><br>
						Address:<b><%= p.get("d_address") %></b><br>
						<input type="hidden" name = "d_email" value='<%= p.get("d_email")%>'>
						<input type="hidden" name = "d_id" value='<%= p.get("d_id")%>'>
						<input type="submit" value='Revoke'>
					</form>
				<%
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		} 
		%> 
	</body>
	</html>
<%
}else{
	application.setAttribute("msg_h", "Please login first..!");
	response.sendRedirect("index.jsp#hospitak_login");
}
%>