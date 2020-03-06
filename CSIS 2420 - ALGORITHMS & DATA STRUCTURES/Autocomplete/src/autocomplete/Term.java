/**
 * 
 */
package autocomplete;

import java.util.Comparator;

/**
 * @author Annie Ruiz & Christopher Munoz
 *
 */
public class Term implements Comparable<Term> {
	private String query;
	private double weight;
	private static int rSize;

	/**
	 * Initialize a term with the given query string and weight.
	 * 
	 * @param query
	 * @param weight
	 */
	public Term(String query, double weight) {
		if (query == null) {
			throw new java.lang.NullPointerException("'query' cannot be a null");
		}
		if (weight < 0) {
			throw new java.lang.IllegalArgumentException("'weight' cannot be a negative");
		}
		this.query = query;
		this.weight = weight;
	}

	/**
	 * Compares the terms in descending order by weight.
	 * 
	 * @return
	 */
	public static Comparator<Term> byReverseWeightOrder() {
		return new ReverseWeightComparator();
	}

	/**
	 * Compares the terms in lexicographic order but using only the first r
	 * characters of each query.
	 * 
	 * @param r
	 * @return
	 */
	public static Comparator<Term> byPrefixOrder(int r) {
		if (r < 0) {
			throw new java.lang.IllegalArgumentException("'r' cannot be a negative");
		}
		rSize = r;
		return new PrefixComparator();
	}

	/**
	 * Compare the terms in lexicographic order by query.
	 */
	@Override
	public int compareTo(Term that) {
		return this.query.compareTo(that.query);
		/* return Integer.compare((int)this.weight, (int)that.weight); */
	}

	/**
	 * Return a string representation of the term in the following format: the
	 * weight, followed by a tab, followed by the query.
	 */
	public String toString() {
		return weight + "\t" + query;
	}

	/**
	 * Creates a Comparator that compares terms by weight in descending order.
	 * 
	 * @author Annie Ruiz & Christopher Munoz
	 *
	 */
	private static class ReverseWeightComparator implements Comparator<Term> {

		@Override
		public int compare(Term first, Term second) {
			return Integer.compare((int) second.weight, (int) first.weight);
			/*
			 * if (first.weight > second.weight) return 1; else if (first.weight <
			 * second.weight) return -1; else return 0;
			 */
		}

	}

	/**
	 * Compares the terms in lexicographic order but using only the first r
	 * characters of each query.
	 * 
	 * @author Annie Ruiz & Christopher Munoz
	 *
	 */
	private static class PrefixComparator implements Comparator<Term> {

		@Override
		public int compare(Term first, Term second) {
			String firstR = first.query.substring(0, rSize);
			String secondR = second.query.substring(0, rSize);

			if (firstR.compareTo(secondR) > 0) {
				return 1;
			}
			
			if (firstR.compareTo(secondR) < 0) {
				return -1;
			}

			return 0;
		}
	}
	
	/* = = = = = = TEST CLIENT = = = = = = */
/*	public static void main(String[] args) {
		Term term1 = new Term("Banjo", 3.0);
		Term term2 = new Term("Bananas", 10.1);
		Term term3 = new Term("Apples", 2.1);
		
		Term[] a = {term1, term2, term3};
		Comparator<Term> rwo = Term.byReverseWeightOrder();
		
		Arrays.sort(a, rwo);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		
		Term term4 = new Term("jam jar", 3.0);
		Term term5 = new Term("jar of jam jars", 10.1);
		Term term6 = new Term("Apples", 2.1);
		
		Term[] b = {term4, term5, term6};
		Comparator<Term> prefix = Term.byPrefixOrder(2);
		System.out.println(prefix.compare(b[0], b[1]));
	}*/

}