package kdtrees;

/**
 * Creates a Rectangle within an X and Y grid system. It can Query for Points
 * within the Rectangle, whether it intersects another Rectangle, and closest
 * Point.
 * 
 * @author Christopher Munoz & Adam Aguirre
 *
 */
public class RectHV {
	private final double xmin, ymin; // minimum x- and y-coordinates
	private final double xmax, ymax; // maximum x- and y-coordinates

	// construct the rectangle [xmin, xmax] x [ymin, ymax]
	public RectHV(double xmin, double ymin, double xmax, double ymax) {
		this.xmin = xmin;
		this.ymin = ymin;
		this.xmax = xmax;
		this.ymax = ymax;
		if (Double.isNaN(xmin) || Double.isNaN(xmax)) {
			throw new IllegalArgumentException("x-coordinate is NaN: " + toString());
		}
		if (Double.isNaN(ymin) || Double.isNaN(ymax)) {
			throw new IllegalArgumentException("y-coordinate is NaN: " + toString());
		}
		if (xmax < xmin) {
			throw new IllegalArgumentException("xmax < xmin: " + toString());
		}
		if (ymax < ymin) {
			throw new IllegalArgumentException("ymax < ymin: " + toString());
		}
	}

	// minimum x-coordinate of rectangle
	public double xmin() {
		return xmin;
	}

	// minimum y-coordinate of rectangle
	public double ymin() {
		return ymin;
	}

	// maximum x-coordinate of rectangle
	public double xmax() {
		return xmax;
	}

	// maximum y-coordinate of rectangle
	public double ymax() {
		return ymax;
	}

	// does this rectangle contain the point p (either inside or on boundary)?
	public boolean contains(Point2D p) {
		return (p.x() >= xmin) && (p.x() <= xmax) && (p.y() >= ymin) && (p.y() <= ymax);
	}

	// does this rectangle intersect that rectangle (at one or more points)?
	public boolean intersects(RectHV that) {
		return this.xmax >= that.xmin && this.ymax >= that.ymin && that.xmax >= this.xmin && that.ymax >= this.ymin;
	}

	// square of Euclidean distance from point p to closest point in rectangle
	public double distanceSquaredTo(Point2D p) {
		double dx = 0.0, dy = 0.0;
		if (p.x() < xmin)
			dx = p.x() - xmin;
		else if (p.x() > xmax)
			dx = p.x() - xmax;
		if (p.y() < ymin)
			dy = p.y() - ymin;
		else if (p.y() > ymax)
			dy = p.y() - ymax;
		return dx * dx + dy * dy;
	}

	// does this rectangle equal that object?
	public boolean equals(Object that) {
		if (that == this)
			return true;
		if (that == null)
			return false;
		if (that.getClass() != this.getClass())
			return false;
		RectHV other = (RectHV) that;
		if (this.xmin != other.xmin)
			return false;
		if (this.ymin != other.ymin)
			return false;
		if (this.xmax != other.xmax)
			return false;
		if (this.ymax != other.ymax)
			return false;
		return true;
	}

	// string representation
	public String toString() {
		return "[" + xmin + ", " + xmax + "] x [" + ymin + ", " + ymax + "]";
	}
}
