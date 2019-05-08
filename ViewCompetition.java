package compMaker.view;
import compMaker.model.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.io.*;

public class ViewCompetition extends JFrame {
	public CardLayout card;
	public Container c;
	public Competition comp;
	public Competition origin;

	// Elements divers de panels
	public Object[][] data = new Object[130][7];
	public JTextField textfieldNomCompetition = new JTextField(21);
	public JTextField textfieldNbEquipes = new JTextField(21);
	public JTextField textfieldJour = new JTextField(7);
	public JPanel choixEquipePanel = new JPanel(new BorderLayout());
	public JTextField textfieldMois = new JTextField(7);
	public JTextField textfieldAnnee = new JTextField(7);
	public JTextField txtModifierScore1 = new JTextField(10);
	public JTextField txtModifierScore2 = new JTextField(10);
	public JButton btnModifierScore = new JButton("Modifier le score");
	public JButton btnClassement = new JButton("Classement");
	public JButton btnSaveListMatch = new JButton("Sauvegarder");
	public JLabel labelNomCompetition = new JLabel();
	public JLabel labelNbEquipes = new JLabel();
	public JLabel labelDateStart = new JLabel();
	public JLabel labelnomEquipe = new JLabel();
	public JLabel labelStatEquipe = new JLabel();
	public JLabel labelStatsMatch = new JLabel();
	public JLabel labelNumeroTour = new JLabel();
	public JLabel titreEquipe = new JLabel();
	public JPanel detailsEquipePanel = new JPanel(new BorderLayout());
	public JCheckBox matchAEuLieu = new JCheckBox();
	public JLabel stat = new JLabel();
	public String[] listJParEquipe = new String[23];
	public int countFlag = 0;
	public JButton creerComp = new JButton("Créer");
	public JButton buttonChargerCompetition = new JButton("Charger compétition");
	public JButton choixEquipeButton = new JButton("valider");
	public JComboBox boxEquipe = new JComboBox();
	public JButton buttonAfficherStats = new JButton("Afficher statistiques");
	public JButton buttonRetourListMatch = new JButton("Retour");
	public JButton buttonRetourListMatchB = new JButton("Retour");
	public GridBagConstraints gbc = new GridBagConstraints();
	public String titreFrame = "Gestionnaire de compétition";

	// test bouton dans JTable
	private JButton boutonDetailsEquipe = new JButton();

	// Tableau Match
	String columnHeaders[] = { "Équipe 1", "détails", "Équipe 2", "détails", "Score", "Date", "Modifier" };
	public JTable table = new JTable(data, columnHeaders);

