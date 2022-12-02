package app.menus.entrance.connection;

import app.InfoSession;
import app.Navigator;
import app.menus.Menu;

import java.sql.*;

public class ConnectionClient extends Menu {
    private int idClient;
    public ConnectionClient(int idClient) {
        super("Connection");
        this.idClient = idClient;
        InfoSession.setInfoClient(idClient);
    }

    public void execute() throws SQLException {
        System.out.println("Connecter vous à votre compte Grenoble Eat !\nVeuillez entrer votre email :");
        String mail = Navigator.getNextLine();
        System.out.println("Veuillez entrer votre mot de passe :");
        String password = Navigator.getNextLine();
        // regarder si le client existe : selon le cas, le connecter ou reroll

    }
}
