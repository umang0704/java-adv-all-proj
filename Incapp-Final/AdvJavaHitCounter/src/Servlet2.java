

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
		out.print("<h1> Counter App </h1>");
		out.print("<p> Page 2 </p>");
		
		ServletContext ctx=getServletContext();
		Integer count=(Integer)ctx.getAttribute("count");
		if(count==null)
			count=0;
		++count;
		ctx.setAttribute("count", count);
		
		out.print("<p> Visitor: "+count+" </p>");
		out.print("</body></html>");
	}

}
