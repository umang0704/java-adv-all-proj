package servlets_doctors;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class AddClinic
 */
@WebServlet("/addClinic")
public class AddClinic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)request.getParameter("id");
		String name = (String)request.getParameter("cname");
		String address = (String)request.getParameter("address");
		String gfromto = (String)request.getParameter("gfromto");
		HttpSession session = request.getSession();
		try {
			boolean added = dbUtil.Doctor_DbUtil.addClinic(id, name, address,gfromto);
			if(added) {
				session.setAttribute("msg_c", "Clinic added successfully!");
			}else {
				session.setAttribute("msg_c", "Couldnt add Clinic!");				
			}
		}catch(Exception ex) {
			session.setAttribute("msg_c", "Technical Error, Check Entries or Try After Sometime..!");
			ex.printStackTrace();
		}
		response.sendRedirect("doctorAccountSetting.jsp");
	}

}
