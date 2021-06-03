<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
  
<html>  
<head>  
<title>jstl</title>  
</head>  
<body>  
   
<sql:setDataSource var="con" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/productdb"  
     user="root"  password="Incapp@12"/>  
  
<sql:query dataSource="${con}" var="rs"> 
select * from product;  
</sql:query>  
  
<c:forEach var="data" items="${rs.rows}">  
	<b>Name:</b> <c:out value="${data.name}"/> 
	<b>Price:</b> <c:out value="${data.price}"/> 
	<b>Information:</b> <c:out value="${data.info}"/> <hr/>
</c:forEach>  
</body>  
</html> 
</html>