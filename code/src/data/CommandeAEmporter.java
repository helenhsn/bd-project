package data;

public class CommandeAEmporter extends Table {

    public CommandeAEmporter() {
        super("Commandes"); // nom de la table
    }

    // Ajouter getters et setters ...

    public enum Attribut {
        EmailResto("emailResto"),
        IdClient("idClient"),
        DateCommande("dateCommande"),
        HeureCommande("heureCommande"),
        PrixFinal("prixFinal"),
        Statut("statut");

        private String name;

        private Attribut(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}


