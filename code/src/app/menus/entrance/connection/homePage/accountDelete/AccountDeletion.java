package app.menus.entrance.connection.homePage.accountDelete;

import app.Navigator;
import app.menus.Menu;

import java.sql.*;

public class AccountDeletion extends Menu {

    public AccountDeletion() {
        super("Supprimer son compte");
    }

    public void execute() throws SQLException {
        System.out.println("Êtes-vous sûr de vouloir supprimer votre compte ? Veuillez taper 0 pour oui et 1 pour non.");
        switch(Navigator.getNextChoice(2)) {
            case 0:
                //TODO supprimer le compte
                break;
            case 1:
                Navigator.popMenu();
        }
    }
}
