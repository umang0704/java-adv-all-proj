package ser;

import java.io.*;
import java.sql.*;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.*;
import javax.servlet.http.*;

public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Product Store</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				//"	<a href=\"index.html\">Home</a> <hr>\r\n" + 
				//" <a href=\"welcome\">Home</a> <hr>\\r\\n"+
				"		<h1>"+getServletConfig().getInitParameter("pgname")+"</h1>");
		try {
			String n=request.getParameter("name");
			int p=Integer.parseInt(request.getParameter("price"));
			String i=request.getParameter("info");
			ServletContext ctx=getServletContext();
			String driver=ctx.getInitParameter("dbDriver");
			String path=ctx.getInitParameter("dbPath");
			String id=ctx.getInitParameter("dbId");
			String pass=ctx.getInitParameter("dbPass");
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(path,id,pass);
			Statement s=connection.createStatement();
			s.executeUpdate("insert into products values('"+n+"','"+p+"','"+i+"')");
			out.print("<hr>"
					+ "<h2>Product <b>"+ n+"</b> added successfully"
							+ ".<hr>");
		}catch(SQLIntegrityConstraintViolationException ex1) {
			out.print("</p>Product already exist</p>");
		}catch(Exception ex2) {
			out.print("<p>Something went wrong!...</p>");
		}
		out.print("</body>"
				+ "</html>");
	}

}
