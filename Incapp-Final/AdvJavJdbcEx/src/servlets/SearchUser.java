package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchUser extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String un=request.getParameter("username");
		out.print("<html><body>");
		out.print("<h1>User Application</h1>");
		//jdbc code
		try {
			ServletContext ctx=getServletContext();
			String dbdriver=ctx.getInitParameter("dbdriver");
			String dbpath=ctx.getInitParameter("dbpath");
			String dbid=ctx.getInitParameter("dbid");
			String dbpass=ctx.getInitParameter("dbpass");
			Class.forName(dbdriver);
			Connection c=DriverManager.getConnection(dbpath,dbid,dbpass);
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from user_info where name like '%"+un+"%'");
			while(rs.next()) {
				out.print("Name: "+rs.getString("name")+"<br/>");
				out.print("Email: "+rs.getString("email")+"<br/>");
				out.print("Phone: "+rs.getString("phone")+"<br/>");
				out.print("Age: "+rs.getInt("age")+"<hr/>");
			}
			c.close();
		}catch(Exception ex) {
			out.print(ex);
		}
		out.print("</body></html>");
		out.close();
	}
}
