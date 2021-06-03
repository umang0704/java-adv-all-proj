package my;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class JK extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out= pageContext.getOut();
			out.print("<p>Hi custom tag</p>");
			
		}catch(Exception ex) { }
		return SKIP_BODY;
	}
	
}
