import javax.swing.*;
import java.util.*;
//import Controller.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;
import java.awt.Dimension;

public class AfficherCompetition{
	JFrame fenetre; Competition compTemp; Match matchTemp; String nomMatch;int init = 0; 


	public AfficherCompetition(Competition comp) {
		compTemp = comp;
		fenetre = new JFrame(""+compTemp);
		List<String> nomMatchs = new ArrayList<String>();
    	for(Match temp : comp.matchs){
    		nomMatchs.add(temp.equipe1.nomEquipe+" - "+temp.equipe2.nomEquipe);
    	}
    	String[] listMatch = nomMatchs.toArray(new String[nomMatchs.size()]);
		JComboBox allMatch = new JComboBox(listMatch);
		allMatch.setBounds(300, 300,100,20); 
		fenetre.add(allMatch);
		List<String> nomJoueurs = new ArrayList<String>();
    	for(Joueur temp : comp.joueurs){
    		nomJoueurs.add(temp.nom+" "+temp.prenom);
    	}
	    String[] listNom = nomJoueurs.toArray(new String[nomJoueurs.size()]);
	    JComboBox cb=new JComboBox(listNom);
	    cb.setBounds(50, 50,200,20);    
	    fenetre.add(cb);        
	    fenetre.setLayout(null);    
	    fenetre.setPreferredSize(new Dimension(1000, 600));   
	    fenetre.setVisible(true); 
		fenetre.pack();
	}
}