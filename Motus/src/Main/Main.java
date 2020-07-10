/**
 * 
 */
package Main;

/**
 * @author tresor
 *
 */

import modele.Partie;
import controleurs.Controleur;
import vues.Console;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Partie model = new Partie();
		Controleur controllConsole = new Controleur(model);
		Console vueConsole = new Console(model, controllConsole);
	}
	

}
