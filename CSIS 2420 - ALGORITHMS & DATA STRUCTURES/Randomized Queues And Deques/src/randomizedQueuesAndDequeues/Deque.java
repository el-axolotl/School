package randomizedQueuesAndDequeues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates a Linked List Data Structure named Deque. It allows you to add and
 * remove, both at the beginning and the end of the Deque.
 * 
 * @author Pat Hurley & Christopher Munoz
 *
 */
public class Deque<Item> implements Iterable<Item> {

	private Node head;
	private Node tail;
	private int size; // size of Deque
	
	/**
	 * Node Class will be used to create Linked List Data Structure.
	 * 
	 * @author Pat Hurley & Christopher Munoz
	 *
	 */
	private class Node {
		private Item item;
		private Node next;
	}

	public Deque() {
		size = 0;
	}

	/**
	 * Checks if Deque is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the size of the Deque.
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Adds an item to the beginning of the Deque.
	 * 
	 * @param item
	 */
	public void addFirst(Item item) {
		if (item == null) {
			throw new java.lang.NullPointerException();
		}
		
		Node newNode = new Node();
		newNode.item = item;

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	/**
	 * Adds an item to the end of the Deque.
	 * 
	 * @param item
	 */
	public void addLast(Item item) {
		if (item == null) {
			throw new java.lang.NullPointerException();
		}
		
		Node newNode = new Node();
		newNode.item = item;

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	/**
	 * Return and remove the first item on the Deque.
	 * @return
	 */
	public Item removeFirst() {
		Node current;
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		
		if (size == 1) {
			current = head;
			head = null;
			tail = null;
			size--;
			return current.item;
		}
		current = head.next;
		head = current;
		size--;
		return current.item;
	}
		
	/**
	 * Return and remove the last item on the Deque.
	 * @return
	 */
	public Item removeLast() {
		Node current = head;
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		
		if (size == 1) {
			head = null;
			tail = null;
			size--;
			return current.item;
		}
		
		while (current.next != tail) {
			current = current.next;
		}
		current.next = null;
		tail = current;
		size--;
		return current.item;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		
		while (current != null) {
			sb.append(current.item).append(" ");
			current = current.next;
		}
		return sb.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		
		return new DequeIterator(this);
	}
	
	private class DequeIterator implements Iterator<Item> {

		Node current;
		
		public DequeIterator(Deque<Item> deque) {
			current = deque.head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			Item data = current.item;
			current = current.next;
			return data;
		}
		
	}
	
	/**
	 * For unit testing.
	 * @param args
	 */
	public static void main(String[] args) {
		Deque test = new Deque();
		System.out.println("Add First:");
		System.out.println("Deque: " + test);
		test.addFirst("Test1");
		System.out.println("Deque: " + test);
		test.addFirst("Test2");
		System.out.println("Deque: " + test);
		test.addFirst("Test3");
		System.out.println("Deque: " + test);
		
		System.out.println("\nRemove First:");
		System.out.println("Deque: " + test);
		test.removeFirst();
		System.out.println("Deque: " + test);
		test.removeFirst();
		System.out.println("Deque: " + test);	
		test.removeFirst();
		System.out.println("Deque: " + test);
		
		System.out.println("\nAdd Last:");
		System.out.println("Deque: " + test);
		test.addLast("Test1");
		System.out.println("Deque: " + test);
		test.addLast("Test2");
		System.out.println("Deque: " + test);
		test.addLast("Test3");
		System.out.println("Deque: " + test);
		
		System.out.println("\nRemove Last:");
		System.out.println("Deque: " + test);
		test.removeLast();
		System.out.println("Deque: " + test);
		test.removeLast();
		System.out.println("Deque: " + test);	
		test.removeLast();
		System.out.println("Deque: " + test);
		

		// = = = Uncomment below to test Iterable = = = //
/*		int i = 0;
		test.addFirst("iterable");
		test.addFirst("iterable");
		test.addFirst("iterable");
		
		System.out.println("\nDeque: " + test);
		System.out.println("Size: " + test.size());
		System.out.println("Test Iterable:");
		for (Object el : test) {
			System.out.println(i);
			i++;
		}*/		
		
		Iterator <Deque> it = test.iterator(); 
		it.next(); 
		
	}
}
