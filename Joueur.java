import java.util.Vector;

public class Joueur extends Personne {

  public int position;
  public String equipe;
  public boolean titulaire;
  public int numeroJoueur;
  public int vitesse;
  public int tirs;
  public int passes;
  public int dribbles;
  public int defense;
  public int physique;

  /*
    public Vector  myEquipe;
    public Vector  myStatJoueur;
    public Vector  myEquipe;
    public Vector  myEquipe;*/
    /**
   * 
   * @element-type Participation
   
  public Vector  tttt;
  public Vector  myPersonne;
  public Equipe appartient;*/
  public Joueur() {
    this.nom = "";
    this.prenom = "";
    this.dateNaissance = 0;
    this.position = 0;
    this.titulaire = false;
    this.numeroJoueur = 0;
    this.vitesse = 0;
    this.tirs = 0;
    this.passes = 0;
    this.dribbles = 0;
    this.defense = 0;
    this.physique = 0;
    this.equipe = "";
  }
  public Joueur(String nom, String prenom,int dateNaissance, int position, int vitesse, int tirs, int passes, int dribbles, int defense, int physique, String equipe, int numeroJoueur, boolean titulaire) {
    this.nom = nom;
    this.prenom = prenom;
    this.dateNaissance = dateNaissance;
    this.position = position;
    this.titulaire = titulaire;
    this.numeroJoueur = numeroJoueur;
    this.vitesse = vitesse;
    this.tirs = tirs;
    this.passes = passes;
    this.dribbles = dribbles;
    this.defense = defense;
    this.physique = physique;
    this.equipe = equipe;
  }

  // il faudra créer les joueurs avec une commande du style : Joueur ronaldo = new Joueur("ronaldo", "cristiano", 34, "5 février 1985", .. .. .. ... etc avec les autres stats);

  public void afficherStats() {
    System.out.println(this.nom + " " + this.prenom);
    System.out.println(this.age + " ans");
    System.out.println("Date de naissance : " + this.dateNaissance);
    System.out.println("Equipe : " + this.equipe);
    if(this.titulaire) {
      System.out.println("Titulaire");
    } else {
      System.out.println("Non-titulaire");
    }
    System.out.println("Numero : " + this.numeroJoueur);
    System.out.println("Position : " + this.position);
    System.out.println("Vitesse : " + this.vitesse);
    System.out.println("Tirs : " + this.tirs);
    System.out.println("Passes : " + this.passes);
    System.out.println("Dribbles : " + this.dribbles);
    System.out.println("Defense : " + this.defense);
    System.out.println("Physique : " + this.physique);
  }

}