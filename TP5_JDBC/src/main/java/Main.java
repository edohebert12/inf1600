import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import model.Departement;
//import model.Article;
//import model.Chercheur;
//import model.Equipe;


public class Main {
	private static void showWholeLine(ResultSet results) {
		try {
			ResultSetMetaData metadata =  results.getMetaData();
			Integer nColumn = metadata.getColumnCount();
			while (results.next()) { 
				for(int i = 1; i <= nColumn; ++i) {
					System.out.print(results.getString(i) + ", ");			
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
	private static void displayTable(Statement stmt, String tableName) throws SQLException {
		ResultSet results = stmt.executeQuery("select * from " + tableName);
		showWholeLine(results);
		return;
	}
	
	private static void q4(Statement stmt) throws SQLException {
		ResultSet authors = stmt.executeQuery("SELECT * FROM CHERCHEUR");
		ArrayList<String> nms = new ArrayList<String>();
		
		while(authors.next()) {
			nms.add(authors.getString("matricule"));
		}
		
		for (String nm : nms) {
			System.out.println("Auteur " + nm + ": ");
			showWholeLine(stmt.executeQuery("SELECT * FROM ARTICLE WHERE auteur LIKE '" + nm + "'"));
		}
	}
	
	private static void q8(Statement stmt) throws SQLException {
		ResultSet matricules = stmt.executeQuery("SELECT * FROM CHERCHEUR WHERE equipe IN (select nom from equipe where departement = 'Mathematiques')");
		ArrayList<String> mts = new ArrayList<String>();
		while(matricules.next()) {
			mts.add(matricules.getString("matricule"));
		}
		for (String mt : mts) {
			stmt.executeUpdate("UPDATE CHERCHEUR SET position = 'postdoc' WHERE matricule LIKE '" + mt + "'");
		}
	} 
	
	public static void main(String[] args) {
		try {
			Connection connexion = DriverManager.getConnection(
					"jdbc:postgresql://192.168.242.136:5432/TP5", 
					"postgres", 
					"sanic");
			Statement stmt = connexion.createStatement();
			System.out.println("QUESTION 1");
		    showWholeLine(stmt.executeQuery("SELECT * from departement where nom = 'Informatique'"));
		    
			System.out.println("\nQUESTION 2");
			displayTable(stmt, "departement");
			
			System.out.println("\nQUESTION 3");
		    showWholeLine(stmt.executeQuery("SELECT * from chercheur"));
		    
		    System.out.println("\nQUESTION 4");
		    q4(stmt);
		    
		    System.out.println("\nQUESTION 5");
		    showWholeLine(stmt.executeQuery("SELECT * FROM ARTICLE WHERE auteur LIKE 'M22556'"));
		    
		    System.out.println("\nQUESTION 6");
		    stmt.executeUpdate("DELETE FROM ARTICLE WHERE departement LIKE 'Mathematiques'");
		    
		    System.out.println("\nQUESTION 7");
		    ResultSet article = stmt.executeQuery("SELECT * FROM ARTICLE WHERE DATE(soumisLe) = '2007-05-16'");
		    if (article.next())
		    	stmt.executeUpdate("DELETE FROM CHERCHEUR WHERE matricule LIKE '" + article.getString("auteur") + "'");
		    
		    System.out.println("\nQUESTION 8");
		    stmt.executeUpdate("UPDATE DEPARTEMENT SET adresse = 'Quebec' WHERE nom = 'Physique'");
		    
		    System.out.println("\nQUESTION 9");
		    q8(stmt);
		    
		    System.out.println("\nQUESTION 10");
		    try {
				stmt.executeUpdate("INSERT INTO Departement VALUES ('Medecine', TO_DATE('01-03-2018','DD:MM:YYYY'), 'Gaspesie', '450-254-6011')");
			} catch (Exception e) {
				System.out.println("Department already exists");
			}
		    
		    System.out.println("\nQUESTION 11");
		    stmt.executeUpdate("INSERT INTO EQUIPE VALUES ('Pediatre', TO_DATE('12-05-1985','DD:MM:YYYY'), 'Medecine', 'Gaetan Barrette', 0)");
		    

			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
