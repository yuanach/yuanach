package yuanach.java.util.collection;

import java.util.List;

public class Demo01 {

	public static void main(String[] args) {
		List<String> list=new CArrayList<String>();
		list.add("karachio");
		list.add("yuanach");
//		list.remove(new String("karachio"));
		list.set(0,"chenyuan");
		System.out.println(list.get(0));
	}

}
