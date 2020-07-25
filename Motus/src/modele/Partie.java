/**
 * 
 */
package modele;

import java.util.Observable;
import java.util.Scanner;

/**
 * @author tresor
 * 
 * @param mot   : String : represente le mot a definer
 * @param mot2  : String : contient le mot entrer par l'utilisateur
 * @param verif : boolean : boolean permettant de verifier la longeur du mot
 *              entrer par l'utilisateur class Partie servira de la classe
 *              principal du package modele et sera donc la class a observer
 *
 */
@SuppressWarnings("deprecation")
public class Partie extends Observable {
	public static int cpt =60;
	public static int chance = 3;
	public static int success = 0;
	public static int total = 0;
	public static int end = 5;

	public static int getChance() {
		return chance;
	}

	public static void setChance() {
		Partie.chance = --chance;
	}

	public static int wordIndex = 0;
	public String mot;
	public String[] dict;
	public String mot2;
	public boolean verif = true;
	public String mess;
	public char[] index;
	public char[] index2;

	public char[] getIndex() {
		return index;
	}

	public void setIndex(int i, char j) {
		this.index[i] = j;
	}

	public char[] getIndex2() {
		return index2;
	}

	public void setIndex2(int i, char j) {
		this.index2[i] = j;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;

	}

	public static int getWordIndex() {
		return wordIndex;
	}

	public static void setWordIndex() {
		++Partie.wordIndex;
	}

	/**
	 * permet de recuperer la valeur de verif
	 */
	public boolean isVerif() {
		return verif;
	}

	/**
	 * @param veriif : boolean
	 * 
	 */
	public void setVerif(boolean verif) {
		this.verif = verif;
	}

	public String getMot2() {
		return mot2;
	}

	/**
	 * @param mot2 : String
	 */

	public void setMot(String mot) {
		this.mot = mot;

	}

	public void setMot2(String mot2) {
		this.mot2 = mot2;
		this.word();
		setChanged();
		notifyObservers();
	}

	public String getMot() {
		return mot;
	}

	/**
	 * Cette methode permet va comparer le mot a definer a celui entre par
	 * l'utilisateur
	 * 
	 */

	public void setWord() {
		//new Thread(new Timer()).start();
	
		int cnt = 0;
		Serveur serv = new Serveur();
		try {
			serv.readDataBase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dict = new String[serv.getLib().size()];

		for (String i : serv.getLib().keySet()) {
			this.dict[cnt] = i;
			++cnt;
		}

		this.setMot(this.dict[Partie.wordIndex]);
		this.index = new char[this.getMot().length()];
		this.index2 = new char[this.getMot().length()];

	}

	@SuppressWarnings("unused")
	public void word() {

		if (this.getMot().equalsIgnoreCase(this.getMot2())) {
			for (int i = 0; i < this.getMot().length(); i++) {
				this.setIndex(i, this.getMot().charAt(i));
			}
			this.setMess("reussi");
			++Partie.success;
			++Partie.total;
			++Partie.wordIndex;
			this.setMot(this.dict[Partie.wordIndex]);
			// this.setMess("echouer");
			Partie.chance = 3;
			this.index = new char[this.getMot().length()];
			this.index2 = new char[this.getMot().length()];

		} else {
			this.setMess(" ");
			outerloop: for (int i = 0; i < this.getMot().length(); i++) {
				innerloop: for (int j = 0; j < this.getMot().length(); j++) {
					if ((this.getMot().charAt(j) == this.getMot2().charAt(i)) && (i == j)) {
						// si il existe des character coommun entre le mot a definer et le mot entre par
						// l'utilisateur

						this.setIndex(i, this.getMot2().charAt(i));
						break innerloop;
						// augmenter le character au tableau 1
					} else if ((this.getMot().charAt(j) == this.getMot2().charAt(i)) && (i != j)) {

						this.setIndex2(i, this.getMot2().charAt(i));
						// break innerloop;
						// add character to index 2;

					} else {
						if (i == this.getMot().length() - 1 && j == this.getMot().length() - 1) {
							// Le joueur n'a trouver aucun character du mot;
						}
					}
				}
			}
			
		}
		if (Partie.getChance() == 0) {

			this.setMess("echouer");
			Partie.chance = 3;
			++Partie.total;
			// this.setMot(this.dict[this.wordIndex]);
			this.index = new char[this.getMot().length()];
			this.index2 = new char[this.getMot().length()];

		}
		if (Partie.total == Partie.end) {
			this.setMess("termine");
		}

	}

	private class Timer implements Runnable {

		@Override
		public void run() {

			for (int i = 60; i > 0; i--) {
				--Partie.cpt;
				System.out.println(Partie.cpt);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			

			}

		}

	}

}
