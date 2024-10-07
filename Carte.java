package cours1.exercice2;
//Créer une classe Carte
//1. Contient un constructeur pour créer une carte
//2. Attributs : couleur (parmi un tableau statique) et valeur (idem)
//3. Méthode : accesseurs, modificateurs et comparateur
public class Carte {
    //attributs
private static String[] couleurs = {
        "coeur","carreau", "trèfle", "pique"
};
private static int[] valeurs = {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
};
private String couleur;
private int valeur ;

   //constructeur
    public Carte(String couleur, int valeur){
        this.couleur = couleur;
        this.valeur = valeur;
    }
    //getters et setters
    public String getCouleur(){
        return this.couleur;
    }
    public int getValeur(){
        return this.valeur;
    }
    public void setCouleur(){
        this.couleur=couleur;
    }
    public void setValeur(){
        this.valeur=valeur;
    }
    public static String[] getCouleurs() {
        return couleurs;
    }
    public static int[] getValeurs() {
        return valeurs;
    }

    //comparateur
    public boolean estSuperieureA(Carte carte){
        int valeur1 = this.valeur;
        int valeur2 = carte.valeur;
        return valeur1 > valeur2; // Comparer les valeurs
    }

    public int compareTo(Carte carte) {
        if (this.estSuperieureA(carte)) {
            return 1;
        } else if (carte.estSuperieureA(this)) {
            return -1;
        } else {
            return 0;
        }
    }


    public String toString() {
        return (this.getValeur() + " de " + this.getCouleur());
    }

}
