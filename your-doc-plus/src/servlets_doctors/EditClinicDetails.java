package servlets_doctors;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class EditClinicDetails
 */
@WebServlet("/editClinicDetails")
public class EditClinicDetails extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(); 
			String did = (String) session.getAttribute("d_id");
			String cname = request.getParameter("cname");
			String address = request.getParameter("address");
			String cname0 = request.getParameter("cname0");
			String address0 = request.getParameter("address0");
			String gfromto = request.getParameter("gfromto");
			boolean edited = false;
			edited=dbUtil.Doctor_DbUtil.editClinicDetails(did,cname,address,cname0,address0,gfromto);
			if (edited)
				session.setAttribute("msg_c", "Clinic edited successfully!");
			else
				session.setAttribute("msg_c", "Clinic cant be edited..!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		response.sendRedirect("doctorAccountSetting.jsp");
	}

}
