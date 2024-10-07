package cours1.exercice2;

import java.util.ArrayList; // Pour utiliser ArrayList
import java.util.Collections; // Pour utiliser la méthode shuffle
import java.util.List; // Pour utiliser List

public class Bataille {
    public static void main(String[] args) {
        System.out.println();
        // ETAPE 1: CREER LE JEU DE CARTES

        // récupérer les couleurs et les valeurs des cartes
        String[] couleurs = Carte.getCouleurs();
        int[] valeurs = Carte.getValeurs();

        // initialiser un tableau de 40 cartes (4 couleurs * 10 valeurs)
        Carte[] jeuDeCartes = new Carte[couleurs.length * valeurs.length];

        int i = 0;
        for (String couleur : couleurs) {
            for (int valeur : valeurs) {
                // créer une nouvelle carte avec la couleur et la valeur correspondantes
                jeuDeCartes[i] = new Carte(couleur, valeur);
                i++;
            }
        }

        // affichage du jeu de cartes généré
        System.out.println("Le jeu de cartes généré contient les cartes suivantes :");
        for (Carte carte : jeuDeCartes) {
            System.out.println(carte.getCouleur() + " " + carte.getValeur());
        }

        // ETAPE 2: MELANGER ALEATOIREMENT LE JEU
        // Convertir le tableau en une liste
        List<Carte> listeDeCartes = new ArrayList<>();
        Collections.addAll(listeDeCartes, jeuDeCartes);

        // Mélanger la liste de cartes
        Collections.shuffle(listeDeCartes);

        // Afficher le jeu de cartes mélangé
        System.out.println("\nLe jeu de cartes mélangé contient les cartes suivantes :");
        for (Carte carte : listeDeCartes) {
            System.out.println(carte.getCouleur() + " " + carte.getValeur());
        }

        // ETAPE 3: CREER LES DEUX JOUEURS
        Joueur Luce = new Joueur(20);
        Joueur Pippo = new Joueur(20);

        // ETAPE 4: DISTRUBUER LE JEU DE CARTES AUX DEUX JOUEURS
        for (int z = 0; z < listeDeCartes.size(); z++) {
            if (z % 2 == 0) { // Si l'index est pair, c'est à Luce de recevoir la carte
                Luce.ajouteCarte(listeDeCartes.get(z));
            } else { // Sinon, c'est à Pippo
                Pippo.ajouteCarte(listeDeCartes.get(z));
            }
        }
        // Afficher les paquets des joueurs après distribution
        System.out.println("\nPaquet de Luce :");
        System.out.println(Luce);
        System.out.println("\nPaquet de Pippo :");
        System.out.println(Pippo);

        // ETAPE 5: LA PARTIE COMMENCE
        while (!Luce.getPaquet().isEmpty() && !Pippo.getPaquet().isEmpty()) {
            // 1. Chaque joueur tire et joue une carte
            Carte carteLuce = Luce.tirerCarte(); // Luce tire une carte
            Carte cartePippo = Pippo.tirerCarte(); // Pippo tire une carte

            // Afficher les cartes jouées
            System.out.println("Luce joue: " + carteLuce);
            System.out.println("Pippo joue: " + cartePippo);

            // 2. Comparer les deux cartes
            int comparaison = carteLuce.compareTo(cartePippo); // Méthode compareTo à ajouter dans la classe Carte

            // 3. Le joueur avec la carte plus forte remporte le pli
            if (comparaison > 0) {
                Luce.setCompteurPoints(Luce.getCompteurPoints() + 1); // Luce gagne un point
                System.out.println("Luce remporte le pli avec " + carteLuce + " contre " + cartePippo);
            } else if (comparaison < 0) {
                Pippo.setCompteurPoints(Pippo.getCompteurPoints() + 1); // Pippo gagne un point
                System.out.println("Pippo remporte le pli avec " + cartePippo + " contre " + carteLuce);
            }

            // 4. Afficher les scores
            System.out.println("Scores actuels: Luce = " + Luce.getCompteurPoints() + ", Pippo = " + Pippo.getCompteurPoints());
        }

        // Annonce du gagnant
        if (Luce.getCompteurPoints() > Pippo.getCompteurPoints()) {
            System.out.println("Luce est le gagnant avec " + Luce.getCompteurPoints() + " points");
        } else if (Pippo.getCompteurPoints() > Luce.getCompteurPoints()) {
            System.out.println("Pippo est le gagnant avec " + Pippo.getCompteurPoints() + " points");
        } else {
            System.out.println("C'est une égalité !");
        }
    }
}



