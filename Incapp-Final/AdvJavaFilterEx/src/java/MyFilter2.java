import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter2 implements Filter {
    public void init(FilterConfig filterConfig){
        
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        PrintWriter out=response.getWriter();
        out.print("<p>hello filter2</p>");
        chain.doFilter(request, response);
        out.print("<p>bye filter2</p>");
    }
    public void destroy(){
        
    }
}
