package yuanach.java.util.collection;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CHashSet<E> extends AbstractSet<E> 
	implements Set<E>, Cloneable,Serializable {

	private static final Object PRESENT = new Object();
	
	private transient HashMap<E,Object> map;
	
	public CHashSet(){
		map=new HashMap<E,Object>();
	}
	
	//如果有重复值，覆盖重复值，并返回重复的值 ,如果返回的是空值，则说明map里不存在该元素，插入成功
	public boolean add(E e){
		return map.put(e, PRESENT) == null;
	}
	
	public boolean remove(Object o){
		return map.remove(o) == PRESENT;
	}
	
	@Override
	public Iterator<E> iterator() {
		return map.keySet().iterator();
	}

	@Override
	public int size() {
		return map.size();
	}
}
