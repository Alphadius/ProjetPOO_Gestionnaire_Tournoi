import javax.swing.*;
import java.util.*;
//import Controller.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;
import java.awt.Dimension;


public class menu{
	public menu(JFrame fenetre,Competition comp){

		int largeurFrame, hauteurFrame, largeurButton, hauteurButton, x, y;
		largeurFrame = 1000;
		hauteurFrame = 600;
		largeurButton = 300;
		hauteurButton = 100;
		x = (largeurFrame/2) - (largeurButton/2);
		y = (hauteurFrame/2) - (hauteurButton/2);

		JButton start = new JButton("Nouveau Tournoi");
		start.setBounds(x, y,largeurButton, hauteurButton); 
		fenetre.add(start); 
		fenetre.setLayout(null);
	    fenetre.setPreferredSize(new Dimension(largeurFrame, hauteurFrame));
	    fenetre.setVisible(true);
		fenetre.pack();

		start.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	comp.getDataJoueurs();
	        	start.setVisible(false);
	        	new AfficherCompetition(fenetre, comp);
			}
		});
	}
}