import java.util.List;
import java.util.ArrayList;

/**
 * This class creates a Binary Search Tree
 * 
 * @author CristinaChu
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements SearchTree<T> {
	
	//instantiating variables
	public Node<T> root;
	public int size;

	/**
	 * This method adds an item to the BST
	 * 
	 * @param item - item/key that wants to be added to the BST
	 */
	public void add(T item) {
		add(root, item);
		size++;
	}
	
	/**
	 * This helper method finds the correct place to add the new element
	 * by checking to go to the right or left of the current node at hand
	 * 
	 * @param current - node that is being check for position 
	 * @param item - item/key that wants to be added to the BST
	 * @return current - node parent to the new node with item/key 
	 */
	private Node<T> add(Node<T> current, T item) {
		if (current == null) {
			root = new Node<T>(item);
			return root;
		}
		
		else if (current.getKey().compareTo(item) > 0){
			if (current.getLeft() == null) 
				current.setLeft(new Node<T>(item));
			else
				add(current.getLeft(), item);
		}
		
		else if (current.getKey().compareTo(item) < 0) {
			if (current.getRight() == null) 
				current.setRight(new Node<T>(item));
			else
				add(current.getRight(), item);
		}
		
		return current;
	}
	
	/**
	 * This method resets the BST (no element and size is zero)
	 */
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * This method finds whether the BST contains a node with a certain key/item
	 * 
	 * @param item - item/key that is being checked
	 * @return true/false depending on whether the BST contains the key/item or not
	 */
	public boolean contains(T item) {
		return contains(root, item);
	}
	
	/**
	 * Helper method that goes through BST checking for equality to the passed item
	 * 
	 * @param current - Node to which the item will be compare to
	 * @param item - the item/key that is being checked to see if its on the BST
	 * @return true/false depending on whether the item is in the BST or not
	 */
	private boolean contains(Node<T> current, T item) {
		if (current ==  null)
			return false;
		
		int x = current.getKey().compareTo(item);
		
		if (x == 0)
			return true;
		else if (x>0)
			return contains(current.getLeft(), item);
		else if (x<0)
			return contains(current.getRight(), item);
		else
			return false;
	}

	/**
	 * This method returns true if the BST does not have any element, and false otherwise
	 * 
	 * @return true/false depending on whether the BST is empty or not
	 */
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	/**
	 * This method returns the integer value corresponding to the number of 
	 * elements on the BST
	 * 
	 * @return size - number of elements on BST
	 */
	public int size() {
		return size;
	}

	/**
	 * This method returns the maximum value in the BST
	 * 
	 * @return maximum value in BST
	 */
	public T getMax() {
		if (root == null)
			return null;
		else
			return getMax(root).getKey();
	}
	
	/**
	 * Helper method that goes through BST looking for the maximum value
	 * 
	 * @param current - node that is being check to see if it is max value
	 * @return maximum value found
	 */
	private Node<T> getMax(Node<T> current) {
		if (current.getRight()==null){
			return current;
		}
		else 
			return getMax(current.getRight());
	}

	/**
	 * This method returns the minimum value in the BST
	 * 
	 * @return minimum value in BST
	 */
	public T getMin() {
		if (root == null)
			return null;
		else
			return getMin(root).getKey();
	}

	/**
	 * Helper method that goes through BST looking for the minimum value
	 * 
	 * @param current - node that is being checked to see if it is the minimum value
	 * @return minimum value found
	 */
	private Node<T> getMin(Node<T> current) {
		if (current.getLeft()==null){
			return current;
		}
		else
			return getMin(current.getLeft());
	}

	/**
	 * This method returns an ArrayList with the elements of the BST in post-order (left-right-center)
	 *
	 *@return cute - an ArrayList containing the elements of the BST
	 */
	public List<T> postOrder() {
		List<T> cute = new ArrayList<T>();
		postOrder(cute, root);
		return cute;
	}
	
	/**
	 * Helper method that goes through BST and adds the keys of each node in the correct order
	 * (post-order = left-right-center)
	 * 
	 * @param list - list to which the keys will be added
	 * @param current - node that is being added
	 * @return list - list with keys added already
	 */
	private List<T> postOrder(List<T> list, Node<T> current) {
		if (current == null)
			return list;
		else {
			postOrder(list, current.getLeft());
			postOrder(list, current.getRight());
			list.add(current.getKey());
		}
		return list;
	}

	/**
	 * This method returns an ArrayList with the elements of the BST in pre-order (center-left-right)
	 *
	 *@return cute - an ArrayList containing the elements of the BST
	 */
	public List<T> preOrder() {
		List<T> cute = new ArrayList<T>();
		preOrder(cute, root);
		return cute;
	}

	/**
	 * Helper method that goes through BST and adds the keys of each node in the correct order
	 * (pre-order = center-left-right)
	 * 
	 * @param list - list to which the keys will be added
	 * @param current - node that is being added
	 * @return list - list with keys added already
	 */
	private List<T> preOrder(List<T> list, Node<T> current) {
		if (current == null)
			return list;
		else {
			list.add(current.getKey());
			preOrder(list, current.getLeft());
			preOrder(list, current.getRight());
		}
			
		return list;
	}
	
	/**
	 * This method returns an ArrayList with the elements of the BST in order (left-center-right)
	 *
	 *@return cute - an ArrayList containing the elements of the BST
	 */
	public List<T> inOrder() {
		List<T> cute = new ArrayList<T>();
		inOrder(cute, root);
		return cute;
	}
	
	/**
	 * Helper method that goes through BST and adds the keys of each node in the correct order
	 * (in-order = left-center-right)
	 * 
	 * @param list - list to which the keys will be added
	 * @param current - node that is being added
	 * @return list - list with keys added already
	 */
	private List<T> inOrder(List<T> list, Node<T> current) {
		if (current == null)
			return list;
		else {
			inOrder(list, current.getLeft());
			list.add(current.getKey());
			inOrder(list, current.getRight());
		}
			
		return list;
	}
}
