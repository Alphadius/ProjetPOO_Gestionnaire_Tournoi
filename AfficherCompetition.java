import javax.swing.*;
import java.util.*;
//import Controller.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;
import java.awt.Dimension;

public class AfficherCompetition{
	JFrame fenetre; Competition compTemp; Match matchTemp; String nomMatch;int init = 0; 


	public AfficherCompetition(JFrame fenetre,Competition comp) {

		List<String> nomJoueurs = new ArrayList<String>();
    	for(Joueur temp : comp.joueurs){
    		nomJoueurs.add(temp.nom+" "+temp.prenom);
    	}
	    String[] listNom = nomJoueurs.toArray(new String[nomJoueurs.size()]);
	    JComboBox cb=new JComboBox(listNom);
	    cb.setBounds(50, 200,200,20);



		final JLabel label = new JLabel();          
  		label.setHorizontalAlignment(JLabel.CENTER);  
    	label.setSize(400,100);

		JButton boutton=new JButton("Afficher");
		boutton.setBounds(250,200,75,20);
		boutton.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
				String data = "<html>"   
				   + comp.joueurs.get(cb.getSelectedIndex()).stat()+"</html>";  
				label.setText(data);  
			}
		});

		JLabel nbEquipeLabel = new JLabel("<html><br/>Nombre d'équipes : </html>");
		nbEquipeLabel.setBounds(20,300,100,50);
		JTextField nbEquipe = new JTextField();
		nbEquipe.setBounds(120,300,100,50);
		JButton boutEquipe = new JButton("entrer");
		boutEquipe.setBounds(220,300,50,50);
		boutEquipe.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				nbEquipe.setVisible(false);
				nbEquipeLabel.setVisible(false);
				boutEquipe.setVisible(false);
				comp.nombreEquipes = Integer.parseInt(nbEquipe.getText());
				comp.initCompetition(comp.nombreEquipes);
			}
		});
		fenetre.add(nbEquipe);
		fenetre.add(nbEquipeLabel);
		fenetre.add(boutEquipe);


		// List<String> nomMatchs = new ArrayList<String>();
  //   	for(Match temp : comp.matchs){
  //   		nomMatchs.add(temp.equipe1.nomEquipe+" - "+temp.equipe2.nomEquipe);
  //   	}
  //   	String[] listMatch = nomMatchs.toArray(new String[nomMatchs.size()]);
  //   	JList list = new JList(listMatch);  
  //         list.setBounds(700,300, 100,300);  
  //         fenetre.add(list);




		JTextField jour = new JTextField();
	     JTextField mois = new JTextField();
	     JTextField annee = new JTextField();  
    	jour.setBounds(500,100, 200,30);
    	mois.setBounds(500,150,200,30);
    	annee.setBounds(500,200,200,30);
    	JButton bDate = new JButton("date");
    	bDate.setBounds(700,200,75,20);
		bDate.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {    
		        if(jour.getText() != ""){   
					String s1=jour.getText();  
	        		String s2=mois.getText();
	        		String s3=annee.getText();  
	        		int a=Integer.parseInt(s1);  
	        		int b=Integer.parseInt(s2); 
	        		int c=Integer.parseInt(s3);
	        		comp.jDebut = a;
	        		comp.mDebut = b;
	        		comp.aDebut = c;
	        		String data = "<html> Date : "   
					   + comp.jDebut+"/"+comp.mDebut+"/"+comp.aDebut+"</html>"; 
	        		label.setText(data);
	        	}
			}
		});


	    fenetre.add(boutton);
	    fenetre.add(bDate);
	    fenetre.add(jour);
	    fenetre.add(mois);
	    fenetre.add(annee);
	    fenetre.add(cb);
	    fenetre.add(label);
	    fenetre.setLayout(null);
	    fenetre.setPreferredSize(new Dimension(1000, 600));
	    fenetre.setVisible(true);
		fenetre.pack();
	}
}