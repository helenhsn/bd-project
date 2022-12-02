package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandeSurPlace extends CommandeAEmporter {

    private static final String tableResto = "Restaurants";

    public static void create(String emailRestaurant, String emailClient, int dateCommande, int heureCommande, int prixFinal, TypeStatut statut, int nbPersonnesSurPlace, int heureArrivee) throws SQLException, Exception {
        ResultSet res = Table.sendQuery(String.format("SELECT nbPlacesAssises FROM %s WHERE emailResto = '%s'", tableResto, emailRestaurant));
        res.next();

        if(nbPersonnesSurPlace < res.getInt(1)){// si il y a encore de la place
            ResultSet idClient = Table.sendQuery(String.format("SELECT idClient FROM %s WHERE emailClient = %s", tableClients, emailClient));
    
            Table.sendQuery(String.format("INSERT INTO %s VALUES ('%s', %d, %d, %d, %d, '%s', '%s', %d)", tableCommandes, emailRestaurant, idClient, dateCommande, heureCommande, prixFinal, statut.toString(), nbPersonnesSurPlace, heureArrivee));
        
            Table.sendQuery(String.format("UPDATE %s SET nbPersonneSurPlace = '%s'", tableResto, nbPersonnesSurPlace + 1));
        }
    }
}