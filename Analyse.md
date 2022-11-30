# EXTRACTION DES DONNEES BRUTES

1. **restaurant** : email, nom, numTel, adresse, **categorie**(s), horairesOuverture (midi et soir), nbPlacesAssises, textePresentation, **plat**sproposés, typeCommande, **evaluation**sCommandesPassees,  note**restaurant**, capaciteMax

2. **plat**: *id***plat**, nom, description, prix, allergène(s).

3. **categorie**

4. **comptesUtilisateurs**: *id*Utilisateur, email, mdp, nom, prenom, adresse

5. **commandes**: *id*Commande, date, heure, client, *id***restaurant**, typeCommande, contenuCommande, prixFinal, statut

livraison: adresseLivraison, texteLivreur, heureLivraison
surPlace: nbPersonnes, heureArrivee.

6. **evaluation**: *id*commande, dateEvaluation, heureEvaluation, avis, note.


### Restaurant
emailRestaurant-->nomRestaurant, numTelRestaurant, adresseRestaurant, horairesOuverture, nbrPlacesAssises, textePresentation, 
emailRestaurant->>**categorie**
*emailRestaurant-->horairesOuverture*

emailRestaurant->>*id***plat**
emailRestaurant->>typeCommandeDisponible
emailRestaurant-|->noteRestaurant

numTelRestaurant-->emailRestaurant

### Horaires
*id***Horaire**--> emailRestaurant, ouverture, fermeture
entité faible de Restaurant

### Plat
*id***Plat**--> nomPlat, descriptionPlat, prixPlat
*id***Plat**-|->> *id***Allergène**

### Allergènes
*id***Allergène**-->nomAllergène

### Categories
**categorie**-|->>**categorie**Enfant

### Utilisateurs
*id***Utilisateur**-->emailUtilisateur, mdp, nom, prenom, adresseUtilisateur

### Commandes
*id***Commande**-->date, heure, client, emailRestaurant, typeCommande, contenu, prixFinal, status
typeCommande correspond a 2 sous entités de l'entité commande: livraison et surPlace

*id***Commande**-|->**evaluation**

*id***Livraison**-->adresse, heureLivraison
*id***Livraison**-|->texteLivreur

*id***SurPlace**-->heureArrivée, nbrDePersonnes

### Evaluation (entité faible de commande)
*id***Evaluation**-->*id***Commande**, date, heure, avisTexte, note

***

## Contraintes

* heureLivraison ssi commande livrée
* si commande pas annulée **evaluation** utilisateur

## Contraintes Multiplicité
* noteRestaurant = moyenne des notes
* $\sum{\text{nbrDePersonnes}}\leq nbrPlacesAssises$
* heure d'arrivée dans les horaires d'ouverture
* verifier que le nombre de personnes ayant commandé sur un service (midi ou soir) est <= à la capacité

## Contraintes valeurs
* 0<=note<=5
* typeCommande $\subset  \{surPlace , livraison , aEmporter\}$ non vide
* nbrPlacesAssises > 0
* nbrDePersonnes > 0
* horairesOuverture entre 12h et 14h ou 19h et 23h
* categorie root
* $idCommande = idSurPlace \bigcup idLivraison$
* $idSurPlace \bigcap idLivraison = \emptyset$
* alergène enum
