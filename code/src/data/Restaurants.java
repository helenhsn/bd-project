package data;

import java.sql.ResultSet;
import java.util.LinkedList;

import java.util.EnumMap;

public class Restaurants {
    private static final String tableResto = "Restautants";

    public static ResultSet getRestaurants(int blockIndex, int blockSize) {
        return Table.getAttributes(tableResto, "*", null, blockSize, blockIndex);
    }

    public static ResultSet getRestaurants(int blockIndex, int blockSize, String categorie) {
        return Table.getAttributes(tableResto, "*", "categorie = '" + categorie + "'", blockSize, blockIndex);
    }


}

