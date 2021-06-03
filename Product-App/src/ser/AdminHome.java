package ser;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.*;


public class AdminHome extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
PrintWriter out = response.getWriter();
        
        HttpSession session=request.getSession();
        String name=(String)session.getAttribute("name");
        if(name!=null){
            out.print("<html><body><div id=\"addprod\">\r\n" + 
            		"		<h1>Add Product</h1>\r\n" + 
            		"		<form action=\"add\">\r\n" + 
            		"			<label>Name:</label>\r\n" + 
            		"			<input type=\"text\" name=\"name\" required/> <br> <br>\r\n" + 
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
            		"	</div> <hr></body></html>");
            out.close();
        }else{
            response.sendRedirect("adminloginerror2.html");
        }
    }
	

}
