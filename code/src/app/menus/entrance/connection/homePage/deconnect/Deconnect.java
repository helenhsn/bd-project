package app.menus.entrance.connection.homePage.deconnect;

import app.InfoSession;
import app.Navigator;
import app.menus.Menu;
import app.menus.entrance.Entrance;

public class Deconnect extends Menu {
    public Deconnect() {
        super("Déconnexion");
    }

    public void execute() {
        System.out.println("Etes vous sûr de vouloir vous déconnecter ?\n 0. Oui\n 1. Non");

        switch(Navigator.getNextChoice(2)) {
            case 0 :
                // back to the entrance ! clear client info
                InfoSession.clearClientInfo();
                Navigator.reset(new Entrance());
                break;
            case 1 :
                // back to 
                Navigator.popMenu();
                break;
        }
    }
}
