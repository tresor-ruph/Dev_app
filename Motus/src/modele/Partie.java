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
public class Partie extends Observable {

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public String mot = "banane";
	public String mot2;
	public boolean verif = true;
	public int len = mot.length();
	public String mess;
	public char[] index = new char[len];

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;

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

	public void word() {

		if (this.getMot().equalsIgnoreCase(this.getMot2())) {
			this.setMess("reussi");

		} else {
			for (int i = 0; i < this.getLen(); i++) {
				for (int j = 0; j < this.getLen(); j++) {

				}
			}
		}

	}
}
