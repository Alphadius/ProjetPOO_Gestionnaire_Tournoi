import java.util.Vector;
import java.util.Scanner;

public class Match {

  int score;

  int tour;

  public Vector myMatch;
  public Vector myMatch;
  /**
   * 
   * @element-type Equipe
   */
  public Vector confronte;public Arbitre 1.1;public Vector 22. n;
  public Vector myCompetition;
  public Competition myCompetition;public Vector 1.1;
  public Vector myEquipe;
  public Vector joue;
  /**
   * 
   * @element-type Equipe
   */
  public Vector confronte;
  public Arbitre arbitre;
  public Vector myCompetition;
  public Competition participe;
  /**
   * 
   * @element-type Participation
   */
  public Vector valide;

  public void afficherScore(String equipe1, String equipe2) {
    System.out.println(score);
  }*/

  public void creationDateDebut() { // demande a lutilisateur de rentrer la date de debut de la compete
    Scanner reader = new Scanner(System.in);
    System.out.println("Veuillez saisir le jour de debut de la competition:");
    int jDebut = reader.nextInt();
    System.out.println("Veuillez saisir le mois de debut de la competition:");
    int mDebut = reader.nextInt();
    System.out.println("Veuillez saisir l'annee de debut de la competition:");
    int aDebut = reader.nextInt();

    System.out.println("la date du debut de la competition est :" + jDebut + "/" + mDebut + "/" + aDebut);
  }

  public void afficherDate(int tour) { // permet de calculer la date d'un match
    int i = tour;
    int dateMatchActuel = jDebut + tour;
    boolean aBisextil = (((aDebut % 100 == 0) || (aDebut % 4 == 0)) && (aDebut % 400 != 0));
    int maxjour = 30;
    int jourAnnee = 365;

    while (i >= 0) {
      if ((mDebut == 1) || (mDebut == 3) || (mDebut == 5) || (mDebut == 7) || (mDebut == 8) || (mDebut == 10)
          || (mDebut == 12)) {
        maxjour = 31;
      } else if ((mDebut == 2) && aBisextil) {
        maxjour = 29;
        jourAnnee = 366;
      } else if ((mDebut == 2) && !aBisextil)
        maxjour = 28;
      if (i > jourAnnee) {
        i -= jourAnnee;
        aDebut++;
      } else if (i > maxjour) {
        i -= maxjour;
        mDebut++;
      } else {
        i -= i;
        jDebut += i;
      }
    }
    System.out.println("la date du match est :" + jDebut + "/" + mDebut + "/" + aDebut);
  }
}