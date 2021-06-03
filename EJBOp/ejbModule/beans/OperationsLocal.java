package beans;

import javax.ejb.Local;

@Local
public interface OperationsLocal {
	public float add(int i,int j);
	public float subtract(int i,int j);
	public float multiply(int i,int j);
	public float divide(int i,int j);
}
