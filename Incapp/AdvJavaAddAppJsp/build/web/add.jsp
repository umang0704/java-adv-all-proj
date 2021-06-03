<!DOCTYPE html>
<%
int n1=Integer.parseInt(request.getParameter("num1"));
int n2=Integer.parseInt(request.getParameter("num2"));
int n=n1+n2;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Application:</h1>
        <p>Sum of <b> <%=n1%> </b> and <b> <%=n2%> </b> is <b> <%=n%> </b>. </p>
    </body>
</html>
