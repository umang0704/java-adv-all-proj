package servlets_doctors;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/doctortLogInAuth")
public class DoctortLogInAuth extends HttpServlet { 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("d_email");
		String pass = request.getParameter("d_password");
		HttpSession session = request.getSession();
		try {
			String d_name = dbUtil.Doctor_DbUtil.accountExist(id, pass);
			if(d_name != null) {
				session.setAttribute("d_name", d_name);
				session.setAttribute("d_id", id);
				response.sendRedirect("doctor_home.jsp");
			}else {
				session.setAttribute("msg_d", "Account does not exist..!");
				response.sendRedirect("index.jsp#doctor_login");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
