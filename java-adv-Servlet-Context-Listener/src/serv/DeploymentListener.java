package serv;

import javax.servlet.*;

public class DeploymentListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("App Deployed");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("App Undeployed");
	}
}