	//////////
	public ViewCompetition(Competition origin, Competition comp) {
		this.setTitle(titreFrame);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		c = getContentPane();
		card = new CardLayout(80, 30);
		c.setLayout(card);

		// PANEL DE LA PAGE INITIALE "NOUVEAU TOURNOI"
		JPanel boutonStart = new JPanel(new BorderLayout());
		boutonStart.setLayout(new GridBagLayout());
		JButton start = new JButton("Nouveau Tournoi");
		// gbc.weightx = 1;
		// gbc.weighty = 1;
		gbc(0, 1, 1, 0);
		boutonStart.add(start, gbc);
		gbc(0, 1, 1, 2);

		boutonStart.add(buttonChargerCompetition, gbc);

	
		c.add("menu", boutonStart);

		//////////////////////////
		// PANEL CREER NOM COMPETITION
		//////////////////////////
		JPanel creerCompetitionPanel = new JPanel(new BorderLayout());
		creerCompetitionPanel.setLayout(new GridBagLayout());

		// Cellule contenant le LABEL "CRÉER UNE NOUVELLE COMPÉTITION"
		gbc(0, 6, 2, 0);
		creerCompetitionPanel.add(new JLabel("<html><h2>Créer une nouvelle compétition</h2></html>"), gbc);

		// Cellule contenant le TEXTFIELD du NOM DE LA COMPÉTITION

		gbc(0, 6, 1, 3);
		focusTextfielMenu(textfieldNomCompetition, "Entrer le nom de la compétition");
		creerCompetitionPanel.add(textfieldNomCompetition, gbc);

		// Cellule contenant le TEXTFIELD du NOMBRE D'ÉQUIPES
		gbc(0, 6, 1, 5);
		focusTextfielMenu(textfieldNbEquipes, "Nombre d'équipes");
		creerCompetitionPanel.add(textfieldNbEquipes, gbc);

		// Cellules DATE
		// Jour
		gbc(0, 1, 1, 7);
		focusTextfielMenu(textfieldJour, "Jour");
		creerCompetitionPanel.add(textfieldJour, gbc);
		// Mois
		gbc(1, 1, 1, 7);
		focusTextfielMenu(textfieldMois, "Mois");
		creerCompetitionPanel.add(textfieldMois, gbc);
		// Année
		gbc(2, 1, 1, 7);
		focusTextfielMenu(textfieldAnnee, "Année");
		creerCompetitionPanel.add(textfieldAnnee, gbc);

		// Cellule contenant le BOUTON VALIDER
		gbc(1, 1, 1, 8);

		creerCompetitionPanel.add(creerComp, gbc);

		c.add("competition", creerCompetitionPanel);

		// CHOIX DES EQUIPES
		choixEquipePanel.setLayout(new GridBagLayout());
		gbc(4, 1, 1, 3);
		choixEquipePanel.add(choixEquipeButton);

		c.add("choixEquipe", choixEquipePanel);

		//////////////////////////
		// PANEL loadCompetition
		//////////////////////////
		JPanel loadCompetitionPanel = new JPanel(new BorderLayout());
		JButton btnLoadCompetition = new JButton("Charger");
		loadCompetitionPanel.setLayout(new GridBagLayout());
		//gbc.fill = GridBagConstraints.BOTH;
		JTextField txtLoadCompetition = new JTextField(20);
		gbc(0, 1, 1, 0);
		loadCompetitionPanel.add(txtLoadCompetition, gbc);
		gbc(0, 1, 1, 1);
		loadCompetitionPanel.add(btnLoadCompetition, gbc);
		c.add("loadCompetition", loadCompetitionPanel);

		//////////////////////////
		// PANEL N°2 : AFFICHAGE DES MATCHS
		//////////////////////////
		JPanel listMatchPanel = new JPanel(new BorderLayout()); // Panel pour le label
		JPanel listMatchTablePanel = new JPanel(new BorderLayout()); // Panel pour le tableau

		// IMPORTATION DU TABLEAU JTABLE DES EQUIPES
		// Render des boutons cliquables de la table
		table.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		;
		table.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JTextField()));

		table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
		;
		table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JTextField()));

		table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
		;
		table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField()));

		// JScrollPane de la table
		JScrollPane scrollPane = new JScrollPane(table);
		listMatchPanel.add(scrollPane, BorderLayout.CENTER);
		JPanel btnClassementP = new JPanel(new BorderLayout());
		JPanel btnSaveP = new JPanel(new BorderLayout());
		
		btnClassementP.add(btnClassement, BorderLayout.WEST);
		btnClassementP.add(btnSaveListMatch, BorderLayout.EAST);
		listMatchPanel.add(btnClassementP, BorderLayout.SOUTH);
		//listMatchPanel.add(btnSaveP, BorderLayout.SOUTH);
		c.add("listMatch", listMatchPanel);
		//c.add("listMatch", scrollPane);

		// ACTION DU BOUTON START DE LA PREMIERE PAGE
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(c, "competition");
				creerComp.requestFocus();
			}
		});

		//////////////////////////
		// PANEL N°4 : DETAILS MATCH
		//////////////////////////
		JPanel detailsMatchPanel = new JPanel(new BorderLayout());
		// afficher le nom de l'équipe 1 du match en question
		detailsMatchPanel.setLayout(new GridBagLayout());
		JLabel labelNomMatch = new JLabel();
		focusTextfielMenu(txtModifierScore1, "Score équipe 1");
		focusTextfielMenu(txtModifierScore2, "Score équipe 2");

		// gbc.weightx = 1;
		// gbc.weighty = 1;
		gbc(0, 1, 2, 0);
		gbc.ipady = 0;
		detailsMatchPanel.add(labelStatsMatch, gbc);
		gbc(1, 1, 1, 6);
		detailsMatchPanel.add(txtModifierScore1, gbc);
		gbc(2, 1, 1, 6);
		detailsMatchPanel.add(new JLabel("<html><center> - </center></html>"), gbc);
		gbc(3, 1, 1, 6);
		detailsMatchPanel.add(txtModifierScore2, gbc);
		gbc(5, 1, 1, 7);
		detailsMatchPanel.add(matchAEuLieu, gbc); // CheckBox à cocher si le match a eu lieu
		gbc(6, 1, 1, 7);
		detailsMatchPanel.add(new JLabel("<html>Le match a eu lieu"), gbc);
		//detailsMatchPanel.add(labelNumeroTour, gbc);
		gbc(5, 1, 1, 6);
		detailsMatchPanel.add(btnModifierScore, gbc);
		gbc(5, 1, 1, 9);
		detailsMatchPanel.add(buttonRetourListMatchB, gbc);
		//gbc(posx, width, height, posy);
		
		c.add("detailsMatch", detailsMatchPanel);
	}

	// placement
	public void gbc(int x, int w, int h, int y) {
		gbc.gridx = x;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.gridy = y;
	}

	// Méthodes qui récupèrent les données des textfields
	public String getNomCompetition() {
		return textfieldNomCompetition.getText();
	}




	//////////////////////////
	// PANEL N°3 : DETAILS EQUIPE
	//////////////////////////

	public void AfficherDetailEquipe(String nomEquipe) {
		detailsEquipePanel.setLayout(new GridBagLayout());
		labelnomEquipe.setText(nomEquipe);
		titreEquipe.setText("<html><h2>" + nomEquipe + "</h2></html>");

		// gbc.weightx = 1;
		// gbc.weighty = 1;
		gbc(0, 2, 2, 0);
		gbc.ipady = 0;
		detailsEquipePanel.add(titreEquipe, gbc);
		gbc(0, 2, 2, 1);
		detailsEquipePanel.add(labelStatEquipe, gbc);
		gbc(0, 2, 1, 6);
		boxEquipe.removeAllItems();
		for (int i = 0; i < comp.equipeDe(labelnomEquipe.getText()).JoueursInEquipe.size(); i++) {
			String tempNom = comp.equipeDe(labelnomEquipe.getText()).JoueursInEquipe.get(i).nom;
			String tempPrenom = comp.equipeDe(labelnomEquipe.getText()).JoueursInEquipe.get(i).prenom;
			boxEquipe.addItem(tempNom + " " + tempPrenom);
		}
		detailsEquipePanel.add(boxEquipe, gbc);
		gbc(0, 2, 1, 7);
		detailsEquipePanel.add(buttonAfficherStats, gbc);
		gbc(0, 2, 1, 8);
		detailsEquipePanel.add(buttonRetourListMatch, gbc);
		gbc(4,1,3,1);
		detailsEquipePanel.add(stat, gbc);
		buttonRetourListMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stat.setText("");
				card.show(c, "listMatch");
			}
		});
		buttonAfficherStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// nomJoueur.afficherStats();
			}
		});
		c.add("detailsEquipe", detailsEquipePanel);
		// boxEquipe=new JComboBox(listJParEquipe);
	}

	//////////////////////////
	// PANEL : CLASSEMENT
	//////////////////////////



	//////
	public int getNbEquipes() {
		int machin = 0;
		if (textfieldNbEquipes.getText().equals("")) {
			machin = 0;
		} else {
			machin = Integer.parseInt(textfieldNbEquipes.getText());
		}
		return machin;
	}

	public int getJour() {
		return Integer.parseInt(textfieldJour.getText());
	}

	public int getMois() {
		return Integer.parseInt(textfieldMois.getText());
	}

	public void focusTextfielMenu(JTextField text, String info) {
		text.setText(info);
		text.addFocusListener(new FocusListener() { // Efface le contenu quand on clique sur le textfield
			@Override
			public void focusGained(FocusEvent arg0) {
				if (text.getText().equals(info)) {
					text.setText("");
				}
			}

			public void focusLost(FocusEvent arg0) {
				if (text.getText().equals("")) {
					text.setText(info);
				}
			}
		});
	}

	public int getAnnee() {
		return Integer.parseInt(textfieldAnnee.getText());
	}

	public void addCompEntreeListener(ActionListener listenForvalidButton) {
		creerComp.addActionListener(listenForvalidButton);
	}

	public void addchoixEquipeListener(ActionListener listenForchoixEquipe) {
		choixEquipeButton.addActionListener(listenForchoixEquipe);
	}
	public void addChargerCompListener(ActionListener listenForChargerComp){
		buttonChargerCompetition.addActionListener (listenForChargerComp);
	}
	public void addRetourListBlistener(ActionListener listenForRetourButtonB){
		buttonRetourListMatchB.addActionListener(listenForRetourButtonB);
	}
	public void addRetourListener(ActionListener listenForRetourButton) {
		// buttonRetourListMatch.addActionListener(listenForRetourButton);
	}
	public void addRetourListlistener(ActionListener listenForRetourButton){
		buttonRetourListMatch.addActionListener(listenForRetourButton);
	}
	public void addClassementListener(ActionListener listenclassement){
		btnClassementP.addActionListener(listenclassement);
	}
	public void addModifScoreListener(ActionListener listenModifScore){
			btnModifierScore.addActionListener(listenModifScore);
		}
	public void addAfficherStatListener(ActionListener listenStat){
		buttonAfficherStats.addActionListener(listenStat);
	}
	public void retourListMatch() {
		stat.setText("");
		card.show(c, "listMatch");
	}

	// MÉTHODES SET
	public void setNomCompetition(String nomComp) { // Renommer ; permet de récupérer le nom de la competition depuis la
													// class etc.
		labelNomCompetition.setText("<html><h2>" + nomComp + "</h2></html>");
	}

	public void setNbEquipes(int nbEquipes) {
		labelNbEquipes.setText(String.valueOf(nbEquipes));
	}

	public void setDateStart(String dateStart) {
		labelDateStart.setText(dateStart);
	}

	public void goChoixEquipe() {
		card.show(c, "choixEquipe");
		choixEquipeButton.requestFocus();
	}

	public void goListMatch() {
		card.show(c, "listMatch");
	}

	public void afficherErreur(Exception erreur) {
		JOptionPane.showMessageDialog(null, erreur);
	}

	// BOUTONS CLIQUABLES DANS LA JTABLE DES MATCHS
	// BUTTON RENDERER CLASS
	class ButtonRenderer extends JButton implements TableCellRenderer {
		// CONSTRUCTOR
		public ButtonRenderer() {
			// SET BUTTON PROPERTIES
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused,
				int row, int col) {
			// SET PASSED OBJECT AS BUTTON TEXT
			setText((obj == null) ? "" : obj.toString());
			return this;
		}
	}

	// BUTTON EDITOR CLASS
	class ButtonEditor extends DefaultCellEditor {
		protected JButton btn;
		private String lbl;
		private Boolean clicked;

		public ButtonEditor(JTextField txt) {
			super(txt);
			btn = new JButton();
			btn.setOpaque(true);
			// WHEN BUTTON IS CLICKED
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}

		// OVERRIDE A COUPLE OF METHODS
		@Override
		public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {
			// SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
			lbl = (obj == null) ? "" : obj.toString();
			btn.setText(lbl);
			clicked = true;
			return btn;
		}

		// IF BUTTON CELL VALUE CHANGES,IF CLICKED THAT IS
		@Override
		public Object getCellEditorValue() {
			if (clicked) {
				// CLIC SUR DETAILS
				if (lbl.matches(".*\\d.*")) {
					Match matchTemp = new Match();
					matchTemp = comp.matchs.get(Integer.parseInt(lbl));
					String infoMatch = "<html><h1>" + matchTemp.equipe1.nomEquipe + " - " + matchTemp.equipe2.nomEquipe
							+ "</h1><h2>Score : " + matchTemp.scoreEquipe1 + " - " + matchTemp.scoreEquipe2
							+ "</h2><p><strong>Date : </strong>" + matchTemp.afficherDate(comp.jDebut,comp.mDebut,comp.aDebut) + "</p></html>";
					labelStatsMatch.setText(infoMatch);
					labelNumeroTour.setText(""+matchTemp.tour);
					// AfficherDetailMatch(infoMatch);


					/// ADD textfield et bouton valider
					//txtModifierScore.setPreferredSize(new Dimension(50,10));
					//c.add("detailsEquipe", txtModifierScore);
					//buttonAfficherStats.setText("Modifier score");
					card.show(c, "detailsMatch");
				} else {
					Equipes equipeTemp = new Equipes();
					equipeTemp = comp.equipeDe(lbl);
					String infoEquipe = "<html><h2> </h2><p>Coach : " + equipeTemp.nomCoach
							+ "</p><p>" + equipeTemp.nombreJoueurs + " joueurs</p><p>" + equipeTemp.points
							+ " points</p></html>";
					// Afficher combobox boxEquipe
					labelStatEquipe.setText(infoEquipe);
					AfficherDetailEquipe(equipeTemp.nomEquipe);
					card.show(c, "detailsEquipe");
				}
			}
			// Retour à false sur clic
			clicked = false;
			return new String(lbl);
		}

		@Override
		public boolean stopCellEditing() {
			// Mettre Clicked sur false en premier
			clicked = false;
			return super.stopCellEditing();
		}

		@Override
		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}
}