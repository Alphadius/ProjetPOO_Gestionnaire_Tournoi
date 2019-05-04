import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ViewCompetition extends JFrame {
	CardLayout card;
	Container c;

	// Elements divers de panels
	public JTextField textfieldNomCompetition = new JTextField(20);
	public JTextField textfieldNbEquipes = new JTextField(20);
	public JTextField textfieldJour = new JTextField(1);
	public JTextField textfieldMois = new JTextField(1);
	public JTextField textfieldAnnee = new JTextField(1);
	public JLabel labelNomCompetition = new JLabel();
	public JLabel labelNbEquipes = new JLabel();
	public JLabel labelDateStart = new JLabel();
	public JLabel labelnomEquipe = new JLabel();
	private JButton creerComp = new JButton("Créer");

	// test bouton dans JTable
	private JButton boutonDetailsEquipe = new JButton();

	//Tableau choixEquipe
	Object[][] data = {
		{"France","Détails France", "Brésil", "Détails Brésil", "7 - 0", "Détails match"},
	};
	String columnHeaders[] = {"Équipe 1", "", "Équipe 2", "", "Score", ""};
	public JTable table = new JTable(data, columnHeaders);


//////////
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
 		// PANEL N°2 : AFFICHAGE DES MATCHS
 		//////////////////////////
 		JPanel choixEquipePanel = new JPanel(new BorderLayout()); // Panel pour le label
 		JPanel choixEquipeTablePanel = new JPanel(new BorderLayout()); // Panel pour le tableau
 		choixEquipePanel.setLayout(new GridBagLayout());

 		/*gbc.weightx = 1;
 		gbc.weighty = 1;*/
 		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbc.gridy = 0;
 		choixEquipePanel.add(labelNomCompetition, gbc);

 		// IMPORTATION DU TABLEAU JTABLE DES EQUIPES
 		// Render des boutons cliquables de la table
 		table.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());;
		table.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JTextField()));

		table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());;
		table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JTextField()));

		table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());;
		table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));

		choixEquipeTablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
		choixEquipeTablePanel.add(table);
		////
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbc.gridy = 2;
		choixEquipePanel.add(choixEquipeTablePanel, gbc);
 		//REMPLIR LE CHOIX DES EQUIPES INTERFACE
 		c.add("choixEquipe", choixEquipePanel);


 		// ACTION DU BOUTON START DE LA PREMIERE PAGE
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(c, "competition");
			}
		});

		//////////////////////////
 		// PANEL N°3 : DETAILS DE EQUIPES
 		//////////////////////////
 		JPanel detailsEquipePanel = new JPanel(new BorderLayout());
 		detailsEquipePanel.add(labelnomEquipe);
 		c.add("detailsEquipe", detailsEquipePanel);



	}
	
	// Méthodes qui récupèrent les données des textfields
	public String getNomCompetition() {
		return textfieldNomCompetition.getText();
	}
	public void writeEquipeName(String dutext){
		labelnomEquipe.setText(dutext) ;
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
		labelNomCompetition.setText("<html><h2>" + nomComp + "</h2></html>");
	}

	public void setNbEquipes(int nbEquipes) {
		labelNbEquipes.setText(String.valueOf(nbEquipes));
	}

	public void setDateStart(String dateStart) {
		labelDateStart.setText(dateStart);
	}

	public void goChoixEquipe(){
			card.show(c, "choixEquipe");
	}
	public void afficherErreur(Exception erreur){
		JOptionPane.showMessageDialog(null,erreur);
	}


	// BOUTONS CLIQUABLES DANS LA JTABLE DES MATCHS
	//BUTTON RENDERER CLASS
	class ButtonRenderer extends JButton implements  TableCellRenderer {
		//CONSTRUCTOR
		public ButtonRenderer() {
			//SET BUTTON PROPERTIES
			setOpaque(true);
		}
		@Override
		public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int col) {
			//SET PASSED OBJECT AS BUTTON TEXT
			setText((obj==null) ? "":obj.toString());
			return this;
		}
		}
		//BUTTON EDITOR CLASS
		class ButtonEditor extends DefaultCellEditor {
			protected JButton btn;
			private String lbl;
			private Boolean clicked;
			public ButtonEditor(JTextField txt) {
			super(txt);
			btn=new JButton();
			btn.setOpaque(true);
			//WHEN BUTTON IS CLICKED
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}
		//OVERRIDE A COUPLE OF METHODS
		@Override
		public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {
			//SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
			lbl=(obj==null) ? "":obj.toString();
			btn.setText(lbl);
			clicked=true;
			return btn;
		}
		//IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
		@Override
		public Object getCellEditorValue() {
			if(clicked) {
				//SHOW US SOME MESSAGE
				//JOptionPane.showMessageDialog(btn, lbl+" Clicked");
				writeEquipeName(lbl);
				card.show(c, "detailsEquipe");
			}
		//SET IT TO FALSE NOW THAT ITS CLICKED
			clicked=false;
			return new String(lbl);
		}
		@Override
		public boolean stopCellEditing() {
			//SET CLICKED TO FALSE FIRST
			clicked=false;
			return super.stopCellEditing();
		}
		@Override
		protected void fireEditingStopped() {
			// TODO Auto-generated method stub
			super.fireEditingStopped();
		}
	}


}