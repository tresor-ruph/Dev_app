/**
 * 
 */
package Main;

import controleurs.Controleur;
import modele.Partie;
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
