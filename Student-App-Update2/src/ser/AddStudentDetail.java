package ser;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddStudentDetail extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
				String rollno=request.getParameter("rollnoadd");
				int s1=Integer.parseInt(request.getParameter("s1"));
				int s2=Integer.parseInt(request.getParameter("s2"));
				int s3=Integer.parseInt(request.getParameter("s3"));
				
				int percent=(s1+s2+s3)/3;
				
				String status="fail";
				if(percent>33)
					status="pass";
				
				//getting servlet context
				ServletContext c=getServletContext();
				String dbdriver=c.getInitParameter("dbdriver");
	            String dbpath=c.getInitParameter("dbpath");
	            String dbid=c.getInitParameter("dbid");
	            String dbpass=c.getInitParameter("dbpass");
	            
				
	            //fetching information from database
	            Class.forName(dbdriver);
	            Connection conn=DriverManager.getConnection(dbpath,dbid,dbpass);
	            Statement st=conn.createStatement();
	            int entry=st.executeUpdate("INSERT INTO `student_app`.`student` (`rollno`, `s1`, `s2`, `s3`, `status`) VALUES ('"+rollno+"', '"+s3+"', '"+s2+"', '"+s3+"', '"+status+"');");
				if(entry!=0) {
					out.print("<h1>Record Added Successfully...</h1>");
				}else {
					out.print("<h1>Record was not Added..</h1>");
				}
			}catch(SQLIntegrityConstraintViolationException ex1) {
				out.print("<h1>Record with this roll numberr alrady exist...</h1>");
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
