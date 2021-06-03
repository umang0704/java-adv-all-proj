<%@page import="java.time.LocalDateTime"%>
<%@page session="true"%>
<%@page info="This page is for display output."%>
<%@page language="java"%>
<%@page buffer="50kb"%>
<%@page isELIgnored="false"%>
<%@page isThreadSafe="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to my page</h1>
        <p> <%= LocalDateTime.now() %> </p>
        
        <p> <%= session %> </p>
        
        <p> <%= getServletInfo() %> </p>
    </body>
</html>
