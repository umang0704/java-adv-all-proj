import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
public class SessionListenerEx implements HttpSessionListener{
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session Created");
    }
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session Destroyed");
    }
}
