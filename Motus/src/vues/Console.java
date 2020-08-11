package vues;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import modele.Partie;
import controleurs.Controleur;

/**
 * @author treso
 * @param sc : Scanner : Objet permettant d'entrer des donn�es
 *
 */
@SuppressWarnings("deprecation")
public class Console extends Vue implements Observer {

	protected Scanner sc;

	protected Scanner sc2;

	Thread ri;
	Thread niv;
	
	/**
	 * 
	 * @param model : Partie : instance de la classe Partie
	 * @param control : Controleur : instance de la classe Controleur
	 */

	public Console(Partie model, Controleur control) {
		super(model, control);
		sc = new Scanner(System.in);
		System.out.println("*****************Bienvenue dans cette partie de motus*******************");
		System.out.println();
		System.out.println();

		System.out.println("veuillez choisir la dificulte");
		System.out.println();
		System.out.println("1 - facile");
		System.out.println("2 - meduim");
		System.out.println("3 - dificile");

		Level l = new Level();
		niv = new Thread(l);
		niv.start();

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

			sc2 = new Scanner(System.in);

			String inputString = sc2.nextLine();

			if (inputString.length() > model.getMot().length()) {
				System.out.println("le mot  entre contient plus de character que le mot a definer");
				System.out.println();
				inputString = sc2.nextLine();

			} else if (inputString.length() < model.getMot().length()) {

				System.out.println("le mot  entre contient moin de character que le mot a definer");
				System.out.println();
				inputString = sc2.nextLine();

			} else {
				control.setString(inputString);
			}

		}
	}

	public class Level implements Runnable {
		public void run() {
			int ctrl = 0;
			while (ctrl == 0) {
				int lvl = sc.nextInt();
				if ((lvl >= 0) || (lvl <= 2)) {
					ctrl = 1;
					if (lvl == 0) {
						control.setLevel("facile");
					} else if (lvl == 1) {
						control.setLevel("meduim");
					} else if (lvl == 2) {
						control.setLevel("dificile");
					} else {
						System.out.println("something went wrong while choosing the level");
					}
				} else {
					System.out.println("veuillez entrer un niveau valide");

				}
			}

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(model.getMess() == "termine") {
		
		}else {
		new Thread(new ReadInput()).start();
		}
		if (model.getMess() == "reussi") {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i =0; i < model.getMot().length();i++) {
			System.out.print(model.dict[Partie.wordIndex -1].charAt(i) + " ") ;}
			System.out.println();
			System.out.println("Mot suivant");
			System.out.println();
			try {
				Thread.sleep(100);
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
		}
		
		if(model.getMess() != "termine") {
			this.afficher();

		}
		
	}

}
