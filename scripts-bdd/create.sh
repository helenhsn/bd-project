#!/bin/bash

echo "Creating data base..."

# connection à la bdd

url='(description=(address_list=(address=(protocol=TCP)(host=oracle1.ensimag.fr)(port=1521)))(connect_data=(sid=oracle1)))'
userName='delayatr'
password='delayatr'

sqlplus -S ${userName}/${password}@${url}<<EOFMYSQL

CREATE TABLE Restaurants (
    emailResto VARCHAR(64) NOT NULL,
    nomResto VARCHAR(32) NOT NULL,
    numResto NUMERIC(10, 0) NOT NULL UNIQUE,
    nbPlacesAssises INTEGER NOT NULL CHECK(nbPlacesAssises >= 0),
    textePresentation VARCHAR(1024) NOT NULL,
    sommeNote INTEGER NOT NULL,
    cardinalNote INTEGER NOT NULL,
    PRIMARY KEY(emailResto)
);

CREATE TABLE CategorieCuisine(
    nomCategorie VARCHAR(32) NOT NULL,
    PRIMARY KEY(nomCategorie)
);

CREATE TABLE TypeCommandesResto (
    typeCommandesDisponibles VARCHAR(9) CHECK( typeCommandesDisponibles IN ('aEmporter', 'surPlace', 'livraison')) NOT NULL,
    PRIMARY KEY(typeCommandesDisponibles)
);

CREATE TABLE Allergene(
    nomAllergene VARCHAR(64) NOT NULL,
    PRIMARY KEY(nomAllergene)
);

CREATE TABLE Horaires(
    horaireOuverture INTEGER NOT NULL,
    jourOuverture VARCHAR(8) CHECK(
        jourOuverture IN ('Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi', 'Dimanche')
    ) NOT NULL,
    horaireFermeture INTEGER NOT NULL,
    PRIMARY KEY(horaireOuverture, jourOuverture, horaireFermeture)
);

CREATE TABLE IdentifiantsClient(
    idClient INTEGER NOT NULL,
    PRIMARY KEY(idClient)
);

CREATE TABLE Clients(
    idClient INTEGER,
    emailClient VARCHAR(64) NOT NULL,
    mdp VARCHAR(64) NOT NULL,
    nomClient VARCHAR(32) NOT NULL,
    prenomClient VARCHAR(32) NOT NULL,
    adresseClient VARCHAR(128) NOT NULL,
    PRIMARY KEY(idClient),
    FOREIGN KEY(idClient) REFERENCES IdentifiantsClient(idClient) 
);

CREATE TABLE Evaluations(
    dateEvaluation DATE NOT NULL,
    heureEvaluation INTEGER NOT NULL CHECK (heureEvaluation >= 0 AND heureEvaluation < 24),
    avis VARCHAR(1024) NOT NULL,
    noteEval INTEGER NOT NULL CHECK(noteEval >= 0 AND noteEval <= 5),
    PRIMARY KEY(dateEvaluation, heureEvaluation, avis, noteEval)
);

CREATE TABLE InformationsLivraison(
    emailResto VARCHAR(64),
    idClient INTEGER,
    dateCommande DATE NOT NULL,
    heureCommande INTEGER NOT NULL CHECK (heureCommande >= 0 AND heureCommande < 24),
    texteLivraison VARCHAR(64),
    PRIMARY KEY(emailResto, idClient, dateCommande, heureCommande),
    FOREIGN KEY(emailResto) REFERENCES Restaurants(emailResto),
    FOREIGN KEY(idClient) REFERENCES IdentifiantsClient(idClient)
);

CREATE TABLE Plats(
    emailResto VARCHAR(64),
    idPlat INTEGER NOT NULL,
    nomPlat VARCHAR(64) NOT NULL,
    descriptionPlat VARCHAR(512) NOT NULL,
    prixPlat INTEGER NOT NULL CHECK(prixPlat > 0),
    PRIMARY KEY(emailResto, idPlat),
    FOREIGN KEY(emailResto) REFERENCES Restaurants(emailResto) 
);

CREATE TABLE Commandes(
    emailResto VARCHAR(64),
    idClient INTEGER,
    dateCommande DATE NOT NULL,
    heureCommande INTEGER NOT NULL,
    prixFinal INTEGER NOT NULL,
    statut VARCHAR(32) CHECK (
        statut IN ('AttenteConfirmation', 'Validee', 'Disponible', 'EnLivraison', 'AnnuleeParClient', 'AnnuleeParRestaurant')
    ) NOT NULL,
    PRIMARY KEY(emailResto, idClient, dateCommande, heureCommande),
    FOREIGN KEY(emailResto) REFERENCES Restaurants(emailResto),
    FOREIGN KEY(idClient) REFERENCES IdentifiantsClient(idClient)
);


