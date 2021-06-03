

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/s2")
public class Servlet2 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<html><body>");
		out.print("<p>hello Servlet 2</p>");
		String u=request.getParameter("username");
		String a=request.getParameter("age");
		String c=(String)request.getAttribute("cname");
		Integer x=(Integer)request.getAttribute("x");
		out.print("<p>Name: "+u+"</p>");
		out.print("<p>Age: "+a+"</p>");	
		out.print("<p>Company Name: "+c+"</p>");
		out.print("<p>X: "+x+"</p>");	
		out.print("<p>bye Servlet 2</p>");	
		out.print("</body></html>");
	}

}
