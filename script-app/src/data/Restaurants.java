package data;

import java.sql.ResultSet;


public class Restaurants {
    private static final String tableRestaurant = "Restautants";
    private static final String RestaurantAttributes = "emailRestaurant, nomRestaurant, numRestaurant, textePresentation, sommeNote/cardinalNote";
    private static final String notesDecroissantes = "sommeNote/cardinalNote DESC, nomRestaurant ASC";

    public static ResultSet getRestaurants(int blockIndex, int blockSize) {
        return Table.getAttributes(tableRestaurant, RestaurantAttributes, null, notesDecroissantes, blockSize, blockIndex);
    }

    public static ResultSet getRestaurants(int blockIndex, int blockSize, String categorie) {
        return Table.getAttributes(tableRestaurant, RestaurantAttributes, "categorie = '" + categorie + "'", notesDecroissantes, blockSize, blockIndex);
    }


}

