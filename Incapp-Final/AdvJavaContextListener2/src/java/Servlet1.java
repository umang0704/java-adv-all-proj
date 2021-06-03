

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.ServletContext;

@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
                out.print("<html><body>");
		out.print("<p>hello Servlet 11</p>");
                try{
                ServletContext ctx=request.getServletContext();
                Connection c=(Connection)ctx.getAttribute("con");
                Statement st=c.createStatement();
                ResultSet rs=st.executeQuery("select * from user_info ");
                while(rs.next()) {
                        out.print("Name: "+rs.getString("name")+"<br/>");
                        out.print("Email: "+rs.getString("email")+"<br/>");
                        out.print("Phone: "+rs.getString("phone")+"<br/>");
                        out.print("Age: "+rs.getInt("age")+"<hr/>");
                }
                }catch(Exception e){
                    out.print(e);
                }
		out.print("</body></html>");
	}

}
