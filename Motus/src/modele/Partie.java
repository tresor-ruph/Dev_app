/**
 * 
 */
package modele;

import java.util.Observable;

import vues.Gui;

import java.util.Collections;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("deprecation")
public class Partie extends Observable {

	public String lvl = " ";
	//public static int cpt = 60;
	public static int chance = 5;
	public static int success = 0;
	public static int total = 0;
	public static int end = 5;
	public static int wordIndex = 0;
	public String mot;
	public String[] dict;
	public String[] dict2;
	public String[] dict3;
	public String mot2;
	//public boolean verif = true;
	public static String mess;
	public static char[] index;
	public static char[] index2;

	public Partie() {
		Serveur serv = new Serveur();
		serv.initWord();
		this.dict = serv.dict;
		this.dict2 = serv.dict2;
		this.dict3 = serv.dict3;
	}

	public static int getChance() {
		return chance;
	}

	public static void setChance() {
		Partie.chance = --chance;
	}

	public char[] getIndex() {
		return index;
	}

	/**
	 * 
	 * @param i : int 
	 * @param j : int 
	 */
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
	
	/**
	 * 
	 * @param mess : String : message a afficher a l'utilisateur
	 */

	public void setMess(String mess) {
		Partie.mess = mess;

	}

	public static int getWordIndex() {
		return wordIndex;
	}

	public static void setWordIndex() {
		++Partie.wordIndex;
	}



	

	public String getMot2() {
		return mot2;
	}

	/**
	 * @param mot2 : String : mot a definer
	 */

	public void setMot(String mot) {
		this.mot = mot;

	}
/**
 * 
 * @param mot2 : String : mot entre par l'utilisateur
 */
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

	public String getLvl() {
		return lvl;
	}

	/**
	 * 
	 * @param lvl : niveau de dificulte du jeu.
	 * peut prendre 3 valeur facile, meduim et dificile.
	 */
	
	public void setLvl(String lvl) {
		this.lvl = lvl;
		this.setWord();

		setChanged();
		notifyObservers();
	}

/**
 * La method setWord va comparer choisir un mot a definer en fonction du niveau
 * de dificulte entre par l'utilisateur
 */

	public void setWord() {

		if (this.getLvl().equalsIgnoreCase("facile")) {
			this.setMot(this.dict[Partie.wordIndex]);
		} else if (this.getLvl().equalsIgnoreCase("meduim")) {
			this.setMot(this.dict2[Partie.wordIndex]);

		} else if (this.getLvl().equalsIgnoreCase("dificile")) {
			this.setMot(this.dict2[Partie.wordIndex]);

		} else {
			System.out.println("something went wrong");
		}

		Partie.index = new char[this.getMot().length()];
		Partie.index2 = new char[this.getMot().length()];

	}
	/**
	 * La methode word permet va comparer le mot a definer a celui entre par
	 * l'utilisateur
	 * 
	 */
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
			++Partie.total;

		}
		if (Partie.total == Partie.end) {

			this.setMess("termine");

			Partie.index = new char[this.getMot().length()];
			Partie.index2 = new char[this.getMot().length()];

		}

	}

}
