package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class will be used to test SqlStatment class and SqlQuery class, before
 * transferring them into GUI Class.
 * 
 * @author Pat Hurley & Christopher Munoz
 *
 */
public class Demo {
	static String[] positions = {"Point Guard", "Center", "Small Forward", "Power Forward", "Shooting Guard"};
	static int[] teams = {100,101,102,103}; // (100 - Bulls) (101 - Warriors) (102 - Jazz) (103 - Celtics)
	private static ResultSet results;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:derby:myBasketBallDB;create=true");
				Statement statement = connection.createStatement()) {
			
			dropCreateFillTables(statement);
			
			getAllPlayers(statement);
			
			getAllTeams(statement);
			
			System.out.println("All that play a given Position from a given team");
			results = statement.executeQuery(SqlQuery.positionFromTeam(positions[4], teams[0]));
			printResults(results);
			
			System.out.println("All MVP's");
			results = statement.executeQuery(SqlQuery.mvp());
			printResults(results);
			
			System.out.println("All Players between 30 - 35 from the Jazz");
			results = statement.executeQuery(SqlQuery.getAllAgeFromTeam(30, 35, teams[2]));
			printResults(results);
			
			System.out.println("Teams with MVP and Championship wins");
			results = statement.executeQuery(SqlQuery.ChampAndMVP());
			printResults(results);
			
			System.out.println("Bulls order by Age ascending");
			results = statement.executeQuery(SqlQuery.TeamAgeAscending(teams[0]));
			printResults(results);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void getAllTeams(Statement statement) throws SQLException {
		results = statement.executeQuery(SqlQuery.getAllTeams);
		printResults(results);
	}

	private static void getAllPlayers(Statement statement) throws SQLException {
		results = statement.executeQuery(SqlQuery.getAllPlayers);
		printResults(results);
		System.out.println();
	}

	private static void dropCreateFillTables(Statement statement) throws SQLException {
		statement.execute(SqlStatement.dropTablePlayers);
		//System.out.println("dropped");
		
		statement.execute(SqlStatement.createTablePlayers);
		System.out.println("created");
		
		statement.execute(SqlStatement.fillTablePlayersBulls);
		statement.execute(SqlStatement.fillTablePlayersWarriors);
		statement.execute(SqlStatement.fillTablePlayersJazz);
		statement.execute(SqlStatement.fillTablePlayersCeltics);
		statement.execute(SqlStatement.fillTablePlayersHeat);
		
		
		
		statement.execute(SqlStatement.dropTableTeams);
		statement.execute(SqlStatement.createTableTeams);
		statement.execute(SqlStatement.fillTableTeams);
		System.out.println("Filled");
	}
	

	private static void printResults(ResultSet results) throws SQLException {
		ResultSetMetaData metadata = results.getMetaData();
		for (int i = 1; i <= metadata.getColumnCount(); i++) {
			System.out.printf("%-15s ", metadata.getColumnName(i));
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------------------"
				+ "-------------------------------------------");
		while (results.next()) {
			for (int i = 1; i <= metadata.getColumnCount(); i++) {
				System.out.printf("%-15s ", results.getObject(i) + " ");
			}
			System.out.println();

		}

		System.out.println();
		System.out.println("Done printing.");
		System.out.println();
	}

}
