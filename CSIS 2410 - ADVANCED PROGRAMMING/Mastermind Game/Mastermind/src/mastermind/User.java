
package mastermind;

/**
 * This class holds the selection of Marbles that the user guesses.
 * 
 * @author chris munoz & kim soto!
 * 
 */
public class User {

	/**
	 * {userMarbles} will be used to compare to Game Class {winningSequence}
	 */
	private static Marble[] userMarbles = new Marble[4];

	public static void setUserMarbles(Marble marble1, Marble marble2, Marble marble3, Marble marble4) {
		int i = 0;

		userMarbles[i] = marble1;
		i++;

		userMarbles[i] = marble2;
		i++;

		userMarbles[i] = marble3;
		i++;

		userMarbles[i] = marble4;
	}

	/**
	 * Sets a Marble object into the userMarbles array at index {i}, which is used to compare
	 * against the winning sequence to check if you won.
	 * 
	 * @param marble
	 * @param i
	 */
	public static void setUserMarbles(Marble marble, int i) {
		userMarbles[i] = marble;
	}

	/**
	 * Returns the userMarbles array.
	 * @return
	 */
	public static Marble[] getUserMarbles() {
		return userMarbles;
	}

}
