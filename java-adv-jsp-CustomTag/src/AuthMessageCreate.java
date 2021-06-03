import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class AuthMessageCreate extends TagSupport {
	private String message;
	private String style;
	
	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getStyle() {
		return style;
	}



	public void setStyle(String style) {
		this.style = style;
	}



	@Override
	public int doStartTag() throws JspException{
		try {
			if(!message.equals(null)) {
				HttpSession session = pageContext.getSession();
				session.setAttribute("message-content", message);
				session.setAttribute("message-style", style);
			} 
		}catch(Exception e) {
			
		}
		return SKIP_BODY;
	}
}
