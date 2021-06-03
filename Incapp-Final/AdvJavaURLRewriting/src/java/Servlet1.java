

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String c=request.getParameter("cname");
                out.print("<html><body>");
		out.print("<p>hello Servlet 1</p>");
		out.print("<p>Company Name: "+c+"</p>");
                out.print("<a href='s2?cname="+c+"'>Call S2</a>");
		out.print("</body></html>");
	}

}
