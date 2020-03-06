package randomizedQueuesAndDequeues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Pat Hurley & Christopher Munoz
 *
 */
public class Subset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomizedQueue<String> rq = new RandomizedQueue<>();
		int k = Integer.parseInt(args[0]);
		
		while(!StdIn.isEmpty()) {
			rq.enqueue(StdIn.readString());
		}
		
		for(int i = 0; i < k; i++) {
			StdOut.println(rq.dequeue());
		}
	}

}
