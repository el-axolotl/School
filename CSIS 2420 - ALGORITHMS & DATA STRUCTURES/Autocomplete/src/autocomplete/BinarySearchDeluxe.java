package autocomplete;

import java.util.Comparator;

/**
 * BinarySearchDeluxe searches through a sorted array that may contain more than one key
 * equal to the search key, and finds the index of either the first or the last such key.
 * @author Annie Ruiz & Christopher Munoz
 */
public class BinarySearchDeluxe {

	/**
	 * Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
	 * @param a - the array being searched through for a key, assumed to have already been sorted
	 * @param key - the key we're searching for the first occasion of
	 * @param comparator - the Comparator<> being used
	 * @return The index of the FIRST equal key in a[], or -1 if there's none
	 */
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		//throws a NullPointerException if any of the arguments are null
		if (a == null || key == null || comparator == null) {
			throw new java.lang.NullPointerException("The argument cannot be null");
		}
		int low = 0; 			//starts at the beginning of array
		int high = a.length - 1; 	//starts at the end of the array

		while (low <= high) {						//runs the while loop until the low and the high pass eachother/overlap
			int mid = low + (high - low) / 2;			//sets the middle of the array 
					 
			if (comparator.compare(key, a[low]) == 0) {		//first checks if the first index in the array is equal to the key,
				return low;					//if it is, then we just return it since it's the first index of the key
			}

			if (comparator.compare(key, a[mid]) < 0) {		//if the key is less than the middle,
				high = mid - 1;					//then the high becomes the middle - 1 (excluding the key just checked)
			}

			else if(comparator.compare(key, a[mid]) > 0) {		//if the key is greater than the middle,
				low = mid + 1;					//then the low becomes the middle + 1 (excluding the key just checked)
			}
			else {
				if (comparator.compare(key, a[mid - 1]) > 0) {	//if the one before the middle is greater than the key,
					return mid;				//then the middle is the first index of the key.
				}												
				high = mid;					//If it's not, then the high becomes the middle.
			}
		}
		if (comparator.compare(key, a[low]) == 0) return low;	//if the key is equal to the low, return the low
		if (comparator.compare(key, a[high]) == 0) return high;	//if the key is equal to the high, return the high
		return -1; 						//returns -1 if there is no such key.
	}
	
	/**
	 * Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
	 * @param a - the array being searched through for a key, assumed to have already been sorted
	 * @param key - the key we're searching for the first occasion of
	 * @param comparator - the Comparator<> being used
	 * @return The index of the LAST equal key in a[], or -1 if there's none
	 */
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
				//throws a NullPointerException if any of the arguments are null
				if (a == null || key == null || comparator == null) {
					throw new java.lang.NullPointerException("The argument cannot be null");
				}
				int low = 0; 			//starts at the beginning of array
				int high = a.length - 1; 	//starts at the end of the array
		
				while (low <= high) {						//runs the while loop until the low and the high pass eachother/overlap
					int mid = low + (high - low) / 2;			//sets the middle of the array 
							 
					if (comparator.compare(key, a[high]) == 0) {		//first checks if the last index in the array is equal to the key,
						return high;					//if it is, then we just return it since it's the last index of the key
					}
		
					if (comparator.compare(key, a[mid]) < 0) {		//if the key is less than the middle,
						high = mid - 1;					//then the high becomes the middle - 1 (excluding the key just checked)
					}
		
					else if(comparator.compare(key, a[mid]) > 0) {		//if the key is greater than the middle,
						low = mid + 1;					//then the low becomes the middle + 1 (excluding the key just checked)
					}
					else {	
						if (comparator.compare(key, a[mid + 1]) < 0) {	//if the one after the middle is less than the key,
							return mid;				//then the middle is the first index of the key.										//if the passed key and the middle are equal, then the low becomes the mid
						}
						low = mid;					//this checks if theres any index later than the middle that are equal.
					}
				}
				if (comparator.compare(key, a[high]) == 0) return high;		//if the key is equal to the high, return the high
				if (comparator.compare(key, a[low]) == 0) return low;		//if the key is equal to the low, return the low
				return -1; 							//returns -1 if there is no such key.
	}
}
