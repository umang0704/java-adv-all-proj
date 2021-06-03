package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String uid=(String) request.getAttribute("uid");
		String user=request.getParameter("username");
		out.print("<p>The "+user+" is added.<br>The user identity is "+uid);
	}

}
