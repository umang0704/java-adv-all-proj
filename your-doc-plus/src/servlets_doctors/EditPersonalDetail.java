package servlets_doctors;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dbUtil.Doctor_DbUtil;

/**
 * Servlet implementation class EditPersonalDetail
 */
@WebServlet("/editPersonalDetails")
public class EditPersonalDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String specialization = request.getParameter("specialization");
		String qualification = request.getParameter("qualification");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");

		try {
			HttpSession session = request.getSession(false);
			boolean edited = Doctor_DbUtil.editAccountDetails(name, email, phone, specialization, qualification, gender,
					address);
			if (edited) {
				session.setAttribute("msg_ae", "Account edited successfully!");
			} else {
				session.setAttribute("msg_ae", "Account not edited successfully!");
			}
			response.sendRedirect("doctorAccountSetting.jsp");
		} catch (Exception ex) {

		}
	}

}
