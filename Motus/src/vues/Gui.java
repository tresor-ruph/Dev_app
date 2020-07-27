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
public class Gui extends Vue implements Observer{
	
	JFrame f = new JFrame();
	Panneau pan = new Panneau();

	public Gui(Partie model, Controleur control) {
		super(model, control);
		model.setWord();
		this.fenetre();
		
	}
	
	
	public void fenetre() {
		f.setTitle("MOTUS");
		f.setSize(600, 400);
		// f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setContentPane(pan);
		f.setResizable(false);
		//ImageIcon icone = new ImageIcon("download.jpg");
		//JLabel image = new JLabel(icone);
		//f.add(image);
		f.setContentPane(new Panneau());
		f.setVisible(true);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
