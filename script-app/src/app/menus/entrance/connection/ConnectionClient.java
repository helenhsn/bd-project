package app.menus.entrance.connection;

import app.InfoSession;
import app.Navigator;
import app.menus.Menu;
import app.menus.entrance.connection.homePage.HomePage;
import data.Clients;

import java.sql.*;

public class ConnectionClient extends Menu {

    public ConnectionClient() {
        super("Connection");
    }

    public void execute() {
        System.out.println("Connecter vous à votre compte Grenoble Eat !\nVeuillez entrer votre email :");
        String mail = Navigator.getNextLine();
        System.out.println("Veuillez entrer votre mot de passe :");
        String password = Navigator.getNextLine();
        // regarder si le client existe : selon le cas, le connecter ou reroll
        try {
            if(Clients.exists(mail, password)) {
                // le client s'est connecté !
                InfoSession.setInfoClient(mail);
                Navigator.pushMenu(new HomePage());
            }
            else {
                System.out.println("Informations de connection non valide !");
                Navigator.popMenu();
            }
        }
        catch(SQLException e) {
            System.out.println("Le serveur a rencontré une erreur interne.");
            Navigator.reRoll();
        }
    }
}
