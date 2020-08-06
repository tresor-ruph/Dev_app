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
	Thread ri;

	public Console(Partie model, Controleur control) {
		super(model, control);
		sc = new Scanner(System.in);
		System.out.println("*****************Bienvenue dans cette partie de motus*******************");
		System.out.println();
		System.out.println();

		model.setWord();
		this.afficher();
		ReadInput readIn = new ReadInput();
		ri = new Thread(readIn);
		ri.start();
	}

	public void afficher() {

		System.out.println("veuillez entrer le mot");

		model.setIndex(0, model.getMot().charAt(0));
		System.out.print("nombre de tentative restante =" + Partie.chance);
		System.out.println("                                                " + Partie.total + "/" + Partie.end);

		System.out.println();
		System.out.print(Partie.index[0]);
		for (int i = 1; i < model.getMot().length(); i++) {

			if ((Partie.index[i] >= 'a') || (Partie.index[i] >= 'A')) {
				System.out.print(" " + Partie.index[i]);
			} else {

				System.out.print(" _ ");
			}
		}
		System.out.println();
		System.out.println();

	}

	private class ReadInput implements Runnable {
		public void run() {
			try {

				String inputString = sc.nextLine();

				if (inputString.length() > model.getMot().length()) {
					System.out.println("le mot  entre contient plus de character que le mot a definer");
					System.out.println();

				} else if (inputString.length() < model.getMot().length()) {
					System.out.println("le mot  entre contient moin de character que le mot a definer");
					System.out.println();

				} else {
					control.setString(inputString);
				}
			} catch (Exception e) {
				System.out.println();
			}
			System.out.println("stop");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

		if (model.getMess() == "reussi") {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Mot suivant");
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (model.getMess() == "echouer") {

			System.out.println("le mot a trouver etait " + model.getMot());
			control.setWordcnt();
			System.out.println("mot suivant");
			System.out.println();
		} else if ((model.getMess() == "termine") && (Partie.success == Partie.end)) {
			System.out.println("BRAVO VOUS AVEZ TROUVE TOUT LES MOTS");
		} else if ((model.getMess() == "termine") && (Partie.success != Partie.end)) {
			System.out.println("VOUS AVEZ TROUVE " + Partie.success + " mot(s) sur " + Partie.end);
		} else if (model.isTimerUp()) {
			System.out.println("Time UP");
			System.out.println("le mot a trouver etait " + model.getMot());
			control.setWordcnt();
			System.out.println("mot suivant");
			System.out.println();
		}
		this.afficher();

		if (ri.isAlive() == false) {
			if (model.getMess() == "termine") {

			} else {
				new Thread(new ReadInput()).start();
			}
		}

	}

}
