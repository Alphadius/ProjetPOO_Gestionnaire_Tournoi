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

		Label l = new Label("Bonjour à\n tous\n lol bonjour\n hey", Label.CENTER);
		fenetre.add(l);
		fenetre.pack();
		fenetre.show();

		bout = new JButton("OK"); 
		fenetre.add(bout); 

		bout.addActionListener(this); 
		fenetre.pack();



	}

	public void actionPerformed(ActionEvent e) {
		if(bout.getText().equals("OK")) {
			bout.setText("KO");
		} else {
			bout.setText("OK");
		}
	}
	static public void main(String[] args) {
	   new OKKO().fenetre.show();
	}
}