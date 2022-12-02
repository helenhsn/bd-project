package app.menus.entrance.connection.homePage.command;

import app.Navigator;
import app.menus.Menu;
import app.menus.entrance.connection.homePage.command.DisplayRestaurants.DisplayMode;

public class Command extends Menu {
    public Command() {
        super("Commander");
    }

    public void execute() {
        System.out.println("C'est parti pour commander ! Comment voulez vous trier les restaurants ?");
        System.out.println(" 0. Retour");
        System.out.println(" 1. Afficher par notes");
        System.out.println(" 2. Afficher par catégories");
        System.out.println(" 3. Afficher par horaires");

        switch(Navigator.getNextChoice(4)) {
            case 0 : 
                Navigator.popMenu();
                break;
            case 1 :
                Navigator.pushMenu(new DisplayRestaurants(DisplayMode.Rating));
                break;
            case 2 :
                Navigator.pushMenu(new DisplayRestaurants(DisplayMode.Categories));
                break;
            case 3 :
                Navigator.pushMenu(new DisplayRestaurants(DisplayMode.Schedule));
                break;
        }
    }
}
