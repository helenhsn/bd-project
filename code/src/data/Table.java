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

    /**
     * @param name Table name
     * @param attributes attributes to retreive
     * @return the selected attributes from each entry
     */
    public static ResultSet getAttributes(String name, Collection<String> attributes) {
        return getAttributes(name, attributes, null);
    }


    /**
     * @param name Table name
     * @param attributes attributes to retreive
     * @param condition an SQL condition
     * @return the selected attributes from each entry verifying the given condition
     */
    public static ResultSet getAttributes(String name, String attributes, String condition) {

        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append(" ").append(attributes == null ? "*" : attributes).append(" ");

        // Table selection
        query.append(" FROM ");
        query.append(name);

        if (condition != null) {
            query.append(" WHERE ").append(condition);
        }

        return sendQuery(query.toString());
    }

    public static ResultSet getAllAttributes(String name) {
        LinkedList<String> all = new LinkedList<>();
        all.add("*");
        return getAttributes(name, all);
    }

    private static Connection connection;
}

