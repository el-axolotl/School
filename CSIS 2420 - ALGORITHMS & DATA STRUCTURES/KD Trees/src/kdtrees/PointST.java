package kdtrees;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Creates a Symbol Table made of Point2D Objects.
 * 
 * @author Christopher Munoz & Adam Aguirre
 *
 * @param <Value>
 */
public class PointST<Value> {
	private RedBlackBST<Point2D, Value> bst;
	
	// construct an empty symbol table of points
	public PointST() {
		bst = new RedBlackBST<Point2D, Value>();
	}

	// is the symbol table empty?
	public boolean isEmpty() {
		return bst.isEmpty();
	}

	// number of points
	public int size() {
		return bst.size();
	}

	// associate the value val with point p
	public void put(Point2D p, Value val) {
		if (p == null) 
			throw new NullPointerException("Keys cannot be null");
		bst.put(p, val);
	}

	// value associated with point p
	public Value get(Point2D p) {
		if (p == null) 
			throw new NullPointerException("Keys cannot be null");
		return bst.get(p);
	}

	// does the symbol table contain point p?
	public boolean contains(Point2D p) {
		if (p == null) 
			throw new NullPointerException("Keys cannot be null");
		return bst.contains(p);
	}

	// all points in the symbol table
	public Iterable<Point2D> points() {
		return bst.keys();

	}

	// all points that are inside the rectangle
	public Iterable<Point2D> range(RectHV rect) {
		if (rect == null)
			throw new NullPointerException("Rectangle cannot be null");
		
		Queue<Point2D> q = new Queue<Point2D>();
		for (Point2D el : bst.keys()) {
			if (rect.contains(el))
				q.enqueue(el);
		}
		return q; //TODO test
	}

	// a nearest neighbor to point p; null if the symbol table is empty
	public Point2D nearest(Point2D p) {
		if (p == null) 
			throw new NullPointerException("Keys cannot be null");
		
		Point2D nearest = new Point2D(0,0);
		
		for (Point2D el : bst.keys()) {
			if (p.distanceSquaredTo(el) < p.distanceSquaredTo(nearest)) {
				nearest = el;
			}
		}
		return nearest; //TODO fix
	}

//	// unit testing of the methods (not graded)
//	public static void main(String[] args) {
//		// Create search node for get method
//		Point2D search = null;
//		
//		// Create 2 double arrays to create points from
//		double[] d1 = new double[10];
//		double[] d2 = new double[10];
//		
//		// To hold points
//		Point2D[] p = new Point2D[10];
//		
//		// Create random doubles for Point2D
//		for (int i = 0; i < d1.length; i++) {
//			d1[i] = StdRandom.uniform(0.0, 1.0);
//			d2[i] = StdRandom.uniform(0.0, 1.0);
//		}
//		
//		// Load up Point2D array
//		for (int i = 0; i < p.length; i++) {
//			p[i] = new Point2D(d1[i], d2[i]);
//			
//			if (i == 8) {
//				
//				// Grab a point to search for with get method
//				search = p[i];
//			}
//		}
//		
//		PointST<Integer> pst = new PointST<Integer>();
//		
//		System.out.println("Testing size and isEmpty methods:");
//		// Test size
//		System.out.println("PointST Size: " + pst.size());
//		
//		// Test isEmpty
//		System.out.println("PointST is empty? " + pst.isEmpty() + "\n");
//		
//		
//		System.out.println("Putting 10 Points on PointST: ");
//		// Load up PointST
//		for (int i = 0; i < p.length; i++) {
//			pst.put(p[i], i*2);
//		}
//		
//		// Print points
//		int j = 1;
//		for (Point2D el : p) {
//			System.out.println(j++ + ": " + el.toString());
//		}
//		System.out.println();
//		
//		// Test get method
//		System.out.println(search.toString() + " is search Point");
//		
//		// Test contains method
//		if (pst.contains(search))
//			System.out.println(search + " was found! Value is: " + pst.get(search) + "\n");
//		else
//			System.out.println(search + " was not found :(");
//		
//		// Test nearest
//		System.out.print("Nearest Point to " + search + ": ");
//		System.out.println(pst.nearest(search));
//	}
}
