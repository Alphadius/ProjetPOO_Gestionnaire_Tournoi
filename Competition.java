import java.util.*;

public class Competition {

  String NomCompetiton;

  int NombreEquipes;

  int dateDeDebut;

  public Vector myMatch;public Match 1. n;public Vector 1. n;
  public Vector myMatch;
  /**
   * 
   * @element-type Match
   */
  public Vector participe;

  public void afficherMatchAll() {
  }

  public void afficherMatchSpe() {
  }

  public void creationEquipe() {
  }

  public void creationCompetition() {

  public static void main(String[] args) {
    int nbEquipes = 0;
    Scanner reader = new Scanner(System.in);
    System.out.println("Quel est le nombre d'equipes ?");
    nbEquipes = reader.nextInt();
    String tab[] = new String[nbEquipes];
    for (int i = 0; i < nbEquipes; i++) {
      Scanner lire = new Scanner(System.in);
      System.out.println("Choisisez le nom de l'Equipe numero " + (i + 1));
      tab[i] = lire.nextLine();
    }
    int tour = 0;
    for (int i = 0; i < nbEquipes; i++) {
      for (int j = 1; j < nbEquipes; j++) {
        if (i + j < nbEquipes) {
          String match = tab[i] + " - " + tab[i + j];
          System.out.println(match);
          tour++;
          System.out.println(tour);
        }
      }
    }
  }
}

}
