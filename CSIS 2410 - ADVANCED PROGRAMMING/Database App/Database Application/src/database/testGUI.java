package database;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Panel;
import java.awt.Button;

/**
 * Creates a GUI for a Basketball Database
 * 
 * @author Pat Hurley & Christopher Munoz
 *
 */
@SuppressWarnings("serial")
public class testGUI extends JFrame {
	static SqlQuery sql = new SqlQuery();
	private static List<String> players = new LinkedList<>();
	private static List<String> teams = new LinkedList<>();
	private static List<String> queries = new LinkedList<>();

	private JPanel contentPane;
	private JTextField addFName;
	private JTextField addLName;
	private JPanel resultPanel;
	private JComboBox<?> addPos;
	private JComboBox<?> comboBoxPosQry;
	private JComboBox<?> addAge;
	private JComboBox<?> addHeight;
	private JRadioButton rdbtnMvp;
	private JComboBox<Object> teamID;
	private JComboBox<?> teamIDQry;
	private JTable addTextArea;
	private static ResultSet results;

	private JTabbedPane tabbedPane;
	private JPanel northRemovePnl;
	private JPanel removePlayerPnl;
	private JButton removePlayerBtn;
	private JPanel removeBtnPlayerPnl;
	private JLabel playerIdLabel;
	private JTextField playerIdTxtField;
	private JPanel removeTeamPnl;
	private JPanel removeBtnTeamPnl;
	private JLabel enterTeamIdLbl;
	private JTextField teamIdTxtField;
	private JButton btnRemoveTeam;
	private JTable removeTextArea;

	private JPanel northQueryPnl;
	private JTable queryTextArea;
	private JButton btnRestartQry;
	private JButton buttonQry;
	private JLabel lblSelectQry;
	private JComboBox<?> comboBoxQry;

	private int posCounter = 0;
	private int ageCounter = 0;
	private int descendingCounter = 0;
	private JPanel panelQryVars;
	private JComboBox<?> comboAgeLo;
	private JComboBox<?> comboAgeHi;

