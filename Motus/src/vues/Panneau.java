/**
 * 
 */
package vues;

import javax.imageio.ImageIO;

/**
 * @author treso
 *
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class Panneau extends JPanel {

	/**
	 * 
	 */
	Partie mod = new Partie();
	public static int chancecnt = 1;
	private JTextField field1;
	public static int index = 3-Partie.chance ;
	public String mot2;
	public  char [] char1;

	public Panneau(String x, char [] y) {

		this.mot2 = x;
		this.char1 = y;
	}



	public void paintComponent(Graphics g) {
		super.paintComponents(g);

		mod.setWord();
		try {
			Image img = ImageIO.read(new File("motus.jpg"));
			g.drawImage(img, 0, 0, 750, 550, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Aucune image n'a ete retrouvee !");
		}
		g.setColor(Color.gray);
		g.fill3DRect(47, 47, mod.getMot().length() * 50 + 7, 257, true);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < mod.getMot().length(); j++) {
				// g.setColor(Color.DARK_GRAY);
				g.fill3DRect((j + 1) * 50, (i + 1) * 50, 50, 50, true);
			}
		}
		JLabel mot = new JLabel("Entrez Le Mot :");
		mot.setBounds(50, 305, 100, 65);
		this.add(mot);

		field1 = new JTextField();
		field1.setBounds(143, 320, 150, 25);
		this.add(field1);
		field1.setColumns(10);

		JLabel point = new JLabel(modele.Partie.total + " mot(s) trouvé sur " + modele.Partie.end);
		point.setBounds(143, 350, 250, 65);
		this.add(point);

		if (Partie.chance == 3) {
			JLabel char1 = new JLabel(mod.getMot().charAt(0) + " ");
			char1.setForeground(Color.ORANGE);
			char1.setFont(new Font("Verdana", Font.PLAIN, 30));
			char1.setBounds(52, 50, 48, 48);
			this.add(char1);

			for (int k = 0; k < mod.getMot().length(); k++) {

				JLabel char2 = new JLabel(". ");
				char2.setForeground(Color.ORANGE);
				char2.setFont(new Font("Verdana", Font.PLAIN, 30));
				char2.setBounds((k + 1) * 52, 50, 48, 48);
				this.add(char2);

			}
		} else if (Partie.chance < 3) {
			

			for (int k = 0; k < mod.getMot().length(); k++) {

				JLabel char2 = new JLabel(this.mot2.charAt(k) + " ");
				char2.setForeground(Color.ORANGE);
				char2.setFont(new Font("Verdana", Font.PLAIN, 30));
				char2.setBounds((k + 1) *52, (Panneau.index + 1) * 50, 48, 48);
				this.add(char2);
				if(this.mot2.charAt(k) == this.char1[k]) {
					
					Color mycolor = new Color(0, 255, 0, 127);
					g.setColor(mycolor);
					g.fill3DRect((k + 1) *50, (Panneau.index + 1) * 50, 50, 50, true);
				}else {
					//

				}

			}

		}

	}

}
