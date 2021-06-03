package ser;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.*;
import java.sql.*;

public class AdminLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=null;
        try{
            out=response.getWriter();
            
            String aid=request.getParameter("id");
            String password=request.getParameter("password");
            
            ServletContext ctx=getServletContext();
            String dbdriver=ctx.getInitParameter("dbDriver");
            String dbpath=ctx.getInitParameter("dbPath");
            String dbid=ctx.getInitParameter("dbPd");
            String dbpass=ctx.getInitParameter("dbPass");
            Class.forName(dbdriver);
            Connection c=DriverManager.getConnection(dbpath,dbid,dbpass);
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from admin where aid='"+aid+"' and password='"+password+"'");
            if(rs.next()){
                HttpSession session=request.getSession();
                session.setAttribute("name",rs.getString("name"));
                response.sendRedirect("adminHome");
            }else{
               response.sendRedirect("adminloginerror.html");
            }
        }catch(Exception ex){
            out.println(ex);
            ex.printStackTrace();
        }
	}

}
