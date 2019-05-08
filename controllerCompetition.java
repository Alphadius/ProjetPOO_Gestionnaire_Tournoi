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
public class controllerCompetition{
	private ViewCompetition theView;
	private Competition theModel;
	private Competition origin;

	public controllerCompetition(ViewCompetition theView, Competition theModel,Competition origin){
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
	}

	class ValidListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			String compName = "";
			int nbEquipe = 0;
			try{
				if (theView.getNomCompetition().isEmpty()){
  					throw new Exception("Entrer un nom pour votre competition");
				}
				compName = theView.getNomCompetition();
				nbEquipe = theView.getNbEquipes();
				theView.comp = theModel;
				theView.origin = origin;
				theModel.putCompName(compName);
				theModel.putNbEquipe(nbEquipe);
				theModel.putDate( theView.getJour(), theView.getMois(), theView.getAnnee());
				//theView.setNomCompetition("<html> nom Competition : "+theModel.compName() + "<BR> Date début : " + theModel.sendDateStart()+"<BR> NombreEquipe : "+theModel.sendNbEquipe()+"</html>");
				
				////**** Séparation des différentes variables/attributs à réutiliser dans la vue
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
						JOptionPane.showMessageDialog(null, "Vous avez selectionné " + theModel.sendNbEquipe() + " Equipes");
					}
				}
			});
			theView.choixEquipePanel.add(buttonTemp, theView.gbc);
		}
		theView.gbc(4, 1, 1, 3);
		theView.choixEquipePanel.add(theView.choixEquipeButton);

				theView.goChoixEquipe();
				
			} catch(Exception erreur) {
				theView.afficherErreur(erreur);
			}
		}
	}
	class choixEquipeListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			theModel.CombiMatch(theView.getNbEquipes());
			sendMatch();
			theModel.trierParEquipe();
			System.out.println(theModel.equipeDe("france").JoueursInEquipe.size());
			theView.goListMatch();
		}
	}
class listenModifScore implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				int a , b;
				Match temp= new Match();
				temp =theModel.matchs.get(Integer.valueOf(theView.labelNumeroTour.getText()));
				a= Integer.valueOf(theView.txtModifierScore1.getText());
				b= Integer.valueOf(theView.txtModifierScore2.getText());
				temp.putScore(a,b);
				String infoMatch = "<html><h1>" + temp.equipe1.nomEquipe + " - " + temp.equipe2.nomEquipe
				+ "</h1><h2>Score : " + temp.scoreEquipe1 + " - " + temp.scoreEquipe2
				+ "</h2><p><strong>Date : </strong>" + temp.afficherDate(theModel.jDebut, theModel.mDebut, theModel.aDebut) + "</p></html>";
				theView.labelStatsMatch.setText(infoMatch);
				//refresh jlabel
			}
		}
		class listenStat implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Joueur temp = new Joueur();
				temp = theModel.equipeDe(theView.labelnomEquipe.getText()).JoueursInEquipe.get(theView.boxEquipe.getSelectedIndex());
				theView.stat.setText("<html>"+temp.stat()+"</html>");
			}

		}
	class listenForRetourButtonB implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				// Refresh table data et score
				sendMatch();
				theView.table.repaint();
				theView.txtModifierScore1.setText("");
				theView.txtModifierScore2.setText("");
				theView.card.show(theView.c, "listMatch");
			}
		}

	class listenForretourlist implements ActionListener{
		public void actionPerformed(ActionEvent e) {		
			sendMatch();
			theView.table.repaint();
			theView.card.show(theView.c, "listMatch");
		}
	}
	class listenForChargerComp implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				theView.card.show(theView.c, "loadCompetition");
			};
	}
	class RetourListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			String compName = "";
			int nbEquipe = 0;
			try{
				theView.retourListMatch();
			} catch(Exception erreur) {
				theView.afficherErreur(erreur);
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
			theView.data[i][5] = tempMatch.afficherDate(theModel.jDebut,theModel.mDebut,theModel.aDebut);
			theView.data[i][6] = i;
		}
	}
}