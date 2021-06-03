

import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class CtxListener
 *
 */
@WebListener
public class CtxListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CtxListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try{
            ServletContext ctx=sce.getServletContext();
            Connection c=(Connection)ctx.getAttribute("con");
            c.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
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
	
}
