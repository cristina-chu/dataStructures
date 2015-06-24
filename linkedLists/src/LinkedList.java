import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
	
	private Node head, tail;
	private int size;

	public LinkedList() {
		Node phantom = new Node((T)new Integer(-1));
		head = phantom;
		tail = phantom;
		size = 0;
	}
	
	public void traverse() {
		Node current = head;
		
		while (current.next != null) {
			System.out.println(current.data.toString());
			current = current.next;
		}
	}
	
	public void add(T item) {
		addLast(item);
	}

	public void clear() {
		Node phatom = new Node((T)new Integer(-1));
		head = phatom;
		tail = phatom;
		size = 0;
	}

	public boolean contains(Object item) {
		Node temp = head;
		
		if (temp.next == null)
			return false;
		
		while (temp.data.equals(item)) {
			temp = temp.next;
		}
		
		if (temp != null)
			return true;
		else
			return false;
	}

	public boolean isEmpty() {
		if (size==0)
			return true;
		else
			return false;
	}

	public T remove(Object item) {
		Node temp = head;
		
		if (size == 0)
			return null;
		
		while (temp!=null && !temp.data.equals(item)) {
			temp = temp.next;
		}
		
		if (temp.prev == null) {
			head = head.next;
			head.prev = null;
			size--;
			return temp.data;
		}
		
		if (temp != null) {
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			size--;
			return temp.data;
		}
		else
			return null;
	}

	public int size() {
		return size;
	}
	
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	public void add(T item, int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		
		if (index == size) {
			addLast(item);
		}
		
		else if (index == 0) {
			addFirst(item);
		}
		
		else {
			Node newNode = new Node(item);
			Node temp = head;
			
			int i = 0;
			while (i != index) {
				i++;
				temp = temp.next;
			}
			
			newNode.prev = temp.prev;
			newNode.next = temp;
			temp.prev.next = newNode;
			temp.prev = newNode;
			}
		
			size++;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		int i = 0;
		Node temp = head;
		
		while (i < index) {
			i++;
			temp = temp.next;
		}
		
		return temp.data;
	}


	public int indexOf(Object item) {
		Node temp = head;
		int index = 0;
		while (temp.data.equals(item)) {
			temp = temp.next;
			index++;
		}
		if (temp != null) 
			return index; 
		else 
			return -1; 
	}

	
	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		int i = 0;
		Node temp = head;
				
		while (i != index) {
			i++;
			temp = temp.next;
			}
		
		if (temp == tail && temp == head) {
			tail = tail.next;
			head = tail;
			
		}
		else if (temp == tail) {
			tail.prev.next = tail.next;
			tail = tail.prev;
		}
		else if (temp == head) {
			head = temp.next;
		}
		else {
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}
		size--;
		return temp.data;
	}

	/** 
	 * @return the first item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getFirst() {
		if (size==0)
			throw new NoSuchElementException();
		else 
			return head.data;
	}

	/**
	 * @return the last item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getLast() {
		if (size==0)
			throw new NoSuchElementException();
		else
			return tail.data;
	}

	/**
	 * Adds 'item' to front of this linked list
	 * 
	 * @param item
	 */
	public void addFirst(T item) {
		Node n = new Node(item);
		Node temp = head;
		
		n.next = temp;
		n.prev = null;
		temp.prev = n;
		head = n;
		size++;
		
		if (temp.next == null) {
			tail = n;
		}
	}

	/**
	 * Adds 'item' to the end of this linked list
	 * 
	 * @param item
	 */
	public void addLast(T item) {
		Node x = new Node(item);
		
		if (tail.next == null) {
			x.next = tail;
			x.prev = tail.prev;
			tail.prev = x;
			tail = x;
			}
		else {
			x.prev = tail;
			x.next = tail.next;
			tail.next.prev = x;
			tail.next = x;
			tail = x;
			}
		
		size++;
	}

	/**
	 * Removes and returns the first item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeFirst() {
		if (head.next == null) 
			throw new NoSuchElementException();
		
		T y = head.data;
		
		head = head.next;
		head.prev = null;
		
		size--;
		
		return y;
	}

	/**
	 * Removes and returns the last item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeLast() {
		if (size==0)
			throw new NoSuchElementException();
		
		T result = tail.data;
		
		if (tail == head) {
			tail = tail.next;
			head = tail;
		}
		else {
			tail.prev.next = tail.next;
			tail.next.prev = tail.prev;
			tail = tail.prev;
		}
		
		size--;
		return result;
	}
	
	
	private class Node {
		public Node next, prev;
		public T data;
		
		
		public Node(T data, Node next, Node prev) {
			this.next = next;
			this.prev = prev;
			this.data = data;
		}
		
		public Node(T item) {
			this(item, null, null);
		}
		
		public Node(T data, Node next) {
			this(data, next, null);
		}
		
		public Node(Node prev, T data) {
			this(data, null, prev);
		}
	}
	
	private class ListIterator<T> implements Iterator <T> { 
		private int index;
		
		public ListIterator() {
			index = size;
		}
		
		public boolean hasNext() { 
			return index < size;
		}
		
		public T next() {
			return (T)get(index++);
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
