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

    list<Match> matchs = new ArrayList<Match>();

    Scanner reader = new Scanner(System.in);
    System.out.println("Quel est le nombre d'equipes ?");
    nbEquipes = reader.nextInt();
    String tab[] = new String[nbEquipes];
    for (int i = 0; i < nbEquipes; i++) {
      Scanner lire = new Scanner(System.in);
      System.out.println("Choisisez le nom de l'Equipe numero " + (i + 1));
      tab[i] = lire.nextLine();
    }
    //if nombre equipe paire
    int tour = 0;
    int nbcombi = ((nbEquipes*nbEquipes)-nbEquipes)/2;
    String tableautri[] = new String[nbcombi+2];
    //diag 1
    for (int i = 0; i < (nbEquipes/2); i++) {
        tableautri[i] = tab[i*2] + " - " + tab[(i*2)+1];
        if((i*2)+2 < nbEquipes){
        tableautri[i+(nbEquipes/2)] = tab[(i*2)+1] + " - " + tab[(i*2)+2];
      }
    }
    //reste
    int sum = 0;
    for(int i = 2; i < nbEquipes; i++){
      for (int j = 0; j <= nbEquipes; j++) {
        if( i+j < nbEquipes){
          if((j == (nbEquipes/2) && i+j == nbEquipes-1 && nbEquipes%2 == 0) || (j == 1 && i+j == nbEquipes-1)){
            Match match1 = new Match();
            tableautri[nbEquipes + sum - 1] = tab[j] + " - " + tab[j + i];
            tableautri[nbEquipes + sum] = "pause";
            sum++;
          } else {
            tableautri[nbEquipes + sum - 1] = tab[j] + " - " + tab[j + i];
          }
          sum++;
        }
      }
    }
    for (int i = 0; i <  nbcombi+2; i++) {
    System.out.println(tableautri[i]);
    }
  }
}

}
