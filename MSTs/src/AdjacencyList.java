import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class AdjacencyList {
	
	private Map<Vertex, List<Pair>> adjacencyList;
	
	/**
	 * Takes in an edge list and converts it into an adjacency list
	 */
	public AdjacencyList(List<Edge> edges) {
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		adjacencyList = new HashMap<Vertex, List<Pair>>();
		
		for (Edge e: edges) {
			if (!vertices.contains(e.u))
				vertices.add(e.u);
			if (!vertices.contains(e.v))
				vertices.add(e.v);
		}
		
		for (Vertex v: vertices) {
			List<Pair> pairs = new ArrayList<Pair>();
			
			for (Edge e: edges) {
				if (e.u == v) 
					pairs.add(new Pair(e.v, e.weight));
				if (e.v == v)
					pairs.add(new Pair(e.u, e.weight));
			}
			
			adjacencyList.put(v, pairs);
		}
	}

	/**
	 * @param v a vertex
	 * @return	a list of vertices and associated weights that are adjacent to v
	 */
	public List<Pair> adjacencies(Vertex v) {
		return adjacencyList.get(v);
	}
	
	/*
	 * Getters and setters
	 */
	
	public Map<Vertex, List<Pair>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(Map<Vertex, List<Pair>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
}
