package app.menus.entrance.connection.homePage.command;

import app.Navigator;
import app.menus.Menu;
import data.Categorie;

import java.sql.SQLException;
import java.util.HashMap;

public class DisplayCategories extends Menu {
    private Categorie categorie;
    public DisplayCategories(Categorie categorie) {
        super("Categorie");
        this.categorie = categorie;
    }
    public void execute() throws SQLException {
        Categorie currentCategory = categorie; //
        int indexCategory = 0;
        HashMap<Integer, Categorie> categories = new HashMap<>();
        System.out.println("Catégories de cuisines disponibles : ");

        while (currentCategory.getChildren().hasNext()) {
            System.out.println(indexCategory + ".   " + currentCategory.getNom());
            categories.put(indexCategory, currentCategory);
            indexCategory++;
        }
        System.out.println("Veuillez sélectionner une catégorie de cuisine");
        int chosenCategory = Navigator.getNextChoice(indexCategory+1);
        System.out.println("Souhaitez-vous regarder la liste des restaurants pour cette catégorie de cuisine ? [Y: yes / N:No]");
        if (Navigator.getNextLine().equals("Y")) {
        }
        else {
            System.out.println("Revenir en arrière ? [Y: yes / N:No]");
            if (Navigator.getNextLine().equals("Y")) {
                Navigator.reRoll();
                return;
            }
            Navigator.pushMenu(new DisplayCategories(categories.get(chosenCategory)));
        }
    }
}
