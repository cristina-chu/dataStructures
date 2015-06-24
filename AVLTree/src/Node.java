
public class Node<T> {

	private Node<T> left, right, parent;
	private T data;
	private int height, bf;
	
	public Node(T data, Node<T> parent){
		this.data = data;
		this.parent = parent;
	}
	
	public Node(T data) {
		this(data,null);
	}
	
	public Node<T> getLeft(){
		return left;
	}
	
	public Node<T> getRight(){
		return right;
	}
	
	public Node<T> getParent(){
		return parent;
	}
	
	public void setLeft(Node<T> left){
		this.left = left;
	}
	
	public void setRight(Node<T> right){
		this.right = right;
	}
	
	public void setParent(Node<T> parent){
		this.parent = parent;
	}
	
	public void setData(T data){
		this.data = data;
	}
	
	public T getData(){
		return data;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public void setBf(int bf){
		this.bf = bf;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getBf(){
		return bf;
	}

}
