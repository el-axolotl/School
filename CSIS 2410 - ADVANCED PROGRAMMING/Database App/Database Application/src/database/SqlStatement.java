package database;

/**
 * Class SqlStatement provides sql statements that create tables, fill tables, or drop tables.
 * All sql statements in this class are going to be arguments for the method execute.
 * e.g. statement.execute(SqlStatement.createTableBooks);
 * @author Pat Hurley & Christopher Munoz 
 *
 */
public class SqlStatement {
	// this is a test
	
	/* = = = Players = = = */
	public static String createTablePlayers =
			"CREATE TABLE Players ("
			+ "PlayerID int not null primary key "
			+ "GENERATED ALWAYS AS IDENTITY "
			+ "(START WITH 1, INCREMENT BY 1), "
			+ "FirstName varchar(255),"
			+ "LastName varchar(255),"
			+ "Position varchar(255),"
			+ "Age int,"
			+ "Height varchar(255),"
			+ "MVP varchar(255),"		// I used this for MVP because boolean is returned as 1 or 0
			+ "TeamID int)";
	
			
	
	public static String fillTablePlayersBulls = 
			"INSERT INTO Players ( FirstName, LastName, Position, Age, Height, MVP, TeamID) VALUES"  
					+ " ('Rawle', 'Alkins', 'Shooting Guard', 21 , '6'' 5' , 'False', 100),"  
					+ " ('Ryan', 'Arcidiacono', 'Point Guard', 24, '6'' 3', 'False', 100),"  
					+ " ('Antonio', 'Blakeney', 'Shooting Guard', 22, '6'' 4', 'False', 100),"
					+ " ('Wendell', 'Carter Jr', 'Center', 19, '6'' 10', 'False', 100),"
					+ " ('Kris', 'Dunn', 'Point Guard', 24, '6'' 4', 'False', 100),"
					+ " ('Cristiano', 'Felicio', 'Power Forward', 26, '6'' 10', 'False', 100),"
					+ " ('Shaquille', 'Harrison', 'Point Guard', 25, '6'' 4', 'False', 100),"
					+ " ('Chandler', 'Hutchison', 'Small Forward', 22, '6'' 7', 'False', 100),"
					+ " ('Zach', 'LaVine', 'Point Guard', 23, '6'' 5', 'False', 100),"
					+ " ('Robin', 'Lopez', 'Center', 30, '7''', 'False', 100),"
					+ " ('Timothe', 'L-Cabarrot', 'Shooting Guard', 23, '6'' 6', 'False', 100),"
					+ " ('Lauri', 'Markkanen', 'Power Forward', 21, '7''', 'False', 100),"
					+ " ('Jabari', 'Parker', 'Power Forward', 23, '6'' 8', 'False', 100),"
					+ " ('Bobby', 'Portis', 'Power Forward', 23, '6'' 11', 'False', 100),"
					+ " ('Brandon', 'Sampson', 'Shooting Guard', 21, '6'' 5', 'False', 100),"
					+ " ('Wayne', 'Selden', 'Shooting Guard', 24, '6'' 5', 'False', 100),"
					+ " ('Denzel', 'Valentine', 'Shooting Guard', 30, '6'' 6', 'False', 100)";
	
	public static String fillTablePlayersWarriors = 
			"INSERT INTO Players ( FirstName, LastName, Position, Age, Height, MVP, TeamID) VALUES"  
					+ " ('Jordan', 'Bell', 'Power Forward', 24 , '6'' 9' , 'False', 101),"  
					+ " ('Quinn', 'Cook', 'Point Guard', 25 , '6'' 2' , 'False', 101),"
					+ " ('DeMarcus', 'Cousins', 'Center', 28 , '6'' 11' , 'False', 101),"
					+ " ('Stephen', 'Curry', 'Point Guard', 30 , '6'' 3' , 'True', 101),"
					+ " ('Marcus', 'Derrickson', 'Forward', 23 , '6'' 7' , 'False', 101),"
					+ " ('Kevin', 'Durant', 'Small Forward', 30 , '6'' 9' , 'True', 101),"
					+ " ('Jacob', 'Evans', 'Shooting Guard', 21 , '6'' 6' , 'False', 101),"
					+ " ('Draymond', 'Green', 'Power Forward', 28 , '6'' 7' , 'False', 101),"
					+ " ('Andre', 'Iguodala', 'Shooting Guard', 35 , '6'' 6' , 'False', 101),"
					+ " ('Jonas', 'Jerebko', 'Power Forward', 31 , '6'' 10' , 'False', 101),"
					+ " ('Damian', 'Jones', 'Center', 23 , '7''' , 'False', 101),"
					+ " ('Damion', 'Lee', 'Shooting Guard', 23 , '6'' 6' , 'False', 101),"
					+ " ('Shaun', 'Livingston', 'Point Guard', 33 , '6'' 7' , 'False', 101),"
					+ " ('Kevin', 'Looney', 'Center', 22 , '6'' 9' , 'False', 101),"
					+ " ('Alfonzo', 'McKinnie', 'Small Forward', 26 , '6'' 8' , 'False', 101),"
					+ " ('Klay', 'Thompson', 'Shooting Guard', 28 , '6'' 7' , 'False', 101)";
	
