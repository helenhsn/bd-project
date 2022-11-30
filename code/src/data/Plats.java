package data;

import java.sql.ResultSet;

public class Plats {
    private static final String tableName = "Plats";

    public ResultSet get(String emailResto) {

        ResultSet result = Table.getAttributes(tableName, "nomPlat, descriptionPlat, prixPlat", "emailResto = '" + emailResto + "'");

        return result;
    }

}

