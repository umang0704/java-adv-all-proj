package beans;

import javax.ejb.Local;

@Local
public interface OperationsLocal {
	public float add(float i, float j);

	public float subtract(float i, float j);

	public float multiply(float i, float j);

	public float divide(float i, float j);
}
