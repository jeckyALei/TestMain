package search;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;


public class Test {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		 Test t=new Test();
		 t.setName("alei");
		 String name=t.getName();
		 System.out.println(name);
		 t.setName("jecky");
		 System.out.println(name);
	}
}
