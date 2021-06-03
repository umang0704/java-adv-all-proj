package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminHome extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		//getting session
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("user");
		
		//checking if session actually exist
		if(user!=null) {
			out.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Student App</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<a href=\"show_all_student\"> Show All Student</a> \r\n"
					+ "	|<a href=\"logout\"> Log Out</a> <hr>\r\n"
					+ "	<h1>Welcome Admin ("+user+")</h1> <hr>\r\n"
					+ "	<h2>Add Student Record</h2> <br> <br>\r\n"
					+ "	<form action=\"add_student_detail\" method=\"POST\">\r\n"
					+ "		<input type=\"text\" placeholder=\"Enter Roll Number\" name=\"rollnoadd\" required=\"required\"> <br> <br>\r\n"
					+ "		<input type=\"number\" placeholder=\"Subject 1\" name=\"s1\" required=\"required\"> <br> <br>\r\n"
					+ "		<input type=\"number\" placeholder=\"Subject 2\" name=\"s2\" required=\"required\"> <br> <br>\r\n"
					+ "		<input type=\"number\" placeholder=\"Subject 3\" name=\"s3\" required=\"required\"> <br> <br>\r\n"
					+ "		<button type=\"submit\"> Add Record</button>\r\n"
					+ "	</form> <hr>\r\n"
					+ "	\r\n"
					+ "	<h2>Delete Student</h2> <br>\r\n"
					+ "	<form action=\"delete_student\" method=\"POST\">\r\n"
					+ "		<input type=\"text\" placeholder=\"Student Roll Number\" name=\"rollnodel\" required=\"required\"> <br> <br>\r\n"
					+ "		<button type=\"submit\">Delete Record</button> \r\n"
					+ "	</form><hr>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}else {
			response.sendRedirect("AdminLoginError.html");
		}
	
	}

}
