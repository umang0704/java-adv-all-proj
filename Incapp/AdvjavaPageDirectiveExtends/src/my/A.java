package my;

import org.apache.jasper.runtime.HttpJspBase;

public abstract class A extends HttpJspBase{
	public String show() {
		return "Hello A";
	}
}
