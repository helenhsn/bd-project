package app.menus.entrance.connection;

import app.Navigator;
import app.menus.Menu;
import app.menus.entrance.connection.homePage.HomePage;
import data.Clients;

import java.sql.*;

public class ConnectionClient extends Menu {

    public ConnectionClient() {
        super("Connection");
    }

    public void execute() throws SQLException {
        System.out.println("Connecter vous à votre compte Grenoble Eat !\nVeuillez entrer votre email :");
        String mail = Navigator.getNextLine();
        System.out.println("Veuillez entrer votre mot de passe :");
        String password = Navigator.getNextLine();
        // regarder si le client existe : selon le cas, le connecter ou reroll
        if(Clients.exists(mail, password)) {
            // le client s'est connecté !
            // TODO infos sessions @hélène
            Navigator.pushMenu(new HomePage());
        }
        else {
            System.out.println("Informations de connection non valide !");
            Navigator.popMenu();
        }
    }
}
