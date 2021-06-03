package ser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteSuccess extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name2");
		out.print("<h1>"+getServletConfig().getInitParameter("pgname")+"</h1><hr>"
						+ "Product <b>"+name+"</b> deleted sucessfully!..."
								+ "</body></html>");
	}

}
