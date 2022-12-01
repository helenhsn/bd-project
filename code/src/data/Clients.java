package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Clients {

    private static final String tableClients = "Clients";
    private static final String tableIdClients = "IdentifiantsClient";



    public void create(String email, String mdp, String nom, String prenom, String adresse) throws SQLException {
        ResultSet result = Table.sendQuery(String.format("SELECT MAX(idClient) FROM %s", tableClients));
        result.next();
        int newId = result.getInt(1) + 1;
        Table.sendQuery(String.format("INSERT INTO %s VALUES (%d, '%s', '%s', '%s', '%s')", tableClients, newId, mdp, nom, prenom, adresse));
        Table.sendQuery(String.format("INSERT INTO %s VALUES (%d)", tableClients, newId));
    }

    public void remove(int idClient) {
        Table.sendQuery(String.format("DELETE FROM %s WHERE idClient='%d'", tableClients, idClient));
    }

}
