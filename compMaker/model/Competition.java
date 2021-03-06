package compMaker.model;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Competition {

  public List<Equipes> equipes = new ArrayList<Equipes>();
  public List<Match> matchs = new ArrayList<Match>();
  public List<Joueur> joueurs = new ArrayList<Joueur>();

  public String nomCompetition;

  public int nombreEquipes;

  public int jDebut = 0;
  public int mDebut = 0;
  public int aDebut = 0;

  public void putCompName(String nom) {

    nomCompetition = nom;

  }

  public class Sortbypoints implements Comparator<Equipes> {
    // Used for sorting in ascending order of
    // roll number

    public int compare(Equipes a, Equipes b) {
      int point1 = a.points;
      int point2 = b.points;
      return point2 - point1;
    }
  }
  // TRI PAR POINT
  // public String[] triequipeParPoint() {
  // Equipes equipeTemp = new Equipes();
  // Match matchTemp = new Match();
  // List<Equipes> tempEquipes = new ArrayList<Equipes>();
  // String result[] = new String[this.equipes.size()];
  // tempEquipes = this.equipes;
  // int sum[] = new int[this.equipes.size()];
  // for (int i = 0; i < this.equipes.size(); i++) {
  // equipeTemp = this.equipes.get(i);
  // for (int j = 0; j < this.matchs.size(); j++) {
  // matchTemp = this.matchs.get(j);
  // if (equipeTemp == matchTemp.equipe1) {
  // sum[i] += matchTemp.scoreEquipe1;
  // } else if (equipeTemp == matchTemp.equipe2) {
  // sum[i] += matchTemp.scoreEquipe2;
  // }
  // }
  // equipeTemp.points = sum[i];
  // }
  // Collections.sort(tempEquipes, new Sortbypoints());
  // for (int i = 0; i < tempEquipes.size(); i++) {
  // result[i] = tempEquipes.get(i).nomEquipe + " " + tempEquipes.get(i).points +
  // "<BR>" + "";
  // }
  // return result;
  // }

  public String[] triEquipeParVictoire() {
    List<Equipes> tempEquipes = new ArrayList<Equipes>();
    String result[] = new String[this.equipes.size()];
    for (int j = 0; j < this.equipes.size(); j++) {
      // Equipe point reinitialiser a 0
      this.equipes.get(j).points = 0;
    }
    for (int i = 0; i < this.matchs.size(); i++) {
      if (this.matchs.get(i).aEuLieux) {
        if (this.matchs.get(i).scoreEquipe1 > this.matchs.get(i).scoreEquipe2) {
          this.matchs.get(i).equipe1.points += 3;
          this.matchs.get(i).equipe2.points += 1;
        }
        if (this.matchs.get(i).scoreEquipe1 < this.matchs.get(i).scoreEquipe2) {
          this.matchs.get(i).equipe1.points += 1;
          this.matchs.get(i).equipe2.points += 3;
        }
        if (this.matchs.get(i).scoreEquipe1 == this.matchs.get(i).scoreEquipe2) {
          this.matchs.get(i).equipe1.points += 2;
          this.matchs.get(i).equipe2.points += 2;
        }
      }
    }
    for (int i = 0; i < this.equipes.size(); i++) {
      tempEquipes.add(this.equipes.get(i));
    }
    Collections.sort(tempEquipes, new Sortbypoints());
    for (int i = 0; i < tempEquipes.size(); i++) {
      result[i] = tempEquipes.get(i).nomEquipe + "  " + tempEquipes.get(i).points + "<BR>" + "";
    }
    return result;
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

  public void coachParEquipe() {
    for (int i = 0; i < this.equipes.size(); i++) {
      switch (this.equipes.get(i).nomEquipe.toUpperCase()) {
      case "FRANCE":
        this.equipes.get(i).nomCoach = "Didier DESCHAMPS";
        ;
        break;
      case "ARGENTINE":
        this.equipes.get(i).nomCoach = "Jorge SAMPAOLI";
        ;
        break;
      case "URUGUAY":
        this.equipes.get(i).nomCoach = " Oscar TABAREZ";
        ;
        break;
      case "PORTUGAL":
        this.equipes.get(i).nomCoach = "Fernando SANTOS";
        ;
        break;
      case "BRESIL":
        this.equipes.get(i).nomCoach = "TITE";
        ;
        break;
      case "RUSSIE":
        this.equipes.get(i).nomCoach = "Stanislav CHERCHESOV";
        ;
        break;
      case "CROATIE":
        this.equipes.get(i).nomCoach = "Zlatko DALIC";
        ;
        break;
      case "DANEMARK":
        this.equipes.get(i).nomCoach = "Age HAREIDE";
        ;
        break;
      case "ESPAGNE":
        this.equipes.get(i).nomCoach = "Fernando HIERRO";
        ;
        break;
      case "MEXIQUE":
        this.equipes.get(i).nomCoach = "Juan Carlos OSORIO";
        ;
        break;
      case "BELGIQUE":
        this.equipes.get(i).nomCoach = "Roberto MARTINEZ";
        ;
        break;
      case "JAPON":
        this.equipes.get(i).nomCoach = "Akira NISHINO";
        ;
        break;
      case "SUEDE":
        this.equipes.get(i).nomCoach = "Janne ANDERSSON";
        ;
        break;
      case "SUISSE":
        this.equipes.get(i).nomCoach = "Vladimir PETKOVIC";
        ;
        break;
      case "COLOMBIE":
        this.equipes.get(i).nomCoach = "Jose PEKERMAN";
        ;
        break;
      case "ANGLETERRE":
        this.equipes.get(i).nomCoach = "Gareth SOUTHGATE";
        ;
        break;
      }
    }
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

  public void CombiMatch(int nbEquipes) {
    int nbcombi = ((nbEquipes * nbEquipes) - nbEquipes) / 2;
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
    }

  }

  public void getDataJoueur(String file) {

    String nom = "";
    String prenom = "";
    int dateNaissance = 0;
    String position = "";
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
      // va chercher le fichier demand??
      br = new BufferedReader(new FileReader(file + ".txt"));

      // cherche la liste de toute les ??quipes dispo dans la bdd et la transformer en
      // objet

      while ((line = br.readLine()) != null) {
        // on va choper toute les donn??es ligne par ligne et les transformer en objets

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
          position = line;
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
          break;
        }
        count = (count + 1) % 13;

      }
    } catch (IOException e) {
      // si ya une erreur
      e.printStackTrace();
    }
    this.joueurs = joueursTemp;
  }

  public void getDataEquipe(String file) {
    BufferedReader br = null;
    String line;
    int count = 0;
    List<Equipes> equipeTemp = new ArrayList<Equipes>();
    try {
      // va chercher le fichier demand??
      br = new BufferedReader(new FileReader(file + ".txt"));

      // cherche la liste de toute les ??quipes dispo dans la bdd et la transformer en
      // objet
      while ((line = br.readLine()) != null) {
        Equipes equipe1 = new Equipes();
        equipe1.nomEquipe = line;
        this.equipes.add(equipe1);
      }
    } catch (IOException e) {
      // si ya une erreur
      e.printStackTrace();
    }
  }

  public void getDataEquipe(String file, int nb) {
    BufferedReader br = null;
    String line;
    int count = 0;
    List<Equipes> equipeTemp = new ArrayList<Equipes>();
    try {
      // va chercher le fichier demand??
      br = new BufferedReader(new FileReader(file + ".txt"));

      // cherche la liste de toute les ??quipes dispo dans la bdd et la transformer en
      // objet
      for (int i = 0; i < nb; i++) {
        line = br.readLine();
        Equipes equipe1 = new Equipes();
        equipe1.nomEquipe = line;
        this.equipes.add(equipe1);
      }
    } catch (IOException e) {
      // si ya une erreur
      e.printStackTrace();
    }
  }

  public void getDataMatch(String file, Competition origin) {
    BufferedReader br = null;
    String line;
    int count = 0;
    Equipes nomEquipe1 = new Equipes();
    Equipes nomEquipe2 = new Equipes();
    int score1 = 0;
    int score2 = 0;
    int tour = 0;
    boolean bool = false;
    List<Match> matchTemp = new ArrayList<Match>();
    try {
      // va chercher le fichier demand??
      br = new BufferedReader(new FileReader(file + ".txt"));

      // cherche la liste de toute les ??quipes dispo dans la bdd et la transformer en
      // objet
      line = br.readLine();
      this.jDebut = Integer.valueOf(line);
      line = br.readLine();
      this.mDebut = Integer.valueOf(line);
      line = br.readLine();
      this.aDebut = Integer.valueOf(line);
      while ((line = br.readLine()) != null) {
        switch (count) {
        case 0:
          nomEquipe1 = this.equipeDe(line);
          break;
        case 1:
          nomEquipe2 = this.equipeDe(line);
          break;
        case 2:
          score1 = Integer.valueOf(line);

          break;
        case 3:
          score2 = Integer.valueOf(line);

          break;
        case 4:
          tour = Integer.valueOf(line);
          break;
        case 5:
          if (Integer.valueOf(line) == 0) {
            bool = false;
          } else {
            bool = true;
          }
          Match temp;
          temp = new Match(nomEquipe1, nomEquipe2, score1, score2, tour, bool);
          matchTemp.add(temp);
          break;

        }
        count = (count + 1) % 6;
      }
      this.matchs = matchTemp;

    } catch (IOException e) {
      // si ya une erreur
      e.printStackTrace();
    }
  }

  public void writeDataJoueur(String file) {

    PrintWriter writer = null;
    try {
      writer = new PrintWriter(file + "Joueur.txt");
      // on va transformer nos objet en fichier txt avec des boucle for ...
      // et les mettres en page de mani??re ?? etre lisible pour le buffer
      for (int i = 0; i < this.joueurs.size(); i++) {
        Joueur temp = this.joueurs.get(i);
        writer.println(temp.nom);
        writer.println(temp.prenom);
        writer.println(temp.dateNaissance);
        writer.println(temp.position);
        writer.println(temp.vitesse);
        writer.println(temp.tirs);
        writer.println(temp.passes);
        writer.println(temp.dribbles);
        writer.println(temp.defense);
        writer.println(temp.physique);
        writer.println(temp.equipe);
        writer.println(temp.numeroJoueur);
        if (temp.titulaire == true) {
          writer.println(1);
        } else {
          writer.println(0);
        }

      }
    } catch (FileNotFoundException e) {
      // sortie erreur
      e.printStackTrace();
    }
    writer.close();
  }

  public void writeDataEquipe(String file) {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(file + "Equipe.txt");
      // on va transformer nos objet en fichier txt avec des boucle for ...
      // et les mettres en page de mani??re ?? etre lisible pour le buffer
      for (int i = 0; i < this.equipes.size(); i++) {
        Equipes temp = this.equipes.get(i);
        writer.println(temp.nomEquipe);
      }
    } catch (FileNotFoundException e) {
      // sortie erreur
      e.printStackTrace();
    }
    writer.close();
  }

  public void writeDataMatch(String file) {

    PrintWriter writer = null;
    try {
      writer = new PrintWriter(file + "Match.txt");
      // on va transformer nos objet en fichier txt avec des boucle for ...
      // et les mettres en page de mani??re ?? etre lisible pour le buffer
      writer.println(this.jDebut);
      writer.println(this.mDebut);
      writer.println(this.aDebut);
      for (int i = 0; i < this.matchs.size(); i++) {
        Match temp = this.matchs.get(i);
        writer.println(temp.equipe1.nomEquipe);
        writer.println(temp.equipe2.nomEquipe);
        writer.println(temp.scoreEquipe1);
        writer.println(temp.scoreEquipe2);
        writer.println(i);
        if (temp.aEuLieux) {
          writer.println(1);
        } else {
          writer.println(0);
        }
      }
    } catch (FileNotFoundException e) {
      // sortie erreur
      e.printStackTrace();
    }
    writer.close();
  }

}