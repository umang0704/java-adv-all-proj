package ejb;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Hello
 */
@Stateless
public class Hello implements HelloLocal {

    /**
     * Default constructor. 
     */
    public Hello() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "Hello";
	}

}
