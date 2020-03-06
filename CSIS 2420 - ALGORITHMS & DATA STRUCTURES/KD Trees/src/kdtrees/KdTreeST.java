package kdtrees;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;

/**
 * Creates a KDTreeST Data Structure that is used as a Symbol Table. It can put
 * items onto the Symbol Table and search as well.
 * 
 * @author Christopher Munoz & Adam Aguirre
 *
 * @param <Value>
 */
public class KdTreeST<Value> {
	int size;

	private Node root;
	private Node lastNode;

	/*
	 * constructs an empty symbol table of points
	 */
	public KdTreeST() {
		size = 0;
	}

	/*
	 * Tells you if the Symbol Table is Empty.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/*
	 * Returns the number of points in the Symbol Table.
	 */
	public int size() {
		return size;
	}

	/*
	 * Associates the value val with point p
	 */
	public void put(Point2D p, Value val) {
		if (p == null)
			throw new NullPointerException("Keys cannot be null");
		boolean currentVertical = true;
		if (size > 0) {
			currentVertical = lastNode.isVertical;
		}
		Node theNode = put(p, val, lastNode, currentVertical);
		if (size == 0) {
			root = theNode;
		}
		lastNode = theNode;
		size++;
	}

	/*
	 * Returns the value associated with point p
	 */
	public Value get(Point2D p) {
		if (p == null)
			throw new NullPointerException("Keys cannot be null");
		return get(root, p, true); // fix
	}

	/*
	 * Tells you if the symbol table contains point p
	 */
	public boolean contains(Point2D p) {
		if (p == null)
			throw new NullPointerException("Keys cannot be null");
		return get(p) != null;
	}

	/*
	 * Returns all points in the symbol table
	 */
	public Iterable<Point2D> points() {
		Queue<Point2D> q = new Queue<Point2D>(); // Queue to return
		Queue<Node> nq = new Queue<Node>(); // Queue to iterate through

		nq.enqueue(root);
		while (!nq.isEmpty()) {
			Node temp = nq.dequeue();
			q.enqueue(temp.point);
			if (temp.leftBottom != null)
				nq.enqueue(temp.leftBottom);

			if (temp.rightTop != null)
				nq.enqueue(temp.rightTop);
		}

		return q;
	}

	/*
	 * Returns all points that are inside the rectangle
	 */
	public Iterable<Point2D> range(RectHV rect) {
		if (rect == null)
			throw new NullPointerException("Rectangle cannot be null");

		Queue<Point2D> q = new Queue<Point2D>();

		range(rect, q, root);

		return q;
	}

	/*
	 * Returns a nearest neighbor to point p; null if the symbol table is empty
	 */
	public Point2D nearest(Point2D p) {
		Point2D nearest = null;
		Iterator<Point2D> it = points().iterator();
		while (it.hasNext()) {
			Point2D pit = it.next();
			if (nearest == null)
				nearest = pit;
			if (p.distanceSquaredTo(pit) <= p.distanceSquaredTo(nearest)) {
				nearest = pit;
			}
		}
		return nearest;
	}

	/* = = = = = = = = = HELPER METHODS = = = = = = = = = */
	private Node put(Point2D p, Value val, Node n, boolean isVertical) {
		if (p == null)
			throw new NullPointerException("Keys cannot be null");
		double pp;
		double rp;
		if (n == null) {
			Node n1 = new Node(p, val, isVertical);
			return n1;
		}
		if (isVertical) {
			pp = p.x();
			rp = n.point.x();
		} else {
			pp = p.y();
			rp = n.point.y();
		}
		if (pp == rp) { // first checks if x or y is equal and then if the points are equal. If points
						// are equal just replace n, if not go right.
			if (p.equals(n.point)) {
				// size++;
				return n;
			} else {
				// size++;
				return n.right = put(p, val, n.right, !isVertical);
			}
		}
		if (pp < rp) {
			n.left = put(p, val, n.left, !isVertical);
			// size++;
			return n.left;
		}
		if (pp > rp) {
			n.right = put(p, val, n.right, !isVertical);
			// size++;
			return n.right;
		}
		return new Node(p, val, null);
	}

	private void range(RectHV rect, Queue<Point2D> q, Node node) {
		if (node == null)
			return;

		if (!rect.contains(node.point))
			return;

		if (rect.contains(node.point))
			q.enqueue(node.point);

		range(rect, q, node.leftBottom);
		range(rect, q, node.rightTop);
	}

	private Value get(Node node, Point2D p, boolean isItVertical) {
		if (node == null) {
			return null;
		}
		double temp = xY(node, p, isItVertical);

		if (node.point.equals(p))
			return node.val;

		if (temp > 0)
			return get(node.right, p, !isItVertical);
		else // if (temp < 0)
			return get(node.left, p, !isItVertical);

		// return get(node.right, p, !isItVertical);
	}

	private double xY(Node node, Point2D p, boolean isItVertical) {
		if (isItVertical)
			return p.x() - node.point.x();
		return p.y() - node.point.y();
	}

	/* = = = = = = = = = HELPER CLASS = = = = = = = = = */
	private class Node {
		private Node leftBottom;
		private Node rightTop;
		private Point2D point; // ST Key
		private Value val; // ST Value
		private RectHV rect;
		private Node left, right;
		private Boolean isVertical = true;

		public Node(Point2D point, Value val, RectHV rect) {
			this.point = point;
			this.val = val;
			this.rect = rect;
		}

		public Node(Point2D point, Value val, boolean v) {
			this.point = point;
			this.val = val;
			this.isVertical = v;
		}

	}

//	// unit testing of the methods (not graded)
//	public static void main(String[] args) {
////		KdTreeST<Integer> kd = new KdTreeST<Integer>();
////		Point2D p = new Point2D(3.0,2.5);
////		Point2D p1 = new Point2D(2,2);
////		Point2D nop1 = new Point2D(100,100);
////		int val = 32;
////		kd.put(p, val);
////		kd.put(p1, val);
////		
////		
////		StdOut.println(kd.nearest(p1));
////		
////		
////		StdOut.println("Contains " + p + ": " + kd.contains(p));
////		StdOut.println(kd.contains(p1));
////		StdOut.println(kd.contains(nop1));
//		
//		// Create search node for get method
//		//Point2D search = null;
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
//				//search = p[i];
//			}
//		}
//		
//		
//		KdTreeST<Integer> kst = new KdTreeST<Integer>();
//		
//		System.out.println("Testing size and isEmpty methods:");
//		// Test size
//		System.out.println("PointST Size: " + kst.size());
//		
//		// Test isEmpty
//		System.out.println("PointST is empty? " + kst.isEmpty() + "\n");
//		
//		
//		System.out.println("Putting 10 Points on PointST: ");
//		// Load up PointST
//		for (int i = 0; i < p.length; i++) {
//			kst.put(p[i], i*2);
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
//		System.out.println(p[2].toString() + " is search Point");
//		
//		// Test contains method
//		if (kst.contains(p[2]))
//			System.out.println(p[2] + " was found! Value is: " + kst.get(p[2]) + "\n");
//		else
//			System.out.println(p[2] + " was not found :(");
//		
//		// Test nearest
//		System.out.print("Nearest Point to " + p[2] + ": ");
//		System.out.println(kst.nearest(p[2]));
//		
//		
//	}
}
