package A;

public class Node {
	
	private final Coordinates coordinates;
	private int gValue;
	private int hValue;
	private Node parent;
	
	public Node(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	/*
	 * Return F = G + H
	 */
	
	public int getFValue() {
		return gValue + hValue;
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public void setHValue(int hValue) {
		this.hValue = hValue;
	}
	
	public void setGValue(int gValue) {
		this.gValue = gValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
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
		Node other = (Node) obj;
		if (coordinates == null) {
			if (other.coordinates != null)
				return false;
		} else if (!coordinates.equals(other.coordinates))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
