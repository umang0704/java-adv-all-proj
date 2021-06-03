package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteProd
 */
@WebServlet("/delete")
public class DeleteProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Product Application</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<h1>Welcome to Store.</h1>\r\n" + 
				"	<hr>\r\n" + 
				"	<a href=\"index.html\">Home</a>\r\n" + 
				"	<hr>");
			try {
				String n=request.getParameter("name");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/productapp?useSSL=false","root","Umang@123");
				Statement st=c.createStatement();
				st.executeUpdate("DELETE FROM `productapp`.`products` WHERE (`name` = '"+n+"');");
				out.print("<h1> Product  '"+n+"' successfully deleted</h1><hr>");
			}catch(Exception e){

				out.print("<h1>"+e+"</h1><hr>");
			}
		out.print("</body>\r\n" + 
				"</html>");
	}

}
