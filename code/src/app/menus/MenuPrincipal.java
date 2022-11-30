package app.menus;

import app.Navigator;
import java.sql.*;

public class MenuPrincipal extends Menu {

    public MenuPrincipal() {
        super("Home");
    }

    public void execute() {
        System.out.println("Welcome back !");
        System.out.println("    0. Parcourir la liste des restaurants");
        System.out.println("    1. Afficher mon historique de commandes");
        System.out.println("    2. Supprimer mon compte");
        System.out.println("    3. Se déconnecter");

        switch(Navigator.getNextChoice(4)) {
            case 0:
                Navigator.pushMenu(new AfficheRestaurants());
                break;
            case 1:
                Navigator.pushMenu(new HistoriqueCommandes());
                break;
            case 2:
                Navigator.pushMenu(new SuppressionCompte());
                break;
            case 3:
                System.out.println("Déconnection... À une prochaine fois !");
                Navigator.popMenu();
                break;
        }
    }
}
