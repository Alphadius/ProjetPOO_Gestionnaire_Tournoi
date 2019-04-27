import java.util.*;

public class Competition {

  List<Equipes> equipes = new ArrayList<Equipes>();
  List<Match> matchs = new ArrayList<Match>();

  String NomCompetiton;

  int NombreEquipes;

  //int dateDeDebut;

  int jDebut = 0;
  int mDebut = 0;
  int aDebut = 0;
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
  //   public void creationDateDebut() { // demande a lutilisateur de rentrer la date de debut de la compete

  // }
  
  // public void creationCompetition() {
      public void InitCompetition() {

            Scanner reader = new Scanner(System.in);
    System.out.println("Veuillez saisir le jour de debut de la competition:");
    this.jDebut = reader.nextInt();
    System.out.println("Veuillez saisir le mois de debut de la competition:");
    this.mDebut = reader.nextInt();
    System.out.println("Veuillez saisir l'annee de debut de la competition:");
    this.aDebut = reader.nextInt();

    System.out.println("la date du debut de la competition est :" + this.jDebut + "/" + this.mDebut + "/" + this.aDebut);
    // System.out.println("le match est a quel tour?");
    // int tourMatch = reader.nextInt();
    // afficherDate(tourMatch, this);
    int nbEquipes = 0;

    // list<Match> matchs = new ArrayList<Match>();
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
    Equipes tableautri[][] = new Equipes[nbcombi+2][2];
    //diag 1
    for (int i = 0; i < (nbEquipes/2); i++) {
        Match match = new Match();
        match.equipe1 = equipes.get(i*2);
        match.equipe2 = equipes.get((i*2)+1);
        tableautri[i][0] = match.equipe1;
        tableautri[i][1] = match.equipe2;
        matchs.add(i,match);
        // System.out.println(i+" : "+tableautri[i][0].nomEquipe + " - " + tableautri[i][1].nomEquipe);
        if((i*2)+2 < nbEquipes){
          Match match0 = new Match();
          match0.equipe1 = equipes.get((i*2)+1);
          match0.equipe2 = equipes.get((i*2)+2);
          matchs.add(match0);
          tableautri[i+(nbEquipes/2)][0] = match0.equipe1;
          tableautri[i+(nbEquipes/2)][1] = match0.equipe2;
          // System.out.println(i+(nbEquipes/2)+" : "+tableautri[i+(nbEquipes/2)][0].nomEquipe + " - "+tableautri[i+(nbEquipes/2)][1].nomEquipe);
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
          matchs.add(match1);
          tableautri[nbEquipes + sum - 1][0] = match1.equipe1;
          tableautri[nbEquipes + sum - 1][1] = match1.equipe2;
          // System.out.println(nbEquipes + sum - 1+" : "+tableautri[nbEquipes + sum - 1][0].nomEquipe + " - " + tableautri[nbEquipes + sum - 1][1].nomEquipe);
          if((j == (nbEquipes/2)&& i+j == nbEquipes-1  && nbEquipes%2 == 0) || (j == 1 && i+j == nbEquipes-1)){
            Match pause = new Match();
          pause.equipe1 = new Equipes();
          pause.equipe2 = new Equipes();
            tableautri[nbEquipes + sum][0] = pause.equipe1;
            tableautri[nbEquipes + sum][1] = pause.equipe2;
            matchs.add(pause);
            sum++;
          }
          sum++;
        }
      }
    }
    int odd = 2;
    if(nbEquipes%2 == 1 || nbEquipes < 5){
      odd = 1;
    }
    for (int i = 0; i <  nbcombi+odd; i++) {
      //transfert dans la liste des matchs toutes les Equipes
    matchs.get(i).equipe1 = tableautri[i][0];
    matchs.get(i).equipe2 = tableautri[i][1];
    System.out.println(i + "** id : " + matchs.get(i));
    System.out.println(matchs.get(i).equipe1.nomEquipe + " - " + matchs.get(i).equipe2.nomEquipe);
    }
  }
}
