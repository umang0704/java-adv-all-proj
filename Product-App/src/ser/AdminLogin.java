package ser;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.*;

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		out.print("<html><body>"
				+ "<h1>Administrator Login</h1>"
				+ "<form action=\"adminlogincheck\" >"
				+ "<input type=\"text\" name=\"id\" placehoder=\"User ID\"required/><br><br>"
				+ "<input type=\"password\" name=\"password\" placehoder=\"Password\"required/><br><br>"
				+ "<button type=\"submit\">Submit</button>"
				+ "</form>"
				+ "</body></html>");
		
	}

}
