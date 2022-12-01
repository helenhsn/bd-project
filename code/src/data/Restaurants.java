package data;

import java.sql.ResultSet;


public class Restaurants {
    private static final String tableResto = "Restautants";
    private static final String restoAttributes = "emailResto, nomResto, numResto, textePresentation, sommeNote/cardinalNote";
    private static final String notesDecroissantes = "sommeNote/cardinalNote DESC"; //todo ajout ordre alphabetique si ce n'est pas le cas

    public static ResultSet getRestaurants(int blockIndex, int blockSize) {
        return Table.getAttributes(tableResto, restoAttributes, null, notesDecroissantes, blockSize, blockIndex);
    }

    public static ResultSet getRestaurants(int blockIndex, int blockSize, String categorie) {
        return Table.getAttributes(tableResto, restoAttributes, "categorie = '" + categorie + "'", notesDecroissantes, blockSize, blockIndex);
    }


}

