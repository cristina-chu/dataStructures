import java.util.List;

public interface SearchTree<T extends Comparable<? super T>> {
	
	public void add(T item);
	public void clear();
	public boolean contains(T item);
	public boolean isEmpty();
	public int size();
	
	public T getMax();
	public T getMin();
	
	public List<T> postOrder();
	public List<T> preOrder();
	public List<T> inOrder();
	
}