	private JScrollPane scrollAdd;
	private JScrollPane scrollRem;
	private JPanel submitTeamPnl;
	private JLabel addTeamLbl;
	private JButton btnSubmitTeam;
	private JPanel teamFieldsPnl;
	private JTextField teamNameTxtField;
	private JTextField teamCityTxtField;
	private JLabel champsLbl;
	private JComboBox<?> champsCombo;
	private JScrollPane scroll3;
	private JPanel dropDownAddPnl;
	private JPanel addNorthPanel;
	private JPanel editPnl;
	private Panel editNorthPanel;
	private Panel editVarsPanel;
	private JLabel lblEditPlayer;
	private Button editSubmitBtn;
	private JLabel lblTeamId;
	private JTextField textFieldPlayerID;
	private JLabel lblNewFirstName;
	private JTextField textFieldFName;
	private JLabel lblNewLastName;
	private JTextField textFieldLName;
	private JScrollPane scrollPane;
	private JTable changeTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SqlQuery.addTeams();
		try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB1;create=true");
				Statement statement = connection.createStatement()) {

			dropCreateFillTables(statement);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testGUI frame = new testGUI();
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
	public testGUI() {
		setTitle("BasketBall DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel addPnl = createAddPnl();
		tabbedPane.addTab("Add", null, addPnl, null);

		JPanel removePnl = createRemovePnl();
		tabbedPane.addTab("Remove", null, removePnl, null);

		JPanel queryPnl = createQueryPnl();
		tabbedPane.addTab("Query", null, queryPnl, null);

		createEditPnl();

		tabbedPane.setSelectedIndex(0);


	}

	private void createEditPnl() {
		{
			editPnl = new JPanel();
			tabbedPane.addTab("Edit", null, editPnl, null);
			editPnl.setLayout(new BorderLayout(0, 0));
			{
				editNorthPanel = new Panel();
				editPnl.add(editNorthPanel, BorderLayout.NORTH);
				GridBagLayout gbl_editNorthPanel = new GridBagLayout();
				gbl_editNorthPanel.columnWidths = new int[] { 384, 384, 0 };
				gbl_editNorthPanel.rowHeights = new int[] { 29, 29, 0 };
				gbl_editNorthPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
				gbl_editNorthPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
				editNorthPanel.setLayout(gbl_editNorthPanel);
				{
					lblEditPlayer = new JLabel("Edit Player");
					lblEditPlayer.setHorizontalAlignment(SwingConstants.CENTER);
					GridBagConstraints gbc_lblEditPlayer = new GridBagConstraints();
					gbc_lblEditPlayer.fill = GridBagConstraints.BOTH;
					gbc_lblEditPlayer.insets = new Insets(0, 0, 5, 5);
					gbc_lblEditPlayer.gridx = 0;
					gbc_lblEditPlayer.gridy = 0;
					editNorthPanel.add(lblEditPlayer, gbc_lblEditPlayer);
				}
				{
					editSubmitBtn = new Button("Submit");
					editSubmitBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						players.clear();
						SqlQuery.changePlayerNames(Integer.parseInt(textFieldPlayerID.getText()),
												textFieldFName.getText(), textFieldLName.getText());
						populatePlayerTable(changeTable);
										
						}
					});
					GridBagConstraints gbc_editSubmitBtn = new GridBagConstraints();
					gbc_editSubmitBtn.fill = GridBagConstraints.BOTH;
					gbc_editSubmitBtn.insets = new Insets(0, 0, 5, 0);
					gbc_editSubmitBtn.gridx = 1;
					gbc_editSubmitBtn.gridy = 0;
					editNorthPanel.add(editSubmitBtn, gbc_editSubmitBtn);
				}
				{
					editVarsPanel = new Panel();
					GridBagConstraints gbc_editVarsPanel = new GridBagConstraints();
					gbc_editVarsPanel.gridwidth = 2;
					gbc_editVarsPanel.fill = GridBagConstraints.BOTH;
					gbc_editVarsPanel.insets = new Insets(0, 0, 0, 5);
					gbc_editVarsPanel.gridx = 0;
					gbc_editVarsPanel.gridy = 1;
					editNorthPanel.add(editVarsPanel, gbc_editVarsPanel);
					editVarsPanel.setLayout(new GridLayout(1, 6, 0, 0));
					{
						lblTeamId = new JLabel("Player ID");
						lblTeamId.setHorizontalAlignment(SwingConstants.CENTER);
						editVarsPanel.add(lblTeamId);
					}
					{
						textFieldPlayerID = new JTextField();
						textFieldPlayerID.setToolTipText("Enter the Player ID for the Player you wish to edit.");
						editVarsPanel.add(textFieldPlayerID);
						textFieldPlayerID.setColumns(10);
					}
					{
						lblNewFirstName = new JLabel("First Name");
						lblNewFirstName.setToolTipText("");
						lblNewFirstName.setHorizontalAlignment(SwingConstants.CENTER);
						editVarsPanel.add(lblNewFirstName);
					}
					{
						textFieldFName = new JTextField();
						textFieldFName.setToolTipText(
								"Enter either the new First Name, or if this part is not being editted, enter the current First Name.");
						editVarsPanel.add(textFieldFName);
						textFieldFName.setColumns(10);
					}
					{
						lblNewLastName = new JLabel("Last Name");
						lblNewLastName.setToolTipText("");
						lblNewLastName.setHorizontalAlignment(SwingConstants.CENTER);
						editVarsPanel.add(lblNewLastName);
					}
					{
						textFieldLName = new JTextField();
						textFieldLName.setToolTipText(
								"Enter either the new Last Name, or if this part is not being editted, enter the current Last Name.");
						editVarsPanel.add(textFieldLName);
						textFieldLName.setColumns(10);
					}
				}
			}
			{	
				changeTable = new JTable(100,8);
				changeTable.setGridColor(Color.LIGHT_GRAY);
				changeTable.setEnabled(false);
				scrollPane = new JScrollPane(changeTable);
				editPnl.add(scrollPane, BorderLayout.CENTER);
			}
		}
	}

	// ========================= Query ===============================
	/**
	 * Creates the panel that handles the users queries and writes them to a table
	 * 
	 * @return
	 */
	private JPanel createQueryPnl() {
		JPanel queryPnl = new JPanel();
		queryPnl.setLayout(new BorderLayout(0, 0));
		{
			queryTextArea = new JTable(100, 8);
			queryTextArea.setGridColor(Color.LIGHT_GRAY);
			queryTextArea.setEnabled(false);
			scroll3 = new JScrollPane(queryTextArea);
			scroll3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		{
			northQueryPnl = new JPanel();
			queryPnl.add(northQueryPnl, BorderLayout.NORTH);
			GridBagLayout gbl_northQueryPnl = new GridBagLayout();
			gbl_northQueryPnl.columnWidths = new int[] { 384, 384, 0 };
			gbl_northQueryPnl.rowHeights = new int[] { 29, 29, 29, 0 };
			gbl_northQueryPnl.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			gbl_northQueryPnl.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			northQueryPnl.setLayout(gbl_northQueryPnl);
			{
				buttonQry = new JButton("Submit");
				buttonQry.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						queryEventsHandler();
					}
				});
				{
					btnRestartQry = new JButton("Restart");
					btnRestartQry.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								testGUI frame = new testGUI();
								frame.setVisible(true);
							} catch (Exception f) {
								f.printStackTrace();
							}
						}
					});
					btnRestartQry.setHorizontalAlignment(SwingConstants.CENTER);
					GridBagConstraints gbc_lblSubmitQry = new GridBagConstraints();
					gbc_lblSubmitQry.fill = GridBagConstraints.BOTH;
					gbc_lblSubmitQry.insets = new Insets(0, 0, 5, 5);
					gbc_lblSubmitQry.gridx = 0;
					gbc_lblSubmitQry.gridy = 0;
					northQueryPnl.add(btnRestartQry, gbc_lblSubmitQry);
				}
				GridBagConstraints gbc_buttonQry = new GridBagConstraints();
				gbc_buttonQry.fill = GridBagConstraints.BOTH;
				gbc_buttonQry.insets = new Insets(0, 0, 5, 0);
				gbc_buttonQry.gridx = 1;
				gbc_buttonQry.gridy = 0;
				northQueryPnl.add(buttonQry, gbc_buttonQry);
			}
			{
				lblSelectQry = new JLabel("Select Query");
				lblSelectQry.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_lblSelectQry = new GridBagConstraints();
				gbc_lblSelectQry.fill = GridBagConstraints.BOTH;
				gbc_lblSelectQry.insets = new Insets(0, 0, 5, 5);
				gbc_lblSelectQry.gridx = 0;
				gbc_lblSelectQry.gridy = 1;
				northQueryPnl.add(lblSelectQry, gbc_lblSelectQry);
			}
			{
				comboBoxQry = new JComboBox<Object>(SqlQuery.queryNames);
				GridBagConstraints gbc_comboBoxQry = new GridBagConstraints();
				gbc_comboBoxQry.fill = GridBagConstraints.BOTH;
				gbc_comboBoxQry.insets = new Insets(0, 0, 5, 0);
				gbc_comboBoxQry.gridx = 1;
				gbc_comboBoxQry.gridy = 1;
				northQueryPnl.add(comboBoxQry, gbc_comboBoxQry);
			}
			{
				panelQryVars = new JPanel();
				GridBagConstraints gbc_panelQryVars = new GridBagConstraints();
				gbc_panelQryVars.gridwidth = 2;
				gbc_panelQryVars.fill = GridBagConstraints.BOTH;
				gbc_panelQryVars.insets = new Insets(0, 0, 0, 5);
				gbc_panelQryVars.gridx = 0;
				gbc_panelQryVars.gridy = 2;
				northQueryPnl.add(panelQryVars, gbc_panelQryVars);
				panelQryVars.setLayout(new GridLayout(1, 0, 0, 0));
			}
		}
		{
			queryPnl.add(scroll3);
			try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB1;create=true");
					Statement statement = connection.createStatement()) {
				// appendResults(getAllPlayers(statement), queryTextArea, scrollPaneQry);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return queryPnl;
	}

	// ========================= Add ====================================
	/**
	 * Creates the Panel that handles the adding Player commands.
	 * 
	 * @return
	 */
	private JPanel createAddPnl() {
		JPanel addPnl = new JPanel();
		addPnl.setLayout(new BorderLayout(0, 0));
		{
			addTextArea = new JTable(100, 8);
			addTextArea.setGridColor(Color.LIGHT_GRAY);
			addTextArea.setEnabled(false);
			scrollAdd = new JScrollPane(addTextArea);
			scrollAdd.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		{
			addNorthPanel = new JPanel();
			addNorthPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
			addPnl.add(addNorthPanel, BorderLayout.NORTH);
			addNorthPanel.setLayout(new GridLayout(4, 0, 0, 0));
			{
				JPanel submitAddPnl = new JPanel();
				submitAddPnl.setBorder(new EmptyBorder(2, 2, 0, 2));
				addNorthPanel.add(submitAddPnl);
				submitAddPnl.setLayout(new GridLayout(0, 2, 0, 0));
				{
					JButton submitBtnAdd = new JButton("Submit Player");
					submitBtnAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							players.clear();
							// adds a player
							SqlQuery.addPlayer(addFName.getText(), addLName.getText(),
									SqlQuery.positions[addPos.getSelectedIndex()],
									Integer.parseInt(SqlQuery.age[addAge.getSelectedIndex()]),
									SqlQuery.height[addHeight.getSelectedIndex()],
									(rdbtnMvp.isSelected() ? "True" : "False"),
									SqlQuery.teams.get(teamID.getSelectedIndex()));

							populatePlayerTable(addTextArea); // populates add Table with players
							addFName.setText("First Name");
							addLName.setText("Last Name");

						}
					});
					{
						JLabel addPlayerLbl = new JLabel("Add a Player");
						addPlayerLbl.setOpaque(true);
						addPlayerLbl.setHorizontalAlignment(SwingConstants.CENTER);
						submitAddPnl.add(addPlayerLbl);
					}
					submitAddPnl.add(submitBtnAdd);
				}
			}
			{
				resultPanel = createAddPlayerPnl();
				addNorthPanel.add(resultPanel);
			}
			{
				submitTeamPnl = new JPanel();
				submitTeamPnl.setBorder(new EmptyBorder(2, 0, 0, 0));
				addNorthPanel.add(submitTeamPnl);
				submitTeamPnl.setLayout(new GridLayout(1, 0, 0, 0));
				{
					addTeamLbl = new JLabel("Add a Team");
					addTeamLbl.setOpaque(true);
					addTeamLbl.setBackground(SystemColor.windowBorder);
					addTeamLbl.setHorizontalAlignment(SwingConstants.CENTER);
					submitTeamPnl.add(addTeamLbl);
				}
				{
					btnSubmitTeam = new JButton("Submit Team");
					btnSubmitTeam.setOpaque(true);
					btnSubmitTeam.setBackground(SystemColor.windowBorder);
					btnSubmitTeam.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							teams.clear();
							SqlQuery.addTeam(teamNameTxtField.getText(), teamCityTxtField.getText(),
									Integer.parseInt(SqlQuery.champs[champsCombo.getSelectedIndex()]));
							sql.addTeam(teamNameTxtField.getText());
							sql.addTeamInt(); // adds the team name to the arraylist for the drop down selection and
												// requesting
							teamID.addItem((String) SqlQuery.teamString.get(SqlQuery.teamString.size() - 1)); // repaints
																												// dropdown
							teamID.repaint();
							clearTable(addTextArea);
							populateTeamTable(addTextArea);
							teamNameTxtField.setText("Team Name");
							teamCityTxtField.setText("Team City");
						}
					});
					submitTeamPnl.add(btnSubmitTeam);
				}
			}
			{
				teamFieldsPnl = new JPanel();
				teamFieldsPnl.setBackground(SystemColor.windowBorder);
				addNorthPanel.add(teamFieldsPnl);
				teamFieldsPnl.setLayout(new GridLayout(1, 0, 0, 0));
				{
					teamNameTxtField = new JTextField();
					teamNameTxtField.setHorizontalAlignment(SwingConstants.CENTER);
					teamNameTxtField.setText("Team Name");
					teamFieldsPnl.add(teamNameTxtField);
					teamNameTxtField.setColumns(10);
				}
				{
					teamCityTxtField = new JTextField();
					teamCityTxtField.setHorizontalAlignment(SwingConstants.CENTER);
					teamCityTxtField.setText("Team City");
					teamFieldsPnl.add(teamCityTxtField);
					teamCityTxtField.setColumns(10);
				}
				{
					champsLbl = new JLabel("Championships won:");
					champsLbl.setHorizontalAlignment(SwingConstants.CENTER);
					champsLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
					teamFieldsPnl.add(champsLbl);
				}
				{
					champsCombo = new JComboBox<Object>(SqlQuery.champs);
					teamFieldsPnl.add(champsCombo);
				}
			}
		}
		{
			addPnl.add(scrollAdd);
		}
		players.clear();
		populatePlayerTable(addTextArea);
		return addPnl;
	}

	/**
	 * Creates a Panel that will read info from the user to add to the database.
	 * 
	 * @return
	 */
	private JPanel createAddPlayerPnl() {
		dropDownAddPnl = new JPanel();
		dropDownAddPnl.setForeground(Color.BLACK);
		dropDownAddPnl.setBorder(new EmptyBorder(0, 0, 5, 0));
		dropDownAddPnl.setLayout(new GridLayout(0, 7, 0, 0));
		{
			addFName = new JTextField();
			addFName.setText("First Name");
			dropDownAddPnl.add(addFName);
			addFName.setColumns(10);
		}
		{
			addLName = new JTextField();
			addLName.setText("Last Name");
			dropDownAddPnl.add(addLName);
			addLName.setColumns(10);
		}
		{
			addPos = new JComboBox<Object>(SqlQuery.positions);
			dropDownAddPnl.add(addPos);
		}
		{
			addAge = new JComboBox<Object>(SqlQuery.age);
			dropDownAddPnl.add(addAge);
		}
		{
			addHeight = new JComboBox<Object>(SqlQuery.heights);
			dropDownAddPnl.add(addHeight);
		}
		{
			rdbtnMvp = new JRadioButton("MVP");
			dropDownAddPnl.add(rdbtnMvp);
		}
		{
			teamID = new JComboBox<Object>(SqlQuery.teamString.toArray());
			dropDownAddPnl.add(teamID);
		}
		return dropDownAddPnl;
	}

	// =========================== Remove ==================================
	/**
	 * Creates the Panel that handles the remove Players commands.
	 * 
	 * @return
	 */
	private JPanel createRemovePnl() {
		JPanel removePnl = new JPanel();
		removePnl.setLayout(new BorderLayout(0, 0));
		{
			removeTextArea = new JTable(100, 8);
			removeTextArea.setGridColor(Color.LIGHT_GRAY);
			removeTextArea.setEnabled(false);

			scrollRem = new JScrollPane(removeTextArea);
			scrollRem.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		{
			northRemovePnl = new JPanel();
			removePnl.add(northRemovePnl, BorderLayout.NORTH);
			northRemovePnl.setLayout(new GridLayout(2, 0, 0, 0));
			{
				removePlayerPnl = new JPanel();
				northRemovePnl.add(removePlayerPnl);
				removePlayerPnl.setLayout(new GridLayout(0, 2, 0, 0));
				{
					removeBtnPlayerPnl = new JPanel();
					removePlayerPnl.add(removeBtnPlayerPnl);
					{
						playerIdLabel = new JLabel("Enter Player ID:");
						playerIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
						removeBtnPlayerPnl.add(playerIdLabel);
					}
					{
						playerIdTxtField = new JTextField();
						playerIdTxtField.setColumns(5);
						removeBtnPlayerPnl.add(playerIdTxtField);
					}
				}
				{
					removePlayerBtn = new JButton("Remove Player");
					removePlayerBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							SqlQuery.removePlayer(Integer.parseInt(playerIdTxtField.getText()));
							players.clear();
							populatePlayerTable(removeTextArea);
							playerIdTxtField.setText("");
						}
					});
					removePlayerPnl.add(removePlayerBtn);
				}
			}
			{
				removeTeamPnl = new JPanel();
				northRemovePnl.add(removeTeamPnl);
				removeTeamPnl.setLayout(new GridLayout(0, 2, 0, 0));
				{
					removeBtnTeamPnl = new JPanel();
					removeTeamPnl.add(removeBtnTeamPnl);
					{
						enterTeamIdLbl = new JLabel("Enter Team ID:");
						enterTeamIdLbl.setHorizontalAlignment(SwingConstants.CENTER);
						removeBtnTeamPnl.add(enterTeamIdLbl);
					}
					{
						teamIdTxtField = new JTextField();
						removeBtnTeamPnl.add(teamIdTxtField);
						teamIdTxtField.setColumns(5);
					}
				}
				{
					btnRemoveTeam = new JButton("Remove Team");
					btnRemoveTeam.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Object[] options = { "OK", "CANCEL" };
							int response = JOptionPane.showOptionDialog(null,
									"This will remove all players \n associated with this team. \n Click OK to continue",
									"Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
									options[0]);
							if (response == 0) {
								SqlQuery.removeTeam(Integer.parseInt(teamIdTxtField.getText()));
								sql.removeTeamfromList(Integer.parseInt(teamIdTxtField.getText()));
								teams.clear();
								resultPanel.remove(teamID);
								teamID = new JComboBox<>(SqlQuery.teamString.toArray());
								resultPanel.add(teamID);
								teamIdTxtField.setText("");

								clearTable(removeTextArea);
								populateTeamTable(removeTextArea);
							}

						}
					});
					removeTeamPnl.add(btnRemoveTeam);
				}
			}
		}
		{
			players.clear();
			populatePlayerTable(removeTextArea);
			removePnl.add(scrollRem);
		}
		return removePnl;
	}

	/**
	 * Handles events based off drop down menus to call different queries.
	 */
	private void queryEventsHandler() {
		try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB1;create=true");
				Statement statement = connection.createStatement()) {

			for (int i = 0; i < SqlQuery.queryNames.length; i++) {
				if (comboBoxQry.getSelectedItem() == SqlQuery.queryNames[0]) {

					if (posCounter == 0) {
						panelQryVars.removeAll();
						comboBoxPosQry = new JComboBox<Object>(SqlQuery.positions);
						teamIDQry = new JComboBox<Object>(SqlQuery.teamString.toArray());
						JLabel lblPos = new JLabel("Position:");
						JLabel lblTeamID = new JLabel("Team:");
						lblPos.setHorizontalAlignment(SwingConstants.CENTER);
						lblTeamID.setHorizontalAlignment(SwingConstants.CENTER);
						panelQryVars.add(lblPos);
						panelQryVars.add(comboBoxPosQry);
						panelQryVars.add(lblTeamID);
						panelQryVars.add(teamIDQry);
						panelQryVars.validate();
						posCounter++;
					}
					ageCounter = 0;

					int teamQry;
					String posQry;
					teamQry = SqlQuery.teams.get(teamIDQry.getSelectedIndex());
					posQry = (String) comboBoxPosQry.getSelectedItem();
					results = statement.executeQuery(SqlQuery.positionFromTeam(posQry, teamQry));

					clearTable(queryTextArea);
					populateQueryTable(queryTextArea, results);

					break; // So things don't run multiple times

				}

				if (comboBoxQry.getSelectedItem() == SqlQuery.queryNames[1]) {
					panelQryVars.removeAll();
					panelQryVars.validate();
					northQueryPnl.validate();
					posCounter = 0;
					ageCounter = 0;

					results = statement.executeQuery(SqlQuery.mvp());
					clearTable(queryTextArea);
					populateQueryTable(queryTextArea, results);

					break; // So things don't run multiple times
				}

				if (comboBoxQry.getSelectedItem() == SqlQuery.queryNames[2]) {
					posCounter = 0;
					int ageLo;
					int ageHi;
					int teamID;

					if (ageCounter == 0) {
						panelQryVars.removeAll();
						panelQryVars.validate();
						comboAgeLo = new JComboBox<Object>(SqlQuery.age);
						comboAgeHi = new JComboBox<Object>(SqlQuery.age);
						teamIDQry = new JComboBox<Object>(SqlQuery.teamString.toArray());
						JLabel lblFrom = new JLabel("From Age:");
						lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
						JLabel lblTo = new JLabel("To Age:");
						lblTo.setHorizontalAlignment(SwingConstants.CENTER);
						panelQryVars.add(lblFrom);
						panelQryVars.add(comboAgeLo);
						panelQryVars.add(lblTo);
						panelQryVars.add(comboAgeHi);
						panelQryVars.add(teamIDQry);
						panelQryVars.validate();
						ageCounter++;
						return;
					}

					if (ageCounter > 0) {
						ageLo = Integer.parseInt((String) comboAgeLo.getSelectedItem());
						ageHi = Integer.parseInt((String) comboAgeHi.getSelectedItem());
						teamID = SqlQuery.teams.get(teamIDQry.getSelectedIndex());

						results = statement.executeQuery(SqlQuery.getAllAgeFromTeam(ageLo, ageHi, teamID));

						clearTable(queryTextArea);
						populateQueryTable(queryTextArea, results);

						break;
					}

				}

				if (comboBoxQry.getSelectedItem() == SqlQuery.queryNames[3]) {
					panelQryVars.removeAll();
					panelQryVars.validate();
					posCounter = 0;
					ageCounter = 0;
					results = statement.executeQuery(SqlQuery.ChampAndMVP());
					System.out.println("MVP AND CHAMP selection testing");

					clearTable(queryTextArea);
					populateQueryTable(queryTextArea, results);

					break; // So things don't run multiple times
				}

				if (comboBoxQry.getSelectedItem() == SqlQuery.queryNames[4]) {

					int teamID;

					if (descendingCounter == 0) {
						panelQryVars.removeAll();
						teamIDQry = new JComboBox<Object>(SqlQuery.teamString.toArray());
						JLabel lblTeam = new JLabel("Select Team");
						lblTeam.setHorizontalAlignment(SwingConstants.CENTER);
						panelQryVars.add(lblTeam);
						panelQryVars.add(teamIDQry);
						panelQryVars.validate();
						descendingCounter++;
						return;
					}

					if (descendingCounter > 0) {
						teamID = SqlQuery.teams.get(teamIDQry.getSelectedIndex());
						System.out.println("Testing Descending Branch");

						results = statement.executeQuery(SqlQuery.TeamAgeAscending(teamID));

						clearTable(queryTextArea);
						populateQueryTable(queryTextArea, results);

						break;
					}
				}

			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Drops previous Tables that may have already been altered, and fills them
	 * again with default data.
	 * 
	 * @param statement
	 * @throws SQLException
	 */
	private static void dropCreateFillTables(Statement statement) throws SQLException {
		statement.execute(SqlStatement.dropTablePlayers);

		statement.execute(SqlStatement.createTablePlayers);
		statement.execute(SqlStatement.fillTablePlayersBulls);
		statement.execute(SqlStatement.fillTablePlayersWarriors);
		statement.execute(SqlStatement.fillTablePlayersJazz);
		statement.execute(SqlStatement.fillTablePlayersCeltics);
		statement.execute(SqlStatement.fillTablePlayersHeat);

		statement.execute(SqlStatement.dropTableTeams);
		statement.execute(SqlStatement.createTableTeams);
		statement.execute(SqlStatement.fillTableTeams);
	}

	/**
	 * Fills a list with the current data available in the teams table
	 * 
	 * @param results
	 * @return
	 * @throws SQLException
	 */
	protected List<String> getListTeams(ResultSet results) throws SQLException {
		ResultSetMetaData metadata = results.getMetaData();
		try {
			while (results.next()) {
				for (int i = 1; i <= metadata.getColumnCount(); i++)
					teams.add(results.getObject(i).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teams;
	}

	/**
	 * clears the table that is passed for new data entries
	 * 
	 * @param t
	 */
	private void clearTable(JTable t) {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 8; j++) {
				t.setValueAt("", i, j);
			}
		}
	}

	/**
	 * will populate the table with data from the teams table on the database stored
	 * in the teams list
	 * 
	 * @param t
	 */
	private void populateTeamTable(JTable t) {
		try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB1;create=true");
				Statement statement = connection.createStatement()) {
			results = statement.executeQuery(SqlQuery.getAllTeams);
			ResultSetMetaData metadata = results.getMetaData();
			List<String> temp = getListTeams(results);

			for (int i = 0; i < metadata.getColumnCount(); i++) {
				t.getColumnModel().getColumn(i).setHeaderValue(metadata.getColumnName(i + 1));
			}
			for (int i = metadata.getColumnCount(); i < t.getColumnCount(); i++) {
				t.getColumnModel().getColumn(i).setHeaderValue("");
			}
			t.getTableHeader().repaint();

			int count = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < metadata.getColumnCount(); j++) {
					if (count < temp.size()) {
						t.setValueAt(temp.get(count), i, j);
						count++;
					} else if (count >= temp.size()) {
						t.setValueAt(" ", i, j);
					}
				}
				t.repaint();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fills a list with the current data available in the players table
	 * 
	 * @param results
	 * @return
	 */
	protected List<String> getListPlayers(ResultSet results) {
		try {
			while (results.next()) {
				for (int i = 1; i <= 8; i++)
					players.add(results.getObject(i).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return players;
	}

	/**
	 * Adds entries into the Jtable with values stored in the players list, pulled
	 * from the database
	 * 
	 * @param t
	 */
	private void populatePlayerTable(JTable t) {
		try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB1;create=true");
				Statement statement = connection.createStatement()) {
			results = statement.executeQuery(SqlQuery.getAllPlayers);
			ResultSetMetaData metadata = results.getMetaData();
			List<String> temp = getListPlayers(results);

			for (int i = 0; i < metadata.getColumnCount(); i++) {
				t.getColumnModel().getColumn(i).setHeaderValue(metadata.getColumnName(i + 1));
			}
			t.getTableHeader().repaint();

			int count = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j <= 7; j++) {
					if (count < temp.size()) {
						t.setValueAt(temp.get(count), i, j);
						count++;
					} else if (count >= temp.size()) {
						t.setValueAt(" ", i, j);
					}
				}
				t.repaint();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	private void changePlayerTable(JTable t, String change) {
//		try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB1;create=true");
//				Statement statement = connection.createStatement()) {
//				statement.executeQuery(change);
//				//populatePlayerTable(t);	
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Gets all players and player information currently in database
	 * 
	 * @param results
	 * @return
	 */
	protected List<String> getListQueries(ResultSet results) throws SQLException {
		ResultSetMetaData metadata = results.getMetaData();
		try {
			while (results.next()) {
				for (int i = 1; i <= metadata.getColumnCount(); i++)
					queries.add(results.getObject(i).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return queries;
	}

	/**
	 * Adds entries into the Jtable with results pulled from the database and stored
	 * in the list queries
	 * 
	 * @param t
	 * @param results
	 * @throws SQLException
	 */
	private void populateQueryTable(JTable t, ResultSet results) throws SQLException {
		queries.clear();
		ResultSetMetaData metadata = results.getMetaData();
		List<String> temp = getListQueries(results);

		for (int i = 0; i < metadata.getColumnCount(); i++) {
			t.getColumnModel().getColumn(i).setHeaderValue(metadata.getColumnName(i + 1));
		}
		for (int i = metadata.getColumnCount(); i < t.getColumnCount(); i++) {
			t.getColumnModel().getColumn(i).setHeaderValue("");
		}
		t.getTableHeader().repaint();

		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < metadata.getColumnCount(); j++) {
				if (count < temp.size()) {
					t.setValueAt(temp.get(count), i, j);
					count++;
				} else if (count >= temp.size()) {
					t.setValueAt(" ", i, j);
				}
			}
			t.repaint();
		}

	}

}
