import javax.swing.*;
import java.util.*;
//import Controller.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;
import java.awt.Dimension;


public class menu{
	public menu(JFrame fenetre,Competition comp){

		JButton start = new JButton("Nouveau Tournoi");
		start.setBounds(300,300,300,100); 
		fenetre.add(start); 
		fenetre.setLayout(null);
	    fenetre.setPreferredSize(new Dimension(1000, 600));
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