CREATE TABLE CommandesLivraison(
    emailResto VARCHAR(64),
    idClient INTEGER,
    dateCommande DATE NOT NULL,
    heureCommande INTEGER NOT NULL,
    adresseLivraison VARCHAR(128) NOT NULL,
    heureLivraison INTEGER NOT NULL CHECK(heureLivraison >= 0 AND heureLivraison < 24),
    PRIMARY KEY(emailResto, idClient, dateCommande, heureCommande),
    FOREIGN KEY(emailResto) REFERENCES Restaurants(emailResto),
    FOREIGN KEY(idClient) REFERENCES IdentifiantsClient(idClient)
);

CREATE TABLE CommandesSurPlace(
    emailResto VARCHAR(64),
    idClient INTEGER,
    dateCommande DATE NOT NULL,
    heureCommande INTEGER NOT NULL,
    nbPersonnesSurPlace INTEGER NOT NULL,
    heureArrivee INTEGER NOT NULL,
    PRIMARY KEY(emailResto, idClient, dateCommande, heureCommande),
    FOREIGN KEY(emailResto) REFERENCES Restaurants(emailResto),
    FOREIGN KEY(idClient) REFERENCES IdentifiantsClient(idClient)
);

CREATE TABLE EstCategorieFilleDe(
    nomFille VARCHAR(32),
    nomMere VARCHAR(32),
    PRIMARY KEY(nomFille),
    FOREIGN KEY(nomFille) REFERENCES CategorieCuisine(nomCategorie),
    FOREIGN KEY(nomMere) REFERENCES CategorieCuisine(nomCategorie)
);

CREATE TABLE APourAllergene(
    emailResto VARCHAR(64),
    idPlat INTEGER,
    nomAllergene VARCHAR(64),
    PRIMARY KEY(idPlat),
    FOREIGN KEY(emailResto) REFERENCES Restaurants(emailResto),
    FOREIGN KEY(nomAllergene) REFERENCES Allergene(nomAllergene)
);

CREATE TABLE APourTypeCommande(
    emailResto VARCHAR(64),
    typeCommandesDisponibles VARCHAR(9),
    PRIMARY KEY(emailResto),
    FOREIGN KEY(emailResto) REFERENCES Restaurants(emailResto),
    FOREIGN KEY(typeCommandesDisponibles) REFERENCES TypeCommandesResto(typeCommandesDisponibles)
);

CREATE TABLE ContenuCommande(
    emailResto VARCHAR(64),
    idClient INTEGER,
    dateCommande DATE,
    heureCommande INTEGER,
    idPlat INTEGER,
    quantite INTEGER CHECK (quantite > 0),
    PRIMARY KEY(emailResto, idClient, dateCommande, heureCommande, idPlat),
    FOREIGN KEY(emailResto) REFERENCES Restaurants(emailResto),
    FOREIGN KEY(idClient) REFERENCES IdentifiantsClient(idClient),
    FOREIGN KEY(emailResto, idClient, dateCommande, heureCommande) REFERENCES Commandes(emailResto, idClient, dateCommande, heureCommande),
    FOREIGN KEY(emailResto, idPlat) REFERENCES Plats(emailResto, idPlat)
);

CREATE TABLE APourCategorie(
    emailResto VARCHAR(64),
    nomCategorie VARCHAR(32),
    PRIMARY KEY(emailResto),
    FOREIGN KEY(nomCategorie) REFERENCES CategorieCuisine(nomCategorie)
);

CREATE TABLE APourHoraire(
    emailResto VARCHAR(64),
    horaireOuverture INTEGER,
    jourOuverture VARCHAR(8),
    horaireFermeture INTEGER,
    PRIMARY KEY(emailResto, horaireOuverture, jourOuverture, horaireFermeture),
    FOREIGN KEY(emailResto) REFERENCES Restaurants(emailResto),
    FOREIGN KEY(horaireOuverture, jourOuverture, horaireFermeture) REFERENCES Horaires(horaireOuverture, jourOuverture, horaireFermeture)
);
 
CREATE TABLE APourEvaluation(
    emailResto VARCHAR(64),
    idClient INTEGER,
    dateCommande DATE,
    heureCommande INTEGER,
    dateEvaluation DATE,
    heureEvaluation INTEGER,
    avis VARCHAR(1024),
    noteEval INTEGER,
    PRIMARY KEY(emailResto, idClient, dateCommande, heureCommande, dateEvaluation, heureEvaluation),
    FOREIGN KEY(emailResto) REFERENCES Restaurants(emailResto),
    FOREIGN KEY(idClient) REFERENCES IdentifiantsClient(idClient),
    FOREIGN KEY(emailResto, idClient, dateCommande, heureCommande) REFERENCES Commandes(emailResto, idClient, dateCommande, heureCommande),
    FOREIGN KEY(dateEvaluation, heureEvaluation, avis, noteEval) REFERENCES Evaluations(dateEvaluation, heureEvaluation, avis, noteEval)
);


EOFMYSQL

echo "Done !"