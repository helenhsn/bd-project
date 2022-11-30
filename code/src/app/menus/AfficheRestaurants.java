package app.menus;

import app.InfoSession;
import app.Navigator;
import java.sql.*;
public class AfficheRestaurants extends Menu {

    public AfficheRestaurants() {
        super("Restaurants");
    }

    public void execute() {
        System.out.println("Selon quelle critère voulez vous filtrer les restaurants, vous pouvez choisir plusieurs critères");

        System.out.println("0. Par jour d'ouverture");
        System.out.println("1. Type de cuisine");
        System.out.println("2. Reccomandations par un algorithme performant d'aprés vos préférences passés");

        int answer = Navigator.getNextChoice(3);

        System.out.println(); //TODO afficher la requête SQL correspondante -> indexer les restaurants de 0 à n-1 pour permettre au client de choisir

        System.out.println("Veuillez sélectionner un restaurant en fonction de son index dans la table (première colonne)");
        System.out.println("Restaurant sélectionné : "); //TODO afficher le restaurant en fonction de l'index sélectionné...

        System.out.println(); //TODO afficher le restaurant (email, horaires, note moyenne, blabla...)
        System.out.println();
        System.out.println("Souhaitez-vous passer une commande ?");
        System.out.println("    0. Non je veux continuer à parcourir les restaurants");
        System.out.println("    1. Oui, j'ai faim !");

        switch (Navigator.getNextChoice(2)) {
            case 1:
                Navigator.reRoll(); //TODO peut-être que faudrait reroll en tenant compte de ses choix d'affichage pour les restos ?
                break;
            case 2:
                String emailResto = ""; //TODO get email resto pour passer les commandes
                InfoSession.setInfoCommande(emailResto);
                Navigator.pushMenu(new PasserCommande());
                break;
        }
    }  
}
