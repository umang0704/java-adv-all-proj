package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		ServletConfig sc=getServletConfig();
		
		//creating session
		HttpSession s=request.getSession();
		s.setAttribute("proj", "Session Scope");
		s.setAttribute("defaultTime", 30);
		
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Session</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				sc.getInitParameter("pgname")+
				"	Project:"+s.getAttribute("proj")+"<br>\r\n" +
				"	Default Session Time:"+s.getAttribute("defaultTime")+"<br>\r\n" + 
				"	<a href =\"s2\">Call servlet 2</a>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

}
