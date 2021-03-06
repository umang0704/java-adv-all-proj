package ser;

import javax.servlet.*;
import java.sql.*;

public class DeploymentListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext sc = sce.getServletContext();
			String dbdriver = sc.getInitParameter("dbdriver");
			String dbpath = sc.getInitParameter("dbpath");
			String dbid = sc.getInitParameter("dbid");
			String dbpass = sc.getInitParameter("dbpass");
			Class.forName(dbdriver);
			Connection c = DriverManager.getConnection(dbpath, dbid, dbpass);

			sc.setAttribute("conn", c);
		} catch (Exception e) {

		}

	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("App Undeployed");
		try {
			ServletContext sc = sce.getServletContext();
			Connection c = (Connection) sc.getAttribute("conn");
			c.close();
		} catch (Exception e) {
		}
	}
}
