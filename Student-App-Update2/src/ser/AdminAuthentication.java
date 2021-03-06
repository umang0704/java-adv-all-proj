package ser;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminAuthentication extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=null;
		try {
			out=response.getWriter();
			//getting Id and Password
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			
			//getting servlet context
			ServletContext c=getServletContext(); 
            Connection conn=(Connection)c.getAttribute("conn");
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from student_app.admin where id='"+id+"' and password='"+password+"';");
            
            if(rs.next()) {
            	//create session
            	HttpSession session=request.getSession();
            	session.setAttribute("user", rs.getString("name"));
            	response.sendRedirect("admin_home");
            }else {
            	//send error
            	response.sendRedirect("AdminLoginError.html");
            }            
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}
	}

}
