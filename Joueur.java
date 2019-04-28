import java.util.Vector;

public class Joueur extends Personne {

  int position;
  String equipe;
  String nom;
  String prenom;
  public boolean titulaire;
  public int numeroJoueur;
  public float vitesse;
  public int tirs;
  public int passes;
  public int dribbles;
  public int defense;
  public int physique;
  int dateNaissance;

  public Joueur(String nom, String prenom,int dateNaissance, int position, int vitesse, int tirs, int passes, int dribbles, int defense, int physique, String equipe, int numeroJoueur, boolean titulaire) {
    this.nom = nom;
    this.prenom = prenom;
    this.age = age;
    this.dateNaissance = dateNaissance;
    this.position = position;
    this.equipe = equipe;
    this.titulaire = titulaire;
    this.numeroJoueur = numeroJoueur;
    this.vitesse = vitesse;
    this.tirs = tirs;
    this.passes = passes;
    this.dribbles = dribbles;
    this.defense = defense;
    this.physique = physique;
  }

  public void afficherStats(int annee) { // AFFICHAGE DES STATS VERSION CONSOLE
    System.out.println(this.nom + " " + this.prenom);
    System.out.println((annee-this.dateNaissance) + " ans");
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
  public String stat(){ // AFFICHAGE DES STATS VERSION INTERFACE GRAPHIQUE
    String text = "Nom : "+this.nom +"<BR>Prenom : "+this.prenom+"<BR>Equipe : "+this.equipe+"<BR>Numero : "+this.numeroJoueur+"<BR>Position : "+this.position;
    return text;
  }

  public void modifierStat() {
    /* Affiche un textfield qui contient toutes les stats du joueur en question
     Telles qu'elles le sont actuellement

     Et renvoie les résultats du textfield comme nouveaux attributs/stats
     qui remplaceront alors les anciennes si elles sont correctes (types etc)
    */
  }
}