package servlets_doctors;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class DeleteClinic
 */
@WebServlet("/deleteClinic")
public class DeleteClinic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String did = (String) session.getAttribute("d_id");
		String cname = request.getParameter("cname");
		String address = request.getParameter("address");
		Integer id = null;
		try {
			id = dbUtil.Doctor_DbUtil.getId(did, cname, address);
			boolean delete = dbUtil.Doctor_DbUtil.deleteCLinic(id);
			if (delete) {
				session.setAttribute("msg_c", "Clinic deleted successfully!");
			} else {
				session.setAttribute("msg_c", "Couldnt delete Clinic!");
			}
		} catch (Exception ex1) {
			session.setAttribute("msg_c", "Technical Error, Check Entries or Try After Sometime..!");
			ex1.printStackTrace();
		}

		response.sendRedirect("doctorAccountSetting.jsp");

	}

}
