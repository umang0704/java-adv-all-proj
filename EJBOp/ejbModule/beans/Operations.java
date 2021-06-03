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

	public float add(int i, int j) {
		// TODO Auto-generated method stub
		return i + j;
	}

	public float subtract(int i, int j) {
		// TODO Auto-generated method stub
		return i - j;
	}

	public float multiply(int i, int j) {
		// TODO Auto-generated method stub
		return i * j;
	}

	public float divide(int i, int j) {
		// TODO Auto-generated method stub
		return i / j;
	}

}
