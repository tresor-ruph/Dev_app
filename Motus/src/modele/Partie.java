/**
 * 
 */
package modele;

import java.util.Observable;

import vues.Gui;

import java.util.Collections;
import java.util.Arrays;
import java.util.List;

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
	public Partie() {
		Serveur serv = new Serveur();
		serv.initWord();
		this.dict = serv.dict;
	}

	public boolean timerUp = false;

	public boolean isTimerUp() {
		return timerUp;
	}

	public void setTimerUp(boolean timerUp) {
		this.timerUp = timerUp;
		// setChanged();
		// notifyObservers();

	}

	public static int cpt = 60;
	public static int chance = 5;
	public static int success = 0;
	public static int total = 0;
	public static int end = 5;
	public static int wordIndex = 0;
	public String mot;
	public String[] dict;
	public String mot2;
	public boolean verif = true;
	public static String mess;
	public static char[] index;
	public static char[] index2;

	public static int getChance() {
		return chance;
	}

	public static void setChance() {
		Partie.chance = --chance;
	}

	public char[] getIndex() {
		return index;
	}

	public void setIndex(int i, char j) {
		Partie.index[i] = j;
	}

	public char[] getIndex2() {
		return index2;
	}

	public void setIndex2(int i, char j) {
		Partie.index2[i] = j;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		Partie.mess = mess;

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
		++Gui.index;

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


		this.setMot(this.dict[Partie.wordIndex]);

		Partie.index = new char[this.getMot().length()];
		Partie.index2 = new char[this.getMot().length()];

	}

	public void word() {

		this.setMess(" ");
		for (int i = 0; i < this.getMot().length(); i++) {
			if (this.getMot().charAt(i) == this.getMot2().charAt(i)) {
				this.setIndex(i, this.getMot2().charAt(i));

			} else {
				innerloop: for (int j = 0; j < this.getMot().length(); j++) {
					if (this.getMot().charAt(j) == this.getMot2().charAt(i)) {
						this.setIndex2(i, this.getMot2().charAt(i));

						break innerloop;

					}
				}
			}
		}

		if (this.getMot().equalsIgnoreCase(this.getMot2())) {
			for (int i = 0; i < this.getMot().length(); i++) {
				this.setIndex(i, this.getMot().charAt(i));
			}
			this.setMess("reussi");

			++Partie.success;
			++Partie.total;
			++Partie.wordIndex;
			Partie.chance = 5;
			Partie.index = new char[this.getMot().length()];
			Partie.index2 = new char[this.getMot().length()];
			this.setMot(this.dict[Partie.wordIndex]);

		}

		if (Partie.getChance() == 0) {
			Gui.index = 0;
			Gui.arr = new char[5][6];
			Gui.arr2 = new char[5][6];
			this.setMess("echouer");
			Partie.chance = 5;

		}
		if (Partie.total == Partie.end) {
			++Partie.total;

			this.setMess("termine");
		}

	}

	
}
