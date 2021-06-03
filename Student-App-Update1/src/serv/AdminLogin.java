package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminLogin extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Admin Console</title>\r\n"
				+ "</head>\r\n"
				+ "<body>"
				+ "<a href=\"index.html\">Home</a><hr>"
				+ "	<h1>Admin Login</h1>"
				+ "<hr>"
				+ "<form action=\"admin_authentication\" method=\"POST\">\r\n"
				+ "		<input type=\"text\" placeholder=\"Admin ID\" name=\"id\" required=\"required\"/><br><br>\r\n"
				+ "		<input type=\"password\" placeholder=\"Admin Password\" name=\"password\" required=\"required\"><br><br>\r\n"
				+ "		<button type=\"submit\">LogIn</button>\r\n"
				+ "	</form>"
				+ "</body>\r\n"
				+ "</html>");
	}

}
