package ser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ServletContext ctx=getServletContext();
		Integer count=(Integer) ctx.getAttribute("count");
		if(count==null)
			count=0;
		++count;
		ctx.setAttribute("count",count);
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Product Store</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<a href=\"index.html\">Home</a>\r\n |Viewers: "+ctx.getAttribute("count")+" <hr>\r\n" +
				"	<div id=\"addprod\">\r\n" + 
				"		<h1>Add Product</h1>\r\n" + 
				"		<form action=\"add\">\r\n" + 
				"			<label>Name:</label>\r\n" + 
				"			<input class=\"form-control form-control-lg\" type=\"text\" placeholder=\"Name\" aria-label=\".form-control-lg example\" name=\"name\"/> <br> <br>\r\n" + 
				"			<label>Price:</label>\r\n" + 
				"			<input type=\"number\" name=\"price\" required/> <br> <br>\r\n" + 
				"			<label>Info:</label>\r\n" + 
				"			<input type=\"text\" name=\"info\" required/> <br> <br>\r\n" + 
				"			<button type=\"submit\"> Add Product</button>\r\n" + 
				"		</form>\r\n" + 
				"	</div> <hr>\r\n" + 
				"	<div id=\"delprod\">\r\n" + 
				"		<h1>Delete Product</h1>\r\n" + 
				"		<form action=\"delete\">\r\n" + 
				"			<label>Name:</label>\r\n" + 
				"			<input type=\"text\" name=\"name2\" required/> <br> <br>\r\n" + 
				"			<button type=\"submit\"> Delete Product</button>\r\n" + 
				"		</form>\r\n" + 
				"	</div> <hr>\r\n" + 
				"	<div id=\"searchprod\">\r\n" + 
				"		<h1>Search Product</h1>\r\n" + 
				"		<form action=\"search\">\r\n" + 
				"			<label>Name:</label>\r\n" + 
				"			<input type=\"text\" name=\"name\"required/> <br> <br>\r\n" + 
				"			<button type=\"submit\"> Search Product</button>\r\n" + 
				"		</form>\r\n" + 
				"	</div> <hr>\r\n" + 
				"	\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

}
