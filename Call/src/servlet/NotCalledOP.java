package servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;

public class NotCalledOP extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/call?useSSL=false", "root", "Umang@123");
			Statement st = c.createStatement();
			st.executeUpdate("insert into call.call(status) values('Not Called') where id="+request.getParameter("cname2"));
			response.sendRedirect("home");
		}catch(Exception e) {
			
		}
	}

}
