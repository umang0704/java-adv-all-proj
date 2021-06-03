package ser;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SearchProd extends HttpServlet {
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
				//		" <a href=\"index.html\">Home</a> <hr>\r\n" + 
					//	" <a href=\"welcome\">Home</a> <hr>\r\n"+
						"		<h1>"+getServletConfig().getInitParameter("pgname")+"</h1>");
				try {
					String n=request.getParameter("name");
					ServletContext ctx=getServletContext();
					String driver=ctx.getInitParameter("dbDriver");
					String path=ctx.getInitParameter("dbPath");
					String id=ctx.getInitParameter("dbId");
					String pass=ctx.getInitParameter("dbPass");
					Class.forName(driver);
					Connection connection=DriverManager.getConnection(path,id,pass);
					Statement s=connection.createStatement();
					ResultSet r=s.executeQuery("select * from products where name like'%"+n+"%'");
					out.print("<table style=\"width:100%;border: 1px solid black;border-collapse: collapse;\">\r\n" + 
							"  <tr>\r\n" + 
							"    <th style=\"border: 1px solid black;border-collapse: collapse;\">Product Name</th>\r\n" + 
							"    <th style=\"border: 1px solid black;border-collapse: collapse;\">Price</th>\r\n" + 
							"    <th style=\"border: 1px solid black;border-collapse: collapse;\">Info</th>\r\n" + 
							"  </tr>");
					while(r.next()) {
						out.print("  <tr>\r\n" + 
								"    <td style=\"border: 1px solid black;border-collapse: collapse;\">"+r.getString("name")+"</td>\r\n" + 
								"    <td style=\"border: 1px solid black;border-collapse: collapse;\">"+r.getInt("price")+"</td>\r\n" + 
								"    <td style=\"border: 1px solid black;border-collapse: collapse;\">"+r.getString("info")+"</td>\r\n" + 
								"  </tr>");
					}
					out.print("</table>");
				}catch(SQLIntegrityConstraintViolationException ex1) {
					out.print("</p>Product already exist</p>");
				}catch(Exception ex2) {
					out.print("<p>Something went wrong!...</p>");
				}
				out.print("</body>"
						+ "</html>");
	}

}
