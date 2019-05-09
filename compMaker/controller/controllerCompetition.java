package compMaker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.io.*;
import compMaker.view.ViewCompetition;
import compMaker.model.*;

public class controllerCompetition {
	private ViewCompetition theView;
	private Competition theModel;
	private Competition origin;

	public controllerCompetition(ViewCompetition theView, Competition theModel, Competition origin) {
		this.theView = theView;
		this.theModel = theModel;
		this.origin = origin;

		this.theView.addCompEntreeListener(new ValidListener());
		this.theView.addRetourListener(new RetourListener());
		this.theView.addchoixEquipeListener(new choixEquipeListener());
		this.theView.addChargerCompListener(new listenForChargerComp());
		this.theView.addRetourListlistener(new listenForretourlist());
		this.theView.addRetourListBlistener(new listenForRetourButtonB());
		this.theView.addModifScoreListener(new listenModifScore());
		this.theView.addAfficherStatListener(new listenStat());
		this.theView.addClassementListener(new listenclassement());
		this.theView.addloadcompListener(new listenload());
		this.theView.addSaveListener(new listensave());
		this.theView.addmatchAEuLieuListener(new listenMatchLieu());

	}

	class ValidListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String compName = "";
			int nbEquipe = 0;
			try {
				if (theView.getNomCompetition().isEmpty()) {
					throw new Exception("Entrer un nom pour votre competition");
				}
				compName = theView.getNomCompetition();
				nbEquipe = theView.getNbEquipes();
				theView.comp = theModel;
				theView.origin = origin;
				theModel.putCompName(compName);
				theModel.putNbEquipe(nbEquipe);
				theModel.putDate(theView.getJour(), theView.getMois(), theView.getAnnee());

				//// **** Séparation des différentes variables/attributs à réutiliser dans la
				//// vue
				theView.setNomCompetition(theModel.compName());
				theView.setNbEquipes(nbEquipe);
				theView.setDateStart(theModel.sendDateStart());
				for (int i = 0; i < 16; i++) {
					int a = i % 4;
					int b = i / 4;
					JButton buttonTemp = new JButton(origin.equipes.get(i).nomEquipe);
					theView.gbc(a, 1, 1, b);
					buttonTemp.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Color actualcolor = buttonTemp.getBackground();
							if (actualcolor.equals(Color.GREEN)) {
								theView.countFlag--;
								for (int i = 0; i < theModel.equipes.size(); i++) {
									if (theModel.equipes.get(i).nomEquipe == buttonTemp.getText()) {
										theModel.equipes.remove(i);
									}
								}
								buttonTemp.setBackground(new JButton().getBackground());
								buttonTemp.setOpaque(true);
							} else {
								theView.countFlag++;
								theModel.equipes.add(origin.equipeDe(buttonTemp.getText()));
								buttonTemp.setBackground(Color.GREEN);
							}
							if (theView.countFlag == theModel.sendNbEquipe()) {
								JOptionPane.showMessageDialog(null,
										"Vous avez selectionné " + theModel.sendNbEquipe() + " Equipes");
							}
						}
					});
					theView.choixEquipePanel.add(buttonTemp, theView.gbc);
				}
				theView.gbc(4, 1, 1, 3);
				theView.choixEquipePanel.add(theView.choixEquipeButton);
				theModel.coachParEquipe();
				for (int i = 0; i < theModel.equipes.size(); i++) {
				}
				theView.goChoixEquipe();

			} catch (Exception erreur) {
				theView.afficherErreur(erreur);
			}
		}
	}

	class choixEquipeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			theModel.CombiMatch(theView.getNbEquipes());
			sendMatch();
			theModel.trierParEquipe();
			theView.btnClassement.requestFocus();
			theModel.coachParEquipe();
			theView.goListMatch();
		}
	}

	class listensave implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			theModel.writeDataJoueur("data/" + theModel.nomCompetition);
			theModel.writeDataEquipe("data/" + theModel.nomCompetition);
			theModel.writeDataMatch("data/" + theModel.nomCompetition);
		}
	}

	class listenModifScore implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int a, b;
			Match temp = new Match();
			temp = theModel.matchs.get(Integer.valueOf(theView.labelNumeroTour.getText()));
			a = Integer.valueOf(theView.txtModifierScore1.getText());
			b = Integer.valueOf(theView.txtModifierScore2.getText());
			temp.putScore(a, b);
			String infoMatch = "<html><h1>" + temp.equipe1.nomEquipe + " - " + temp.equipe2.nomEquipe
					+ "</h1><h2>Score : " + temp.scoreEquipe1 + " - " + temp.scoreEquipe2
					+ "</h2><p><strong>Date : </strong>"
					+ temp.afficherDate(theModel.jDebut, theModel.mDebut, theModel.aDebut) + "</p></html>";
			theView.labelStatsMatch.setText(infoMatch);
			// refresh jlabel
		}
	}

	class listenload implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			theView.comp = theModel;
			String filename = theView.txtLoadCompetition.getText();
			theModel.getDataJoueur("data/" + filename + "Joueur");
			theModel.getDataEquipe("data/" + filename + "Equipe");
			theModel.coachParEquipe();
			theModel.trierParEquipe();
			theModel.getDataMatch("data/" + filename + "Match", origin);
			theModel.nomCompetition = filename;
			sendMatch();
			theView.card.show(theView.c, "listMatch");
		}
	}

	class listenStat implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Joueur temp = new Joueur();
			temp = theModel.equipeDe(theView.labelnomEquipe.getText()).JoueursInEquipe
					.get(theView.boxEquipe.getSelectedIndex());
			theView.stat.setText("<html>" + temp.stat() + "</html>");
		}

	}

	class listenclassement implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			theModel.triEquipeParVictoire();

			JDialog d = new JDialog(theView, "classement");
			String classement = "";
			for (int i = 0; i < theModel.equipes.size(); i++) {
				classement = classement + theModel.triEquipeParVictoire()[i] + "<BR>";
			}
			d.add(new JLabel("<html>" + classement + "</html>"));
			d.setSize(1000, 1000);
			d.setVisible(true);
		}
	}

	class listenForRetourButtonB implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// Refresh table data et score
			sendMatch();
			theView.table.repaint();
			theView.txtModifierScore1.setText("");
			theView.txtModifierScore2.setText("");
			theView.card.show(theView.c, "listMatch");
		}
	}

	class listenForretourlist implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			sendMatch();
			theView.table.repaint();
			theView.card.show(theView.c, "listMatch");
		}
	}

	class listenForChargerComp implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			theView.card.show(theView.c, "loadCompetition");
		};
	}

	class RetourListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String compName = "";
			int nbEquipe = 0;
			try {
				theView.retourListMatch();
			} catch (Exception erreur) {
				theView.afficherErreur(erreur);
			}
		}
	}

	class listenMatchLieu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int num = Integer.valueOf(theView.numMatch.getText());
			boolean etat = theModel.matchs.get(num).aEuLieux;
			if (etat) {
				theModel.matchs.get(num).aEuLieux = false;
			} else {
				theModel.matchs.get(num).aEuLieux = true;
			}
			if (theModel.matchs.get(num).aEuLieux) {
				theView.labelMatchAEulieu.setText("Ce match a eu lieu !");
			} else {
				theView.labelMatchAEulieu.setText("Ce match n'a pas eu lieu !");
			}
		}
	}

	public void sendMatch() {
		for (int i = 0; i < theModel.matchs.size(); i++) {
			Match tempMatch = new Match();
			tempMatch = theModel.sendMatch(i);
			theView.data[i][0] = tempMatch.equipe1.nomEquipe;
			theView.data[i][1] = tempMatch.equipe1.nomEquipe;
			theView.data[i][2] = tempMatch.equipe2.nomEquipe;
			theView.data[i][3] = tempMatch.equipe2.nomEquipe;
			theView.data[i][4] = tempMatch.scoreEquipe1 + " - " + tempMatch.scoreEquipe2;
			tempMatch.tour = i;
			theView.data[i][5] = tempMatch.afficherDate(theModel.jDebut, theModel.mDebut, theModel.aDebut);
			theView.data[i][6] = i;
		}
	}
}