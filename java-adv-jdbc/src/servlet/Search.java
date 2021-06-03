package servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.print("<html><head><title>User application</title></head><body>");
		out.print("<h1>User Application</h1>");
		String n=request.getParameter("username");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info?useSSL=false","root","Umang@123");
			Statement st=c.createStatement();	
			ResultSet r=st.executeQuery("select * from user_info where name like'%"+n+"%'");
			while(r.next()) {
				out.print("<b>Name:</b>"+r.getString("name")+"<br>");
				out.print("<b>Email:</b>"+r.getString("email")+"<br>");
				out.print("<b>Phone:</b>"+r.getString("phone")+"<br>");
				out.print("<b>Age:</b>"+r.getInt("age")+"<hr>");
			}
			c.close();
		}catch(Exception e) {
			out.print(e);
		}
	}

}
