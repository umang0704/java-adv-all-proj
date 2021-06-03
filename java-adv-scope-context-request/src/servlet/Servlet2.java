package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ServletContext ctx=getServletContext();
		Integer count=(Integer)ctx.getAttribute("count");
		if(count==null)
			count=0;
		ctx.setAttribute("count", ++count);
		
		out.print("<html><body>"
				+ "This is servlet 2.<br><br>"
				+ "Count:"+ctx.getAttribute("count")+"<br><br>"
				+ "<a href=\"s1\"> Call servlet 1</a>"
				+ "</body></html>");
		
	}

}
