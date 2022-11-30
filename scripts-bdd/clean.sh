#!/bin/bash

echo "Cleaning data base..."

# connection à la bdd
url='(description=(address_list=(address=(protocol=TCP)(host=oracle1.ensimag.fr)(port=1521)))(connect_data=(sid=oracle1)))'
userName='delayatr'
password='delayatr'

sqlplus -S ${userName}/${password}@${url}<<EOFMYSQL

DROP TABLE EstCategorieFilleDe;
DROP TABLE APourAllergene;
DROP TABLE APourTypeCommande;
DROP TABLE ContenuCommande;
DROP TABLE APourCategorie;
DROP TABLE APourHoraire;
DROP TABLE APourEvaluation;

DROP TABLE InformationsLivraison;
DROP TABLE CommandesSurPlace;
DROP TABLE CommandesLivraison;
DROP TABLE Commandes;

DROP TABLE Clients;
DROP TABLE IdentifiantsClient;

DROP TABLE Evaluations;
DROP TABLE CategorieCuisine;
DROP TABLE Horaires;

DROP TABLE TypeCommandesResto;
DROP TABLE Allergene;
DROP TABLE Plats;

DROP TABLE Restaurants;

EOFMYSQL

echo "Done !"