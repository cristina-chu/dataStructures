public class ArrayList<T> implements List<T> {

	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private static int size;
	private T[] array;

	/**
	 * Constructs an ArrayList using the default capacity
	 */
	public ArrayList() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	
	/**
	 * Constructs an ArrayList with an 'initialCapacity'
	 * 
	 * If 'initalCapacity' is non-positive use the default capacity
	 * 
	 * @param initialCapacity
	 */
	public ArrayList(int initialCapacity) {
		size = 0;
		array =(T[]) new Object[initialCapacity];
	}


	public void add(T item,int index){
		if (size == array.length){
			regrow();
		}
		
		int i = size-1;
		
		while(i>=index) {
			array[i+1]=array[i];
			i--;
		}
		
		array[index] = item;
		size++;
	}
	
	
	private void regrow() {
		T[] array2 = (T[]) new Object[2*array.length];
		for (int i=0; i<size; i++) {
			array2[i] = array[i];
		}
		
		array = array2;
	}

	
	public void clear() {
		for (int i = 0; i<array.length; i++){
			array[i] = null;
		}
		size = 0;
	}

	
	public boolean contains(Object item) {
		for (int i=0;i<size;i++) {
			if (array[i].equals(item))
				return true;
		}
			
		return false;
	}


	public T get(int index) {
		if (index<size&&index>=0) 
			return array[index];
		else
			return null;
	}

	
	public int indexOf(Object item) {
		for (int i=0; i<size; i++) {
			if (array[i].equals(item))
				return i;
		}
		return -1;
	}


	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}


	public int size() {
		return size;
	}
	
}
