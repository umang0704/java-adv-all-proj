<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	Integer count=(Integer)application.getAttribute("count");
	if(count==null){
		count=0;
	}
	application.setAttribute("count", ++count);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product APP</title>
</head>
<body>
	<h1>Welcome to Product APP</h1>
    <hr/>
    <h2>Search product</h2>
    <form action="SearchProduct.jsp" method="post">
        <label>enter product name: </label>
        <input type="text" name='pname' required/>
        <button type="submit">GO</button>
    </form>
    <hr/>
    <a href='admin.jsp'>admin page</a>
</body>
</html>