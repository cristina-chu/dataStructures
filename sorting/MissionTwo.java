

public class MissionTwo<T extends Comparable<? super T>> {

	private T[] data;
	private int maxCapacity;
	private int size;
	
	/**
	 * Default Constructor
	 */
	public MissionTwo(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		data = (T[]) new Comparable[maxCapacity];
		size = 0;
	}
	
	/**
	 * Adds the item to the structure, must be
	 * 
	 * in-place
	 * stable
	 * O(n)
	 * 
	 * @param item
	 */
	public void add(T item) {
		if (size == 0) {
			data[0] = item;
		}
		
		else {
			int current = 0;
			boolean found = false;
			while (found==false) {
				if (data[current]!=null && data[current].compareTo(item)>0) {
					current++;
				}
				else {
					found = true;
				}
			}
					
			int x = size;
			while (x>current) {
				data[x] = data[x-1];
				x--;
			}
			data[current] = item;
			current = size;
		}

		size++;
	}

	/**
	 * This must return the smallest element in this structure, must be
	 * 
	 * in-place
	 * stable
	 * O(1)
	 * 
	 * @return the smallest element currently in this structure
	 */
	public T remove() {
		if (size == 0) {
			return null;
		}
		
		T temp = data[size-1];
		data[size-1] = null;
		size--;

		return temp;
	}
	
}
