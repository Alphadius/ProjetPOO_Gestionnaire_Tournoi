import javax.swing.*;
import java.util.*;
//import Controller.*;
import java.awt.*;
import java.awt.event.*;

public class AfficherCompetition implements ActionListener {
	JFrame fenetre; JButton bout; Competition compTemp; Match matchTemp; String nomMatch;int init = 0; 


	public AfficherCompetition(Competition comp) {
		compTemp = comp;
		matchTemp = compTemp.matchs.get(0);
		nomMatch = matchTemp.equipe1.nomEquipe + " - " +matchTemp.equipe2.nomEquipe;
		fenetre = new JFrame(""+compTemp); 
		fenetre.setLayout(new BorderLayout());
		bout = new JButton(nomMatch); 
		fenetre.add(bout);
		bout.addActionListener(this); 
		fenetre.pack();
	}
	public void actionPerformed(ActionEvent e) {
		init = (init+1)%compTemp.matchs.size();
		matchTemp = compTemp.matchs.get(init);
		nomMatch = matchTemp.equipe1.nomEquipe + " - " +matchTemp.equipe2.nomEquipe;
		bout.setText(nomMatch);
	}
}