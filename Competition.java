import java.util.*;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Competition {

  List<Equipes> equipes = new ArrayList<Equipes>();
  List<Match> matchs = new ArrayList<Match>();
  List<Joueur> joueurs = new ArrayList<Joueur>();

  public String nomCompetition;

  int nombreEquipes;

  // int dateDeDebut;

  int jDebut = 0;
  int mDebut = 0;
  int aDebut = 0;
  // public Vector myMatch;public Match 1. n;public Vector 1. n;
  // public Vector myMatch;
  // /**
  // *
  // * @element-type Match
  // */
  // public Vector participe;

  public void putCompName(String nom) {

    nomCompetition = nom;

  }

  public Equipes equipeDe(String nomEquipe) {
    Equipes truc = new Equipes();
    for (int i = 0; i < this.equipes.size(); i++) {
      if (nomEquipe.toUpperCase().equals(this.equipes.get(i).nomEquipe.toUpperCase())) {
        truc = this.equipes.get(i);
      }
    }
    return truc;
  }

  public void trierParEquipe() {
    for (int i = 0; i < this.joueurs.size(); i++) {
      Equipes EquipeTemp = new Equipes();
      Joueur JoueurTemp = new Joueur();
      JoueurTemp = this.joueurs.get(i);
      EquipeTemp = equipeDe(JoueurTemp.equipe);
      EquipeTemp.JoueursInEquipe.add(JoueurTemp);
    }
  }

  public String compName() {

    return nomCompetition;
  }

  public void putNbEquipe(int nb) {
    nombreEquipes = nb;
  }

  public int sendNbEquipe() {
    return nombreEquipes;
  }

  public Match sendMatch(int num) {
    return matchs.get(num);
  }

  public void putDate(int j, int m, int a) {
    jDebut = j;
    mDebut = m;
    aDebut = a;
  }

  public String sendDateStart() {
    String date = "(" + jDebut + "/" + mDebut + "/" + aDebut + ")";
    return date;
  }

  public void afficherMatchAll() {

  }

  public void afficherMatchSpe() {
  }

  public void creationEquipe() {
  }
  // public void creationDateDebut() { // demande a lutilisateur de rentrer la
  // date de debut de la compete

  // }

  // public void creationCompetition() {
  public void CombiMatch(int nbEquipes) {

    // Scanner reader = new Scanner(System.in);
    // System.out.println("Veuillez saisir le jour de debut de la competition:");
    // this.jDebut = reader.nextInt();
    // System.out.println("Veuillez saisir le mois de debut de la competition:");
    // this.mDebut = reader.nextInt();
    // System.out.println("Veuillez saisir l'annee de debut de la competition:");
    // this.aDebut = reader.nextInt();

    // System.out.println("la date du debut de la competition est :" + this.jDebut +
    // "/" + this.mDebut + "/" + this.aDebut);
    // // System.out.println("le match est a quel tour?");
    // // int tourMatch = reader.nextInt();
    // //afficherDate(tourMatch, this);
    // int nbEquipes = nombreEquipes;
    // int tour = 0;
    // // list<Match> matchs = new ArrayList<Match>();
    // System.out.println("Quel est le nombre d'equipes ?");
    // nbEquipes = reader.nextInt();
    // for (int i = 0; i < nbEquipes; i++) {
    // Scanner lire = new Scanner(System.in);
    // System.out.println("Choisisez le nom de l'Equipe numero " + (i + 1));
    // Equipes equipe1 = new Equipes(lire.nextLine());
    // this.equipes.add(equipe1);
    // System.out.println(this.equipes.get(16+i).nomEquipe);
    // }
    // listmatchsimple
    // for (int i = 0; i < nbEquipes; i++) {
    // for (int j = 1; j < nbEquipes; j++) {
    // if (i + j < nbEquipes) {
    // System.out.println(equipes.get(i).nomEquipe + " - " +
    // equipes.get(i+j).nomEquipe);
    // Match match = new Match(equipes.get(i),equipes.get(i+j));
    // matchs.add(match);
    // tour++;
    // }
    // }
    // }
    // for(Match temp : matchs){
    // System.out.println(temp.equipe1.nomEquipe+ " - " +temp.equipe2.nomEquipe);
    // }
    // if nombre equipe paire
    int nbcombi = ((nbEquipes * nbEquipes) - nbEquipes) / 2;
    System.out.println("Avec " + nbEquipes + " équipes tu peux faire " + nbcombi + " match ");
    // diag 1
    for (int i = 0; i < (nbEquipes / 2); i++) {
      Match match = new Match();
      match.equipe1 = equipes.get(i * 2);
      match.equipe2 = equipes.get((i * 2) + 1);
      matchs.add(i, match);
      if ((i * 2) + 2 < nbEquipes) {
        Match match0 = new Match();
        match0.equipe1 = equipes.get((i * 2) + 1);
        match0.equipe2 = equipes.get((i * 2) + 2);
        matchs.add(match0);
      }
    }
    // reste
    int sum = 0;
    for (int i = 2; i < nbEquipes; i++) {
      for (int j = 0; j <= nbEquipes; j++) {
        if (i + j < nbEquipes) {
          Match match1 = new Match();
          match1.equipe1 = equipes.get(j);
          match1.equipe2 = equipes.get(j + i);
          matchs.add(match1);
          if ((j == (nbEquipes / 2) && i + j == nbEquipes - 1 && nbEquipes % 2 == 0)
              || (j == 1 && i + j == nbEquipes - 1)) {
            Match pause = new Match();
            pause.equipe1 = new Equipes();
            pause.equipe2 = new Equipes();
            matchs.add(pause);
            sum++;
          }
          sum++;
        }
      }
    }
    int odd = 2;
    if (nbEquipes % 2 == 1 || nbEquipes < 5) {
      odd = 1;
    }
    for (int i = 0; i < nbcombi + odd; i++) {
      // System.out.println(matchs.get(i).equipe1.nomEquipe + " - " +
      // matchs.get(i).equipe2.nomEquipe);
    }

  }

  public void getDataJoueur(String file) {

    String nom = "";
    String prenom = "";
    int dateNaissance = 0;
    int position = 0;
    boolean titulaire = false;
    int numeroJoueur = 0;
    int vitesse = 0;
    int tirs = 0;
    int passes = 0;
    int dribbles = 0;
    int defense = 0;
    int physique = 0;
    String equipe = "";
    BufferedReader br = null;
    String line;
    int count = 0;
    List<Joueur> joueursTemp = new ArrayList<Joueur>();
    Calendar c = Calendar.getInstance();
    int annee = c.get(Calendar.YEAR);
    try {
      // va chercher le fichier demandé
      br = new BufferedReader(new FileReader(file + ".txt"));

      // cherche la liste de toute les équipes dispo dans la bdd et la transformer en
      // objet
      // for(int i = 0; i < nbEquipe; i++){
      // line = br.readLine();
      // Equipe equipe1 = new Equipe;
      // this.equipes.add(equipe1);
      // }

      while ((line = br.readLine()) != null) {
        // on va choper toute les données ligne par ligne et les transformer en objets

        switch (count) {
        case 0:
          nom = line;
          break;
        case 1:
          prenom = line;
          break;
        case 2:
          dateNaissance = Integer.valueOf(line);
          break;
        case 3:
          position = Integer.valueOf(line);
          break;
        case 4:
          vitesse = Integer.valueOf(line);
          break;
        case 5:
          tirs = Integer.valueOf(line);
          break;
        case 6:
          passes = Integer.valueOf(line);
          break;
        case 7:
          dribbles = Integer.valueOf(line);
          break;
        case 8:
          defense = Integer.valueOf(line);
          break;
        case 9:
          physique = Integer.valueOf(line);
          break;
        case 10:
          equipe = line;
          break;
        case 11:
          numeroJoueur = Integer.valueOf(line);
          break;
        case 12:
          if (line.equals("1")) {
            titulaire = true;
          } else {
            titulaire = false;
          }
          Joueur joueur1 = new Joueur(nom, prenom, dateNaissance, position, vitesse, tirs, passes, dribbles, defense,
              physique, equipe, numeroJoueur, titulaire);
          joueursTemp.add(joueur1);
          // joueur1.afficherStats(annee);
          break;
        }
        count = (count + 1) % 13;

      }
    } catch (IOException e) {
      // si ya une erreur
      e.printStackTrace();
    }
    this.joueurs = joueursTemp;
    // for(int i = 0; i < 3; i++){
    // joueurs.get(i).afficherStats(annee);
    // }
  }

  public void getDataEquipe(String file, int nb) {
    BufferedReader br = null;
    String line;
    int count = 0;
    List<Equipe> equipeTemp = new ArrayList<Equipe>();
    try {
      // va chercher le fichier demandé
      br = new BufferedReader(new FileReader(file + ".txt"));

      // cherche la liste de toute les équipes dispo dans la bdd et la transformer en
      // objet
      for (int i = 0; i < nb; i++) {
        line = br.readLine();
        Equipes equipe1 = new Equipes();
        equipe1.nomEquipe = line;
        this.equipes.add(equipe1);
        // System.out.println(equipe1.nomEquipe+""+i);
      }
    } catch (IOException e) {
      // si ya une erreur
      e.printStackTrace();
    }
    // for(int i = 0; i < 3; i++){
    // joueurs.get(i).afficherStats(annee);
    // }
  }
}