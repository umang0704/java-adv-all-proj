package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class Success extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String un=request.getParameter("username");
		out.print("<html><body>");
		out.print("<h1>User Application</h1>");
		out.print("<p>User("+un+") Added successfully! </p>");
		out.close();
	}
}
