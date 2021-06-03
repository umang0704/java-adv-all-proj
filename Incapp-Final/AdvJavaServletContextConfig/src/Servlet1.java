

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet1 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<html><body>");
		ServletContext ctx=getServletContext();
		String c=ctx.getInitParameter("cname");
		out.print("<h1> "+c+" </h1>");
		out.print("<p> Hi INCAPP </p>");
		ServletConfig cfg=getServletConfig();
		String e=cfg.getInitParameter("email");
		out.print("<p> Email id: "+e+" </p>");
		out.print("</body></html>");
	}

}
