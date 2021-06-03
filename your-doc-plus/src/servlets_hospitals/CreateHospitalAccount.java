package servlets_hospitals;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/createHospitalAccount")
public class CreateHospitalAccount extends HttpServlet { 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("ph");
		String tier1 = request.getParameter("Primary");
		String tier2 = request.getParameter("Secondary");
		String tier3 = request.getParameter("Tertiary"); 
		String tiers = "";
		if(tier1!=null)
			tiers=tiers+"-"+tier1;

		if(tier2!=null)
			tiers=tiers+"-"+tier2;

		if(tier3!=null)
			tiers=tiers+"-"+tier3;
		//System.out.println(tiers);
		try {
			boolean created = dbUtil.HospitalUtil.createHospitalAccount(email, password, name,phone, address,tiers);
			//System.out.println(created);
			if(created)
				getServletContext().setAttribute("msg_h", "Hospital Account Created Successfully");
			
			response.sendRedirect("index.jsp#hospital_login");
		} catch (Exception e) { 
			e.printStackTrace();
			response.sendRedirect("hospital_signup.jsp");
		}
		
	}

}
