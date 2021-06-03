package servlet_patient;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout1 extends HttpServlet { 

	private ServletContext application ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String msg_type = request.getParameter("msg_type");
		if(session != null) {
			session.invalidate();
			application = getServletContext();
			application.setAttribute("msg_type", "Successfully Logged out...!");
		}else {
			application = getServletContext();
			application.setAttribute("msg_type", "No account is logged in!");
		}
		response.sendRedirect("index.jsp");
	}

}
