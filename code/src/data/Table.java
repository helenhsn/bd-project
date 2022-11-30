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
    public static ResultSet getAttributes(String name, String attributes) {
        return getAttributes(name, attributes, null, -1, -1);
    }


    /**
     * @param name Table name
     * @param attributes attributes to retrieve
     * @param condition an SQL condition
     * @return the selected attributes from each entry verifying the given condition
     */
    public static ResultSet getAttributes(String name, String attributes, String condition) {
        return getAttributes(name, attributes, condition, -1, -1);
    }

    /**
     * @param name Table name
     * @param attributes attributes to retrieve
     * @param condition an SQL condition
     * @param blockIndex the index of the selected block
     * @param blockSize the number of line per block
     * @return the selected attributes from each entry verifying the given condition in the selected block
     */
    public static ResultSet getAttributes(String name, String attributes, String condition, int blockIndex, int blockSize) {

        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append(" ").append(attributes == null ? "*" : attributes).append(" ");

        // Table selection
        query.append(" FROM ");
        query.append(name);

        if (condition != null) {
            query.append(" WHERE ").append(condition);
        }

        if (blockIndex > 0 && blockSize > 0) {
            query.append(" LIMIT ").append(blockSize)
                    .append(" OFFSET ").append(blockSize * blockIndex);
        }

        return sendQuery(query.toString());
    }

    public static ResultSet getAllAttributes(String name) {
        return getAttributes(name, "*");
    }

    private static Connection connection;
}

