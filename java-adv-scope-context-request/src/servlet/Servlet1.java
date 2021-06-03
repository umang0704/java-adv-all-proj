package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Servlet1 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//Context-Scope 
		ServletContext ctx=getServletContext();
		Integer count=(Integer)ctx.getAttribute("count");
		if(count==null)
			count=0;
		ctx.setAttribute("count", ++count);
		
		out.print("<html><body>"
				+ "This is servlet 1.<br><br>"
				+ "Count:"+ctx.getAttribute("count")+"<br><br>"
				+ "<a href=\"s2\"> Call servlet 2</a>"
				+ "</body></html>");
		
	}

}
