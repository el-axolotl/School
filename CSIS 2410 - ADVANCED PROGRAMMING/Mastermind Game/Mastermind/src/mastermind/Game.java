package mastermind;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class handles the creation of Winning Sequence, and calculates if the
 * user won.
 * 
 * @author chris munoz & kim soto!
 *
 */
public class Game {

	private static Marble[] winningSequence = new Marble[4];

	public static void setWinningSequence() {
		Random rand = new Random();

		for (int i = 0; i < winningSequence.length; i++) {
			int j = rand.nextInt(6) + 1;
			if (j == 1) {
				Marble marble = new Marble(MarbleColor.YELLOW);
				winningSequence[i] = marble;
			}
			if (j == 2) {
				Marble marble = new Marble(MarbleColor.RED);
				winningSequence[i] = marble;
			}
			if (j == 3) {
				Marble marble = new Marble(MarbleColor.BLUE);
				winningSequence[i] = marble;
			}
			if (j == 4) {
				Marble marble = new Marble(MarbleColor.GREEN);
				winningSequence[i] = marble;
			}
			if (j == 5) {
				Marble marble = new Marble(MarbleColor.BLACK);
				winningSequence[i] = marble;
			}
			if (j == 6) {
				Marble marble = new Marble(MarbleColor.WHITE);
				winningSequence[i] = marble;
			}
		}

		/*
		 * for (int i = 0; i < winningSequence.length; i++) { Marble marble = new
		 * Marble(MarbleColor.BLACK); winningSequence[i] = marble; }
		 */
		/*
		 * Marble marble1 = new Marble(MarbleColor.RED); Marble marble2 = new
		 * Marble(MarbleColor.BLUE); Marble marble3 = new Marble(MarbleColor.BLACK);
		 * Marble marble4 = new Marble(MarbleColor.WHITE);
		 * 
		 * winningSequence[0] = marble1; winningSequence[1] = marble2;
		 * winningSequence[2] = marble3; winningSequence[3] = marble4;
		 */
	}

	/**
	 * Returns the winning sequence.
	 * @return
	 */
	public static Marble[] getWinningSequence() {
		return winningSequence;
	}

	/**
	 * Checks if user won.
	 * @param userMarbles
	 * @param winningSequence
	 * @return
	 */
	public static boolean didYouWin(Marble[] userMarbles, Marble[] winningSequence) {
		boolean[] test = new boolean[4];
		for (int i = 0; i < winningSequence.length; i++) {
			if (userMarbles[i].getColor() == winningSequence[i].getColor()) {
				test[i] = true;
			}
		}

		if (test[0] && test[1] && test[2] && test[3]) {
			return true;
		}
		return false;
	}

	/**
	 * Creates the losing Graphic if you lose.
	 * @return
	 */
	public static JLabel youLose() {
		JLabel lblYouLoose = new JLabel();
		lblYouLoose.setIcon(new ImageIcon(Game.class.getResource("/images/youloose.jpg")));
		return lblYouLoose;
	}

}
