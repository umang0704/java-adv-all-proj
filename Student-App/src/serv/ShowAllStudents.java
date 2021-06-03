package serv;

import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
 
public class ShowAllStudents extends HttpServlet { 
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				+ "	<a href=\"admin_home\">Back</a>\r\n"
				+ "	|<a href=\"logout\">Logout</a>\r\n"
				+ "	<hr>");
		//check if session exist
		if(user!=null) {
			try {
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
	            ResultSet rs=st.executeQuery("SELECT * FROM `student_app`.`student`;");
				out.print("<table style=\"width:100%;border: 1px solid black;border-collapse: collapse;\">\r\n"
						+ "  <tr>\r\n"
						+ "    <th style=\"border: 1px solid black;border-collapse: collapse;\">Roll Number</th>\r\n"
						+ "    <th style=\"border: 1px solid black;border-collapse: collapse;\">Subject 1</th>\r\n"
						+ "    <th stle=\"border: 1px solid black;border-collapse: collapse;\">Subject 2</th>\r\n"
						+ "    <th style=\"border: 1px solid black;border-collapse: collapse;\">Subject 3</th>\r\n"
						+ "    <th stye=\"border: 1px solid black;border-collapse: collapse;\">Status</th>\r\n"
						+ "  </tr>");
	            while(rs.next()){
					out.print("  <tr>\r\n"
							+ "    <td style=\"border: 1px solid black;border-collapse: collapse;\">"+rs.getString("rollno")+"</td>\r\n"
							+ "    <td style=\"border: 1px solid black;border-collapse: collapse;\">"+rs.getInt("s1")+"</td>\r\n"
							+ "    <td style=\"border: 1px solid black;border-collapse: collapse;\">"+rs.getInt("s2")+"</td>\r\n"
							+ "    <td style=\"border: 1px solid black;border-collapse: collapse;\">"+rs.getInt("s3")+"</td>\r\n"
							+ "    <td style=\"border: 1px solid black;border-collapse: collapse;\">"+rs.getString("status")+"</td>\r\n"
							+ "  </tr>");
				}
	            out.print("</table>");
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
