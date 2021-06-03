import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Square extends HttpServlet{
    public void service(HttpServletRequest req, HttpServletResponse res){
        PrintWriter p=null;
        try{
            p=res.getWriter();
			double n=Double.parseDouble(req.getParameter("sq"));
			double sq=n*n;
            p.print("<html><head><title>Square</title></head>");
			p.print("<body><a href=\"index.html\">Home</a><hr><h1>Number: "+n+"<br>Square: "+sq+"</h1>");
			p.print("</body></html>");
        }catch(Exception e){
            p.print(e);
            p.close();
        }
    }    
}
