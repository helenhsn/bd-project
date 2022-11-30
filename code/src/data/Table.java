package data;

import java.io.Console;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.TreeSet;

import java.sql.*;

public class Table {

    private String name;
    private Connection connection;
    // Un element du treeSet correspond a une ligne de la table et la hashMap contient les attributs que l'on a recuperé
    // du serveur

    public Table(String name, Connection connection) {
        this.name = name;
        this.connection = connection;
        
    }

    public ResultSet getAttributs(Collection<String> attributs) {
        try {
            PreparedStatement stmt = connection.prepareStatement
                    ("select ? from ?");
            
            StringBuilder attributsList = new StringBuilder();
            for (String attribut: attributs) {
                attributsList.append(attribut);
                attributsList.append(",");
            }

            stmt.setString(1, attributsList.substring(0, attributsList.length() - 1));
            stmt.setString(2, this.name);

            return stmt.executeQuery();

        } catch (SQLException e) {
            System.out.println("Could not execute database query :/");
            throw new RuntimeException(e);
        }
    }

}
