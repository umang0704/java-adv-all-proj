<%@page import="java.util.*"%>
<%
	String admin_name=(String)session.getAttribute("admin_name");
	if(admin_name!=null){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planto</title>
</head>
<body>
	<h1>Planto App</h1>
	<hr/>
	Welcome: <b> <%=admin_name %> </b> <a href='adminHome.jsp'>HOME</a> | <a href='Logout'>Logout</a>
	<hr/>
	<%
	dao.DbConnect db=new dao.DbConnect();
	ArrayList<HashMap> allPlants=db.getAllPlants();
	for(HashMap plant : allPlants){
	%>
		<p>
			Plant ID: <b><%= plant.get("plant_id") %> </b>
			Name: <b><%= plant.get("name") %> </b>
			Price: <b><%= plant.get("price") %> </b> 
			Category: <b><%= plant.get("category") %> </b>
			Height: <b><%= plant.get("height") %> </b>
			Quantity: <b><%= plant.get("quantity") %> </b> 
			<a href='plantDetails.jsp?plant_id=<%= plant.get("plant_id") %>'>View Details</a>
		</p>
		<hr/>
	<%
	}
	%>
</body>
</html>
<% 
}else{
	session.setAttribute("msg","Plz login!");
	response.sendRedirect("adminLogin.jsp");
}
%>