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
	
	public Controleur(Partie model) {
		this.model = model;
	}
	
	
}
