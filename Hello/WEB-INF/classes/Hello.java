import javax.servlet.*;
import java.io.*;
public class Hello implements Servlet{
		public void init(ServletConfig sc){
			
		}
		public void service(ServletRequest req, ServletResponse res){
			PrintWriter p=null;
			try{
				p=res.getWriter();
				p.print("<html><body>");
				p.print("<h1>welcome to my page</h1>");
				p.print("<p>Hello my Servlet</p>");
				p.print("</body></html>");
				p.close();
			}catch(Exception ex){
				p.print(ex);
				p.close();
			}
		}
		public void destroy(){
			
		}
		public String getServletInfo(){
			return null;
		}
		public ServletConfig getServletConfig(){
			return null;
		}
}