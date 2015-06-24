import java.util.Comparator;

/**
 * This is an implementation of a heap that is backed by an array.
 * 
 * This implementation will accept a comparator object that can be used to
 * define an ordering of the items contained in this heap, other than the
 * objects' default compareTo method (if they are comparable). This is useful if
 * you wanted to sort strings by their length rather than their lexicographic
 * ordering. That's just one example.
 * 
 * Null should be treated as positive infinity if no comparator is provided. If
 * a comparator is provided, you should let it handle nulls, which means it
 * could possibly throw a NullPointerException, which in this case would be
 * fine.
 * 
 * If a comparator is provided that should always be what you use to compare
 * objects. If no comparator is provided you may assume the objects are
 * Comparable and cast them to type Comparable<T> for comparisons. If they
 * happen to not be Comparable you do not need to handle anything, and you can
 * just let your cast throw a ClassCastException.
 * 
 * This is a minimum heap, so the smallest item should always be at the root.
 * 
 * @param <T>
 *            The type of objects in this heap
 */
public class BinaryHeap<T> implements Heap<T> {

	/**
	 * The comparator that should be used to order the elements in this heap
	 */
	private Comparator<T> comp;

	/**
	 * The backing array of this heap
	 */
	private T[] data;

	/**
	 * The number of elements that have been added to this heap, this is NOT the
	 * same as data.length
	 */
	private int size=0;

	/**
	 * Default constructor, this should initialize data to a default size (11 is
	 * normally a good choice)
	 * 
	 * This assumes that the generic objects are Comparable, you will need to
	 * cast them when comparing since there are no bounds on the generic
	 * parameter
	 */
	public BinaryHeap() {
		this(null);
	}

	/**
	 * Constructor that accepts a comparator to use with this heap. Also
	 * initializes data to a default size.
	 * 
	 * When a comparator is provided it should be preferred over the objects'
	 * compareTo method
	 * 
	 * If the comparator given is null you should attempt to cast the objects to
	 * Comparable as if a comparator were not given
	 * 
	 * @param comp
	 */
	public BinaryHeap(Comparator<T> comp) {
		data = (T[]) new Object[11];
		size = 0;
		this.comp = comp;
	}

	@Override
	public void add(T item) {
		if ((size+1)>data.length) {
			regrow();
		}
		
		data[size] = item;

		T current = data[size];
		int i = size;
		boolean place = false;
		
		if(size<1){
			place = true;
		}
		
		while (place == false) {
			if (i==0) {
				place = true;
			}
			
			else if (i%2 == 0) { //right child
				if (compare(current, data[(i-2)/2])<0) {
					System.out.println("right child");
					data[i] = data[(i-2)/2];
					data[(i-2)/2] = current;
					i = (i-2)/2;
					current = data[i];
				}
				else 
					place = true;
			}

			else if (i%2 != 0) { //left child
				if (compare(current, data[(i-1)/2])<0) {
					data[i] = data[(i-1)/2];
					data[(i-1)/2] = current;
					i = (i-1)/2;
					current = data[i];
				}
				else
					place = true;
			}

			else {
				System.out.println("place = true");
				place = true;
			}
		}

		size++;
	}
	
	private void regrow() {
		T[] newData = (T[]) new Object[2*size];
		
		for (int i = 0; i<size+1; i++) {
			newData[i] = data[i];
		}
		
		data = newData;
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	public T peek() {
		return data[0];
	}

	@Override
	public T remove() {
		if (size==0) {
			return null;
		}
		
		T temp1 = data[0];
		
		if (size == 1) {
			data[0] = null;
			size--;
			return temp1;
		}
		
		data[0] = data[size-1];
		
		T current = data[0];
		int i = 0;
		boolean place = false;

		while (place == false) {
			if (compare(current, data[2*i+1])>0 || compare(current, data[2*i+2])>0) {
				if (compare(data[2*i+1], data[2*i+2])>0) {
					data[i] = data[2*i+2];
					data[2*i+2] = current;
					i = 2*i+2;
					current = data[i];
				}
				else if (compare(data[2*i+1], data[2*i+2])<0) {
					data[i] = data[2*i+1];
					data[2*i+1] = current;
					i = 2*i+1;
					current = data[i];
				}
					
			}
			else {
				place = true;
			}
		}

		data[size-1] = null;
		size--;
		
		return temp1;
	}

	@Override
	public int size() {
		return size;
	}
	
	public int compare(T t1,T t2){
		if(comp==null){
			if(t1==null){
				return 1;
			}
			if(t1.equals(t2)){
				return 0;
			}
			if(t2==null){
				return -1;
			}
			else{
				return ((Comparable)(t1)).compareTo(t2);
			}
		}
		else{
			return comp.compare(t1,t2);
		}
	}
	
	public void printAll(){
		for(int i=0;i<data.length;i++){
			if(data[i]!=null)
				System.out.print(data[i].toString()+" ");
		}
		System.out.println("\n"+"__________________"+"\n");
	}
}
