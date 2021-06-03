
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListenerEx implements ServletContextListener{
    public  void contextInitialized(ServletContextEvent sce) {
        System.out.println("App deployed ");
    }
    public  void contextDestroyed(ServletContextEvent sce) {
        System.out.println("App Undeployed ");
    }
}
