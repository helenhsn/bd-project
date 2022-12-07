package data;

public class CommandeAEmporter {

    public CommandeAEmporter() {
    }

    // Ajouter getters et setters ...

    public enum Attribut {
        EmailRestaurant("emailRestaurant"),
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