	public static String fillTablePlayersJazz = 
			"INSERT INTO Players ( FirstName, LastName, Position, Age, Height, MVP, TeamID) VALUES"  
					+ " ('Grayson', 'Allen', 'Shooting Guard', 23 , '6'' 5' , 'False', 102),"
					+ " ('Tony', 'Bradley', 'Center', 21 , '6'' 10' , 'False', 102),"
					+ " ('Tyler', 'Cavanaugh', 'Power Forward', 24 , '6'' 9' , 'False', 102),"
					+ " ('Jae', 'Crowder', 'Power Forward', 28 , '6'' 6' , 'False', 102),"
					+ " ('Dante', 'Exum', 'Point Guard', 23 , '6'' 6' , 'False', 102),"
					+ " ('Derrick', 'Favors', 'Power Forward', 27 , '6'' 10' , 'False', 102),"
					+ " ('Rudy', 'Gobert', 'Center', 26 , '7'' 1' , 'False', 102),"
					+ " ('Joe', 'Ingles', 'Small Forward', 31 , '6'' 8' , 'False', 102),"
					+ " ('Kyle', 'Korver', 'Shooting Guard', 37 , '6'' 7' , 'False', 102),"
					+ " ('Donovan', 'Mitchell', 'Shooting Guard', 22 , '6'' 3' , 'False', 102),"
					+ " ('Naz', 'Mitrou-Long', 'Shooting Guard', 25 , '6'' 4' , 'False', 102),"
					+ " ('Raul', 'Neto', 'Point Guard', 26 , '6'' 1' , 'False', 102),"
					+ " ('Georges', 'Niang', 'Small Forward', 25 , '6'' 8' , 'False', 102),"
					+ " ('Royce', 'O''Neale', 'Small Forward', 25 , '6'' 6' , 'False', 102),"
					+ " ('Ricky', 'Rubio', 'Point Guard', 28 , '6'' 4' , 'False', 102),"
					+ " ('Thabo', 'Sefolosha', 'Small Forward', 34 , '6'' 7' , 'False', 102),"
					+ " ('Ekpe', 'Udoh', 'Center', 31 , '6'' 10' , 'False', 102)";
	
