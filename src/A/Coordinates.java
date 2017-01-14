package A;

import java.util.Objects;

public class Coordinates {
	private int x;
	private int y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Coordinates createNorth() {
		return new Coordinates(this.x, this.y - 1);
	}
	
	public Coordinates createEast() {
		return new Coordinates(this.x + 1, this.y);
	}
	
	public Coordinates createWest() {
		return new Coordinates(this.x - 1, this.y);
	}
	
	public Coordinates createSouth() {
		return new Coordinates(this.x, this.y + 1);
	}
	
	public Coordinates createNorthWest() {
		return new Coordinates(this.x - 1, this.y - 1);
	}
	
	public Coordinates createNorthEast() {
		return new Coordinates(this.x + 1, this.y - 1);
	}
	
	public Coordinates createSouthWest() {
		return new Coordinates(this.x - 1, this.y + 1);
	}
	
	public Coordinates createSouthEast() {
		return new Coordinates(this.x + 1, this.y + 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Coordinates other = (Coordinates) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}	
	
}


