package a01;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Implements the Weighted Quick Find Data Structure to test on an N by N grid
 * if your model Percolates. Methods let you open sites, check if they're
 * full, and merge sites as well.
 * 
 * @author Christopher Munoz & Kenneth Salguero
 *
 */
public class Percolation {
	private WeightedQuickUnionUF wqf; // Used for Weighted Quick Find methods.
	private boolean[][] openArray; // Used to quickly check if a site is open.
	private int gridSize; // Used to keep track of 2 dimension {openArray}.
	private int topSite; // Used as the root to check for top connections before Percolation.
	private int bottomSite; // Used as the root to check for bottom connections before Percolation.

	/**
	 * Creates N by N grid, with all sites blocked.
	 * 
	 * @param N
	 */
	public Percolation(int N) {
		// wqf = new WeightedQuickUnionUF(gridSize * gridSize + 4);
		openArray = new boolean[N][N];
		gridSize = N;
		topSite = gridSize * gridSize + 1;
		bottomSite = topSite + 1;

		/*
		 * Creating a 2D boolean Array as a graph of size N * N. This will be used in
		 * the isOpen method to check quickly if a site is open.
		 */

		/*
		 * Constructor for WeightedQuickUnionUF.
		 */
		wqf = new WeightedQuickUnionUF(bottomSite + 1);
	}

	/**
	 * Opens site (row i, column j) if it is not open already.
	 * 
	 * @param i
	 * @param j
	 */
	public void open(int i, int j) {

		if (i < gridSize && j < gridSize - 1) {
			openArray[i][j] = true;

			// Checking if top row, connect to topSite
			if (i == 0) {
				wqf.union(mergePoints(i, j), topSite);
			}

			// Checking not top row and site above open, connect
			if (i > 0 && isOpen(i - 1, j)) {
				wqf.union(mergePoints(i, j), mergePoints(i - 1, j));
			}

			// Checking if not left most column
			if (j > 0) {
				if (isOpen(i, j - 1)) {
					wqf.union(mergePoints(i, j), mergePoints(i, j - 1));
				}

				if (isOpen(i, j + 1)) {
					wqf.union(mergePoints(i, j), mergePoints(i, j + 1));
				}
			}

			// Checking if left most column
			if (j == 0) {
				if (isOpen(i, j + 1)) {
					wqf.union(mergePoints(i, j), mergePoints(i, j + 1));
				}
			}

			// Checking if not bottom row and site below open
			if (i < gridSize - 1 && isOpen(i + 1, j)) {
				wqf.union(mergePoints(i, j), mergePoints(i + 1, j));
			}

		}

		// Checking if right most row, connect
		if (j == gridSize - 1) {
			openArray[i][j] = true;
			if (i == 0) {
				wqf.union(mergePoints(i, j), topSite);
			}

			// Checking not top row and site above open, connect
			if (i > 0 && isOpen(i - 1, j)) {
				wqf.union(mergePoints(i, j), mergePoints(i - 1, j));
			}

			// Checking if not bottom row and site below open
			if (i < gridSize - 1 && isOpen(i + 1, j)) {
				wqf.union(mergePoints(i, j), mergePoints(i + 1, j));
			}
		}
		
		if (i == gridSize - 1) {
			wqf.union(mergePoints(i,j), bottomSite);
		}

		isFull(i, j);
	}

	/**
	 * Checks if site (row i, column j) is open.
	 * 
	 * @param i
	 * @param j
	 * @return true if site {i, j} is open. Else returns false.
	 */
	public boolean isOpen(int i, int j) {
		return openArray[i][j];
	}

	/**
	 * Checks if site (row i, column j) is full.
	 * 
	 * @param i
	 * @param j
	 * @return true if site {i, j} is connected to the {topSite}. Else returns
	 *         false.
	 */
	public boolean isFull(int i, int j) {
		percolates();
		return wqf.connected(topSite, mergePoints(i, j));
	}

	/**
	 * Checks if the system percolates.
	 * 
	 * @return true if {topSite} and {bottomSite} are connected. Else returns false.
	 */
	public boolean percolates() {
		return wqf.connected(topSite, bottomSite);
	}

	/*
	 * Turns a 2 Coordinate system into a single point. So that Weighted Quick Union
	 * methods can be called, since all its methods take single points per
	 * parameter.
	 */
	private int mergePoints(int i, int j) {
		return gridSize * i + j;
	}

}
