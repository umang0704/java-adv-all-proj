package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/see_cookie")
public class SeeCookie extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<p>See Cookie</p>");
		Cookie ck[] = request.getCookies();
		for (Cookie c : ck) {
			out.print("<p> " + c.getName() + " : " + c.getValue() + "</p>");
		}
		out.print("</body></html>");

	}

}
