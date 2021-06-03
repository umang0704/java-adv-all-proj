package my;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Pqr extends TagSupport {
	private int num1,num2;
	
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out= pageContext.getOut();
			out.print("<p>Hello custom tag</p>");
			int r=num1+num2;
			out.print("<p>Sum: "+r+"</p>");
		}catch(Exception ex) { }
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out= pageContext.getOut();
			out.print("<p>Bye custom tag</p>");
		}catch(Exception ex) { }
		return EVAL_PAGE;
	}
}
