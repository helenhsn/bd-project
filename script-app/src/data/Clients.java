package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Clients {
    


    public static void create(String email, String mdp, String nom, String prenom, String adresse) throws SQLException {
        ResultSet result = Table.sendQuery(String.format("SELECT MAX(idClient) FROM %s", Table.Clients));
        result.next();
        int newId = result.getInt(1) + 1;
        Table.sendQuery(String.format("INSERT INTO %s VALUES (%d, '%s', '%s', '%s', '%s')", Table.Clients, newId, mdp, nom, prenom, adresse));
        Table.sendQuery(String.format("INSERT INTO %s VALUES (%d)", Table.IdClients, newId));
    }

    public static void remove(String email) {
        Table.sendQuery(String.format("DELETE FROM %s WHERE emailClient='%s'", Table.Clients, email));
    }

    public static boolean exists(String email, String mdp) throws SQLException {
        ResultSet result = Table.getAttributes(Table.Clients, "COUNT(*)", String.format("emailClient='%s', mdp='%s'", email, mdp));
        result.next();
        return result.getInt(1) > 0;
    }

}
