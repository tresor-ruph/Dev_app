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
@SuppressWarnings("deprecation")
public class Console extends Vue implements Observer {

	protected Scanner sc;

	public Console(Partie model, Controleur control) {
		super(model, control);
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

		while (model.getMess() != "termine") {
			model.setIndex(0, model.getMot().charAt(0));
			System.out.print("nombre de tentative restante =" + Partie.chance);
			System.out.println("                                                " + Partie.total + "/" + Partie.end);

			System.out.println();
			System.out.print(model.index[0]);
			for (int i = 1; i < model.getMot().length(); i++) {

				if ((model.index[i] >= 'a') || (model.index[i] >= 'A')) {
					System.out.print(" " + model.index[i]);
				} else {

					System.out.print(" _ ");
				}
			}
			System.out.println();
			// control.setChance();
			String inputString = sc.nextLine();
			if (inputString.length() > model.getMot().length()) {
				System.out.println("le mot a entre contient plus de character que le mot a definer");
				System.out.println();

			} else if (inputString.length() < model.getMot().length()) {
				System.out.println("le mot a entre contient moin de character que le mot a definer");
				System.out.println();

			} else {
				control.setString(inputString);
			}
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

		if (model.getMess() == "reussi") {
			System.out.println("reussi");
		} else if (model.getMess() == "echouer") {

			System.out.println("le mot a trouver etait " + model.getMot());
			control.setWordcnt();
			System.out.println("mot suivant");
			System.out.println();
		} else if ((model.getMess() == "termine") && (Partie.success == Partie.end)) {
			System.out.println("BRAVO VOUS AVEZ TROUVE TOUT LES MOTS");
		} else if ((model.getMess() == "termine") && (Partie.success != Partie.end)) {
			System.out.println("VOUS AVEZ TROUVE " + Partie.success + " mot(s) sur " + Partie.end);
		}
	}

}
