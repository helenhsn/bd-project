package data;

import java.util.*;

import java.sql.*;

public class Table {

    public static void setConnection(Connection connection) {
        Table.connection = connection;
    }
    

    public static ResultSet sendQuery(String query) throws RuntimeException {
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rset = stmt.executeQuery();
            stmt.close();
            return rset;
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            throw new RuntimeException("Could not execute database query :/");
        }
    }

    public static ResultSet getAttributes(String name, Collection<String> attributes) {
        StringBuilder query = new StringBuilder();
        query.append("select ");

        // Attribute selection
        StringBuilder attributesList = new StringBuilder();
        for (String attribute: attributes) {
            attributesList.append(attribute);
            attributesList.append(",");
        }

        query.append(attributesList.substring(0, attributesList.length() - 1));

        // Table selection
        query.append(" from ");
        query.append(name.toString());

        return sendQuery(query.toString());
    }

    public static ResultSet getAllAttributes(String name) {
        LinkedList<String> all = new LinkedList<>();
        all.add("*");
        return getAttributes(name, all);
    }

    private static Connection connection;
}
