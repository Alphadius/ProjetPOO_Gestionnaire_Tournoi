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

  public static int jDebut = 0;
  public static int mDebut = 0;
  public static int aDebut = 0;
  public static int tour = 0;

  public void creationDateDebut() { // demande a lutilisateur de rentrer la date de debut de la compete
    Scanner reader = new Scanner(System.in);
    System.out.println("Veuillez saisir le jour de debut de la competition:");
    jDebut = reader.nextInt();
    System.out.println("Veuillez saisir le mois de debut de la competition:");
    mDebut = reader.nextInt();
    System.out.println("Veuillez saisir l'annee de debut de la competition:");
    aDebut = reader.nextInt();

    System.out.println("la date du debut de la competition est :" + jDebut + "/" + mDebut + "/" + aDebut);
    System.out.println("le match est a quel tour?");
    tour = reader.nextInt();
    afficherDate(tour);
  }

  public static void afficherDate(int tour) { // permet de calculer la date d'un match
    int i = tour + jDebut;
    int maxjour = 30;
    int jourAnnee = 365;
    System.out.println(i);
    while (i > 0) {
      System.out.println(i);
      boolean aBisextil = (((aDebut % 100 == 0) || (aDebut % 4 == 0)) && (aDebut % 400 != 0));
      if (aBisextil) {
        jourAnnee = 366;
      } else {
        jourAnnee = 335;
      }
      if ((mDebut == 1) || (mDebut == 3) || (mDebut == 5) || (mDebut == 7) || (mDebut == 8) || (mDebut == 10)
          || (mDebut == 12)) {
        maxjour = 31;
      } else if ((mDebut == 2) && aBisextil) {
        maxjour = 29;
      } else if ((mDebut == 2) && !aBisextil) {
        maxjour = 28;
        jourAnnee = 365;
      }
      if (i > jourAnnee) {
        i -= jourAnnee;
        aDebut++;
        System.out.println("annee " + aDebut + " " + i + "-" + jourAnnee + "c'est une annee" + aBisextil);
      } else if (i > maxjour) {
        System.out.println("mois " + mDebut + " : " + i + " " + maxjour);
        i -= maxjour;
        mDebut = ((mDebut) % 12) + 1;
        if (mDebut == 1) {
          aDebut++;
        }
      } else {
        jDebut = i;
        System.out.println("jour " + jDebut + " : " + i);
        i -= i;
      }
    }
    System.out.println("la date du match est :" + jDebut + "/" + mDebut + "/" + aDebut);
  }
}}