package yuanach.java.util.map;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class CHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>,
		Cloneable, Serializable {

	private static final long serialVersionUID = -7011793058649744322L;

	//空的哈希表
	static final CEntry<?, ?>[] EMPTY_TABLE = {};

	//用空的哈希表来初始化刚开始的哈希表
	transient CEntry<K, V>[] table = (CEntry<K, V>[]) EMPTY_TABLE;

	//键值对的数量
	int size;
	
	//负载因子
	final float loadFactor;
	
	//模的大小
	int modCount;
	
	int hashseed = 0; 
	
	public CHashMap(int initialCapacity,int loadFactor){
		this.loadFactor = loadFactor;
	}
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public int size(){
		return size;
	}
	
	static class CEntry<K, V> implements Map.Entry<K, V> {

		K key;
		V value;
		CEntry<K, V> next;
		int hash;

		public CEntry(int h, K k, V v, CEntry<K, V> n) {
			this.hash = h;
			this.key = k;
			this.value = v;
			this.next = n;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

	}

}
