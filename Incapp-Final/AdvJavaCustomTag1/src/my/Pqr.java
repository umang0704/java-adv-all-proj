package my;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Pqr extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out= pageContext.getOut();
			out.print("<p>Hello custom tag</p>");
			int x=10,y=20;
			int r=x+y;
			out.print("<p>Sum: "+r+"</p>");
		}catch(Exception ex) { }
		return SKIP_BODY;
	}
	
}
