package app.menus;

import app.Navigator;
import java.sql.*;

public class SuppressionCompte extends Menu {

    public SuppressionCompte() {
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
