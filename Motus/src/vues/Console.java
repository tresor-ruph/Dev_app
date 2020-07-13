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
		System.out.println("*****************Bienvenue dans cette partie de motus*******************");
		System.out.println();
		System.out.println();
		

		int j = 5;
		while(model.getMess() != "termine") {
		System.out.println("veuillez entrer le mot");
		System.out.print(model.getMot().charAt(0));
		for(int i=0; i < model.getLen()-1;i++) {
			System.out.print(" _ ");
		}
		System.out.println("                              nombre de tentative restante ="+j);
		System.out.println();
		String inputString = sc.nextLine();
		control.setString(inputString);
		j = --j;

		}
	}
	



@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
	System.out.println(model.getMess());
	
}


}
