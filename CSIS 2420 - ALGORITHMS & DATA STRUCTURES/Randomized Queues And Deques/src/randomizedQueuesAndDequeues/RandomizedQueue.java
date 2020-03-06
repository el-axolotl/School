package randomizedQueuesAndDequeues;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Pat Hurley & Christopher Munoz
 * @param <Item>
 *
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	private int size;
	private Item[] rq;
	
	/**
	 * Creates a radomizedQueue
	 * I went with an array because
	 * randomly selecting from the middle of a 
	 * list I think would be too expensive
	 */
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		rq = (Item[]) new Object[1];
		size = 0;
	}
	
	/**
	 * returns whether the 
	 * queue is empty or not
	 * @return
	 */
	public boolean isEmpty() {
		return (size <= 0);
	}
	
	/**
	 * Returns size of the queue
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Adds item to array, also will resize
	 * array if it hits capacity
	 * @param item
	 */
	public void enqueue(Item item) {
		if(item == null) {
			throw new java.lang.NullPointerException();
		}
		rq[size++] = item;
		if(size == rq.length) {
			resizeArray(rq.length * 2);
		}
		 
	}

	/**
	 * Removes item from array at a random index
	 * it will resize my array if it hits 1/4 capacity
	 * @return
	 */
	public Item dequeue() {
		if(isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		int index = StdRandom.uniform(size);
		Item temp = rq[index];
		rq[index] = rq[--size];
		rq[size] = null;
		if(size <= (rq.length/4)) {
			resizeArray(rq.length/2);
		}
		return temp;
	}
	
	/**
	 * returns a random item in queue, but
	 * does not delete it
	 * @return
	 */
	public Item sample() {
		if(isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		return rq[StdRandom.uniform(size)];
	}
	
	/**
	 * this resizes my array if it hits capacity
	 * it will double the size via enque method
	 * if size hits 1/4 the length of the array
	 * it will make the array half the size per
	 * Sedgwicks recommendations to avoid thrashing
	 * @param newSize
	 */
	private void resizeArray(int newSize) {
		@SuppressWarnings("unchecked")
		Item[] newArray = (Item[]) new Object[newSize];
		for (int i = 0; i < size; i++) {
			newArray[i] = rq[i];
		}
		rq = newArray;
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		return new RQIterator();
	}
	
	/**
	 * Creating a private class for 
	 * my Iterator
	 * @author pat
	 *
	 */
	private class RQIterator implements Iterator<Item>{
		private Item[] rq2;
		private int s = size;
		
		@SuppressWarnings("unchecked")
		private RQIterator() {
			rq2 = (Item[]) new Object[s];
			for(int i = 0; i < s; i++) {
				rq2[i] = rq[i];
			}
		}
		
		@Override
		public boolean hasNext() {
			return s > 0;
		}

		@Override
		public Item next() {
			if(!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			int index = StdRandom.uniform(s);
			Item temp = rq2[index];
			rq2[index] = rq2[--s];
			rq2[s] = null;
			return temp;
		}
		
		@Override
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
		
	}
	
	public static void main(String[] args) {
		RandomizedQueue rq = new RandomizedQueue();
		
		StdOut.println(rq.isEmpty());
		rq.enqueue("First");
		rq.enqueue("Second");
		rq.enqueue("third");
		rq.enqueue("Fourth");
		rq.enqueue(1);
		rq.enqueue(2);
		rq.enqueue(3);
		rq.enqueue(4);
		rq.enqueue(5);
		rq.enqueue(6);
		StdOut.println("Sample: " + rq.sample());
		StdOut.println(rq.isEmpty());
		StdOut.println("size: " + rq.size());
		StdOut.println(rq.dequeue().toString());
		StdOut.println(rq.dequeue().toString());
		StdOut.println(rq.dequeue().toString());
		StdOut.println(rq.dequeue().toString());
		StdOut.println(rq.dequeue().toString());
		StdOut.println(rq.dequeue().toString());
		StdOut.println(rq.dequeue().toString());
		StdOut.println(rq.dequeue().toString());
		StdOut.println(rq.dequeue().toString());
		StdOut.println(rq.dequeue().toString());
//		StdOut.println(rq.dequeue().toString());
		
		
		for(Object el: rq) {
			StdOut.print(el.toString() + ",");
			
		}
	}
	


}
