package data;

import java.sql.ResultSet;
import java.util.Arrays;

public class Plat {
    private static final String tableName = "Plats";

    public ResultSet get(String emailResto) {

        ResultSet result = Table.getAttributes(tableName, "nomPlat, descriptionPlat, prixPlat", "emailResto = " + emailResto);

        return result;
    }

}

