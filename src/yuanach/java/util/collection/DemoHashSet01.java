package yuanach.java.util.collection;

import java.util.Set;

public class DemoHashSet01 {

	public static void main(String[] args) {
		Set<String> set=new CHashSet<String>();

		set.add("kara");
		
		
		System.out.println(set.add("karachio"));
	}

}
