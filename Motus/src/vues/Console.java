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
		model.setWord();
		this.afficher();
	}
	
	public void afficher() {
		System.out.println("*****************Bienvenue dans cette partie de motus*******************");
		System.out.println();
		System.out.println();
		
		System.out.println("veuillez entrer le mot");
		System.out.println();

		while(model.getMess() != "termine") {
		model.setIndex(0, model.getMot().charAt(0));
		System.out.println("nombre de tentative restante ="+model.chance);
		System.out.println();
		System.out.print(model.index[0]);
		for(int i=1; i < model.getMot().length();i++) {

			if((model.index[i] >= 'a')||(model.index[i] >= 'A')) {
				System.out.print(" "+model.index[i]);
			}else {	
				
			System.out.print(" _ ");
		}
		}
		System.out.println();
		//control.setChance();
		String inputString = sc.nextLine();
		control.setString(inputString);
		
		}
		
	}
	



@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
	if(model.getMess() == "reussi") {
		System.out.println("reussi");
	}else if(model.getMess() == "echouer") {

		System.out.println("le mot a trouver etait "+ model.getMot());
		control.setWordcnt();
		System.out.println("mot suivant");
		System.out.println();
	}
}


}
