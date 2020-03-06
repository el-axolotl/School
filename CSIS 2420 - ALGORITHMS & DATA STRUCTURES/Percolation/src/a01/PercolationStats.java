package a01;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Runs a percolation experiment a given number of times
 * Keeps track of percentage of open spaces when system percolates
 * Then calculates the mean, standard deviation and
 * confidence interval based off that percentage
 *
 * @author Kenneth Salguero & Christopher Munoz
 * 2/1/19
 */

public class PercolationStats {
	// stats keeps track of the percentage of open spaces
	private double stats[];
	
	/**
	 * Performs T independent experiments on an N by N grid.
	 * @param N
	 * @param T
	 */
	public PercolationStats(int N, int T) {	
		if(N <= 0 || T <= 0) {
			throw new IllegalArgumentException("N & T must be > 0");
		}
		
		// x and y store value of random location
		// openSpaceCounter keeps track of open spaces
		// stats resized to T (number of experiments
		int x;
		int y;
		double openSpaceCounter = 0;
		stats = new double[T];
		
		// Ran experiment T times
		for(int i = 0; i < T; i++) {
			// Run experiment till percolates
			Percolation test = new Percolation(N);
			do {
				// Check is random site is open
				x = StdRandom.uniform(N);		
				y = StdRandom.uniform(N);
				if(!test.isOpen(x, y)) {		
					test.open(x, y);			
					openSpaceCounter++;
				}
			} while(!test.percolates());		
			
			// When system percolates find percentage of open spaces
			// divide that by number of total spaces
			// add percentage to stats
			stats[i] = openSpaceCounter / Math.pow(N, 2);		
			openSpaceCounter = 0;
		}
	}
	
	/**
	 * Samples mean of percolation threshold.
	 * @return mean of stats[]
	 */
	public double mean() {
		return StdStats.mean(stats); 
	}
	
	/**
	 * Samples standard deviation of percolation threshold.
	 * @return standard deviation of stats[]
	 */
	public double stddev() {
		return StdStats.stddev(stats);
	}
	
	/**
	 * Calculates the low end-point of 95% confidence interval.
	 * @return low point of 95% confidence interval of stats[]
	 */
	public double confidenceLow() {
		return mean() - (1.96 * stddev() / Math.sqrt(stats.length)); 
	}
	
	/**
	 * Calculates the high end-point of 95% confidence interval.
	 * @return high point of 95% confidence interval stats[]
	 */
	public double confidenceHigh() {
		 return mean() + (1.96 * stddev() / Math.sqrt(stats.length)); 
	}
}
