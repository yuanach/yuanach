package yuanach.java.util.sort;

import java.util.Comparator;

public interface CSort<T extends Comparable<T>>{
	public void sort(T t[]);
	public void sort(T t[],Comparator<T> comp);
}
