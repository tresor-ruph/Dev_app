/**
 * 
 */
package Main;

import controleurs.Controleur;
import modele.Partie;
import vues.Console;
import vues.Gui;

public class Main { 
 
	/**
	 * @param args
	 */ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Partie model = new Partie();
		
	
		
		Controleur controllConsole = new Controleur(model);
		Gui vueGraphique = new Gui(model, controllConsole);
		Console vueConsole = new Console(model, controllConsole);

		 
	}
	

}
