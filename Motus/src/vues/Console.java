package vues;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import modele.Partie;
import controleurs.Controleur;


/**
 * @author treso
 * @param sc : Scanner : Objet permettant d'entrer des données
 *
 */
public class Console extends Vue implements Observer{
	
	protected Scanner sc;
	
	public Console(Partie model, Controleur control) {
		super(model , control);
		sc = new Scanner(System.in);
		
	}
	
	public void afficher() {
		System.out.println("Bienvenue dans cette partie de motus");
	}
	


@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
}

}
