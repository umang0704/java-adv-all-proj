package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/search")
public class Search extends HttpServlet {
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
				ResultSet r=st.executeQuery("select * from products where name like'%"+n+"%'");
				out.print("<table style=\"width:100%;border: 1px solid black;border-collapse: collapse;\">\r\n" + 
						"  <tr>\r\n" + 
						"    <th style=\"border: 1px solid black;border-collapse: collapse;\">Product Name</th>\r\n" + 
						"    <th style=\"border: 1px solid black;border-collapse: collapse;\">Price</th>\r\n" + 
						"    <th style=\"border: 1px solid black;border-collapse: collapse;\">Info</th>\r\n" + 
						"  </tr>");
				while(r.next()) {
					out.print("  <tr>\r\n" + 
							"    <td style=\"border: 1px solid black;border-collapse: collapse;\">"+r.getString("name")+"</td>\r\n" + 
							"    <td style=\"border: 1px solid black;border-collapse: collapse;\">"+r.getInt("price")+"</td>\r\n" + 
							"    <td style=\"border: 1px solid black;border-collapse: collapse;\">"+r.getString("info")+"</td>\r\n" + 
							"  </tr>");
				}
				out.print("</table>");
			}catch(Exception e){

				out.print("<h1>"+e+"</h1><hr>");
			}
		out.print("</body>\r\n" + 
				"</html>");
	}

}
