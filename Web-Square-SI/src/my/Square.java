package my;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "sqr", urlPatterns = { "/Sqr" })
public class Square extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int n=Integer.parseInt(request.getParameter("num"));
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" +  
				"<title>Square</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<h2>Find Square:</h2>\r\n" + 
				"	 <p> square of <b>"+n+"</b> is <b>"+(n*n)+"</b> ."+
				"</html>");		
		out.close();		
	}
}