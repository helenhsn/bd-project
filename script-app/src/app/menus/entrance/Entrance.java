package app.menus.entrance;

import app.Navigator;
import app.menus.Menu;
import app.menus.entrance.newUser.AccountCreation;
import app.menus.entrance.connection.ConnectionClient;

import java.sql.*;

/**
 * First menu in the app !
 */
public class Entrance extends Menu{

    public Entrance() {
        super("Grenoble Eat");
    }

    public void execute() {
        System.out.println("Bienvenue dans GrenobleEat !\nVeuillez vous connecter ou créer un compte !");
        System.out.println("    0. Quitter");
        System.out.println("    1. Se connecter");
        System.out.println("    2. Créer un compte");

        switch(Navigator.getNextChoice(3)) {
            case 0:
                System.out.println("Au revoir !");
                break;
            case 1:
                Navigator.pushMenu(new ConnectionClient());
                break;
            case 2:
                Navigator.pushMenu(new AccountCreation());
                break;
        }
    }
}
