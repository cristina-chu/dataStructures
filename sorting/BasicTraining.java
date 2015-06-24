
public class BasicTraining {

	/**
	 * Sort the array using quick sort, this must be:
	 * 
	 * in-place (no temporary arrays)
	 * O(n log n)
	 * 
	 * @param array
	 * @return a sorted array
	 */
	public static <T extends Comparable<? super T>> T[] quickSort(T[] array) {
		if (array.length<=0) {
			return null;
		}
		
		sort(array, 0, array.length-1);

		return array;
	}
	
	
	private static <T extends Comparable<? super T>> void sort(T[] array1, int left, int  right) {
		int pivotNewIndex = partition(array1, left, right, right);
		
		if (pivotNewIndex>left) {
			sort(array1, left, pivotNewIndex-1);
		}
		
		if (pivotNewIndex<right) {
			sort(array1, pivotNewIndex+1, right);
		}
	}
	
	private static <T extends Comparable<? super T>> int partition(T[] array, int left, int right, int pivot) {
		T pivotVal = array[pivot];
		int newIndex = left;
		change(array, pivot, right);
		
		for (int i = left; i<right; i++) {
			if (array[i].compareTo(pivotVal)<0) {
				change(array, i, newIndex);
				newIndex++;
			}
		}
		change(array, newIndex, right); 
		
		return newIndex;
	}
	
	private static <T extends Comparable<? super T>> void change(T[] array, int x, int y) {
		T temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}
