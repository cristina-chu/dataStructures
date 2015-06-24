import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Search {

	/**
	 * Performs General Graph search(unweighted graph) to find shortest 
	 * @param start
	 * @param struct
	 * @param successors
	 * @param goal
	 */
	public static <T> void search(T start, 
			Structure<T> struct,
			Function<T, List<T>> successors, 
			Function<T, Boolean> goal) {
		
		List<T> visited = new ArrayList<T>();
		struct.add(start);
		T temp = start;
		
		while (struct.isEmpty()!=true) {
			temp = struct.remove();
			
			if (goal.apply(temp)){
				return;
			}
			
			if (visited.contains(temp) == false) {
				visited.add(temp);
			}
			
			if (successors.apply(temp) != null) {
				for (T thing : successors.apply(temp)) {
					struct.add(thing);
				}
			}
		}
	}

	/**
	 * Implements Dijkstra's Weighted Graph Search
	 * @param start
	 * @param dist
	 * @param successors
	 * @param goal
	 */
	public static <T> void distance(T start,
			Function<Pair<T, T>, Integer> dist,
			Function<T, List<T>> successors,
			Function<Pair<T, Integer>, Boolean> goal) {
		
		Comparator<Pair<T,Integer>> comp = new Comparator<Pair<T,Integer>>() {
			public int compare(Pair<T,Integer> pair1, Pair<T,Integer> pair2) {
				return pair1.b-pair2.b;
			}
		};
		
		PriorityQueue<Pair<T, Integer>> struct = new PriorityQueue<Pair<T,Integer>>(11,comp);
		List<T> visited = new ArrayList<T>();
		Pair<T, Integer> temp = new Pair<T, Integer>(start, 0);
		struct.add(temp);
		
		while (struct.isEmpty()!=true) {
			temp = struct.poll();
			
			if (goal.apply(temp)){
				return;
			}
			
			if (visited.contains(temp) == false) {
				visited.add(temp.a);
			}
			
			if (successors.apply(temp.a) != null) {
				for (T thing : successors.apply(temp.a)) {
					if (visited.contains(thing) == false) {
						Pair<T, Integer> newPair = new Pair<T,Integer>(thing,dist.apply(new Pair<T,T>(temp.a,thing))+temp.b);
						struct.add(newPair);
					}
				}
			}
		}

	}
}
