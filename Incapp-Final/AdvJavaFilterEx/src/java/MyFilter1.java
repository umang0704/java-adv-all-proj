/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author Incapp
 */
public class MyFilter1 implements Filter {
    public void init(FilterConfig filterConfig){
        
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        PrintWriter out=response.getWriter();
        out.print("<p>hello filter1</p>");
        chain.doFilter(request, response);
        out.print("<p>bye filter1</p>");
    }
    public void destroy(){
        
    }
}
