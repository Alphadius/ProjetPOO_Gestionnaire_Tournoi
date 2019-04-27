import java.util.Vector;
import java.util.Scanner;

public class Match {

  int scoreEquipe1;
  int scoreEquipe2;
  Equipes equipe1;
  Equipes equipe2;
  int tour = 0;



public Match(){
  this.equipe1 = null;
  this.equipe2 = null;
}

public Match(Equipes equipe1, Equipes equipe2){
  this.equipe1 = equipe1;
  this.equipe2 = equipe2;
}
  /*public Vector myMatch;
  public Vector myMatch;
  /**
   * 
   * @element-type Equipe
   *
  public Vector confronte;public Arbitre 1.1;
  public Vector 22. n;
  public Vector myCompetition;
  public Competition myCompetition;public Vector 1.1;
  public Vector myEquipe;
  public Vector joue;
  /**
   * 
   * @element-type Equipe
   *
  public Vector confronte;
  public Arbitre arbitre;
  public Vector myCompetition;
  public Competition participe;
  /**
   * 
   * @element-type Participation
   *
  public Vector valide;*/

  public void afficherScore() {
    System.out.println(this.scoreEquipe1 + " - " + this.scoreEquipe2);
  }

  public void afficherDate(int tour, Competition comp) { // permet de calculer la date d'un match
    int i = tour + comp.jDebut;
    int maxjour = 30;
    int jourAnnee = 365;
  //  System.out.println(i);
    while (i > 0) {
      System.out.println(i);
      boolean aBisextil = (((comp.aDebut % 100 == 0) || (comp.aDebut % 4 == 0)) && (comp.aDebut % 400 != 0));
      if (aBisextil) {
        jourAnnee = 366;
      } else {
        jourAnnee = 365;
      }
      if ((comp.mDebut == 1) || (comp.mDebut == 3) || (comp.mDebut == 5) || (comp.mDebut == 7) || (comp.mDebut == 8) || (comp.mDebut == 10)
          || (comp.mDebut == 12)) {
        maxjour = 31;
      } else if ((comp.mDebut == 2) && aBisextil) {
        maxjour = 29;
      } else if ((comp.mDebut == 2) && !aBisextil) {
        maxjour = 28;
        jourAnnee = 365;
      }
      if (i > jourAnnee) {
        i -= jourAnnee;
        comp.aDebut++;
        System.out.println("annee " + comp.aDebut + " " + i + "-" + jourAnnee + "c'est une annee" + aBisextil);
      } else if (i > maxjour) {
        System.out.println("mois " + comp.mDebut + " : " + i + " " + maxjour);
        i -= maxjour;
        comp.mDebut = ((comp.mDebut) % 12) + 1;
        if (comp.mDebut == 1) {
          comp.aDebut++;
        }
      } else {
        comp.jDebut = i;
        System.out.println("jour " + comp.jDebut + " : " + i);
        i -= i;
      }
    }
    System.out.println("la date du match est :" + comp.jDebut + "/" + comp.mDebut + "/" + comp.aDebut);
  }
}