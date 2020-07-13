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
 * @author tresor
 * @params host : String : hote hebergent la BDD
 * @params user : String : utilisateur
 * @params passwd : String : mot de passe
 *
 */
public class Serveur {
	int id;
	String mot;
	String signification;
	String indice;
	
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
	      this.id= resultSet.getInt("id");
	      this.mot = resultSet.getString("mot");
	      this.signification = resultSet.getString("signification");
	     this.indice = resultSet.getString("indice");
	      System.out.println("indice: " + this.id);
	      System.out.println("mot: " + this.mot);
	      System.out.println("signification: " + this.signification);
	      System.out.println("indice: " + this.indice);
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
	
	



