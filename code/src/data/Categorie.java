package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * A simple class with a name connected to its parent and children representing the hierachy of "Categorie"
 */
public class Categorie {

    private static final String rootName = "root";
    private static final String tableName = "EstCategorieFilleDe";

    public static Categorie getRoot() {
        return new Categorie(rootName);
    }

    /**
     * @param name Category name
     * @return the associated Category Object
     * @throws SQLException
     */
    public static Categorie get(String name) throws SQLException {
        ResultSet result = Table.sendQuery(String.format("SELECT * FROM %s WHERE nomFille = '%s'", tableName, name));

        result.next();
        if (result.getInt(1) == 0) {
            throw new RuntimeException(name + " is not a category.");
        }
        return new Categorie(name);
    }


    public String getNom() {return nom;}
    public Categorie getParent() throws SQLException {
        getDirectParent();
        return parent;
    }
    public Iterator<Categorie> getChildren() throws SQLException {
        getDirectChildren();
        return children.iterator();
    }
    public void setChild() {
        // Todo requete java
    }


    private String nom;
    private Categorie parent = null;
    private TreeSet<Categorie> children = null;

    private Categorie(String nom) {
        this.nom = nom;
    }

    private Categorie(String nom, Categorie parent) {
        this.nom = nom;
        this.parent = parent;
    }

    private void getDirectParent() throws SQLException {
        if (nom.equals(rootName) || parent != null) {
            return;
        }

        ResultSet result = Table.sendQuery(String.format("SELECT nomMere FROM %s WHERE nomFille = '%s'", tableName, nom));
        result.next();
        Categorie parent = new Categorie(result.getString(1));
        result.close();
    }

    private void getDirectChildren() throws SQLException {
        if (children != null) {
            return;
        }
        children = new TreeSet<>();

        ResultSet result = Table.sendQuery(String.format("SELECT nomFille FROM %s WHERE nomMere = '%s'", tableName, nom));
        while(result.next()) {
            children.add(new Categorie(result.getString(1)));
        }

        result.close();
    }

    int compareTo(Categorie categorie) {
        return this.nom.compareTo(categorie.nom);
    }

    @Override
    public String toString() {
        return this.nom;
    }

}
