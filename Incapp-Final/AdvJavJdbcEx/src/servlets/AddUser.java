package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class AddUser extends HttpServlet {
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
			ServletContext ctx=getServletContext();
			String dbdriver=ctx.getInitParameter("dbdriver");
			String dbpath=ctx.getInitParameter("dbpath");
			String dbid=ctx.getInitParameter("dbid");
			String dbpass=ctx.getInitParameter("dbpass");
			Class.forName(dbdriver);
			Connection c=DriverManager.getConnection(dbpath,dbid,dbpass);
			Statement st=c.createStatement();
			st.executeUpdate("insert into user_info values('"+e+"','"+p+"','"+un+"',"+a+",'"+ph+"')");
			RequestDispatcher rd=request.getRequestDispatcher("success");
			rd.forward(request, response);
			c.close();
		}catch(java.sql.SQLIntegrityConstraintViolationException ex) {
			response.sendRedirect("userError.html");
		}catch(Exception ex) {
			out.print(ex);
		}
		out.print("</body></html>");
		out.close();
	}
}
