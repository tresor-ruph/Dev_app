/**
 * 
 */
package modele;

import java.util.Observable;
import java.util.Scanner;

/**
 * @author tresor
 * 
 * @param mot   : String  : represente le mot a definer
 * @param mot2  : String  : contient le mot entrer par l'utilisateur
 * @param verif : boolean : boolean permettant de verifier la longeur du mot entrer par l'utilisateur
 * class Partie servira de la classe principal du package modele et sera donc la class a observer
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
	
	/**
	 * permet de recuperer la valeur de verif
	 */
	 public boolean isVerif() {
		return verif;
	}
	 /**
	  * permet de modifier la valeur de verif
	  */
	public void setVerif(boolean verif) {
		this.verif = verif;
	}

	public String getMot2() {
		return mot2;
	}

	public void setMot2(String mot2) {
		this.mot2 = mot2;
		setChanged();
		notifyObservers();
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
		
	}
	/**
	 * cette methode verifie si le mot entre par l'utilisateur est bien le mot a definer
	 */
	


	public static void main(String[] args) {
		Partie mod = new Partie();
		
		
		  }
}
