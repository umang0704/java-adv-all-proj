package servlets_hospitals;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dynamicUtil.OTPGenerator;
import dynamicUtil.Send_email;

/**
 * Servlet implementation class AcceptAffiliationRequest
 */
@WebServlet("/acceptAffiliationRequest")
public class AcceptAffiliationRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		HttpSession session = request.getSession(false);
		ServletContext application = getServletContext();
		try {
			Integer h_id = Integer.parseInt((String)session.getAttribute("h_id"));
			Integer d_id = Integer.parseInt(request.getParameter("d_id"));
			String code = dbUtil.HospitalUtil.sendCodeToDoctorRequest(h_id, d_id);
			String email = dbUtil.Doctor_DbUtil.getEmail(d_id);
			Send_email.sendEmail("umang.work82@gmail.com", "Your Doc + | Request Verification.", "Use the below code to verify\n" + code);
			application.setAttribute("msg_doc_aff", "Acceptance sent successfully");
			response.sendRedirect("pending_request_hospitals.jsp");
		} catch (Exception ex) {
			application.setAttribute("msg_doc_aff", ex.getMessage());
			response.sendRedirect("pending_request_hospitals.jsp");
			ex.printStackTrace();
		}
	}

}
