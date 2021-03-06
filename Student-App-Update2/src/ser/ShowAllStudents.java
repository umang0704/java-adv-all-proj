package ser;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ShowAllStudents extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		// Getting Session
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		out.print("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Student App</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "	<a href=\"admin_home\">Back</a>\r\n" + "	|<a href=\"logout\">Logout</a>\r\n" + "	<hr>"
				+ "	<h2>Add Student Record</h2> <br> <br>\r\n"
				+ "	<form action=\"add_student_detail\" method=\"POST\">\r\n"
				+ "		<input type=\"text\" placeholder=\"Enter Roll Number\" name=\"rollnoadd\" required=\"required\"> <br> <br>\r\n"
				+ "		<input type=\"number\" placeholder=\"Subject 1\" name=\"s1\" required=\"required\"> <br> <br>\r\n"
				+ "		<input type=\"number\" placeholder=\"Subject 2\" name=\"s2\" required=\"required\"> <br> <br>\r\n"
				+ "		<input type=\"number\" placeholder=\"Subject 3\" name=\"s3\" required=\"required\"> <br> <br>\r\n"
				+ "		<input type=\"hidden\"  name=\"backto\" value='show_all_student'>"
				+ "		<button type=\"submit\"> Add Record</button>\r\n" + "	</form> <hr>\r\n");
		// check if session exist
		if (user != null) {
			try {
				// getting servlet context
				ServletContext c = getServletContext();
				Connection conn = (Connection) c.getAttribute("conn");
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM `student_app`.`student`;");
				out.print("<table style=\"width:100%;border: 1px solid black;border-collapse: collapse;\">\r\n"
						+ "  <tr>\r\n"
						+ "    <th style=\"border: 1px solid black;border-collapse: collapse;\">Roll Number</th>\r\n"
						+ "    <th style=\"border: 1px solid black;border-collapse: collapse;\">Subject 1</th>\r\n"
						+ "    <th stle=\"border: 1px solid black;border-collapse: collapse;\">Subject 2</th>\r\n"
						+ "    <th style=\"border: 1px solid black;border-collapse: collapse;\">Subject 3</th>\r\n"
						+ "    <th stye=\"border: 1px solid black;border-collapse: collapse;\">Status</th>\r\n"
						+ "    <th stye=\"border: 1px solid black;border-collapse: collapse;\">Delete</th>\r\n"
						+ "  </tr>");
				while (rs.next()) {
					out.print("  <tr>\r\n" + "    <td style=\"border: 1px solid black;border-collapse: collapse;\">"
							+ rs.getString("rollno") + "</td>\r\n"
							+ "    <td style=\"border: 1px solid black;border-collapse: collapse;\">" + rs.getInt("s1")
							+ "</td>\r\n" + "    <td style=\"border: 1px solid black;border-collapse: collapse;\">"
							+ rs.getInt("s2") + "</td>\r\n"
							+ "    <td style=\"border: 1px solid black;border-collapse: collapse;\">" + rs.getInt("s3")
							+ "</td>\r\n" + "    <td style=\"border: 1px solid black;border-collapse: collapse;\">"
							+ rs.getString("status") + "</td>\r\n"
							+ "    <td style=\"border: 1px solid black;border-collapse: collapse;\">"
							+ "	<form action=\"delete_student\" method=\"POST\">\r\n"
							+ "		<input type=\"hidden\"  name=\"backto\" value='show_all_student'>"
							+ "		<input type=\"hidden\"  name=\"rollnodel\" value='" + rs.getString("rollno") + "'>"
							+ "		<button type=\"submit\">X</button> \r\n" + "	</form>\r\n" + "		</td>\r\n"
							+ "  </tr>");
				}
				out.print("</table>");
			} catch (Exception ex2) {
				response.sendRedirect("error.html");
			}

		} else {
			response.sendRedirect("AdminLoginError.html");
		}

		out.print("</body>" + "</html>");
		out.close();

	}

}
