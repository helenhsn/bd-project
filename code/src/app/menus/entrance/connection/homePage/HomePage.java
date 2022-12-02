package app.menus.entrance.connection.homePage;

import app.Navigator;
import app.menus.Menu;
import app.menus.entrance.connection.homePage.accountDelete.AccountDeletion;

import java.sql.*;

public class HomePage extends Menu {

    public HomePage() {
        super("Home");
    }

    public void execute() throws SQLException {
        System.out.println("Bienvenue sur GrenobleEats® !");
        System.out.println("    0. Parcourir la liste des restaurants");
        System.out.println("    1. Afficher mon historique de commandes");
        System.out.println("    2. Supprimer mon compte");
        System.out.println("    3. Se déconnecter");

        switch(Navigator.getNextChoice(4)) {
            case 0:
                // TODO Navigator.pushMenu(new DisplayRestaurants());
                break;
            case 1:
                // TODO Navigator.pushMenu(new HistoriqueCommandes());
                break;
            case 2:
                Navigator.pushMenu(new AccountDeletion());
                break;
            case 3:
                System.out.println("Déconnection... À une prochaine fois !");
                Navigator.popMenu();
                break;
        }
    }
}
