package app;

import java.sql.Connection;

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

    public static void setInfoClient(int idClient) {
        infoClient = new InfoClient(idClient);
    }

    public static void setInfoCommande(String emailResto) {
        infoCommande = new InfoCommande(emailResto);
    }

    private static class InfoClient {
        private int idClient;
        public InfoClient(int idClient) {
            this.idClient = idClient;
        }
    }

    private static class InfoCommande {
        private String emailResto;
        public InfoCommande(String emailResto) {
            this.emailResto = emailResto;
        }
    }
}
