package yuanach.java.util.sort;

import java.lang.Comparable;
import java.util.Comparator;

public class BubbleSort<T extends Comparable<T>> 
	implements CSort<T>{

	
	@Override
	public void sort(T[] t) {
		int flag;

		if (t == null)
			throw new NullPointerException(msgOfException());
		ex: for (int i = 0; i < t.length - 1; i++) {
			flag = 0;
			for (int j = t.length - 1; j > i; j--)
				if (t[j].compareTo(t[j - 1]) < 0) {
					T temp;
					temp = t[j];
					t[j] = t[j - 1];
					t[j - 1] = temp;
					flag = 1;
				}
			if (flag == 0)
				break ex;
		}
	}
	
	@Override
	public void sort(T t[],Comparator<T> comp){
		int flag;

		if (t == null)
			throw new NullPointerException(msgOfException());
		ex: for (int i = 0; i < t.length - 1; i++) {
			flag = 0;
			for (int j = t.length - 1; j > i; j--)
				if (comp.compare(t[j],t[j-1]) < 0) {
					T temp;
					temp = t[j];
					t[j] = t[j - 1];
					t[j - 1] = temp;
					flag = 1;
				}
			if (flag == 0)
				break ex;
		}
	}
	
	private String msgOfException(){
		return "The array sorted can't be null type";
	}
}
