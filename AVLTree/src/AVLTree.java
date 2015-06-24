import java.util.Comparator;
import java.util.List;
import java.util.ArrayList; 

/**
 * This class creates an ANL Tree
 * 
 * @author cristinachu
 * @version 1.00
 */
public class AVLTree<T extends Comparable<T>> implements BSTInterface<T>{

	private Node<T> root;
	private int size;
	
	/**
	 * This method returns the root of the tree
	 * 
	 * @return root of the tree
	 */
	public Node<T> getRoot(){
		return root;
	}
	
	
	/**
	 * This method adds a node to the tree with the indicated data
	 * 
	 * @param data - data for the new node
	 */
	public void add(T data) {
		add(root,data);
		size++;
		balance(root);
	}
	
	/**
	 * This class adds a new Node with the given data, at the right location
	 * @param current - node to start checking where to put the new node
	 * @param data - data for new node
	 * @return new node that has been created
	 */
	private Node<T> add(Node<T> current, T data) {
		if (current == null) {
			root = new Node<T>(data);
			return root;
		}
		
		else if (comp.compare(current.getData(),data) == 0) {
			Node<T> newNode = new Node<T>(data);
			newNode.setParent(current.getParent());
			newNode.setRight(current.getRight());
			newNode.setLeft(current.getLeft());
			size--;
			if (current.getRight() != null) {
				current.getRight().setParent(newNode);
			}
			if (current.getLeft() != null) {
				current.getLeft().setParent(newNode);
			}
		}
			
		else if (comp.compare(current.getData(),data) > 0){
			if (current.getLeft() == null)
				current.setLeft(new Node<T>(data,current));
			else
				add(current.getLeft(), data);
		}
		
		else if (comp.compare(current.getData(), data) < 0) {
			if (current.getRight() == null) 
				current.setRight(new Node<T>(data,current));
			else
				add(current.getRight(), data);
		}
		
		balance(current);
		return current;
	}
		

	/**
	 * This method removes the node in the tree with the given data
	 * 
	 * @param data - data of the node that wants to be removed
	 * @return data of the node that was removed. Null if no such data in the tree
	 */
	public T remove(T data) {
		Node<T> node = getNode(root, data);
		
		if (node == null) { //no such data in the tree
			return null;
		}
		
		if (node.getRight()==null && node.getLeft()==null) { //case 1: no children
			if (node==root) { //root case
				root = null;
			}
			else if (comp.compare(node.getParent().getData(),node.getData())>0) {
				node.getParent().setLeft(null);
			}
			else if (comp.compare(node.getParent().getData(),node.getData())<0) {
				node.getParent().setRight(null);
			}
			
		}
		
		else if (node.getLeft() != null && node.getRight() == null){ //case2: 1 child (to left)
			Node<T> child = node.getLeft();
			
			if (node==root) {
				root = child;
				child.setParent(null);
			}
			else {
				node.getParent().setLeft(child);
				child.setParent(node.getParent());
			}
		}
		
		else if (node.getRight() != null && node.getLeft() == null){ //case2: 1 child (to right)
			Node<T> child = node.getRight();
			
			if (node==root) {
				root = child;
				child.setParent(null);
			}
			else {
				child.setParent(node.getParent());
				node.getParent().setRight(child);
			}
		}
		
		else { //case3: 2 children - replace with successor. 
			Node<T> suc = node.getRight(); 
			
			while (suc.getLeft() != null) {
				suc = suc.getLeft();
			}
			
			if (suc.getParent() != node) {
				suc.getParent().setLeft(null);
				suc.setRight(node.getRight());
				node.getRight().setParent(suc);
			}
			suc.setLeft(node.getLeft());
			node.getLeft().setParent(suc);
			
			if (node==root) {
				root = suc;
			}
			else if (comp.compare(node.getParent().getData(), node.getData()) >0){
				node.getParent().setLeft(suc);
			}
			else if (comp.compare(node.getParent().getData(),node.getData()) <0) {
				node.getParent().setRight(suc);
			}
		}
		 
		balance(root);
		size--;
		return node.getData();
	}

	
	/**
	 * This method clears the tree
	 */
	public void clear() {
		this.root = null;
		this.size = 0;
	}

	
	/**
	 * This method returns whether the tree is empty or not
	 * 
	 * @return boolean true if the tree is empty, false if it is not. 
	 */
	public boolean isEmpty() {
		return size==0;
	}


