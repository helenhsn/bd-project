package app.menus;

import app.Navigator;
import java.sql.*;

public class CreationCompte extends Menu{

    public CreationCompte() {
        super("Créer un compte");
    }

    public void execute() throws SQLException {

        boolean gotMail = false;
        while (!gotMail){
            System.out.println("Entrez votre adresse mail : ");
            String mail = Navigator.getNextLine();

            //TODO requete pour vérifier que le mail n'est pas déjà dans la table
            boolean dejaExistant = false;
            if (dejaExistant){
                System.out.println("Adresse mail déjà utilisé");
                Navigator.reRoll();
            }
        }

        String mdp1 = "\n";
        String mdp2 = "No";
        while (!mdp1.equals(mdp2)){
            if (mdp1.equals("\n")){
                System.out.println("Les deux mots de passe ne correspondent pas, réssayer ");
            }
            System.out.println("Entrez votre mot de passe : ");
            mdp1 = Navigator.getNextLine();
            System.out.println("Confirmez votre mot de passe : ");
            mdp2 = Navigator.getNextLine();
        }
        


        System.out.println("Entrez votre nom");
        String nom = Navigator.getNextLine();

        System.out.println("Entrez votre prénom");
        String prenom = Navigator.getNextLine();

        System.out.println("Entrez votre adresse courante");
        String adresse = Navigator.getNextLine();



        // TODO Il faut récuperer le plus grand ID de la table idClient

        // int idClient = resultat requete + 1
         
        //TODO : faire requete pour creer élément dans table idClient et client 
        

        System.out.println("Félicitation ! Votre compte a été crée ! ");


        Navigator.popMenu();
        
    }
    
}
