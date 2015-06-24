
public class MissionOne {

	/**
	 * Sort the array using an in-place sort, this algorithm must be:
	 * 
	 * in-place (no temporary arrays)
	 * stable
	 * O(n^2)
	 * 
	 * @param array
	 * @return array sorted
	 */
	public static <T extends Comparable<? super T>> T[] inplaceSort(T[] array) {
		int nextPlace = 0;
		int index = 1;
		int t = 0;
		T biggest = array[0];
		T temp = array[nextPlace];
		
		while (nextPlace < array.length-1) {
			while (index<array.length) {
				if (biggest.compareTo(array[index])<0) {
					biggest = array[index];
					t = index;
				}
				index++;
			}
			
			if (biggest == array[nextPlace]) {
				nextPlace++;
				biggest = array[nextPlace];
				index = nextPlace+1;
			}
			else {
				temp = array[nextPlace];
				array[nextPlace] = biggest;
				array[t] = temp;
				nextPlace++;
				biggest = array[nextPlace];
				index = nextPlace+1;
			}
		}
		
		return array;
	}
	
}
