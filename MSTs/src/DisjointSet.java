import java.util.Map;
import java.util.Set;
import java.util.HashMap;


public class DisjointSet<T> {
	
	private Map<T, Node<T>> map;
	
	/**
	 * Takes in a Set of type T, wraps all of the objects in nodes
	 * and adds them to the Map with the method put.
	 */
	public DisjointSet(Set<T> set) {
		map = new HashMap<T, Node<T>>(); 
		
		for (T thing: set) {
			if (thing != null) {
				map.put(thing, new Node<T>(thing));
			}
		}
	}
	
	/**
	 * This method will find the parent of a given object of type T. This will involve
	 * using the object of type T to hash to a node. Use this node and trace up the 
	 * parent pointers until you see null. This will be the root. Point the node that 
	 * you started with directly to the root node that you just found (path compression). 
	 * Extract the object T from the root node and return it.
	 * 
	 * @param o 	an object of type T whose root is to be found
	 * @return 		the root of the vertex taken in
	 */
	public T find(T o) {
		Node<T> temp = map.get(o);
		
		if (temp.parent == null) {
			return o;
		}
		
		while (temp.parent != null) {
			temp = temp.parent;
		}
		
		return temp.data;
	}
	
	/**
	 * Use the same process as above to retrieve the root and then point the parent of 
	 * one to the other
	 * 
	 * Do nothing if one and two are already in the same set
	 *  
	 * @param one 	an object of type T who is to be merged with parameter two
	 * @param two 	an object of type T who is to be merged with parameter one
	 */
	public void merge(T one, T two) {
		if (find(one).equals(find(two))) {
			return;
		}
		
		Node<T> temp = map.get(find(two));
		temp.parent = map.get(find(one));
	}

}
