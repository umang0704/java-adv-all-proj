package beans;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Operations
 */
@Stateless
public class Operations implements OperationsLocal {

    /**
     * Default constructor. 
     */
    public Operations() {
        // TODO Auto-generated constructor stub
    }
    public float add(float i, float j) {
		// TODO Auto-generated method stub
		return i + j;
	}

	public float subtract(float i, float j) {
		// TODO Auto-generated method stub
		return i - j;
	}

	public float multiply(float i, float j) {
		// TODO Auto-generated method stub
		return i * j;
	}

	public float divide(float i, float j) {
		// TODO Auto-generated method stub
		return i / j;
	}
}
