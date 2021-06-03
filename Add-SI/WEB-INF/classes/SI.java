import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SI extends HttpServlet{
    public void service(HttpServletRequest req, HttpServletResponse res){
        PrintWriter p=null;
        try{
            p=res.getWriter();
            double pr=Double.parseDouble(req.getParameter("pr"));
            double rate=Double.parseDouble(req.getParameter("rt"));
            double t=Double.parseDouble(req.getParameter("t"));
            double si=(pr*rate*t)/100;
            p.print("<html><head><title>Simple Intrest</title></head>");
            p.print("<body><a href=\"index.html\">Home</a><hr><h1>Principle: "+pr+"<br>Rate: "+rate+"<br>Time: "+t+"<br>SI: "+si+"<br></h1></body></html>");
        }catch(Exception e){
            p.print(e);
            p.close();
        }
    }    
}
