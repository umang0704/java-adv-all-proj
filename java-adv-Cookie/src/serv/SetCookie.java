package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/set_cookie")
public class SetCookie extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Cookie ck1 = new Cookie("name", request.getParameter("name"));
		Cookie ck2 = new Cookie("age", request.getParameter("age"));
		ck1.setMaxAge(60 * 2);
		response.addCookie(ck1);
		response.addCookie(ck2);
		out.print("<html><body>");
		out.print("<p>Cookie Set</p>");
		out.print("</body></html>");
	}

}
