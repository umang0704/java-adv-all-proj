package servlets_hospitals;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Logout_h
 */
@WebServlet("/logout_h")
public class Logout_h extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ServletContext application = getServletContext();
		if (session != null) {
			session.invalidate();
			application.setAttribute("msg_h", "Logged out successfully...!");
			response.sendRedirect("index.jsp#hospital_login");
		} else {
			application.setAttribute("msg_h", "Please LogIn First...!");
			response.sendRedirect("index.jsp#hospital_login");
		}
	}

}
