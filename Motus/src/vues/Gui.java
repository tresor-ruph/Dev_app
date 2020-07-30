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

	public static char arr[][] = new char[5][6];

	public Gui(Partie model, Controleur control) {
		super(model, control);
		model.setWord();
		this.f = new JFrame();
		this.pan = new Panneau(model.getMot2(), Partie.index);
		this.fenetre(model.getMot2(), Partie.index);

	}

	public void fenetre(String mot, char[] char2) {
		f.setTitle("MOTUS");
		f.setSize(500, 550);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// f.setContentPane(pan);
		f.setResizable(false);
		// ImageIcon icone = new ImageIcon("download.jpg");
		// JLabel image = new JLabel(icone);
		// f.add(image);
		f.setContentPane(new Panneau(mot,char2));
		f.setVisible(true);
	}

	public void setArr() {

		for (int i = 0; i < model.getMot().length(); i++) {

			arr[0][0] = model.getMot().charAt(0);

			if (i > 0) {
				arr[0][i] = '.';
			}
		}
		for (int j = 0; j < model.getMot().length(); j++) {

			if (j == 0) {
				arr[0][0] = model.getMot().charAt(0);
			}
			if (j > 0) {
				arr[Panneau.chancecnt][j] = Partie.index[j];
			}

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.setArr();

		this.fenetre(model.getMot2(), Partie.index);
		System.out.println(Panneau.index);
		
		// pan.clear();
		// pan.dessin();

	}

}
