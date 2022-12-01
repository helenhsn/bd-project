package app.menus;

import app.Navigator;
import java.sql.*;

/**
 * First menu in the app !
 */
public class Entrance extends Menu{

    public Entrance() {
        super("Grenoble Eat");
    }

    public void execute() throws SQLException {
        System.out.println("Bienvenue dans GrenobleEat !\nVeuillez vous connecter ou créer un compte !");
        System.out.println("    0. Quitter");
        System.out.println("    1. Se connecter");
        System.out.println("    2. Créer un compte");

        switch(Navigator.getNextChoice(3)) {
            case 0:
                System.out.println("Au revoir !");
                break;
            case 1:
                int idClient = 0; //TODO get l'id du client lors de sa connection !
                Navigator.pushMenu(new ConnectionClient(idClient));
                break;
            case 2:
                Navigator.pushMenu(new CreationCompte());
                break;
        }
    }
}
