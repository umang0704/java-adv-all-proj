package ser;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession  session=request.getSession(false);
		if(session!=null)
			session.invalidate();
		response.sendRedirect("admin_login");
	}

}
