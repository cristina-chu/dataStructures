
/**
 * Basic pair class to store adjacencies
 */
public class Pair {
	
	public final Vertex vertex;
	public final int weight;
	
	public Pair(Vertex vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	/*
	 * Auto-generated methods
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertex == null) ? 0 : vertex.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (vertex == null) {
			if (other.vertex != null)
				return false;
		} else if (!vertex.equals(other.vertex))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
}
