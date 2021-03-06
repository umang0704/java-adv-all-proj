package serv;

import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;


public class DeleteStudentDetail extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
PrintWriter out=response.getWriter();
		
		//Getting Session
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("user");
		out.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Student App</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<a href='"+request.getParameter("backto")+"'>Back</a>\r\n"
				+ "	|<a href=\"logout\">Logout</a>\r\n"
				+ "	<hr>");
		//check if session exist
		if(user!=null) {
			try {
				String rollno=request.getParameter("rollnodel");
				
				//getting servlet context
				ServletContext c=getServletContext();
				String dbdriver=c.getInitParameter("dbdriver");
	            String dbpath=c.getInitParameter("dbpath");
	            String dbid=c.getInitParameter("dbid");
	            String dbpass=c.getInitParameter("dbpass");
	            
				
	            //fetching information from database
	            Class.forName(dbdriver); 

	            Connection conn=(Connection)c.getAttribute("conn");
	            Statement st=conn.createStatement();
	            int entry=st.executeUpdate("DELETE FROM `student_app`.`student` WHERE (`rollno` = '"+rollno+"');");
				if(entry!=0) {
					out.print("<h1>Record Delted Successfully...</h1>");
				}else {
					out.print("<h1>Record was not deleted..</h1>");
				}
			}catch(Exception ex2) {
				response.sendRedirect("error.html");
			}

		}else {
			response.sendRedirect("AdminLoginError.html");
		}
		
		out.print("</body>"
				+ "</html>");
		out.close();
	}

}
