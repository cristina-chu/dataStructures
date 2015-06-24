import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Set;

public class MST {
	
	/**
	 * This will be where you implement kruskal's algorithm as detailed in the instructions.
	 * 
	 * When you use your disjoint set, you are going to have to instantiate it with a set, so you
	 * will need to create this set and give it to the constructor before you can do anything else
	 * 
	 * @param edges the edge list that represents the graph whose MST will be returned
	 * @return 		a collection of edges that represent the MST of the imputed graph
	 */
	public static Collection<Edge> kruskals(List<Edge> edges) {
		Collection<Edge> result = new ArrayList<Edge>(); 
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		HashSet<Vertex> hashSet = new HashSet<Vertex>();

		//hashSet contains all the vertices
		for (Edge e: edges) {
			hashSet.add(e.u);
			hashSet.add(e.v);
		}
		
		//disjoint set - cycles or not...
		DisjointSet<Vertex> set = new DisjointSet<Vertex>(hashSet);
		
		//add all edges to priority queue
		for (Edge e: edges) {
			q.add(e);
		}
		
		while (!q.isEmpty()) {
			Edge ed = (Edge)q.poll();
			Edge other = new Edge(ed.u, ed.v, ed.weight);
			
			if (!result.contains(ed) && !result.contains(other)){
				if (set.find(ed.u) != set.find(ed.v)) {
					result.add(ed);
					set.merge(ed.u, ed.v);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * This will be where you implement prim's algorithm as detailed in the instructions.
	 * 
	 * @param start	the vertex to start constructing the MST from, you are guaranteed that
	 * 				it is contained in the AdjacencyList
	 * @param graph	the adjacencyList that represents the graph whose MST will be returned
	 * @return 		a collection of edges that represent the MST of the imputed graph
	 */
	public static Collection<Edge> prims(Vertex start, AdjacencyList graph) {
		Collection<Edge> edges = new ArrayList<Edge>();
		ArrayList<Vertex> visited = new ArrayList<Vertex>();
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();

		Edge e = null;
		visited.add(start);
		
		//add the adjacencies of the first vertex 
		for (Pair p: graph.adjacencies(start)) {
			Edge ed = new Edge(start, p.vertex, p.weight);
			q.add(ed);
		}
		
		while (!q.isEmpty()) {
			e = q.poll();
			
			if (!(visited.contains(e.u)&&visited.contains(e.v))){
				edges.add(e);
				
				for (Pair p : graph.adjacencies(e.v)) {
					Edge ed = new Edge(e.v, p.vertex, p.weight);
					q.add(ed);
				}
				
				for (Pair p : graph.adjacencies(e.u)) {
					Edge ed = new Edge(e.u, p.vertex, p.weight);
					q.add(ed);
				}
				
				visited.add(e.u);
				visited.add(e.v);
			}
			

		}
		
		
		
		
		/*
		while (!q.isEmpty() && visited.size()<=vertices.size()) { //while something in the queue 
			e = (Edge)q.poll(); //take out edge

			Edge other = new Edge(e.v, e.u, e.weight); //reverse of the current edge
			
			//add edge to the tree if it doesn't create cycle
			if (edges.contains(e)==false && edges.contains(other)==false && !visited.contains(current)); {
				edges.add(e);
				System.out.println(edges.contains(e)==false);
				System.out.println(e);

				visited.add(current); //add current to already visited

				//change the current vertex
				if (e.v == current) 
					current = e.u;
				else
					current = e.v;
			
				//add adjacencies of the new current vertex
				for (Pair p : graph.adjacencies(current)) {
					Edge ed = new Edge(current, p.vertex, p.weight);
					q.add(ed);
				}
			}
		}*/
		
		return edges;
	}
}
