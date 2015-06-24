import java.util.Map;

public interface GradableMap<K, V> extends Map<K, V> {
	
	/********************************************************
	 * 				These methods are for grading
	 * 	Just implement them as one line getters and setters
	 ********************************************************/
	
	/**
	 * returns an array backing the hashTable
	 * 
	 * @return array 
	 */
	public HashTableEntry<K,V>[] getArray();
	
	/**
	 * sets the array backing the hashTable
	 * 
	 * @param new array
	 */
	public void setArray(HashTableEntry<K,V>[] array);
	
	/**
	 * sets the size of the hashTable
	 * 
	 * @param size
	 */
	public void setSize(int size);
	
}
