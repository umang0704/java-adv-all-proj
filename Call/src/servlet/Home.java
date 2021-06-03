package servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;

public class Home extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Calling</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<a href=\"called\">Called</a>\r\n"
				+ "	|<a href=\"not_called\">Not Called</a>\r\n"
				+ "	<hr>\r\n"
				+ "	<table>\r\n"
				+ "		<tr style=\"width:100%;border: 1px solid black;border-collapse: collapse;\">\r\n"
				+ "			<th style=\"border: 1px solid black;border-collapse: collapse;\">Name</th>\r\n" 
				+ "			<th style=\"border: 1px solid black;border-collapse: collapse;\">Called/Not Called</th>\r\n"
				+ "			<th style=\"border: 1px solid black;border-collapse: collapse;\">Status</th>\r\n"
				+ "		</tr> \r\n");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/call?useSSL=false", "root", "Umang@123");
			Statement st = c.createStatement();
			ResultSet rs=st.executeQuery("select * from call.call");
		while(rs.next()) {
			
		
	out.print( 
			 "<tr>\r\n"
			+"<td style=\"border: 1px solid black;border-collapse: collapse;\">"+rs.getString("name")+" </td><br>\r\n" 
				+ "		<td style=\"border: 1px solid black;border-collapse: collapse;\"> \r\n"
				+ "		<form action=\"called_op\">\r\n"
				+ "			<input type=\"hidden\" name='cname1' value="+rs.getInt("id")+"/>\r\n"
				+ "			<button type=\"submit\">Called</button>\r\n"
				+ "		</form>\r\n"
				+ "		<form action=\"not_called_op\">\r\n "
				+ "			<input type=\"hidden\" name='cname2' value="+rs.getInt("id")+" />\r\n"
				+ "			<button type=\"submit\">Not Called</button>\r\n"
				+ "		</form>  \r\n"
				+ "		</td>\r\n"
				+ "		<td style=\"border: 1px solid black;border-collapse: collapse;\"> \r\n"
				+ "		<form action=\"\">\r\n"
				+ "			<input type=\"hidden\" name='cname3' value="+rs.getInt("id")+"/>\r\n"
				+ "			<input type=\"text\" name='status' value='"+ rs.getString("coming")+"'required>\r\n"
				+ "			<button type=\"submit\">Set Status</button>\r\n"
				+ "		</form>\r\n"
				+ "		\r\n"
				+ "		</td>\r\n"
				+ "		</tr>\r\n");
		}
	}catch (Exception e) {
		// TODO: handle exception
	}

		out.print( "	</table>\r\n"
		+ "</body>\r\n"
		+ "</html>");
	}
	

}
