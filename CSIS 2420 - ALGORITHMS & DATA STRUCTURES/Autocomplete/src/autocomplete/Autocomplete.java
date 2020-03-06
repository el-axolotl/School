/**
 * 
 */
package autocomplete;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.MergeBU;

/**
 * Creates a Class that can be passed Terms made up of String Query and a Double
 * Weight. It can search all the Terms that match the given String that the user
 * passes to the allMatches method, organized by weight (descending). It can
 * also return the number of Terms that match the String that the user passes to
 * the numberOfMatches method.
 * 
 * @author Annie Ruiz & Christopher Munoz
 *
 */
public class Autocomplete {

	private final Term[] originalTerms;

	/**
	 * Initializes the data structure from the given array of terms.
	 * 
	 * @param terms
	 */
	public Autocomplete(Term[] terms) {
		if (terms == null) {														// If term array is null:
			throw new NullPointerException("Value cannot be null");					// Throwing exception as requested in assignment.
		}

		originalTerms = new Term[terms.length];										// New array created so that it can be accessed in
																					// multiple methods.
		
		for (int i = 0; i < terms.length; i++) {
			originalTerms[i] = terms[i];											// Loading up new array.
		}
		MergeBU.sort(originalTerms);												// Sorting by Mergesort since it is guaranteed
																					// to be done in N log N.
	}

	/**
	 * Returns all terms that start with the given prefix, in descending order of
	 * weight.
	 * 
	 * @param prefix
	 * @return
	 */
	public Term[] allMatches(String prefix) {
		Term key = new Term(prefix, 0.0);											// Term will be used as a key.
		Comparator<Term> po = Term.byPrefixOrder(prefix.length());
		Comparator<Term> rwo = Term.byReverseWeightOrder();

		int firstMatch = BinarySearchDeluxe.firstIndexOf(originalTerms, key, po);	// Used to calculate the size of the results array.
		int lastMatch = BinarySearchDeluxe.lastIndexOf(originalTerms, key, po);		// Used to calculate the size of the results array.
		Term[] results = new Term[lastMatch - firstMatch + 1];						// New array will hold results of search.
		
		for (int i = 0; firstMatch <= lastMatch; i++) {								// Load up new array with results of old array from
			results[i] = originalTerms[firstMatch++];								// the first index where the key was found to the last.
		}
		Arrays.sort(results, rwo);													// Sort new array by ReverseWeightOrder.
		return results;																// Return new array with results.
	}

	/**
	 * Returns the number of terms that start with the given prefix.
	 * 
	 * @param prefix
	 * @return
	 */
	public int numberOfMatches(String prefix) {
		Term key = new Term(prefix, 0.0);											// Term will be used as a key.
		Comparator<Term> po = Term.byPrefixOrder(prefix.length());
		
		int firstMatch = BinarySearchDeluxe.firstIndexOf(originalTerms, key, po);	// Used to calculate number of matches.
		int lastMatch = BinarySearchDeluxe.lastIndexOf(originalTerms, key, po);		// Used to calculate number of matches.
		
		if (firstMatch == -1 || lastMatch == -1) {
			return 0;
		}
		
		return lastMatch - firstMatch + 1;											// Returns number of matches.
	}

	
	/* = = = = = = TEST CLIENT = = = = = = */
/*	public static void main(String[] args) {
		Term[] terms = { new Term("Ace In The Hole", 421.02), new Term("Addiction", 108.9), new Term("Ace Ventura", 500),
				new Term("Batman Returns", 27), new Term("Beauty And The Beast", 200), new Term("Bridge to Terabithia", 3.14) };
		Autocomplete test = new Autocomplete(terms);

		System.out.print("Number of Matches 'Ace': ");
		System.out.println(test.numberOfMatches("Ace"));

		Term[] temp = test.allMatches("B");

		for (Term term : temp)
			System.out.println(term);
	}
*/
}
