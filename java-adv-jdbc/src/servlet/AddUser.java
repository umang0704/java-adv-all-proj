package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String un=request.getParameter("username");
		String e=request.getParameter("email");
		int a=Integer.parseInt(request.getParameter("age"));
		String ph=request.getParameter("phone");
		String p=request.getParameter("password");
		out.print("<html><body>");
		out.print("<h1>User Application</h1>");
		//jdbc code
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info?useSSL=false","root","Umang@123");
			Statement st=c.createStatement();
			//request scope
			String uid=un.substring(0,4)+ph.substring(ph.length()-4,ph.length());
			request.setAttribute("uid", uid);
			st.executeUpdate("insert into user_info values('"+e+"','"+p+"','"+un+"',"+a+",'"+ph+"')");
			//out.print("<p> User Added successfully! </p>");
			//Request Dispatcher
			RequestDispatcher rd=request.getRequestDispatcher("success");
			rd.include(request, response);
			c.close();
		}catch(java.sql.SQLIntegrityConstraintViolationException ex) {
			out.print("<p> User email Already exist! </p>");
		}catch(Exception ex) {
			out.print(ex);
		}
		out.print("</body></html>");
		out.close();
	}
	

}
