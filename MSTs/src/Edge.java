
/**
 *	Basic edge class 
 */
public class Edge implements Comparable<Edge> {
	
	public final Vertex u;
	public final Vertex v;
	public final int weight;
	
	public Edge(Vertex v, Vertex u, int weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge e) {
		return weight - e.weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result += ((u == null) ? 0 : u.hashCode());
		result += ((v == null) ? 0 : v.hashCode());
		return prime * result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (weight != other.weight)
			return false;
		
		if (u == null && v == null) {
			return (other.u == null && other.v == null);
		} else if (u == null || v == null) {
			Vertex notNull = u == null ? v : u;
			if ((other.u == null && other.v == null) || (other.u != null && other.v != null)) {
				return false;
			} else {
				return (notNull.equals(other.u == null ? other.v : other.u));
			}
		} else {
			return (v.equals(other.v) && u.equals(other.u)) || (v.equals(other.u) && u.equals(other.v)); 
		}
	}
}
