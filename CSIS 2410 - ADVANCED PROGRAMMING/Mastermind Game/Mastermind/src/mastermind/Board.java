package mastermind;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Creates the Mastermind Board Game.
 * 
 * @author chris munoz & kim soto!
 */
public class Board extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3155973236070932371L;
	private JPanel contentPane;
	private static ArrayList<JLabel> marbleindex = new ArrayList<JLabel>();
	private List<Marble> marbles = new LinkedList<Marble>();
	private static JLabel[] pegs = new JLabel[40];
	private List<Marble> tempMarble = new LinkedList<Marble>();
	private int counter = 0;
	private JPanel pnlMarbles;
	private JPanel pnlGuess_1;
	private int temp = 0;
	private int trigger = 0;
	private int setCounter;
	private int pegCounter;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board frame = new Board();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Board() {
		// Sets winning sequence.
		Game.setWinningSequence();
		createsPanel();
		JPanel pnlGuess = createsPnlGuess();
		createColorButtons(pnlGuess);
		createsPnlMarbles();
		JPanel pnlPegs = createsPnlPegs();
		// black and white pegs
		createPegs(pnlPegs);
		// marble slots
		createMarbleSlots(pnlMarbles);
	}

	/**
	 * Creates the Panel where the Peg Images are placed.
	 * @return JPanel
	 */
	private JPanel createsPnlPegs() {
		JPanel pnlPegs = new JPanel();
		pnlPegs.setBorder(new EmptyBorder(0, 0, 0, 20));
		contentPane.add(pnlPegs, BorderLayout.EAST);
		pnlPegs.setLayout(new GridLayout(30, 2, 0, 0));
		pnlPegs.setBackground(Color.WHITE);
		pnlPegs.setOpaque(true);
		return pnlPegs;
	}

	/**
	 * Creates the Panel where the Marbles are placed.
	 */
	private void createsPnlMarbles() {
		pnlMarbles = new JPanel();
		pnlMarbles.setBackground(Color.WHITE);
		pnlMarbles.setBorder(new EmptyBorder(0, 10, 10, 0));
		contentPane.add(pnlMarbles, BorderLayout.WEST);
		pnlMarbles.setLayout(new GridLayout(10, 4, 0, 2));
	}

	/**
	 * Creates the Panel where the Color Buttons are placed.
	 * @return JPanel
	 */
	private JPanel createsPnlGuess() {
		pnlGuess_1 = new JPanel();
		pnlGuess_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPane.add(pnlGuess_1, BorderLayout.SOUTH);
		pnlGuess_1.setBackground(Color.WHITE);
		pnlGuess_1.setOpaque(true);
		return pnlGuess_1;
	}

	/**
	 * Creates Title Panel that reads "MASTERMIND".
	 */
	private void createsPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 1015);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setOpaque(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblMastermind = new JLabel("Mastermind");
		lblMastermind.setBorder(new EmptyBorder(0, 0, 10, 0));
		lblMastermind.setFont(new Font("Impact", Font.PLAIN, 33));
		lblMastermind.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMastermind, BorderLayout.NORTH);
	}

	/**
	 * Creates 10 Rows and 4 Columns of Marble Slots.
	 * 
	 * @param pnlMarbles
	 */
	private void createMarbleSlots(JPanel pnlMarbles) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				JLabel label = new JLabel("");
				pnlMarbles.add(label);
				label.setIcon(new ImageIcon(Board.class.getResource("/images/emptymarbleslot.jpg")));
				marbleindex.add(label);
			}
		}
	}

	/**
	 * Creates Pegs at the end of the rows for Player feedback.
	 * 
	 * @param pnlPegs
	 */
	private void createPegs(JPanel pnlPegs) {
		int tally = 0;
		for (int i = 0; i <= pegs.length; i++) {
			pegs[i] = new JLabel("");
			pegs[i].setIcon(new ImageIcon(Game.class.getResource("/images/defaultorincorrect.JPG")));
			;
			pnlPegs.add(pegs[i]);
			tally++;
			if (tally % 4 == 0) {
				if (tally == 40) {
					break;
				}
				JLabel lblSeparation1 = new JLabel("___");
				JLabel lblSeparation2 = new JLabel("___");
				lblSeparation1.setHorizontalAlignment(SwingConstants.RIGHT);
				lblSeparation2.setHorizontalAlignment(SwingConstants.LEFT);
				pnlPegs.add(lblSeparation1);
				pnlPegs.add(lblSeparation2);

			}
		}

	}

	/**
	 * Creates buttons and event handlers for the buttons.
	 * 
	 * @param pnlGuess
	 */
	private void createColorButtons(JPanel pnlGuess) {
		GridBagLayout gbl_pnlGuess_1 = new GridBagLayout();
		gbl_pnlGuess_1.columnWidths = new int[] { 232, 232, 0 };
		gbl_pnlGuess_1.rowHeights = new int[] { 33, 33, 33, 33, 0 };
		gbl_pnlGuess_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnlGuess_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlGuess_1.setLayout(gbl_pnlGuess_1);

		btnSubmit = new JButton("Submit");
		createSubmitButton();

		JButton rdbtnBlue = new JButton("Blue");
		rdbtnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// blue
				tempMarble.clear();
				Marble blueMarble = new Marble(MarbleColor.BLUE);
				marbleindex.get(counter).setIcon(new ImageIcon(Board.class.getResource("/images/bluemarble.jpg")));
				tempMarble.add(blueMarble);
				

				btnSubmit.setEnabled(true);
			}
		});

		JButton rdbtnBlack = new JButton("Black");
		rdbtnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// black
				tempMarble.clear();
				Marble blackMarble = new Marble(MarbleColor.BLACK);
				marbleindex.get(counter).setIcon(new ImageIcon(Board.class.getResource("/images/blackmarble.jpg")));
				tempMarble.add(blackMarble);

				btnSubmit.setEnabled(true);
			}
		});
		rdbtnBlack.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		rdbtnBlack.setBackground(Color.BLACK);
		GridBagConstraints gbc_rdbtnBlack = new GridBagConstraints();
		gbc_rdbtnBlack.fill = GridBagConstraints.BOTH;
		gbc_rdbtnBlack.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBlack.gridx = 0;
		gbc_rdbtnBlack.gridy = 0;
		pnlGuess.add(rdbtnBlack, gbc_rdbtnBlack);
		rdbtnBlue.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		rdbtnBlue.setBackground(Color.BLUE);
		GridBagConstraints gbc_rdbtnBlue = new GridBagConstraints();
		gbc_rdbtnBlue.fill = GridBagConstraints.BOTH;
		gbc_rdbtnBlue.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnBlue.gridx = 1;
		gbc_rdbtnBlue.gridy = 0;
		pnlGuess.add(rdbtnBlue, gbc_rdbtnBlue);

		JButton rdbtnYellow = new JButton("Yellow");
		rdbtnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// yellow
				tempMarble.clear();
				Marble yellowMarble = new Marble(MarbleColor.YELLOW);
				marbleindex.get(counter).setIcon(new ImageIcon(Board.class.getResource("/images/yellowmarble.jpg")));
				tempMarble.add(yellowMarble);

				btnSubmit.setEnabled(true);
			}
		});

		JButton rdbtnWhite = new JButton("White");
		rdbtnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// white
				tempMarble.clear();
				Marble whiteMarble = new Marble(MarbleColor.WHITE);
				marbleindex.get(counter).setIcon(new ImageIcon(Board.class.getResource("/images/whitemarble.jpg")));
				tempMarble.add(whiteMarble);
				
				btnSubmit.setEnabled(true);
			}
		});

		JButton rdbtnRed = new JButton("Red");
		rdbtnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// red
				tempMarble.clear();
				Marble redMarble = new Marble(MarbleColor.RED);
				marbleindex.get(counter).setIcon(new ImageIcon(Board.class.getResource("/images/redmarble.jpg")));
				tempMarble.add(redMarble);

				btnSubmit.setEnabled(true);
			}
		});

		JButton rdbtnGreen = new JButton("Green");
		rdbtnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// green
				tempMarble.clear();
				Marble greenMarble = new Marble(MarbleColor.GREEN);
				marbleindex.get(counter).setIcon(new ImageIcon(Board.class.getResource("/images/greenmarble.jpg")));
				tempMarble.add(greenMarble);

				btnSubmit.setEnabled(true);
			}
		});
		rdbtnGreen.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		rdbtnGreen.setBackground(Color.GREEN);
		GridBagConstraints gbc_rdbtnGreen = new GridBagConstraints();
		gbc_rdbtnGreen.fill = GridBagConstraints.BOTH;
		gbc_rdbtnGreen.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnGreen.gridx = 0;
		gbc_rdbtnGreen.gridy = 1;
		pnlGuess.add(rdbtnGreen, gbc_rdbtnGreen);
		rdbtnRed.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		rdbtnRed.setBackground(Color.RED);
		GridBagConstraints gbc_rdbtnRed = new GridBagConstraints();
		gbc_rdbtnRed.fill = GridBagConstraints.BOTH;
		gbc_rdbtnRed.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnRed.gridx = 1;
		gbc_rdbtnRed.gridy = 1;
		pnlGuess.add(rdbtnRed, gbc_rdbtnRed);
		rdbtnWhite.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		rdbtnWhite.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnWhite = new GridBagConstraints();
		gbc_rdbtnWhite.fill = GridBagConstraints.BOTH;
		gbc_rdbtnWhite.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWhite.gridx = 0;
		gbc_rdbtnWhite.gridy = 2;
		pnlGuess.add(rdbtnWhite, gbc_rdbtnWhite);
		rdbtnYellow.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		rdbtnYellow.setBackground(Color.YELLOW);
		GridBagConstraints gbc_rdbtnYellow = new GridBagConstraints();
		gbc_rdbtnYellow.fill = GridBagConstraints.BOTH;
		gbc_rdbtnYellow.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnYellow.gridx = 1;
		gbc_rdbtnYellow.gridy = 2;
		pnlGuess.add(rdbtnYellow, gbc_rdbtnYellow);
		btnSubmit.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridwidth = 2;
		gbc_btnSubmit.fill = GridBagConstraints.BOTH;
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 3;
		pnlGuess.add(btnSubmit, gbc_btnSubmit);
	}

	/**
	 * Creates Submit Button with Action Listener that calculates the Peg Images,
	 * and sets Marbles on the board. Submit button starts disabled, Color Buttons
	 * enable it, and upon Submitting, this button disables itself again.
	 */
	private void createSubmitButton() {
		btnSubmit.setEnabled(false);
		btnSubmit.setPreferredSize(new Dimension(100, 29));
		btnSubmit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marbles.addAll(tempMarble);
				
				counter++;
				if (setCounter <= 3) {
					User.setUserMarbles(marbles.get(setCounter), setCounter);
					if (User.getUserMarbles()[setCounter].getColor() == Game.getWinningSequence()[setCounter]
							.getColor()) {
						pegs[temp].setIcon(new ImageIcon(Game.class.getResource("/images/correctpeg.JPG")));
						temp++;
					}
					else {
						for(int i = 0;i < Game.getWinningSequence().length;i++) {
							if(User.getUserMarbles()[setCounter].getColor() == Game.getWinningSequence()[i].getColor()) {
								pegs[temp].setIcon(new ImageIcon(Game.class.getResource("/images/almostcorrectpeg.JPG")));
								temp++;
							}
						}
					}

					setCounter++;

					if (setCounter > 3) {
						pegCounter++;
						setCounter = 0;
						temp = 0;
						temp = pegCounter * 4;
					}
				}

				if (counter >= 37) {

					if (trigger == 3) {
						lose();
					}
					if (User.getUserMarbles()[trigger].getColor() != Game.getWinningSequence()[trigger].getColor()) {
					}
					trigger++;
				}

				if (counter % 4 == 0) {

					if (Game.didYouWin(User.getUserMarbles(), Game.getWinningSequence())) {
						win();
					} else {
						marbles.clear();
					}
				}
				btnSubmit.setEnabled(false);
			}

		});
	}

	/**
	 * Removes the whole board and displays winning graphic.
	 */
	private void win() {
		JLabel lblYouWin = new JLabel();
		lblYouWin.setIcon(new ImageIcon(Game.class.getResource("/images/youwin.jpg")));
		contentPane.removeAll();
		contentPane.add(lblYouWin);
		contentPane.validate();
	}

	/**
	 * Removes the whole board and displays losing graphic.
	 */
	private void lose() {
		JLabel lblYouLoose = new JLabel();
		lblYouLoose.setIcon(new ImageIcon(Game.class.getResource("/images/youloose.jpg")));
		contentPane.removeAll();
		contentPane.add(lblYouLoose);
		contentPane.validate();
	}

}
