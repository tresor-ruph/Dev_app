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
	// Partie mod = new Partie();
	public static int chancecnt = 1;
	private JTextField field1;
	public String mot;

	public String mot2;
	public String mess;
	public char[][] char1;
	public char[][] char2;

	public Panneau(String x, String x2, String x3, char[][] y, char[][] z) {
		this.mot = x2;
		this.mot2 = x;
		this.char1 = y;
		this.char2 = z;
		this.mess = x3;
	}

	public void paintComponent(Graphics g) {

		// super.paintComponents(g);

		// mod.setWord();

		try {
			Image img = ImageIO.read(new File("motus.jpg"));
			g.drawImage(img, 0, 0, 750, 550, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Aucune image n'a ete retrouvee !");
		}
		g.setColor(Color.gray);
		g.fill3DRect(47, 47, this.mot.length() * 50 + 7, 257, true);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < this.mot.length(); j++) {
				g.setColor(Color.DARK_GRAY);
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

		if (Partie.chance == 5) {
			JLabel char1 = new JLabel(this.mot.charAt(0) + " ");
			char1.setForeground(Color.ORANGE);
			char1.setFont(new Font("Verdana", Font.PLAIN, 30));
			char1.setBounds(52, 50, 48, 48);
			this.add(char1);

			for (int k = 0; k < this.mot.length(); k++) {

				JLabel char2 = new JLabel(". ");
				char2.setForeground(Color.ORANGE);
				char2.setFont(new Font("Verdana", Font.PLAIN, 30));
				char2.setBounds((k + 1) * 52, 50, 48, 48);
				this.add(char2);

			}
		} else if (Partie.chance < 5) {
			
			
			 for (int i = 0; i < 5; i++) {
				 for (int j = 0; j < this.mot2.length(); j++) {
					if (Gui.arr2[i][j] >= 'a' || Gui.arr2[i][j] >= 'A') {
						JLabel char2 = new JLabel(Gui.arr2[i][j] + " ");
						char2.setForeground(Color.ORANGE);
						char2.setFont(new Font("Verdana", Font.PLAIN, 30));
						char2.setBounds((j + 1) * 52, (i + 1) * 50, 48, 48);
						this.add(char2);

						if (Gui.arr[i][j] >= 'a' || Gui.arr[i][j] >= 'A') {

							Color mycolor = new Color(0, 255, 0, 127);
							g.setColor(mycolor);
							g.fillRoundRect((j + 1) * 50, (i+1) * 50, 50, 50,50, 50);
						}
						
					
					} 
					
				}
			}

		}

	}

}
