package servlets_doctors;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*; 

 
@WebServlet("/createDoctorAccount")
public class CreateDoctorAccount extends HttpServlet { 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String specialization = request.getParameter("specialization");
		String phone = request.getParameter("ph");
		String address = request.getParameter("address");
		String qualification = request.getParameter("qualification");
		String gender = request.getParameter("gender");
		

		boolean created = false;
		try {
			created = dbUtil.Doctor_DbUtil.createAccount(email, password, name, specialization, phone, address, qualification, gender);	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		
		if(created) {
			session.setAttribute("msg_d", "Account created successfully..!");	
		}else {
			session.setAttribute("msg_d", "Account creation un-successfull..!");
		}
		response.sendRedirect("index.jsp#doctor_login");
	}

}
