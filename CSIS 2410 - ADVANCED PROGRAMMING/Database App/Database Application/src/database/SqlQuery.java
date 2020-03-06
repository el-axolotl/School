package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class SqlQuery provides sql statements that query data from one or more
 * database tables. All sql statements in this class are going to be arguments
 * for the method executeQuery. e.g.
 * statement.executeQuery(SqlQuery.getAllPersons);
 * 
 * @author Pat Hurley & Christopher Munoz
 *
 */
public class SqlQuery {
	static String[] positions = { "Point Guard", "Center", "Small Forward", "Power Forward", "Shooting Guard" };
	static String[] add = { "Player", "Team" };
	static String[] age = { "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32",
			"33", "34", "35", "36", "37", "38", "39", "40" };
	static String[] champs = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
	// for display in JCombo box
	static String[] heights = { "5' 11\"", "6'", "6' 1\"", "6' 2\"", "6' 3\"", "6' 4\"", "6' 5\"", "6' 6\"", "6' 7\"", "6' 8\"",
			"6' 9\"", "6' 10\"", "6' 11\"", "7' ", "7' 1\"", "7' 2\"", "7' 3\"", "7' 4\"", "7' 5\"", "7' 6\"", "7' 7\"", "7' 8\"",
			"7' 9\"", "7' 10\"", "7' 11\"" };
	// for the sql query format
	static String[] height = { "5'' 11", "6''", "6'' 1", "6'' 2", "6'' 3", "6'' 4", "6'' 5", "6'' 6", "6'' 7", "6'' 8",
			"6'' 9", "6'' 10", "6'' 11", "7'' ", "7'' 1", "7'' 2", "7'' 3", "7'' 4", "7'' 5", "7'' 6", "7'' 7", "7'' 8",
			"7'' 9", "7'' 10", "7'' 11" };
	// using a list so that users can add team, and still use the drop down box
	
	static ArrayList<String> teamString = new ArrayList<>();  //{ "Bulls", "Warriors", "Jazz", "Celtics", "Heat" };
	
	static ArrayList<Integer> teams = new ArrayList<>();  // (100 - Bulls) (101 - Warriors) (102 - Jazz) (103 - Celtics) (104 - Heat)
	
	static String[] queryNames = {"Position From Team", "MVPs", "Age From Team", "Champ And MVP", "Team Age Ascending"};


	public static String[] getPositions() {
		return positions;
	}
	
	/**
	 * Initializes the teams to the 
	 * two corrosponding teams lists
	 */
	public static void addTeams() {
		teamString.add("Bulls");
		teamString.add("Warriors");
		teamString.add("Jazz");
		teamString.add("Celtics");
		teamString.add("Heat");
		teams.add(100);
		teams.add(101);
		teams.add(102);
		teams.add(103);
		teams.add(104);
	}
	
	/**
	 * Adds a team in string format
	 * to then be added to the drop down
	 * box for a new players team selection
	 * @param t
	 */
	public void addTeam(String t) {
		teamString.add(t);
	}
	
	/**
	 * Adds the teams unique id
	 * to the list
	 */
	public void addTeamInt() {
		teams.add(teams.get(teams.size()-1)+1);
	}
	
	public void removeTeamfromList(int team) {
		for(int i = 0; i < teams.size(); i++) {
			if(team == teams.get(i)) {
				teams.remove(i);
				teamString.remove(i);
			}
		}
	}

	/**
	 * Selects All Players
	 */
	public static String getAllPlayers = "SELECT * FROM Players";

	/**
	 * Selects All Teams
	 */
	public static String getAllTeams = "SELECT * FROM Teams";

	/**
	 * Queries all players from a passed team with that passed position
	 * 
	 */
	public static String positionFromTeam(String position, int teamID) {
		return "Select Players.FirstName, Players.LastName, Players.Position , Teams.Name " + "FROM Players "
				+ "INNER JOIN Teams ON Players.TeamID=Teams.TeamID " + "WHERE Players.Position='" + position + "'"
				+ "AND Teams.TeamID=" + teamID + "";
	}
	
