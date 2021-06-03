

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
		HttpSession s=request.getSession();
		String cname="INCAPP";
		s.setAttribute("cname",cname);
		s.setAttribute("x",15);
                
                String u=request.getParameter("username");
		String a=request.getParameter("age");
                out.print("<html><body>");
		out.print("<p>hello Servlet 1</p>");
                out.print("<p>Name: "+u+"</p>");
		out.print("<p>Age: "+a+"</p>");	
                out.print("<p>bye Servlet 1</p>");	
		out.print("</body></html>");
	}

}
