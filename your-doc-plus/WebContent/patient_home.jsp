
<%
String name = (String) session.getAttribute("patient_name");
if (name != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Doc+| <%=name %></title>
</head>
<body>
	<div id = 'patient_menu'> 
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
			Welcome:<b><%=name%></b>
			
		</p>
		<div id='p_search_doc'>
			<form action="p_search_doc.jsp" method="get"> 
				<label>Specialist :</label>
				<select name ='doc_type'>
					<option name='' value''>
			 	</select>
			 	<input type="submit" value='Search'/>
			</form>
		</div> 
		<p>Scheduled Appointment:<b>0</b> </p>
		<a href = 'logout_1'>Log Out</a>
	</div> 
	<hr>
	<div id='p_home_content'>
		<table id='p_home_main_bif'>
			<tr> 
				<td> 
					<div id='p_open_hospitals'>
						<table id = 'p_home_open_hospitals_list'>
						<thead> Open Hospitals</thead>
							<tr>
								<th> Name & Address </th> 
							</tr>
							<tr>
								<td> <button>Name Address</button> </td> 
							</tr>
						</table> 
					</div>
				</td>
				<td> 
					<div id='p_home_avail_doctors'>
						<table id = 'p_home_available_doctors_list'>
						<thead> Available Doctors</thead>
							<tr>
								<th> At Hospitals </th> 
								<th> At Personal Clinic </th> 
							</tr> 
							<tr>
							
								<!-- At Hospitals -->
								<td> <button>Name Address Specialization</button> </td> 
								<!-- At Personal Clinic -->
								<td> <button>Name Address Specialization</button> </td> 
							
							</tr> 
						</table> 
					</div>
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>
<%
} else {
application.setAttribute("msg", "Please LogIn First..!");
response.sendRedirect("index.jsp");
}
%>

