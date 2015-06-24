import java.awt.Point;
import java.util.List;
import java.util.Map;

public class Impl {

	public static <T> Function<T, List<T>> adjacencyList(final Map<T, List<T>> map) {
		return new Function<T, List<T>>() {
			@Override
			public List<T> apply(T o) {
				return map.get(o);
			}
		};
	}
	
	public static Function<Pair<Point, Point>, Integer> euclideanDistanceSquared() {
		return new Function<Pair<Point,Point>, Integer>() {
			public Integer apply(Pair<Point, Point> o) {
				int result = ((o.b.x-o.a.x)^2)+((o.b.y-o.a.y)^2);
				
				return result;
			}
		};
	}

	public static Function<Pair<Point, Point>, Integer> manhattanDistance() {
		return new Function<Pair<Point,Point>, Integer>() {
			public Integer apply(Pair<Point, Point> o) {
				int result = Math.abs(((o.a.x-o.b.x)+(o.a.y-o.b.y)));
				
				return result;
			}
		};
	}
	
	public static <T> Structure<T> queue() {
		return new Structure<T>() {
			
			private int size = 0;
			T[] queue = (T[]) new Object[11];

			@Override
			public void clear() {
				for (int i = 0; i<queue.length; i++) {
					queue[i] = null;
				}
				size = 0;
			}

			@Override
			public boolean isEmpty() {
				return (size==0);
			}

			@Override
			public void add(T item) {
				if (size+1 >= queue.length) {
					regrow();
				}
				
				queue[size] = item;
				size++;
			}

			@Override
			public T remove() {
				T temp = queue[0];
				
				for (int i = 0; i<queue.length-2; i++) {
					queue[i] = queue[i+1];
				}
				
				size--;
				
				return temp;
			}
			
			private void regrow() {
				T[] newQueue = (T[]) new Object[2*size];

				for (int i=0; i<queue.length; i++) {
					newQueue[i] = queue[i];
				}

				queue = newQueue;
			}
			
		};
	}
	
	public static <T> Structure<T> stack() {
		return new Structure<T>() {
			
			private int size=0;
			T[] stack = (T[]) new Object[11];

			@Override
			public void clear() {
				for (int i =0; i<stack.length; i++) {
					stack[i] = null;
				}
				size = 0;
			}

			@Override
			public boolean isEmpty() {
				return (size==0);
			}

			@Override
			public void add(T item) {
				if (size+1 >= stack.length) {
					regrow();
				}
				
				stack[size] = item;
				size++;
			}

			@Override
			public T remove() {
				T temp = stack[size];
				
				stack[size] = null;
				size--;
				
				return temp;
			}
			
			private void regrow() {
				T[] newStack = (T[]) new Object[2*size];

				for (int i=0; i<stack.length; i++) {
					newStack[i] = stack[i];
				}
				
				stack = newStack;
			}
			
		};
	}
	
}
