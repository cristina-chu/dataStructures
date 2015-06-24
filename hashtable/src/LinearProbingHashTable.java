import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class makes a hashTable that treats collision with linear probing
 * @author cristinachu
 *
 * @param <K>
 * @param <V>
 */
public class LinearProbingHashTable<K, V> implements GradableMap<K, V> {
	
	private HashTableEntry<K,V>[] array;
	private double loadFactor;
	private int size;
	
	/**
	 * Constructor1 (no parameters)
	 */
	public LinearProbingHashTable(){
		this(11, .75);
	}
	
	/**
	 * Constructor2 (1 parameter)
	 * 
	 * @param size of hashTable
	 */
	public LinearProbingHashTable(int size){
		this(size, .75);
	}
	
	/**
	 * constructor3 (2parameters)
	 * 
	 * @param size of hashTable
	 * @param loadFactor of hashTable --> loadFactor = # elements/ size of array
	 */
	public LinearProbingHashTable(int size, double loadFactor){
		this.array = new HashTableEntry[size];
		this.loadFactor = loadFactor;
		this.size = 0;
	}
	

	/**
	 * This method clears the hashTable and resets size to 0
	 */
	public void clear() {
		int x = array.length;
		array = new HashTableEntry[x];
		size = 0;
	}

	/**
	 * this method returns whether the hashTable contains a specific key
	 * 
	 * @param key
	 * @return true/false depending on whether the key is in the hashTable
	 */
	public boolean containsKey(Object arg0) {
		if(arg0 == null) 
			return false;

		int index = arg0.hashCode()%array.length;

		while(array[index] != null) {
			if(array[index].getKey().equals(arg0) && !array[index].isAvailable()) {
				return true; 
				}

			index++;
			index = index%array.length;
		}
		
		return false;
	}


	/**
	 * This method returns whether the hashTable contains a specific value
	 * 
	 * @param value 
	 * @return true/false depending on whether the hashTable contains the value
	 */
	public boolean containsValue(Object arg0) {
		for (int i=0; i<array.length; i++) {
			if (array[i] != null && array[i].isAvailable()==false) {
				if (array[i].getValue().equals(arg0)) 
					return true;
			}
		} 
		return false;
	}

	/**
	 * This method returns a set containing all the entries in the hashTable
	 * 
	 * @return set with all hashTable entries
	 */
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K,V>> set = new HashSet<Map.Entry<K,V>>();
		
		for (int i = 0; i<array.length; i++) {
			if (array[i] != null && !array[i].isAvailable()) {
				set.add(array[i]);
			}
		}
		
		return set;
	}


	/**
	 * This method returns the value associated with the given key
	 * 
	 * @param key
	 * @return value
	 */
	public V get(Object arg0) {
		if (arg0 == null) 
			throw new NullPointerException();
		
		if (containsKey(arg0)==false) 
			return null;
		
		int index = arg0.hashCode()%array.length;
		
		while (array[index] != null) {
			if (array[index].getKey().equals(arg0) && array[index].isAvailable()==false) {
				return array[index].getValue();
			}
			index++;
			index = index%array.length;
		}

		return null;
	}

	/**
	 * This method return whether the hashTable is empty or not
	 * 
	 * @return true/false
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * This method returns a set containing only the keys of in the hashTable
	 * 
	 * @return set containing keys
	 */
	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		
		for (int i = 0; i<array.length; i++) {
			if (array[i] != null && array[i].isAvailable()==false) {
				set.add(array[i].getKey());
			}
		}

		return set;
	}

	/**
	 * This method adds a new entry to the hashTable
	 * 
	 * @param key to be added
	 * @param value to be added with key
	 * @return old value, if the value added already existed, null otherwise
	 */
	public V put(K key, V value) {
		if (key == null)
			throw new NullPointerException();
		
		int index = key.hashCode()%array.length;

		if(containsKey(key)) {
			V temp = array[index].getValue();
			array[index].setValue(value);
			return temp;
		}
		
		while(array[index] != null) { 
			if(array[index].isAvailable()){
				V temp = array[index].getValue();
				array[index] = new HashTableEntry<K, V>(key, value);
				size++;
				return temp;
			}

			index++;
			index = index% array.length;
		}

		array[index] = new HashTableEntry<K, V>(key, value);
		size++;
		
		if(((double)size/array.length) > loadFactor)
			regrow();

		return null;
	}

	/**
	 * This private method doubles the size of the array of the HashTable if
	 * the  current loadFactor is bigger than the maxLoadFactor
	 */
	private void regrow() {
		HashTableEntry<K,V>[] newArray = new HashTableEntry[array.length];
		
		for (int i = 0; i<array.length; i++) {
			if (array[i] != null) {
				newArray[i] = array[i];
			}
		}
			
		array = new HashTableEntry[(newArray.length * 2) + 1];
			
		for (int x = 0; x<newArray.length; x++) {
			if (newArray[x] != null) {
				array[(newArray[x].getKey().hashCode())%(newArray.length-1)] = newArray[x];
			}
		}
	}
	
	
	/**
	 * This method puts all the entries of one table into a new table
	 * 
	 * @param old table to be re-created
	 */
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		
		if (otherMap == null) 
			return;
		
		Set<? extends K> setK = otherMap.keySet();
		K[] arrayKey = (K[]) setK.toArray();
		Collection<? extends V> setV = otherMap.values();
		V[] arrayValues = (V[]) setV.toArray();
		
		for (int i=0; i<arrayKey.length; i++) {
			if (arrayKey[i] != null) {
				put(arrayKey[i], arrayValues[i]);
			}
		}
	}
	
	/**
	 * This method removes the entry with a certain key
	 * 
	 * @param key
	 * @return value removed, if found, null otherwise
	 */
	public V remove(Object key) {
		if (key == null) 
			throw new NullPointerException();
		
		if (containsKey(key)) {
			int index = key.hashCode()%array.length;
			V val = array[index].getValue();
			array[index] = null;
			
			size--;
			return val;
		}
		
		return null;
	}

	/**
	 * this method returns the size of the hashTable
	 * 
	 * @return size
	 */
	public int size() {
		return size;
	}

	/**
	 * This method returns a collection of all the values in the hashTable
	 * 
	 * @return Collection with all values
	 */
	public Collection<V> values() {
		Collection<V> values = new ArrayList<V>();
		for (int i = 0; i<array.length; i++) {
			if (array[i] != null && array[i].isAvailable()==false) {
				values.add(array[i].getValue());
			}
		}

		return values;
	}

	
	/*Gradable Map implementations*/
	/**
	 * this method returns the array backing the hashTable
	 * 
	 * @return array of hashTable entries
	 */
	public HashTableEntry<K, V>[] getArray() {
		return array;
	}

	/**
	 * this method sets the array backing the hashTable
	 */
	public void setArray(HashTableEntry<K, V>[] array) {
		this.array = array;
	}

	/**
	 * this method sets the size (number of elements) in hashTable
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
