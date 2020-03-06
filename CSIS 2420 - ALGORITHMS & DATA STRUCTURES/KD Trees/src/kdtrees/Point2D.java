package kdtrees;

/**
 * Creates a Point in a X and Y grid system. It can calculate the distance
 * between the current and another Point.
 * 
 * @author Christopher Munoz & Adam Aguirre
 *
 */
public class Point2D implements Comparable<Point2D> {

	private double x;
	private double y;

	// construct the point (x, y)
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// x-coordinate
	public double x() {
		return x;
	}

	// y-coordinate
	public double y() {
		return y;

	}

	// square of Euclidean distance between two points
	public double distanceSquaredTo(Point2D that) {
		double dx = this.x - that.x;
		double dy = this.y - that.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	// for use in an ordered symbol table
	public int compareTo(Point2D that) {
		if (this.y < that.y)
			return -1;
		if (this.y > that.y)
			return +1;
		if (this.x < that.x)
			return -1;
		if (this.x > that.x)
			return +1;
		return 0;
	}

	// does this point equal that object?
	public boolean equals(Object that) {
		if (that == this)
			return true;
		if (that == null)
			return false;
		if (that.getClass() != this.getClass())
			return false;
		Point2D other = (Point2D) that;
		return this.x == other.x && this.y == other.y;
	}

	// string representation
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
