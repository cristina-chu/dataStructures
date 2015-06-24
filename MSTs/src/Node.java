
/**
 * Basic node class for use with DisjointSet
 */
public class Node<T> {

	public final T data;
	public Node<T> parent;

	public Node(T data) {
		this(data, null);
	}

	public Node(T data, Node<T> parent) {
		this.data = data;
		this.parent = parent;
	}
}