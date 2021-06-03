package ejb;

import javax.ejb.Local;

@Local
public interface HelloLocal {
	public String hello();
}
