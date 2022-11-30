package app.menus;

import app.Navigator;
import java.time.*;
import java.sql.*;

public class PasserCommande extends Menu {
    private String resto;
    public PasserCommande() {
        super("Passer une commande");

    }

    public void execute() {

        System.out.println("Quel type de commande souhaitez-vous passer ? ");
        System.out.println("    0. SurPlace");
        System.out.println("    1. A Emporter");
        System.out.println("    2. Livraison");
        System.out.println("    3. Je ne souhaite pas commander finalement");

        int choix = Navigator.getNextChoice(3);
        switch (choix) {
            case 0:
                Navigator.pushMenu(new MenuCommandeSurPlace());
                break;
            case 1:case 2:

                //TODO afficher la liste des plats.

                System.out.println("Veuillez choisir les plats que vous voulez commander ainsi que leur quantité : ");
                System.out.println("Format : indexDuPlat:quantitéChoisie (exemple : 12:1)");
                //TODO faut parser l'input pour avoir l'id du plat et sa quantité

                //heure et date de la commande : attention, les mois commencent à 0
                LocalDate dateCommande = LocalDate.now();
                LocalTime heureCommande = LocalTime.now(); //format : HH:mm:ss.ms

                if (choix==1) {
                    //a emporter
                    //TODO on crée directement la commande du coup, pas besoin d'un menu
                    return;
                }
                Navigator.pushMenu(new MenuCommandeLivraison());
                break;
            case 3:
                Navigator.popMenu();
        }

    }
}
