public class Match {

  int scoreEquipe1;
  int scoreEquipe2;
  Equipes equipe1;
  Equipes equipe2;
  int tour = 0;
  boolean aEuLieux = false;

  public Match() {
    this.equipe1 = null;
    this.equipe2 = null;
  }

  public Match(Equipes equipe1, Equipes equipe2) {
    this.equipe1 = equipe1;
    this.equipe2 = equipe2;
  }

  public void afficherScore(int a, int b) {
    //System.out.println(this.scoreEquipe1 + " - " + this.scoreEquipe2);
    this.scoreEquipe1 = a; 
    this.scoreEquipe2 = b;
  }

  public String afficherDate(Competition comp) { // permet de calculer la date d'un match
    int jourTemp = comp.jDebut;
    int moisTemp = comp.mDebut;
    int anneeTemp = comp.aDebut;
    int i = this.tour + comp.jDebut;
    int maxjour = 30;
    int jourAnnee = 365;
    // System.out.println(i);
    while (i > 0) {
      boolean aBisextil = (((anneeTemp % 100 == 0) || (anneeTemp % 4 == 0)) && (anneeTemp % 400 != 0));
      if (aBisextil) {
        jourAnnee = 366;
      } else {
        jourAnnee = 365;
      }
      if ((moisTemp == 1) || (moisTemp == 3) || (moisTemp == 5) || (moisTemp == 7) || (moisTemp == 8)
          || (moisTemp == 10) || (moisTemp == 12)) {
        maxjour = 31;
      } else if ((moisTemp == 2) && aBisextil) {
        maxjour = 29;
      } else if ((moisTemp == 2) && !aBisextil) {
        maxjour = 28;
        jourAnnee = 365;
      }
      if (i > jourAnnee) {
        i -= jourAnnee;
        anneeTemp++;
        // System.out.println("annee " + anneeTemp + " " + i + "-" + jourAnnee + "c'est
        // une annee" + aBisextil);
      } else if (i > maxjour) {
        // System.out.println("mois " + moisTemp + " : " + i + " " + maxjour);
        i -= maxjour;
        moisTemp = ((moisTemp) % 12) + 1;
        if (moisTemp == 1) {
          anneeTemp++;
        }
      } else {
        jourTemp = i;
        // System.out.println("jour " + jourTemp + " : " + i);
        i -= i;
      }
    }
    // System.out.println("la date du match est :" + jourTemp + "/" + moisTemp + "/"
    // + anneeTemp);
    return (jourTemp + "/" + moisTemp + "/" + anneeTemp);
  }
}