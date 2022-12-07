import app.InfoSession;
import app.Navigator;
import app.menus.Entrance;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final String CONN_URL = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";
        final String USER = "delayatr";
        final String PASSWD = "delayatr";
        try {
            // Enregistrement du driver Oracle
            System.out.print("Loading Oracle driver... ");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("loaded");

            // Etablissement de la connection
            System.out.print("Connecting to the database... ");
            Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
            System.out.println("connected");

            //stack the connection
            InfoSession.setConnection(conn);
            // start everything by adding the entrance menu to the navigator
            Navigator.pushMenu(new Entrance());
        } catch (SQLException e) {
            System.err.println("failed");
            e.printStackTrace(System.err);
        }
    }
}
