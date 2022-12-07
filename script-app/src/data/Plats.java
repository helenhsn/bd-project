package data;

import java.sql.ResultSet;

public class Plats {
    private static final String tablePlats = "Plats";
    private static final String tableAllergene = "APourAllergene";

    /**
     * @param emailRestaurant L'id du Restaurant
     * @return La liste des attributs "idPlat, nomPlat, descriptionPlat, prixPlat" de chaque plat proposé par le Restaurant
     */
    public ResultSet get(String emailRestaurant) {
        return Table.getAttributes(tablePlats, "idPlat, nomPlat, prixPlat", "emailRestaurant = '" + emailRestaurant + "'");
    }

    public ResultSet getDescription(String idPlat) {
        return Table.getAttributes(tablePlats, "descriptionPlat", "idPlat = '" + idPlat + "'");
    }

    public ResultSet getAllergenes(String idPlat) {
        return Table.getAttributes(tableAllergene, "nomAllergene", "idPlat = '" + idPlat + "'");
    }

}

