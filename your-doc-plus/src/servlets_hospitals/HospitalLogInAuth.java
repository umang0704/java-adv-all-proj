package servlets_hospitals;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HospitalLogInAuth
 */
@WebServlet("/hospitalLogInAuth")
public class HospitalLogInAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hid = request.getParameter("h_email");
		String hpass = request.getParameter("h_password");
		try {

			HashMap<String, String> h_det = dbUtil.HospitalUtil.isAuth(hid, hpass);
			HttpSession session = request.getSession();
			ServletContext application = getServletContext();

			if (!h_det.isEmpty()) {
				for (Map.Entry<String, String> d : h_det.entrySet()) {
					session.setAttribute(d.getKey(), d.getValue());
				}
				response.sendRedirect("hospital_home.jsp");
			} else {
				application.setAttribute("msg_h", "Account does not exist..!");
				response.sendRedirect("index.jsp#doctor_login");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
