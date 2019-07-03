package tianqin.iedu.behavior;

import java.util.Arrays;

public class Iterator {
	private interface MIterator<T>{
		void First();
		void Next();
		boolean IsDone();
		T CurrentItem();
	}
	
	private interface Aggregate <T>{
		MIterator<T> CreateIterator();
		void add(T t);
		T get(int index);
	}
	
	private static class Vector<T> implements Aggregate <T>{
		private static final int DEFAULT_CAPACITY = 10;
		private transient Object[] elementData;
		private int size;
		private int capacity;
		
		private class Itr implements MIterator<T>{
			private int cursor; 
			
			public Itr() {
				cursor = 0;
			}

			@Override
			public void First() {
				cursor = 0;
			}

			@Override
			public void Next() {
				cursor ++;
			}

			@Override
			public boolean IsDone() {
				return (cursor >= size);
			}

			@Override
			public T CurrentItem() {
				return get(cursor);
			}
			
		}
		
		public Vector() {
			elementData =  new Object[DEFAULT_CAPACITY];
			size = 0;
			capacity = DEFAULT_CAPACITY;
		}
		
		@Override
		public void add(T t) {
			if(size >= capacity) {
				/**空间不够，重新分配空间**/
				int newCapacity = capacity + DEFAULT_CAPACITY;
				elementData = Arrays.copyOf(elementData, newCapacity);
				capacity = newCapacity;
			}
			elementData[size] = t;
			size++;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public T get(int index) {
			rangeCheck(index);
			return (T)elementData[index];
		}
		
	    private void rangeCheck(int index) {
	        if (index >= size)
	            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	    }
	    
	    private String outOfBoundsMsg(int index) {
	        return "Index: "+index+", Size: "+size;
	    }

		@Override
		public MIterator<T> CreateIterator() {
			return new Itr();
		}
	}
	
	public static void run() {
		Aggregate<Integer> aggr = new Vector<>();
		for(int i = 0; i < 100; i++) {
			aggr.add(i);
		}
		
		/***遍历***/
		MIterator<Integer> it = aggr.CreateIterator();
		while(!it.IsDone()) {
			System.out.println("-->" + it.CurrentItem());
			it.Next();
		}
	}

}
