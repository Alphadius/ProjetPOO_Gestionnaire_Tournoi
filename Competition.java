import java.util.*;

public class Competition {

  String NomCompetiton;

  int NombreEquipes;

  int dateDeDebut;
  // public Vector myMatch;public Match 1. n;public Vector 1. n;
  // public Vector myMatch;
  // /**
  //  * 
  //  * @element-type Match
  //  */
  // public Vector participe;

  public void afficherMatchAll() {

  }

  public void afficherMatchSpe() {
  }

  public void creationEquipe() {
  }
  
  // public void creationCompetition() {

      public static void main(String[] args) {
        List<Equipes> equipes = new ArrayList<Equipes>();
    int nbEquipes = 0;

    // list<Match> matchs = new ArrayList<Match>();

    Scanner reader = new Scanner(System.in);
    System.out.println("Quel est le nombre d'equipes ?");
    nbEquipes = reader.nextInt();
    String tab[] = new String[nbEquipes];
    for (int i = 0; i < nbEquipes; i++) {
      Scanner lire = new Scanner(System.in);
      System.out.println("Choisisez le nom de l'Equipe numero " + (i + 1));
      // tab[i] = lire.nextLine();
      Equipes equipe1 = new Equipes(lire.nextLine());
      equipes.add(equipe1);
    }
    //if nombre equipe paire
    int tour = 0;
    int nbcombi = ((nbEquipes*nbEquipes)-nbEquipes)/2;
    String tableautri[] = new String[nbcombi+2];
    //diag 1
    for (int i = 0; i < (nbEquipes/2); i++) {
        tableautri[i] = equipes.get(i*2).nomEquipe + " - " + equipes.get((i*2)+1).nomEquipe;
        if((i*2)+2 < nbEquipes){
        tableautri[i+(nbEquipes/2)] = equipes.get((i*2)+1).nomEquipe + " - " + equipes.get((i*2)+2).nomEquipe;
      }
    }
    //reste
    int sum = 0;
    for(int i = 2; i < nbEquipes; i++){
      for (int j = 0; j <= nbEquipes; j++) {
        if( i+j < nbEquipes){
          Match match1 = new Match();
          match1.equipe1 = equipes.get(j);
          match1.equipe2 = equipes.get(j + i);
          tableautri[nbEquipes + sum - 1] = match1.equipe1.nomEquipe + " - " + match1.equipe2.nomEquipe;
          if((j == (nbEquipes/2)&& i+j == nbEquipes-1  && nbEquipes%2 == 0) || (j == 1 && i+j == nbEquipes-1)){
            tableautri[nbEquipes + sum] = "pause";
            sum++;
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
