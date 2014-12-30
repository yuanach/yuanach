package yuanach.java.util.collection;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class CArrayList<E> extends AbstractList<E> 
	implements List<E>,RandomAccess, Cloneable, java.io.Serializable {
	
	private static final long serialVersionUID = -8144109689947111876L;

	private Object[] elementData;
	
	private static final int DEFAULT_CAPACITY=0x0000000A;
	private int size;
	
	public CArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	public CArrayList(int initialCapacity) {
		if(initialCapacity<0){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		elementData = new Object[initialCapacity];
	}
	
	@SuppressWarnings("unchecked")
	private E elementData(int index){
		return (E)elementData[index];
	}
	
	public boolean add(Object obj){
		//扩容
		if(size == elementData.length){
			Object[] nObjectArr = new Object[elementData.length << 1];
			System.arraycopy(elementData, 0, nObjectArr, 0, elementData.length);
			elementData = nObjectArr;
		}
		elementData[size++]=obj;
		return true;
	}

	private void checkBounds(int index){
		if(index >= size){
			throw new ArrayIndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}
	
	private void ensureCapacity(){
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		checkBounds(index);
		return (E)elementData[index];
	}

	@SuppressWarnings("unchecked")
	public E remove(int index){
		checkBounds(index);
		Object oldValue = elementData[index];
		int num=size-index-1;
		if(num > 0)
			System.arraycopy(elementData, index+1, elementData, index, num);
		elementData[--size] = null;
		return (E)oldValue;
	}
	
	/* 根据内容选择删除，而不是根据对象的引用
	 * (non-Javadoc)
	 * @see java.util.AbstractCollection#remove(java.lang.Object)
	 */
	public boolean remove(Object obj) {
		if (obj == null) {
			for (int i = 0; i < elementData.length; i++)
				if (elementData[i] == null) {
					remove(i);
					return true;
				}
		} else {
			for (int i = 0; i < elementData.length; i++)
				if (obj.equals(elementData[i])) {
					remove(i);
					return true;
				}
		}
		return false;
	}
	
	public E set(int index,E element){
		checkBounds(index);
		
		E oldValue=elementData(index);
		elementData[index]=element;
		return oldValue;
	}
	
	@Override
	public int size() {
		return size;
	}

	private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size();
    }
	
}
