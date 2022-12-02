package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandeLivraison extends CommandeAEmporter {

    public static void create(String emailRestaurant, String emailClient, int dateCommande, int heureCommande, int prixFinal, TypeStatut statut, String adresseLivraison, int heureLivraison) throws SQLException {
        
        ResultSet idClient = Table.sendQuery(String.format("SELECT idClient FROM %s WHERE emailClient = %s", tableClients, emailClient));

        Table.sendQuery(String.format("INSERT INTO %s VALUES ('%s', %d, %d, %d, %d, '%s', '%s', %d)", tableCommandes, emailRestaurant, idClient, dateCommande, heureCommande, prixFinal, statut.toString(), adresseLivraison, heureLivraison));
    }
}
