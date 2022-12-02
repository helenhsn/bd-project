package app.menus.entrance.connection.homePage.command;

import app.InfoSession;
import app.Navigator;
import app.menus.Menu;
import data.Categorie;

import java.sql.*;
import java.util.HashMap;

public class DisplayRestaurants extends Menu {

    public DisplayRestaurants() {
        super("Restaurants");
    }


    public void execute() throws SQLException {
        System.out.println("Selon quelle critère voulez vous filtrer les restaurants, vous pouvez choisir plusieurs critères");

        System.out.println("0. Par jour d'ouverture");
        System.out.println("1. Type de cuisine");
        System.out.println("2. Reccomandations par un algorithme performant d'aprés vos préférences passées");

        int answer = Navigator.getNextChoice(3);

        switch (answer) {
            case 0:
                break;
            case 1:
                Navigator.pushMenu(new DisplayCategories(Categorie.getRoot()));
                break;
            case 2:
                break;
        }

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
                // TODO Navigator.pushMenu(new PasserCommande());
                break;
        }
    }  
}
