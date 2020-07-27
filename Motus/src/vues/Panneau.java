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
import javax.swing.JPanel;
import modele.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class Panneau  extends JPanel{

	/**
	 * 
	 */

	public  void paintComponent(Graphics g) {
		super.paintComponents(g);
		Partie mod = new Partie();
		mod.setWord();

	
	try {
		Image img = ImageIO.read(new File("motus.jpg"));
		g.drawImage(img, 0, 0, 750, 550, this);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Aucune image n'a ete retrouvee !");
	}
	g.setColor(Color.gray);
	g.fill3DRect(47, 47, mod.getMot().length()*50+7, 257, true);
	
	for(int i =0; i<5; i++) {
		for(int j=0;j<mod.getMot().length(); j++) {
			g.setColor(Color.DARK_GRAY);
			g.fill3DRect((j+1)*50, (i+1)*50, 50, 50, true);
		}
	}
	
	
}
}
