package app.menus;

import app.Navigator;
import java.sql.*;

public class MenuCommandeSurPlace extends PasserCommande {
    private String resto;
    public MenuCommandeSurPlace() {
        super();
    }

    public void execute() throws SQLException {

        System.out.println("Veuillez indiquer le nombre de personnes mangeant sur place : ");
        int nbPersonnesSurPlace = Integer.valueOf(Navigator.getNextLine());

        //TODO lancer une exception si nombre de personnes indiqué est supérieur au nb de places disponibles

        System.out.println("Veuillez indiquer votre heure d'arrivée : [format : HH:mm (ex : 12:30)]");
        String heureArrivee = Navigator.getNextLine();
        int heure = Integer.valueOf(heureArrivee.substring(0,2));
        int minutes = Integer.valueOf(heureArrivee.substring(3,5));

        //TODO lancer une exception si l'heure rentrée n'est pas dans les horaires du restaurant


    }
}
