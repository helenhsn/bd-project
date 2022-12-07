package app.menus.entrance.connection.homePage.accountDelete;

import app.InfoSession;
import app.Navigator;
import app.menus.Menu;
import data.Clients;

public class AccountDeletion extends Menu {

    public AccountDeletion() {
        super("Supprimer son compte");
    }

    public void execute() {
        System.out.println("Êtes-vous sûr de vouloir supprimer votre compte ?\n 0. oui\n 1. non");
        switch(Navigator.getNextChoice(2)) {
            case 0:
                Clients.remove(InfoSession.getInfoClient().getEmail());
                Navigator.pushMenu(new AccountDeleted());
                break;
            case 1:
                Navigator.popMenu();
                break;
        }
    }
}
