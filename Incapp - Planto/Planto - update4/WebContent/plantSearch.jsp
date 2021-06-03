<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	String name=request.getParameter("name");
	dao.DbConnect db=new dao.DbConnect();
	ArrayList<HashMap> allPlants=db.getPlantLikeName(name);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planto</title>
</head>
<body>
	<h1>Planto App</h1>
	<hr/>
	<form action="plantSearch.jsp" method="post">
		<label>Search Plant: </label>
		<input type="search" name="name" required />
		<button type="submit">Search</button>
	</form>
	<a href="signIn.jsp">SignIn</a> | <a href="index.jsp">Home</a>
	Cart: <b>0</b>
	<hr/>
	<%
	for(HashMap plant : allPlants){
	%>
	<div style="width:max-content;border:1px solid gray;padding:20px; float:left;margin:10px;">
		<a href='viewPlant.jsp?plant_id=<%=plant.get("plant_id")%>' style="color:black; text-decoration:none;">
			<img src='GetPhoto?plant_id=<%=plant.get("plant_id")%>&photo_no=1' height="130px" />
			<h3><b><%=plant.get("name")%></b></h3>
			<p><b><%=plant.get("category")%></b></p>
		</a>
		<%
			int quantity=(Integer)plant.get("quantity");
			if(quantity>0){
		%>
				<p style="color:blue;"><b>&#x20B9; <%=plant.get("price")%>/-</b></p>
				<form action="" method="post">
					<input type="hidden" name="plant_id" value="<%=plant.get("plant_id")%>" />
					<button type="submit">Add To Cart</button>
				</form>
		<%		
			}else{
				%>
				<p style="color:red;"><b>OUT OF STOCK!</b></p>
		<%		
			}
		%>
	</div>
	<%
	}
	%>
</body>
</html>