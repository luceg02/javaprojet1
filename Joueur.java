package cours1.exercice2;

import java.util.ArrayList;
import java.util.Arrays;

//Créer une classe Joueur
//1. Propriétés : tableau de cartes et compteur de points
//2. Méthode : tire une carte et ajoute une carte
import java.util.ArrayList; // Importer ArrayList
import java.util.List; // Importer List

public class Joueur {
    // Attributs
    private ArrayList<Carte> paquet; // Liste de cartes
    private int compteurPoints; // Compteur de points

    // Constructeur
    public Joueur(int nCartes) {
        this.paquet = new ArrayList<>(nCartes); // Initialiser l'ArrayList avec une capacité initiale
        this.compteurPoints = 0; // Points au début du jeu
    }

    // Getters
    public List<Carte> getPaquet() {
        return paquet; // Retourne l'ArrayList de cartes
    }

    public int getCompteurPoints() {
        return compteurPoints; // Retourne le compteur de points
    }

    // Setters
    public void setPaquet(ArrayList<Carte> paquet) {
        this.paquet = paquet; // Met à jour le paquet de cartes
    }

    public void setCompteurPoints(int compteurPoints) {
        this.compteurPoints = compteurPoints; // Met à jour le compteur de points
    }

    // Méthodes
    public void ajouteCarte(Carte carte) {
        paquet.add(carte); // Ajoute la carte à la liste
    }

    public Carte tirerCarte() {
        // Vérifie si le paquet n'est pas vide
        if (!paquet.isEmpty()) {
            Carte carteTiree = paquet.remove(0); // Retire et renvoie la première carte
            return carteTiree;
        }
        System.out.println("Aucune carte disponible à tirer."); // Message si le paquet est vide
        return null; // Si aucune carte n'est disponible, renvoie null
    }

    @Override
    public String toString() {
        return "Ce joueur possède un paquet composé de " + paquet + " et a " + compteurPoints + " points"; // Affiche le paquet et le compteur de points
    }
}

