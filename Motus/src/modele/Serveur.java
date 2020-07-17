/**
 *  @author tresor
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * @author tresor
 * @params host : String : hote hebergent la BDD
 * @params user : String : utilisateur
 * @params passwd : String : mot de passe
 * @params Lib : HashMap : association mot et indice
 * @params Lib2 : HashMAP : association mot et definition
 */
public class Serveur {
	int id;
	String mot;
	String signification;
	String indice;

	public HashMap<String, String> getLib() {
		return lib;
	}

	public void setLib(HashMap<String, String> lib) {
		this.lib = lib;
	}

	public HashMap<String, String> getLib2() {
		return lib2;
	}

	public void setLib2(HashMap<String, String> lib2) {
		this.lib2 = lib2;
	}

	HashMap<String, String> lib = new HashMap<String, String>();
	HashMap<String, String> lib2 = new HashMap<String, String>();

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	final private String host = "jdbc:mysql://localhost";
	final private String user = "root";
	final private String passwd = "85550";

	public void readDataBase() throws Exception {
		try {
			// Connexion a la BDD
			connect = DriverManager.getConnection(host, user, passwd);

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
	 * @throws SQLException Cette methode va nous permettre de parcourire et
	 *                      afficher les resultats de notre requette
	 */

	private void writeResultSet(ResultSet resultSet) throws SQLException {

		while (resultSet.next()) {
			this.id = resultSet.getInt("id");
			this.mot = resultSet.getString("mot");
			this.signification = resultSet.getString("signification");
			this.indice = resultSet.getString("indice");

			lib.put(this.mot, this.indice);
			lib2.put(this.mot, this.signification);
			
		

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
