package app;

import data.Plats;

import java.sql.Connection;
import java.util.HashMap;

public class InfoSession {
    private static Connection connection;
    private static InfoClient infoClient;
    private static InfoCommande infoCommande;

    public static Connection getConnection() {
        return connection;
    }

    public static InfoCommande getInfoCommande() {
        return infoCommande;
    }

    public static InfoClient getInfoClient() {
        return infoClient;
    }

    public static void setConnection(Connection conn) {
        connection = conn;
    }

    public static void setInfoClient(String emailClient) {
        infoClient = new InfoClient(emailClient);
    }

    public static void setChoixCategorie(boolean choix) {
        infoClient.choixCategorie = choix;
    }

    public static void setInfoCommande(String emailRestaurant) {
        infoCommande = new InfoCommande(emailRestaurant);
    }

    private static class InfoClient {
        private String emailClient;
        private boolean choixCategorie;
        public InfoClient(String emailClient) {
            this.emailClient = emailClient;
        }
    }

    private static class InfoCommande {
        private String emailRestaurant;
        private HashMap<Integer, Plats> platsChoisis;
        public InfoCommande(String emailRestaurant) {
            this.emailRestaurant = emailRestaurant;
        }
    }
}
