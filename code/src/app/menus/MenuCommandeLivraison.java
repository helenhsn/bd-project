package app.menus;

import app.Navigator;
import java.sql.*;

public class MenuCommandeLivraison extends PasserCommande {
    private String resto;
    public MenuCommandeLivraison() {
        super();
    }

    public void execute() {
        System.out.println("Veuillez entrer votre adresse de livraison : ");
        String adresseLivraison = Navigator.getNextLine();

        System.out.println("Veuillez entrer l'heure à laquelle vous voulez être livré : [format : HH:mm (ex : 12:30)]");
        String heureLivraison = Navigator.getNextLine();
        int heure = Integer.valueOf(heureLivraison.substring(0,2));
        int minutes = Integer.valueOf(heureLivraison.substring(3,5));

        //TODO lancer une exception si l'heure rentrée n'est pas dans les horaires du restaurant

    }
}
