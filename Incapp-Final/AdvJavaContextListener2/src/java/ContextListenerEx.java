
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import javax.servlet.ServletContext;
public class ContextListenerEx implements ServletContextListener{
    public  void contextInitialized(ServletContextEvent sce) {
//        System.out.println("App deployed ");
        try{
            ServletContext ctx=sce.getServletContext();
            String dbdriver=ctx.getInitParameter("dbdriver");
            String dbpath=ctx.getInitParameter("dbpath");
            String dbid=ctx.getInitParameter("dbid");
            String dbpass=ctx.getInitParameter("dbpass");
            Class.forName(dbdriver);
            Connection c=DriverManager.getConnection(dbpath,dbid,dbpass);
			
            
            ctx.setAttribute("con", c);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public  void contextDestroyed(ServletContextEvent sce) {
//        System.out.println("App Undeployed ");
        try{
            ServletContext ctx=sce.getServletContext();
            Connection c=(Connection)ctx.getAttribute("con");
            c.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