	public static String fillTablePlayersCeltics = 
			"INSERT INTO Players ( FirstName, LastName, Position, Age, Height, MVP, TeamID) VALUES"
					+ " ('Aron', 'Baynes', 'Center', 32 , '6'' 10' , 'False', 103),"
					+ " ('Jabari', 'Bird', 'Shooting Guard', 24 , '6'' 6' , 'False', 103),"
					+ " ('Jaylen', 'Brown', 'Shooting Guard', 22 , '6'' 7' , 'False', 103),"
					+ " ('PJ', 'Dozier', 'Point Guard', 22 , '6'' 6' , 'False', 103),"
					+ " ('Gordon', 'Hayward', 'Small Forward', 28 , '6'' 8' , 'False', 103),"
					+ " ('Al', 'Horford', 'Center', 32 , '6'' 10' , 'False', 103),"
					+ " ('RJ', 'Hunter', 'Shooting Guard', 25 , '6'' 5' , 'False', 103),"
					+ " ('Kyrie', 'Irving', 'Point Guard', 26 , '6'' 3' , 'False', 103),"
					+ " ('Marcus', 'Morris', 'Power Forward', 29 , '6'' 9' , 'False', 103),"
					+ " ('Semi', 'Ojeleye', 'Power Forward', 24 , '6'' 7' , 'False', 103),"
					+ " ('Terry', 'Rozier', 'Point Guard', 24 , '6'' 1' , 'False', 103),"
					+ " ('Marcus', 'Smart', 'Point Guard', 24 , '6'' 4' , 'False', 103),"
					+ " ('Jayson', 'Tatum', 'Small Forward', 20 , '6'' 8' , 'False', 103),"
					+ " ('Daniel', 'Theis', 'Power Forward', 26 , '6'' 8' , 'False', 103),"
					+ " ('Brad', 'Wanamaker', 'Point Guard', 29 , '6'' 4' , 'False', 103),"
					+ " ('Robert', 'Williams', 'Center', 21 , '6'' 10' , 'False', 103),"
					+ " ('Guerschon', 'Yabusele', 'Power Forward', 23 , '6'' 8' , 'False', 103)";
	
	public static String fillTablePlayersHeat = 
			"INSERT INTO Players ( FirstName, LastName, Position, Age, Height, MVP, TeamID) VALUES"
					+ " ('Bam', 'Adebayo', 'Center', 21 , '6'' 10' , 'False', 104),"
					+ " ('Ryan', 'Anderson', 'Power Forward', 30 , '6'' 10' , 'False', 104),"
					+ " ('Goran', 'Dragic', 'Point Guard', 32 , '6'' 3' , 'False', 104),"
					+ " ('Udonis', 'Haslem', 'Power Forward', 38 , '6'' 8' , 'False', 104),"
					+ " ('James', 'Johnson', 'Power Forward', 31 , '6'' 8' , 'False', 104),"
					+ " ('Derrick', 'Jones Jr', 'Small Forward', 21 , '6'' 7' , 'False', 104),"
					+ " ('Yante', 'Maten', 'Power Forward', 22 , '6'' 8' , 'False', 104),"
					+ " ('Rodney', 'McGruder', 'Small Forward', 27 , '6''4' , 'False', 104),"
					+ " ('Kelly', 'Olynyk', 'Power Forward', 27 , '7''' , 'False', 104),"
					+ " ('Josh', 'Richardson', 'Shooting Guard', 25 , '6'' 6' , 'False', 104),"
					+ " ('Duncan', 'Robinson', 'Small Forward', 24 , '6'' 8' , 'False', 104),"
					+ " ('Dwayne', 'Wade', 'Shooting Guard', 37 , '6'' 4' , 'False', 104),"
					+ " ('Dion', 'Waiters', 'Shooting Guard', 27 , '6'' 4' , 'False', 104),"
					+ " ('Hassan', 'Whiteside', 'Center', 29 , '7''' , 'False', 104),"
					+ " ('Justise', 'Winslow', 'Small Forward', 22 , '6'' 7' , 'False', 104)";
	
	public static String dropTablePlayers =
			"DROP TABLE Players";
	
	
	/* = = = Teams = = = */
	
	
	public static String createTableTeams = 
			"CREATE TABLE Teams ("
			+ "TeamID int not null primary key "
			+ "GENERATED ALWAYS AS IDENTITY "
			+ "(START WITH 100, INCREMENT BY 1), "
			+ "Name varchar(255),"
			+ "City varchar(255),"
			+ "ChampsWon int)";
	
	public static String fillTableTeams =
			"INSERT INTO Teams (Name, City, ChampsWon) VALUES"
			+ " ('Bulls', 'Chicago', 6),"			// TeamID 100
			+ " ('Warriors', 'Oakland',6),"			// TeamID 101
			+ " ('Jazz', 'Salt Lake City',0),"		// TeamID 102
			+ " ('Celtics', 'Boston',17),"			// TeamID 103
			+ " ('Heat', 'Miami', 3) ";				// TeamID 104
	
	public static String dropTableTeams =
			"DROP TABLE Teams";
=======
 * e.g. statement.execute(SqlStatment.createTableBooks);
 * @author Pat Hurley & Christopher Munoz
 *
 */
public class SqlStatement {
}
