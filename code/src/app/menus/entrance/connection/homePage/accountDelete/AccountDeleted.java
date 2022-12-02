package app.menus.entrance.connection.homePage.accountDelete;

import app.Navigator;
import app.menus.Menu;
import app.menus.entrance.Entrance;

public class AccountDeleted extends Menu {
    public AccountDeleted() {
        super("Compte supprimé");
    }

    @Override
    public void execute() {
        System.out.println("Votre compte a bien été supprimé.");
        System.out.println("Appuyez sur 'entrée' pour revenir à l'acceuil.");
        Navigator.getNextLine();
        Navigator.reset(new Entrance());
    }
}
