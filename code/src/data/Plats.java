package data;

import java.sql.ResultSet;

public class Plats {
    private static final String tablePlats = "Plats";
    private static final String tableAllergene = "APourAllergene";

    /**
     * @param emailResto L'id du resto
     * @return La liste des attributs "idPlat, nomPlat, descriptionPlat, prixPlat" de chaque plat proposé par le resto
     */
    public ResultSet get(String emailResto) {
        return Table.getAttributes(tablePlats, "idPlat, nomPlat, prixPlat", "emailResto = '" + emailResto + "'");
    }

    public ResultSet getDescription(String idPlat) {
        return Table.getAttributes(tablePlats, "descriptionPlat", "idPlat = '" + idPlat + "'");
    }

    public ResultSet getAllergenes(String idPlat) {
        return Table.getAttributes(tableAllergene, "nomAllergene", "idPlat = '" + idPlat + "'");
    }

}