	/**
	 * This method looks for the node with the corresponding data
	 * 
	 * @param data that is need to be found
	 * @return data of the node that has the data needed
	 */
	public T get(T data) {
		Node<T> ans = getNode(root, data);
		
		if (ans==null){
			return null;
		}
		
		return ans.getData();
	}
	
	
	/**
	 * This method looks for the node with the desired data and returns it
	 * 
	 * @param current - starting node
	 * @param data - data desired
	 * @return node that contains the data
	 */
	public Node<T> getNode(Node<T> current, T data) {
		
		if (current==null) {
			return null;
		}
		
		else {
			
			if(comp.compare(current.getData(), data)>0){
				current = getNode(current.getLeft(), data);
			}
			else if (comp.compare(current.getData(), data)<0) {
				current = getNode(current.getRight(), data);
			}
			else if (comp.compare(current.getData(), data)==0) {
				return current;
			}
		}
		return current;
	}
	
	
	/**
	 * This method returns a list of the elements in the tree
	 * 
	 * @return list with elements
	 */
	public List<T> asSortedList() {
		List<T> cute = new ArrayList<T>();
		asSortedList(cute, root);
		return cute;
	}

	
	/**
	 * This method returns a list of the elements in the tree 
	 * 
	 * @param list - list to which the elements will be added
	 * @param current - current node that is being looked at
	 * @return list with the elements next to the current node added
	 */
	private List<T> asSortedList(List<T> list, Node<T> current) {
		if (current == null)
			return list;
		else {
			asSortedList(list, current.getLeft());
			list.add(current.getData());
			asSortedList(list, current.getRight());
		}
			
		return list;
	}

	
	/**
	 * This method returns the size of the tree
	 * 
	 * @return size of tree
	 */
	public int size() {
		return size;
	}

	
	/**
	 * This method verifies which rotation is needed, and calls it
	 * 
	 * @param n - node/root of subtree that needs to be rotated
	 * @return new root of balance subtree
	 */
	private Node<T> rotate(Node<T> n) {
		
		if (n.getBf() == -2) {
			if (n.getRight().getBf() == -1) {
				n = left(n);
			}
			else {
				n = rightLeft(n);
			}
		}
		
		if (n.getBf() == 2) {
			if (n.getLeft().getBf() == 1) {
				n = right(n);
			}
			else {
				n = leftRight(n);
			}
		}
		
		return n;
	}

	
	/**
	 * This method balances the tree
	 * 
	 * @param current node that needs to be checked/balanced
	 */
	private void balance(Node<T> current){	
		if (current!=null) {
			balance(current.getLeft());
			balance(current.getRight());
			calcHeightAndBf(current);
			rotate(current);
		}
	}
	
	
	/**
	 * this method calculates the height and balance factor of a node
	 * 
	 * @param n node to be calculated
	 */
	private void calcHeightAndBf(Node<T> n){
		int left = -1;
		int right = -1;	
		
		if (n.getLeft() != null) {
			left =  n.getLeft().getHeight();
		}
		if (n.getRight() != null) {
			right = n.getRight().getHeight();
		}
	
		n.setBf(left-right);
		
		if (left>right) {
			n.setHeight(left+1);
		}
		else {
			n.setHeight(right+1);
		}
	}
	

	/**
	 * this method rotates a right heavy subtree, left
	 * @param n - root of subtree to be rotated
	 * @return new root of subtree
	 */
	private Node<T> left(Node<T> n) { //if right heavy
		Node<T> ch = n.getRight().getLeft();
		Node<T> parent = n.getRight();
		
		if (n == root) {
			parent.setLeft(n);
			root = parent;
			
			parent.setParent(null);
			n.setParent(parent);
			
			n.setRight(ch);
		}
		else {
			parent.setLeft(n);
			n.getParent().setRight(parent);
			
			parent.setParent(n.getParent());
			n.setParent(parent);
	
			n.setRight(ch);
		}
		
		return parent;
	}
	
	
	/**
	 * this method rotates a left heavy subtree, right
	 * @param n - root of subtree to be rotated
	 * @return new root of subtree
	 */
	private Node<T> right(Node<T> n) { //if left heavy
		Node<T> ch = n.getLeft().getRight();
		Node<T> parent = n.getLeft();
		
		if (n==root) {
			parent.setRight(n);
			root = parent;
			
			parent.setParent(null);
			n.setParent(parent);
			
			n.setLeft(ch);
		}
		else {
			parent.setRight(n);
			n.getParent().setLeft(parent);
			
			parent.setParent(n.getParent());
			n.setParent(parent);
			
			n.setLeft(ch);
		}
		return parent;
	}

	
	/**
	 * this method rotates a subtree with root=left heavy, and left child = right heavy
	 * 
	 * @param n root of subtree to be rotated
	 * @return new root of subtree
	 */
	private Node<T> leftRight(Node<T> n) { 
		Node<T> ch = n.getLeft();
		Node<T> gch = ch.getRight();
		Node<T> leftG = gch.getLeft();
		
		n.setLeft(gch);
		gch.setParent(n);
		
		gch.setLeft(ch);
		ch.setParent(gch);
		
		ch.setRight(leftG);
		if (leftG != null) {
			leftG.setParent(ch);
		}
		
		return right(n);
	}
	
	
	/**
	 * this method rotates a subtree with root=right heavy and right child=left heavy
	 * @param n - root of subtree to be rotated
	 * @return new root of subtree
	 */
	private Node<T> rightLeft(Node<T> n) {
		Node<T> ch = n.getRight();
		Node<T> gch = ch.getLeft();
		Node<T> rightG = gch.getRight();
		
		n.setRight(gch);
		gch.setParent(n);
		
		gch.setRight(ch);
		ch.setParent(gch);
		
		ch.setLeft(rightG);
		if (rightG != null) {
			rightG.setParent(ch);
		}
		
		return left(n);
	}

	
	/**
	 * comparator = to compare elements' data, even when null
	 */
	private Comparator<T> comp = new Comparator<T>() {
		/**
		 * compare method - compare two pieces of data
		 * 
		 * @param ths - piece of data a
		 * @param tht - piece of data b
		 * @return an integer (positive if a>b and negative if a<b)
		 */
		public int compare(T ths, T tht) {
			if (ths == tht) {
				return 0;
				}
			else if (ths == null) {
				return 1;
			}
			else if (tht == null) {
				return -1;
			}
			else
				return ths.compareTo(tht);
		}
	};

}
