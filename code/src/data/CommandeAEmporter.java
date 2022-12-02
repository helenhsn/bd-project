package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandeAEmporter {

    public enum TypeStatut {
        AttenteConfirmation, Validee, Disponible, EnLivraison, AnnuleeParClient, AnnuleeParRestaurant;
    }

    protected static final String tableCommandes = "Commandes";
    protected static final String tableClients = "Clients";
    protected static final String tableContenu = "ContenuCommande";


    public static void create(String emailRestaurant, String emailClient, int dateCommande, int heureCommande) throws SQLException {
        ResultSet idClient = Table.sendQuery(String.format("SELECT idClient FROM %s WHERE emailClient = %s", tableClients, emailClient));

        Table.sendQuery(String.format("INSERT INTO %s VALUES ('%s', %d, %d, %d, 0, 'AttenteConfirmation')", tableCommandes, emailRestaurant, idClient, dateCommande, heureCommande));
    }

    // Remplis la table ContenuCommande
    public static void commande(String emailRestaurant, String emailClient, int dateCommande, int heureCommande, int idPlat, int quantite){
        ResultSet idClient = Table.sendQuery(String.format("SELECT idClient FROM %s WHERE emailClient = %s", tableClients, emailClient));

        Table.sendQuery(String.format("INSERT INTO %s VALUES ('%s', '%s', '%s', %d, %d, %d)", tableContenu, emailRestaurant, idPlat, idClient, dateCommande, heureCommande, quantite));
    }

    public static void setStatut(String emailRestaurant, String emailClient, int dateCommande, int heureCommande, TypeStatut statut){
        Table.sendQuery(String.format("UPDATE %s SET statut = '%s' WHERE emailRestaurant = '%s' AND emailClient = '%s' AND dateCommande = %d AND heureCommande = %d", tableCommandes, statut, emailRestaurant, emailClient, dateCommande, heureCommande));
    }

    public static ResultSet get(String emailRestaurant, String emailClient, int dateCommande, int heureCommande, int idCommande, String attributs){
        return Table.getAttributes(tableCommandes, attributs, String.format("emailRestaurant = '%s' AND emailClient = '%s' AND dateCommande = %d AND heureCommande = %d", emailRestaurant, emailClient, dateCommande, heureCommande));
    }

    
    public static ResultSet contenu(String emailRestaurant, String emailClient, int dateCommande, int heureCommande){
        return Table.getAttributes(tableContenu, "idPlat, quantite", String.format("emailRestaurant = '%s' AND emailClient = '%s' AND dateCommande = %d AND heureCommande = %d", emailRestaurant, emailClient, dateCommande, heureCommande));

    }
}