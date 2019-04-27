import javax.swing.*;
import java.util.*;
//import Controller.*;
import java.awt.*;
import java.awt.event.*;

public class OKKO implements ActionListener {
	JFrame fenetre; JButton bout;


	public OKKO() {
		fenetre = new JFrame("Bonjour"); 
		fenetre.setLayout(new BorderLayout());

		bout = new JButton("OK"); 
		fenetre.add(bout); 

		bout.addActionListener(this); 
		fenetre.pack();
	}

	public void actionPerformed(ActionEvent e) {
		String allMatch;
		for(int i = 0; i < 5; i++){
			Match temp = new Match();
			temp.returnMatchAll(i);
			allMatch = allMatch + temp.equipe1.nomEquipe;
		}
			bout.setText(allMatch);
	}
	// static public void main(String[] args) {
	//    new OKKO().fenetre.show();
	// }
}