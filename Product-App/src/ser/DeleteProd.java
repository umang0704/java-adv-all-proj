package ser;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeleteProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Product Store</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				//"	<a href=\"index.html\">Home</a> <hr>\r\n" + 
				//" <a href=\"welcome\">Home</a> <hr>\r\n"+
				"		<h1>"+getServletConfig().getInitParameter("pgname")+"</h1>");
		try {
			String n=request.getParameter("name2");
			System.out.println(n);
			ServletContext ctx=getServletContext();
			String driver=ctx.getInitParameter("dbDriver");
			String path=ctx.getInitParameter("dbPath");
			String id=ctx.getInitParameter("dbId");
			String pass=ctx.getInitParameter("dbPass");
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(path,id,pass);
			Statement s=connection.createStatement();
			int del=s.executeUpdate("DELETE FROM `productapp`.`products` WHERE (`name` = '"+n+"');");
			System.out.println(del);
			RequestDispatcher rd1=request.getRequestDispatcher("deleteSuccess");
			RequestDispatcher rd2=request.getRequestDispatcher("delUnsuccess");
			if(del==0) {
				rd2.forward(request, response);
			}else {
				rd1.include(request,response);
			}
		}catch(Exception e){

			out.print("<h1>"+e+"</h1><hr>");
		}
	out.print("</body>\r\n" + 
			"</html>");
	}

}
