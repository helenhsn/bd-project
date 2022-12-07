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

    public static void setInfoCommande(String emailResto) {
        infoCommande = new InfoCommande(emailResto);
    }

    public static void clearClientInfo() {
        infoClient = null;
    }

    public static class InfoClient {
        private String emailClient;

        public InfoClient(String emailClient) {
            this.emailClient = emailClient;
        }
        public String getEmail() {
            return emailClient;
        }
    }

    public static class InfoCommande {
        private String emailResto;
        private HashMap<Integer, Plats> platsChoisis;
        public InfoCommande(String emailResto) {
            this.emailResto = emailResto;
        }
    }
}
