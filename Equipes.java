package compMaker.model;

import java.util.*;

public class Equipes {

  public String nomEquipe;
  public String nomCoach;
  public int nombreJoueurs;
  public int points;
  public List<Joueur> JoueursInEquipe = new ArrayList<Joueur>();

  public Equipes(String nom) {
    this.nomEquipe = nom;
  }

  public Equipes() {
    this.nomEquipe = "non attribuer";
    this.nomCoach = "non attribuer";
    this.nombreJoueurs = 0;
  }
}
