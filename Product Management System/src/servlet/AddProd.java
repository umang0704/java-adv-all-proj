package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;


/**
 * Servlet implementation class AddProd
 */
@WebServlet("/add")
public class AddProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				int a= Integer.parseInt(request.getParameter("price"));
				String i=request.getParameter("info");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/productapp?useSSL=false","root","Umang@123");
				Statement st=c.createStatement();
				st.executeUpdate("insert into products values('"+n+"','"+a+"','"+i+"');");
				out.print("<h1> Product  '"+n+"' success fully added</h1>"
						+ "<b>Name:</b>"+n+".<br>"
								+ "<b>Price:</b>"+a+".<br>"
										+ "<b>Info:</b>"+i+".<br><hr>");
			}catch(java.sql.SQLIntegrityConstraintViolationException ex1) {
				out.print("<h1>Product Already Exist</h1><hr>");
			}catch(Exception e){

				out.print("<h1>"+e+"</h1><hr>");
			}
		out.print("</body>\r\n" + 
				"</html>");
	}

}
