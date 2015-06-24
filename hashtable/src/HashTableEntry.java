import java.util.Map;

/**
 * This class is defines the entries of the HashTable
 * @author cristinachu
 *
 * @param <K>
 * @param <V>
 */
public class HashTableEntry<K,V> implements Map.Entry<K,V> {
	
	private K key;
	private V value;
	private boolean available;

	/**
	 * Constructor
	 * 
	 * @param key
	 * @param value
	 */
	public HashTableEntry(K key, V value){
		this.key = key;
		this.value = value;
		available = false;
	}
	
	/**
	 * this method returns whether the spot in the hashTable is available or not
	 * 
	 * @return true or false
	 */
	public boolean isAvailable(){
		return available;
	}
	
	/**
	 * this method sets the flag available - whether the spot in the hashTable is free or not
	 * 
	 * @param true/false
	 */
	public void setAvailable(boolean isAvailable){
		available = isAvailable;	
	}

	/**
	 * this method returns key of entry
	 * 
	 * @return key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * this method returns value of entry
	 * 
	 * @return value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * this method sets the value of entry 
	 * 
	 * @param: new value
	 * @return old value
	 */
	public V setValue(V value) {
		V temp = this.value;
		this.value = value;
		return temp;
	}

	/**
	 * this method returns the hashcode of the entry
	 * 
	 * @return int hashcode
	 */
	public int hashCode(){
		return (getKey()==null ? 0 : getKey().hashCode())
		^ (getValue()==null ? 0 : getValue().hashCode());
	}
	
	/**
	 * this method returns whether two entries are the same
	 * 
	 * @return true/false depending on whether the entries are the same or not
	 */
	public boolean equals(Object o){
		if (o instanceof Map.Entry<?,?>) {
			Map.Entry<K,V> x = (Map.Entry<K,V>) o;
		
			return (getKey()==null ? x.getKey()==null : getKey().equals(x.getKey()))  &&
	    	       (getValue()==null ? x.getValue()==null : getValue().equals(x.getValue()));
		}
		
		return false;
	}
}
