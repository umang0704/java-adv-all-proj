import javax.servlet.*;
import java.io.*;

public class Helllo2 extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res){
			PrintWriter p=null;
			try{
				p=res.getWriter();
				p.print("<html><body>");
				p.print("<h1>welcome to my page</h1>");
				p.print("<p>Hello2 my Servlet</p>");
				p.print("</body></html>");
				p.close();
			}catch(Exception ex){
				p.print(ex);
				p.close();
			}
		}
}