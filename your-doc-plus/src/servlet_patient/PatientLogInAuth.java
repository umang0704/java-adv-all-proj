package servlet_patient;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbUtil.PatientUtil;

/**
 * Servlet implementation class PatientLogInAuth
 */ 
public class PatientLogInAuth extends HttpServlet { 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("p_email");
		String pass = request.getParameter("p_password");
		String name = PatientUtil.login_aut(email, pass);
		if (name != null) {
			HttpSession session = request.getSession() ;
			session .setAttribute("patient_name",name);
		 	response.sendRedirect("patient_home.jsp");
		} else {
			ServletContext application = getServletContext();
			application .setAttribute("msg", "Enter valid credentials..!");
			response.sendRedirect("index.jsp");
		}
	}

}
