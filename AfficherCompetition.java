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
    	final JLabel label = new JLabel();          
    label.setHorizontalAlignment(JLabel.CENTER);  
    label.setSize(400,100);
    	String[] listMatch = nomMatchs.toArray(new String[nomMatchs.size()]);
		JComboBox allMatch = new JComboBox(listMatch);
		allMatch.setBounds(300, 300,100,20); 
		fenetre.add(allMatch);
		JButton b=new JButton("Show");
		b.setBounds(250,200,75,20);
		List<String> nomJoueurs = new ArrayList<String>();
    	for(Joueur temp : comp.joueurs){
    		nomJoueurs.add(temp.nom+" "+temp.prenom);
    	}
	    String[] listNom = nomJoueurs.toArray(new String[nomJoueurs.size()]);
	    JComboBox cb=new JComboBox(listNom);
	    cb.setBounds(50, 200,200,20);
	    b.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) {       
String data = "<html>"   
   + comp.joueurs.get(cb.getSelectedIndex()).stat()+"</html>";  
label.setText(data);  
} });
	    fenetre.add(b);  
	    fenetre.add(cb);
	    fenetre.add(label);       
	    fenetre.setLayout(null);    
	    fenetre.setPreferredSize(new Dimension(1000, 600));   
	    fenetre.setVisible(true); 
		fenetre.pack();
	}
}