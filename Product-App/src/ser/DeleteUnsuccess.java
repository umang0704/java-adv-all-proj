package ser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteUnsuccess
 */
@WebServlet("/deleteUnsuccess")
public class DeleteUnsuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Product Store</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				//"	<a href=\"index.html\">Home</a> <hr>\r\n" + 
				" <a href=\"welcome\">Home</a> <hr>\r\n"+
				"		<h1>"+getServletConfig().getInitParameter("pgname")+"</h1><hr>"
						+ "<p style=\" color:red;\">Product delete un-sucessfully!...</p>"
								+ "</body></html>");
	}

}
