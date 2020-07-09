/**
 *  @author tresor
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author treso
 * @params host : String : hote hebergent la BDD
 * @params user : String : utilisateur
 * @params passwd : String : mot de passe
 *
 */
public class Serveur {
	
	  private Connection connect = null;
	  private Statement statement = null;
	  private ResultSet resultSet = null;

	  final private String host = "jdbc:mysql://localhost";
	  final private String user = "root";
	  final private String passwd = "85550";
	  
	  public void readDataBase() throws Exception {
	    try {
	      // Connexion a la BDD
	      connect = DriverManager.getConnection(host,user,passwd);

	      // Permet d'effectuer des requettes sur la BDD
	      statement = connect.createStatement();
	      statement.executeQuery("use motus");
	      // ResultSet recupère les resultats de la requette
	      resultSet = statement.executeQuery("select * from dictionary");
	      writeResultSet(resultSet);
	      
	    } catch (Exception e) {
	      throw e;
	    } finally {
	      close();
	    }

	  }
	  
	  /**
	 * @param resultSet
	 * @throws SQLException
	 * Cette methode va nous permettre de parcourire et afficher les resultats de notre requette
	 */
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		  
	    while (resultSet.next()) {
	      int id = resultSet.getInt("id");
	      String mot = resultSet.getString("mot");
	      String signification = resultSet.getString("signification");
	      String indice = resultSet.getString("indice");
	      System.out.println("indice: " + id);
	      System.out.println("mot: " + mot);
	      System.out.println("signification: " + signification);
	      System.out.println("indice: " + indice);
	    }
	  }

	  
	  private void close() {
	    try {
	      if (resultSet != null) {
	        resultSet.close();
	      }

	      if (statement != null) {
	        statement.close();
	      }

	      if (connect != null) {
	        connect.close();
	      }
	    } catch (Exception e) {

	    }
	  }
	
	  public static void main(String[] args) throws Exception {
		    Serveur BDD = new Serveur();
		    BDD.readDataBase();
		  }
}
	
	



