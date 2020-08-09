package vues;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controleurs.*;
import modele.Partie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("deprecation")
public class Gui extends Vue implements Observer, ActionListener {

	JFrame f;
	JFrame f1;
	Panneau pan;
	private JTextField field1;
	JRadioButton jRadioButton1;
	JRadioButton jRadioButton2;
	JRadioButton jRadioButton3;
	JButton jButton;
	ButtonGroup G1;
	JLabel L1;

	public static int index = 0;

	public static char arr[][] = new char[5][6];
	public static char arr2[][] = new char[5][6];
	public static char arr3[][] = new char[5][6];

	public Gui(Partie model, Controleur control) {
		super(model, control);
		this.home();
		this.f = new JFrame();

		this.pan = new Panneau(model.getMot2(), model.getMot(), model.getMess(), Gui.arr, Gui.arr2, Gui.arr3);
		f.setVisible(false);

	}

	public void home() {
		f1 = new JFrame();
		f1.setTitle("MOTUS");
		f1.setSize(500, 550);

		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f1.setLocationRelativeTo(null);

		f1.setResizable(false);

		f1.setLayout(null);

		jRadioButton1 = new JRadioButton();

		jRadioButton2 = new JRadioButton();

		jRadioButton3 = new JRadioButton();

		jButton = new JButton("commencer");

		G1 = new ButtonGroup();

		L1 = new JLabel("veuillez choisir votre niveau de dificulte");

		jRadioButton1.setText("Facile");

		jRadioButton2.setText("Meduim");
		jRadioButton3.setText("dificile");

		jRadioButton1.setBounds(120, 100, 120, 50);

		jRadioButton2.setBounds(120, 160, 80, 50);
		jRadioButton3.setBounds(120, 220, 80, 50);

		jButton.setBounds(125, 280, 120, 30);

		L1.setBounds(100, 30, 250, 50);

		f1.add(jRadioButton1);

		f1.add(jRadioButton2);
		f1.add(jRadioButton3);

		f1.add(jButton);

		f1.add(L1);

		G1.add(jRadioButton1);
		G1.add(jRadioButton2);
		G1.add(jRadioButton3);
		f1.setVisible(true);

		jButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (jRadioButton1.isSelected()) {
					control.setLevel("facile");

				}

				else if (jRadioButton2.isSelected()) {
					control.setLevel("medium");
				} else {

					control.setLevel("dificile");
				}
				model.setWord();
				Gui.arr = new char[5][model.getMot().length()];
				Gui.arr2 = new char[5][model.getMot().length()];
				Gui.arr3 = new char[5][model.getMot().length()];
			}
		});
	}

	public void fenetre(String mot, String mot2, String mess, char[][] char2, char[][] char3, char[][] char4) {
		f.setTitle("MOTUS");
		f.setSize(500, 550);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setLocationRelativeTo(null);

		f.setResizable(false);
		f.setContentPane(new Panneau(mot, mot2, mess, char2, char3, char4));
		f.getContentPane().setLayout(null);

		JLabel motx = new JLabel("Entrez Le Mot :");
		motx.setBounds(50, 305, 100, 65);
		f.getContentPane().add(motx);

		field1 = new JTextField();
		field1.setBounds(143, 320, 150, 25);
		f.getContentPane().add(field1);
		field1.setColumns(10);

		JButton b = new JButton("ok");
		b.setBounds(293, 320, 50, 25);
		f.getContentPane().add(b);
		b.addActionListener(this);

		JLabel point = new JLabel(modele.Partie.total + " mot(s) trouvé sur " + modele.Partie.end);
		point.setBounds(143, 350, 250, 65);
		f.getContentPane().add(point);
		f.setVisible(true);
	}

	public void setArr2() {
		if ((model.getMess() == "reussi") || (model.getMess() == "echouer")) {
			Gui.arr = new char[5][6];
			Gui.arr2 = new char[5][6];
			Gui.arr3 = new char[5][6];

			Gui.index = 0;
		}
		
		try {
			for (int j = 0; j < model.getMot().length(); j++) {
				Gui.arr2[Gui.index][j] = model.getMot2().charAt(j);

			}
		} catch (Exception e) {
			System.out.println();
		}

	}

	public void setArr() {

		for (int j = 0; j < model.getMot().length(); j++) {
			Gui.arr[Gui.index][j] = Partie.index[j];
		}

	}

	public void setArr3() {
		if ((model.getMess() == "reussi") || (model.getMess() == "echouer")) {
			Gui.arr = new char[5][6];
			Gui.arr2 = new char[5][6];
			Gui.arr3 = new char[5][6];

			Gui.index = 0;
		}
		for (int j = 0; j < model.getMot().length(); j++) {
			Gui.arr3[Gui.index][j] = Partie.index2[j];

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		f1.setVisible(false);
		f.setVisible(true);
		this.setArr();
		this.setArr2();
		this.setArr3();

		if ((model.getMess() == "reussi") || (model.getMess() == "echouer")) {
			if (model.getMess() == "reussi") {
				Gui.index = 0;

				Gui.arr = new char[5][6];
				Gui.arr2 = new char[5][6];
				Gui.arr3 = new char[5][6];

				--Gui.index;

			}

		}

		if (model.getMess() == "reussi") {
			JOptionPane.showMessageDialog(f, "BINGO !!\n" + model.dict[Partie.wordIndex - 1].toUpperCase());
		} else if (model.getMess() == "echouer") {
			JOptionPane.showMessageDialog(f,
					"Le mot a definer etait\n" + model.dict[Partie.wordIndex - 1].toUpperCase());
		} else if (model.getMess() == "termine") {
			if (Partie.success == Partie.end) {
				JOptionPane.showMessageDialog(f, "FELICITATION !!!\n VOUS AVEZ TROUVER TOUT LES MOTS");
			} else {

				JOptionPane.showMessageDialog(f,
						"FIN DE PARRTIE !!!\n" + "VOUS AVEZ TROUVER  " + Partie.success + "MOT(s) SUR  " + Partie.end);
			}
		}
		if(model.getMess() == "termine") {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			f.setVisible(false);
		}else {
		this.fenetre(model.getMot2(), model.getMot(), model.getMess(), Gui.arr, Gui.arr2, Gui.arr3);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String x = field1.getText();
		if (x.length() < model.getMot().length()) {

		} else {
			control.setString(x);

		}
	}

}
