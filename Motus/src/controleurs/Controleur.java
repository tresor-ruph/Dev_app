/**
 * 
 */
package controleurs;
import modele.Partie;
import vues.Console;


/**
 * @author tresor
 *
 */

public class Controleur {

	private Partie model;
	private Console vueConsole = null; 
	
	/**
	 * @param model : partie
	 *
	 */
	
	public Controleur(Partie model) {
		this.model = model;
	}
	
	public void setString(String s) {
		model.setMot2(s);
	}
	public String getMessag() {
		return model.getMess();
	}
	
	
}