	/**
	 * Changes players first and last name
	 */
	public static void changePlayerNames(int ID, String FirstName, String LastName) {
		String update = "UPDATE Players " 
						+ "Set FirstName = '" + FirstName + "', LastName = '" + LastName + "' "
						+ "WHERE PlayerID = " + ID + "";
		try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB1;create=true");
				Statement statement = connection.createStatement()) {
				statement.executeUpdate(update);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * Selects all MVP's unfortunately there were only two from all our players not
	 * so exciting
	 */
	public static String mvp() {
		return "Select FirstName, LastName " + "FROM Players " + "Where MVP='True'";
	}

	/**
	 * Selects all players between given low and high age from given team
	 * 
	 * @param low
	 * @param high
	 * @param teamID
	 * @return
	 */
	public static String getAllAgeFromTeam(int low, int high, int teamID) {
		return "Select Players.FirstName, Players.LastName, Players.Age, Teams.Name " + "From Players "
				+ "Inner JOIN Teams ON Players.TeamID=Teams.TeamID " + "WHERE Players.Age BETWEEN " + low + " AND "
				+ high + "" + "AND Teams.TeamID=" + teamID + "";
	}

	/**
	 * This tells us which team has a championship wins and MVPs
	 */
	public static String ChampAndMVP() {
		return "Select Teams.Name, Players.FirstName, Players.LastName " + "From Teams "
				+ "INNER JOIN Players ON Teams.TeamID=Players.TeamID " + "WHERE Players.MVP='True' "
				+ "AND Teams.ChampsWon > " + 0;
	}

	/**
	 * Selects all players from provided team and sorts them by age ascending
	 * 
	 * @param teamID
	 * @return
	 */
	public static String TeamAgeAscending(int teamID) {
		return "Select Players.FirstName, Players.LastName, Players.Age, Teams.Name " + "FROM Players "
				+ "INNER JOIN Teams ON Players.TeamID=Teams.TeamID " + "Where Teams.TeamID= " + teamID + " "
				+ "ORDER BY Players.Age";
	}

	/**
	 * this is to add a player param String fn, string, ln , string pos, int age
	 * @param string height, string mvp, int team
	 */
	public static void addPlayer(String fn, String ln, String pos, int age, String height, String MVP, int team) {
		try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB1;create=true");
				Statement statement = connection.createStatement()) {
			String insert = "INSERT INTO Players ( FirstName, LastName, Position, Age, Height, MVP, TeamID) VALUES"
					+ " ('" + fn + "', '" + ln + "', '" + pos + "', " + age + ", '" + height + "' , '" + MVP + "', "
					+ team + ")";

			statement.execute(insert);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
	
	/**
	 * this is to add a team to the db
	 */
	public static void addTeam(String teamName, String teamCity, int champs) {
		try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB1;create=true");
				Statement statement = connection.createStatement()) {
			String insert = "INSERT INTO Teams (Name, City, ChampsWon) VALUES"
					+ " ('"+ teamName +"', '"+ teamCity +"', "+ champs +")";

			statement.execute(insert);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Removes the player from the Players Table that matches the ID passed as the .
	 * 
	 * @param playerID
	 */
	public static void removePlayer(int playerID) {
		try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB1;create=true");
				Statement statement = connection.createStatement()) {
			String delete = "DELETE FROM Players " + " WHERE PlayerID = " + playerID;

			statement.execute(delete);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Removes the team from the Players table that matches the TeamID passed as
	 * parameter.
	 * 
	 * @param TeamID
	 */
	public static void removeTeam(int TeamID) {
		try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB1;create=true");
				Statement statement = connection.createStatement()) {
			String delete = "DELETE FROM Teams " + " WHERE TeamID = " + TeamID;
			String delete2 = "DELETE FROM Players " + " WHERE TeamID = " + TeamID;

			statement.execute(delete);
			statement.execute(delete2);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
