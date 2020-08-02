package vues;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleurs.*;
import modele.Partie;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("deprecation")
public class Gui extends Vue implements Observer {

	JFrame f;
	Panneau pan;
	public static int index = 0;

	public static char arr[][] = new char[5][6];
	public static char arr2[][] = new char[5][6];

	public Gui(Partie model, Controleur control) {
		super(model, control);
		model.setWord();
		Gui.arr = new char[5][model.getMot().length()];
		Gui.arr2 = new char[5][model.getMot().length()];
		this.f = new JFrame();
		this.pan = new Panneau(model.getMot2(), model.getMot(), model.getMess(), Gui.arr, Gui.arr2);
		this.fenetre(model.getMot2(), model.getMot(), model.getMess(), Gui.arr, Gui.arr2);

	}

	public void fenetre(String mot, String mot2, String mess, char[][] char2, char[][] char3) {
		f.setTitle("MOTUS");
		f.setSize(500, 550);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setContentPane(new Panneau(mot, mot2, mess, char2, char3));
		f.setVisible(true);
	}

	public void setArr2() {
		System.out.println(model.getMess());
		if (model.getMess() == "reussi") {
			Gui.arr = new char[5][6];
			Gui.arr2 = new char[5][6];
			Gui.index = 0;
		}
		for (int j = 0; j < model.getMot().length(); j++) {
			Gui.arr2[Gui.index][j] = model.getMot2().charAt(j);

		}
		System.out.println(Gui.index);

	}

	public void setArr() {

		for (int j = 0; j < model.getMot().length(); j++) {
			Gui.arr[Gui.index][j] = Partie.index[j];
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.setArr();
		this.setArr2();

		if (model.getMess() == "reussi") {
			if (model.getMess() == "reussi") {
				Gui.index = 0;

				Gui.arr = new char[5][6];
				Gui.arr2 = new char[5][6];

				--Gui.index;
				for (int j = 0; j < model.getMot().length(); j++) {
					System.out.println(Gui.arr2[0][j]);

				}
			}

		}
		this.fenetre(model.getMot2(), model.getMot(), model.getMess(), Gui.arr, Gui.arr2);

	}

}
