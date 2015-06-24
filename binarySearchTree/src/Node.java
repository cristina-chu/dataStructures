public class Node<K> {
		private K key;
		private Node<K> left;
		private Node<K> right;
		
		public Node(K key) {
			this(key, null, null);
		}
		
		public Node(K key, Node<K> left, Node<K> right) {
			this.key = key;
			this.left = left;
			this.right = right;
		}
		
		public K getKey() {
			return key;
		}
		
		public void setKey(K key) {
			this.key = key;
		}
		
		public Node<K> getLeft() {
			return left;
		}
		
		public void setLeft(Node<K> left) {
			this.left = left;
		}
		
		public Node<K> getRight() {
			return right;
		}
		
		public void setRight(Node<K> right) {
			this.right = right;
		}
	}