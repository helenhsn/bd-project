package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandeAEmporter {

    public enum TypeStatut {
        AttenteConfirmation, Validee, Disponible, EnLivraison, AnnuleeParClient, AnnuleeParRestaurant;
    }

    protected static final String tableCommandes = "Commandes";
    protected static final String tableClients = "Clients";


    public static void create(String emailRestaurant, String emailClient, int dateCommande, int heureCommande, int prixFinal, TypeStatut statut) throws SQLException {
        ResultSet idClient = Table.sendQuery(String.format("SELECT idClient FROM %s WHERE emailClient = %s", tableClients, emailClient));

        Table.sendQuery(String.format("INSERT INTO %s VALUES ('%s', %d, %d, %d, %d, '%s')", tableCommandes, emailRestaurant, idClient, dateCommande, heureCommande, prixFinal, statut.toString()));
    }

    public static void setStatut(String emailRestaurant, String emailClient, int dateCommande, int heureCommande, TypeStatut statut){
        Table.sendQuery(String.format("UPDATE %s SET statut = '%s' WHERE emailRestaurant = '%s' AND emailClient = '%s' AND dateCommande = %d AND heureCommande = %d", tableCommandes, statut, emailRestaurant, emailClient, dateCommande, heureCommande));
    }

    public static ResultSet get(String emailRestaurant, String emailClient, int dateCommande, int heureCommande, int idCommande, String attributs){
        return Table.getAttributes(tableCommandes, attributs, String.format("idCommande = %d AND emailRestaurant = '%s' AND emailClient = '%s' AND dateCommande = %d AND heureCommande = %d", idCommande, emailRestaurant, emailClient, dateCommande, heureCommande) );
    }
}