

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/s2")
public class Servlet2 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<html><body>");
		out.print("<p>hello Servlet 2</p>");
                Cookie ck[]=request.getCookies();
		for(Cookie c:ck){
                    out.print("<p> "+c.getName()+" : "+ c.getValue()+"</p>");
                }	
		out.print("</body></html>");
	}

}
