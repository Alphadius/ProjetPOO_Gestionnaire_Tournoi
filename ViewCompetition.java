import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewCompetition extends JFrame {
	CardLayout card;
	Container c;

	public JTextField textfieldNomCompetition = new JTextField(20);
	public JTextField textfieldNbEquipes = new JTextField(20);
	public JTextField textfieldJour = new JTextField(1);
	public JTextField textfieldMois = new JTextField(1);
	public JTextField textfieldAnnee = new JTextField(1);
	public JLabel labelNomCompetition = new JLabel();
	public JLabel labelNbEquipes = new JLabel();
	public JLabel labelDateStart = new JLabel();
	private JButton creerComp = new JButton("Créer");

	private String[] tableEquipeTitres = {"Equipes", "Score..."}; // Entête du tableau (je suis pas sûr des titres)
	private Object[][] tableEquipeData = {
		{"France", "1-0"} // Contenu du tableau
	};
	private JTable tableEquipe = new JTable(tableEquipeData, tableEquipeTitres); // JTable pour afficher le tableau de valeurs des matchs etc, j'ai pas encore add au panel choixEquipe

	public ViewCompetition() {
		this.setTitle("Gestionnaire de competition");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		c = getContentPane();
		card = new CardLayout(80, 30);
		c.setLayout(card);

		// PANEL DE LA PAGE INITIALE "NOUVEAU TOURNOI"
		JPanel boutonStart = new JPanel();
 		JButton start = new JButton("Nouveau Tournoi");
 		boutonStart.add(start);
 		c.add("menu", boutonStart);
		
		//////////////////////////
 		// PANEL CREER NOM COMPETITION
 		//////////////////////////
 		JPanel creerCompetitionPanel = new JPanel(new BorderLayout());
 		creerCompetitionPanel.setLayout(new GridBagLayout());
 		GridBagConstraints gbc = new GridBagConstraints();

 		// Cellule contenant le LABEL "CRÉER UNE NOUVELLE COMPÉTITION"
 		gbc.gridx = 0;
 		gbc.gridwidth = 6;
 		gbc.gridheight = 2;
 		gbc.gridy = 0;
 		gbc.fill = GridBagConstraints.BOTH;
 		creerCompetitionPanel.add(new JLabel("<html><h2>Créer une nouvelle compétition</h2></html>"), gbc);

 		// Cellule contenant le TEXTFIELD du NOM DE LA COMPÉTITION
		gbc.weightx = 1;
 		gbc.weighty = 1;
 		gbc.gridx = 0;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;
		gbc.gridy = 3;
		textfieldNomCompetition.setText("Entrer le nom de la compétition");
		textfieldNomCompetition.addMouseListener(new MouseAdapter() { // Efface le contenu quand on clique sur le textfield
		  @Override
		  public void mouseClicked(MouseEvent e) {
		    textfieldNomCompetition.setText("");
		  }
		});
		creerCompetitionPanel.add(textfieldNomCompetition, gbc);
 		
		// Cellule contenant le TEXTFIELD du NOMBRE D'ÉQUIPES
 		gbc.gridx = 0;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;
		gbc.gridy = 5;
		textfieldNbEquipes.setText("Nombre d'équipes");
		textfieldNbEquipes.addMouseListener(new MouseAdapter() { // Efface le contenu quand on clique sur le textfield
		  @Override
		  public void mouseClicked(MouseEvent e) {
		    textfieldNbEquipes.setText("");
		  }
		});
		creerCompetitionPanel.add(textfieldNbEquipes, gbc);

		// Cellules DATE
		// Jour
 		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 7;
		textfieldJour.setText("Jour");
		textfieldJour.addMouseListener(new MouseAdapter() { // Efface le contenu quand on clique sur le textfield
		  @Override
		  public void mouseClicked(MouseEvent e) {
		    textfieldJour.setText("");
		  }
		});

		creerCompetitionPanel.add(textfieldJour, gbc);
		// Mois
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 7;
		textfieldMois.setText("Mois");
		textfieldMois.addMouseListener(new MouseAdapter() { // Efface le contenu quand on clique sur le textfield
		  @Override
		  public void mouseClicked(MouseEvent e) {
		    textfieldMois.setText("");
		  }
		});
		creerCompetitionPanel.add(textfieldMois, gbc);
		// Année
		gbc.gridx = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.gridy = 7;
		textfieldAnnee.setText("Année");
		textfieldAnnee.addMouseListener(new MouseAdapter() { // Efface le contenu quand on clique sur le textfield
		  @Override
		  public void mouseClicked(MouseEvent e) {
		    textfieldAnnee.setText("");
		  }
		});
		creerCompetitionPanel.add(textfieldAnnee, gbc);



 		// Cellule contenant le BOUTON VALIDER
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 8;

		creerCompetitionPanel.add(creerComp, gbc);

 		c.add("competition", creerCompetitionPanel);

		//////////////////////////
 		// PANEL N°2 : CHOIX ÉQUIPE
 		//////////////////////////
 		JPanel choixEquipePanel = new JPanel(new BorderLayout());
 		choixEquipePanel.setLayout(new GridBagLayout());

 		gbc.weightx = 1;
 		gbc.weighty = 1;
 		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.gridy = 1;
 		choixEquipePanel.add(labelNomCompetition, gbc);
 		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridy = 2;
		// test ImageIcon + resize, rendre plus propre dans le code plus tard
		ImageIcon drapeauFrance = new ImageIcon(new ImageIcon("images/france.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
 		choixEquipePanel.add(new JButton(drapeauFrance), gbc);
 		choixEquipePanel.add(labelNbEquipes, gbc);
 		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.gridy = 3;
 		//choixEquipePanel.add(labelDateStart, gbc);

 		//REMPLIR LE CHOIX DES EQUIPES INTERFACE
 		c.add("choixEquipe", choixEquipePanel);


 		// ACTION DU BOUTON START DE LA PREMIERE PAGE
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(c, "competition");
			}
		});

		//////////////////////////
 		// PANEL N°3 : 
 		//////////////////////////


	}
	
	// Méthodes qui récupèrent les données des textfields
	public String getNomCompetition() {
		return textfieldNomCompetition.getText();
	}

	public int getNbEquipes() {
		return Integer.parseInt(textfieldNbEquipes.getText());
	}

	public int getJour() {
		return Integer.parseInt(textfieldJour.getText());
	}

	public int getMois() {
		return Integer.parseInt(textfieldMois.getText());
	}

	public int getAnnee() {
		return Integer.parseInt(textfieldAnnee.getText());
	}

	public void addCompEntreeListener(ActionListener listenForvalidButton){
		creerComp.addActionListener(listenForvalidButton);
	}

	// MÉTHODES SET
	public void setNomCompetition(String nomComp) { //Renommer ; permet de récupérer le nom de la competition depuis la class etc.
		labelNomCompetition.setText(nomComp);
	}

	public void setNbEquipes(int nbEquipes) {
		labelNbEquipes.setText(String.valueOf(nbEquipes));
	}

	public void setDateStart(String dateStart) {
		labelDateStart.setText(dateStart);
	}

	public void goChoixEquipe(){
			card.show(c, "choixEquipe");
			System.out.println("choix equipe");
	}
	public void afficherErreur(Exception erreur){
		JOptionPane.showMessageDialog(null,erreur);
	}
}