package app.menus;

import app.Navigator;
import java.util.Calendar;
import java.sql.*;

public class MenuCommandeLivraison extends PasserCommande {
    public MenuCommandeLivraison() {
        super();
    }

    public void execute() throws SQLException {
        try {
            System.out.println("Veuillez entrer votre adresse de livraison : ");
            String adresseLivraison = Navigator.getNextLine();

            System.out.println("Veuillez entrer l'heure à laquelle vous voulez être livré : [format : HH:mm (ex : 12:30)]");
            String heureLivraison = Navigator.getNextLine();

            int heure = Integer.valueOf(heureLivraison.substring(0, 2));
            int minutes = Integer.valueOf(heureLivraison.substring(3, 5));

            int dayOfWeek = Calendar.DAY_OF_WEEK;
            if (true) {
                throw new IllegalArgumentException("Le restaurant ne livre pas à l'heure que vous avez indiquée. Veuillez choisir une heure comprise dans les horaires d'ouverture.");
            }
        } catch (IllegalArgumentException e) {
            Navigator.reRoll();
        }

        //TODO lancer une exception si l'heure rentrée n'est pas dans les horaires du restaurant

    }
}
