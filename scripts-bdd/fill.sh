#!/bin/bash

echo "Filling data base..."

# connection à la bdd
url='(description=(address_list=(address=(protocol=TCP)(host=oracle1.ensimag.fr)(port=1521)))(connect_data=(sid=oracle1)))'
userName='delayatr'
password='delayatr'

# todo gestion des dates utiliser un timestamp et pas juste dd/mm/yyyy car ici on ne peut pas avoir deux commandes
# à la même heure le même jour dans un même restaurant

sqlplus -S ${userName}/${password}@${url}<<EOFMYSQL

INSERT INTO Restaurants  VALUES ('burger.king@bk.com',   'Burger King',     0468421567, 58, 'Venez gouter notre déliceux Whooper !',      9, 2);
INSERT INTO Restaurants  VALUES ('ferme.a.dede@fad.com', 'La ferme à Dédé', 0447851269, 36, 'La meilleure raclette de la région !',       49, 11);
INSERT INTO Restaurants  VALUES ('dominos.pizza@dp.com', 'Dominos Pizza',   0448725698, 0,  'Une pizza achetée, une offerte !',           13, 4);
INSERT INTO Restaurants  VALUES ('mini.poke@mp.com',     'Mini Poke',       0412789653, 33, 'Cuisine thaïlandaise dans votre assiette !', 34, 7);
INSERT INTO Restaurants  VALUES ('sushi.shop@ss.com',    'Sushi Shop',      0418756934, 14, 'L''incontournable du sushi !',               11, 3);

INSERT INTO CategorieCuisine VALUES ('Cuisine');
INSERT INTO CategorieCuisine VALUES ('Fast Food');
INSERT INTO CategorieCuisine VALUES ('Burgers');
INSERT INTO CategorieCuisine VALUES ('Asiatique');
INSERT INTO CategorieCuisine VALUES ('Japonaise');
INSERT INTO CategorieCuisine VALUES ('Thaï');
INSERT INTO CategorieCuisine VALUES ('Pizza');

INSERT INTO TypeCommandesResto VALUES ('aEmporter');
INSERT INTO TypeCommandesResto VALUES ('surPlace');
INSERT INTO TypeCommandesResto VALUES ('livraison');

INSERT INTO Allergene VALUES ('Arachides');
INSERT INTO Allergene VALUES ('Soja');
INSERT INTO Allergene VALUES ('Gluten');

INSERT INTO Horaires VALUES (12, 'Lundi',    14);
INSERT INTO Horaires VALUES (12, 'Mardi',    14);
INSERT INTO Horaires VALUES (12, 'Mercredi', 14);
INSERT INTO Horaires VALUES (12, 'Jeudi',    14);
INSERT INTO Horaires VALUES (12, 'Vendredi', 14);
INSERT INTO Horaires VALUES (12, 'Samedi',   14);
INSERT INTO Horaires VALUES (12, 'Dimanche', 14);
INSERT INTO Horaires VALUES (19, 'Lundi',    22);
INSERT INTO Horaires VALUES (19, 'Mardi',    22);
INSERT INTO Horaires VALUES (19, 'Mercredi', 22);
INSERT INTO Horaires VALUES (19, 'Jeudi',    22);
INSERT INTO Horaires VALUES (19, 'Vendredi', 22);
INSERT INTO Horaires VALUES (19, 'Samedi',   22);
INSERT INTO Horaires VALUES (19, 'Dimanche', 22);

INSERT INTO IdentifiantsClient VALUES (0);
INSERT INTO IdentifiantsClient VALUES (1); 
INSERT INTO IdentifiantsClient VALUES (2); 
INSERT INTO IdentifiantsClient VALUES (3); 
INSERT INTO IdentifiantsClient VALUES (4);

INSERT INTO Clients VALUES (0, 'tutur@gmail.com',  'tutur02',       'Luth',    'Arthur', 'Montbonnot');
INSERT INTO Clients VALUES (1, 'pouet@gmail.com',  'blagueur69',    'Dupont',  'Louis',  'Gières');
INSERT INTO Clients VALUES (2, 'babar@gmail.com',  '_plouf_31',     'Tessane', 'MAN',    'Crolles, Le hamac');
INSERT INTO Clients VALUES (3, 'zoltan@gscop.com', 'zozo_hongrie_', 'Zsigeti', 'Zoltan', 'Amphi D');
INSERT INTO Clients VALUES (4, 'forev@tonight.fr', 'mon_histoire',  'Forever', 'Michel', 'Claix');

INSERT INTO Evaluations VALUES (TO_DATE('17/12/2015', 'DD/MM/YYYY'), 14, 'Les serveurs ne sont pas très agréables...',                                     2);
INSERT INTO Evaluations VALUES (TO_DATE('11/10/2010', 'DD/MM/YYYY'), 13, 'Les frites étaient complètement brûlées ! C''est inadmissible !',                0);
INSERT INTO Evaluations VALUES (TO_DATE('05/07/2012', 'DD/MM/YYYY'), 14, 'Les meilleures nouilles de Grenoble !',                                          5);
INSERT INTO Evaluations VALUES (TO_DATE('28/01/2020', 'DD/MM/YYYY'), 15, 'Sushis très corrects, je recommande.',                                           4);
INSERT INTO Evaluations VALUES (TO_DATE('05/03/2021', 'DD/MM/YYYY'), 18, 'Les nouilles sont vraiment incroyables, et le service également.',               5);
INSERT INTO Evaluations VALUES (TO_DATE('04/08/2022', 'DD/MM/YYYY'), 22, 'Le dernier burger 3 viandes est vraiment super !',                               5);
INSERT INTO Evaluations VALUES (TO_DATE('17/04/2019', 'DD/MM/YYYY'), 23, 'Fromage à raclette plutôt bon, mais cela manque de charcuterie...',              3);
INSERT INTO Evaluations VALUES (TO_DATE('24/05/2018', 'DD/MM/YYYY'), 0,  'Moins de 5 minutes après notre commande, nous avons reçu nos délicieux burgers', 4);
INSERT INTO Evaluations VALUES (TO_DATE('12/07/2017', 'DD/MM/YYYY'), 23, 'La pizza était froide a son arrivée...',                                         3);
INSERT INTO Evaluations VALUES (TO_DATE('02/12/2018', 'DD/MM/YYYY'), 2,  'Super service à emporter',                                                       5);

INSERT INTO InformationsLivraison VALUES ('burger.king@bk.com',   1, TO_DATE('25/05/2018', 'DD/MM/YYYY'), 12, 'Je suis là dans quelques minutes');
INSERT INTO InformationsLivraison VALUES ('sushi.shop@ss.com',    3, TO_DATE('28/01/2020', 'DD/MM/YYYY'), 13, 'Je serai là dans 15 minutes.');
INSERT INTO InformationsLivraison VALUES ('dominos.pizza@dp.com', 4, TO_DATE('11/07/2017', 'DD/MM/YYYY'), 23, 'Excusez moi du dérangement, je vais être en retard.');

INSERT INTO Plats VALUES ('burger.king@bk.com',   0, 'Whooper',                                        'Le Whopper est un hamburger, consistant en un patty de bœuf haché de quatre onces (110 gr) grillé à la flamme, avec de la mayonnaise, de la salade, deux rondelles de tomate, des rondelles de cornichon, du ketchup et trois rondelles d''oignon dans un pain non croustillant mais légèrement grillé et garni de graines de sésame.', 5);
INSERT INTO Plats VALUES ('burger.king@bk.com',   1, 'Frites',                                         'Les classiques frites, faites de pommes de terre fraîches, dorées et croustillantes.', 3);
INSERT INTO Plats VALUES ('burger.king@bk.com',   2, 'King Wings',                                     'Des ailes de poulet dorées, tendres et délicatement épicées, les KING WINGS sont de retour !', 6);
INSERT INTO Plats VALUES ('ferme.a.dede@fad.com', 0, 'Tartiflette des Alpages',                        'N''en déplaise à l''indémodable Reblochon, il n''est en fait pas irremplaçable. Ses cousins Savoyards : Tamié, Vacherin des Bauges ou Chevrotin des Aravis, présentent eux aussi  une pâte bien crémeuse et goûteuse, et sauront relever le défi haut la main', 20 );
INSERT INTO Plats VALUES ('ferme.a.dede@fad.com', 1, 'Andouillette cuisinée aux graines de moutardes', 'Viande venant du tube digestif du cochon :)', 25);
INSERT INTO Plats VALUES ('dominos.pizza@dp.com', 0, 'Divine 3 fromages',                              'Crème fraîche légère française, mozzarella, oignons, raclette française, emmental.', 12);
INSERT INTO Plats VALUES ('dominos.pizza@dp.com', 1, 'Surprenante Raclette-Miel',                      'Crème fraîche légère française, mozzarella, raclette française, oignons, haché au bœuf assaisonné, miel français.', 10);
INSERT INTO Plats VALUES ('dominos.pizza@dp.com', 2, 'Authentique raclette',                           'Crème fraîche légère française, mozzarella, bacon, pommes de terre françaises sautées, oignons, raclette française.', 10);
INSERT INTO Plats VALUES ('dominos.pizza@dp.com', 3, 'Chessy And Veggie',                              'Crème fraiche légère française, mozzarella, oignons, pommes de terre françaises sautées, tomates fraiches, chèvre, origan.', 10 );
INSERT INTO Plats VALUES ('mini.poke@mp.com',     0, 'Curry de poulet thaïlandais',                    'Du poulet avec du curry, miam', 5);
INSERT INTO Plats VALUES ('mini.poke@mp.com',     1, 'Brochettes de poulet sauce satay',               'Ce plat thaïlandais est un vrai régal, avec sa sauce à base de crème de coco et de cacahuètes. À tester d''urgence !', 10);
INSERT INTO Plats VALUES ('mini.poke@mp.com',     2, 'Boeuf sauté au piment et oignons',               'Des fines lamelletes agrémentant un boeuf d''exception', 15);
INSERT INTO Plats VALUES ('sushi.shop@ss.com',    0, 'Sushis',                                         'Des supers sushis !', 10);
INSERT INTO Plats VALUES ('sushi.shop@ss.com',    1, 'Makis',                                          'Des supers makis !', 10);

INSERT INTO Commandes VALUES ('burger.king@bk.com',   1, TO_DATE('25/05/2018', 'DD/MM/YYYY'), 12, 15, 'Validee');
INSERT INTO Commandes VALUES ('burger.king@bk.com',   0, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 11, 9,  'AnnuleeParClient');
INSERT INTO Commandes VALUES ('burger.king@bk.com',   4, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 19, 6,  'Validee');
INSERT INTO Commandes VALUES ('ferme.a.dede@fad.com', 1, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 19, 25, 'Validee');
INSERT INTO Commandes VALUES ('ferme.a.dede@fad.com', 2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 12, 20, 'AnnuleeParClient');
INSERT INTO Commandes VALUES ('dominos.pizza@dp.com', 4, TO_DATE('11/07/2017', 'DD/MM/YYYY'), 23, 12, 'Validee');
INSERT INTO Commandes VALUES ('dominos.pizza@dp.com', 3, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 12, 10, 'AnnuleeParRestaurant');
INSERT INTO Commandes VALUES ('dominos.pizza@dp.com', 1, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 13, 20, 'Validee');
INSERT INTO Commandes VALUES ('mini.poke@mp.com',     2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 12, 15, 'Validee');
INSERT INTO Commandes VALUES ('sushi.shop@ss.com',    3, TO_DATE('28/01/2020', 'DD/MM/YYYY'), 13, 20, 'Validee');

INSERT INTO CommandesLivraison VALUES ('burger.king@bk.com',   1, TO_DATE('25/05/2018', 'DD/MM/YYYY'), 12, 'Montbonnot', 13);
INSERT INTO CommandesLivraison VALUES ('sushi.shop@ss.com',    3, TO_DATE('28/01/2020', 'DD/MM/YYYY'), 13, 'Amphi D',    13);
INSERT INTO CommandesLivraison VALUES ('dominos.pizza@dp.com', 4, TO_DATE('11/07/2017', 'DD/MM/YYYY'), 22, 'Claix',      23);

INSERT INTO CommandesSurPlace VALUES ('burger.king@bk.com',   0, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 11, 3, 12);
INSERT INTO CommandesSurPlace VALUES ('burger.king@bk.com',   4, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 19, 2, 20);
INSERT INTO CommandesSurPlace VALUES ('ferme.a.dede@fad.com', 1, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 19, 1, 20);
INSERT INTO CommandesSurPlace VALUES ('dominos.pizza@dp.com', 1, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 13, 1, 14);
INSERT INTO CommandesSurPlace VALUES ('mini.poke@mp.com',     2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 12, 2, 14);
INSERT INTO CommandesSurPlace VALUES ('sushi.shop@ss.com',    3, TO_DATE('28/01/2020', 'DD/MM/YYYY'), 13, 4, 14);

INSERT INTO EstCategorieFilleDe VALUES ('Burgers',   'Fast Food');
INSERT INTO EstCategorieFilleDe VALUES ('Pizza',     'Fast Food');
INSERT INTO EstCategorieFilleDe VALUES ('Asiatique', 'Japonaise');
INSERT INTO EstCategorieFilleDe VALUES ('Thaï',      'Japonaise');
INSERT INTO EstCategorieFilleDe VALUES ('Fast Food', 'Cuisine');
INSERT INTO EstCategorieFilleDe VALUES ('Japonaise', 'Cuisine');

INSERT INTO APourAllergene VALUES ('dominos.pizza@dp.com', 0, 'Gluten');
INSERT INTO APourAllergene VALUES ('dominos.pizza@dp.com', 1, 'Gluten');
INSERT INTO APourAllergene VALUES ('dominos.pizza@dp.com', 2, 'Gluten');
INSERT INTO APourAllergene VALUES ('mini.poke@mp.com',     1, 'Soja');
INSERT INTO APourAllergene VALUES ('sushi.shop@ss.com',    0, 'Arachides');

INSERT INTO APourTypeCommande VALUES ('burger.king@bk.com',   'aEmporter');
INSERT INTO APourTypeCommande VALUES ('burger.king@bk.com',   'surPlace');
INSERT INTO APourTypeCommande VALUES ('burger.king@bk.com',   'livraison');
INSERT INTO APourTypeCommande VALUES ('ferme.a.dede@fad.com', 'surPlace');
INSERT INTO APourTypeCommande VALUES ('dominos.pizza@dp.com', 'aEmporter');
INSERT INTO APourTypeCommande VALUES ('dominos.pizza@dp.com', 'aEmporter');
INSERT INTO APourTypeCommande VALUES ('mini.poke@mp.com',     'livraison');
INSERT INTO APourTypeCommande VALUES ('mini.poke@mp.com',     'aEmporter');
INSERT INTO APourTypeCommande VALUES ('sushi.shop@ss.com',    'surPlace');
INSERT INTO APourTypeCommande VALUES ('sushi.shop@ss.com',    'aEmporter');
INSERT INTO APourTypeCommande VALUES ('sushi.shop@ss.com',    'livraison');

INSERT INTO ContenuCommande VALUES ('burger.king@bk.com', 1, TO_DATE('25/05/2018', 'DD/MM/YYYY'), 12, 0, 3);
INSERT INTO ContenuCommande VALUES ('burger.king@bk.com', 0, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 11, 1, 3);
INSERT INTO ContenuCommande VALUES ('burger.king@bk.com', 4, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 19, 0, 4);
INSERT INTO ContenuCommande VALUES ('ferme.a.dede@fad.com', 1, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 19, 1, 1);
INSERT INTO ContenuCommande VALUES ('ferme.a.dede@fad.com', 2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 12, 0, 1);
INSERT INTO ContenuCommande VALUES ('dominos.pizza@dp.com', 4, TO_DATE('11/07/2017', 'DD/MM/YYYY'), 23, 0, 1);
INSERT INTO ContenuCommande VALUES ('dominos.pizza@dp.com', 3, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 12, 1, 1);
INSERT INTO ContenuCommande VALUES ('dominos.pizza@dp.com', 1, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 13, 2, 1);
INSERT INTO ContenuCommande VALUES ('mini.poke@mp.com', 2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 12, 2, 1);
INSERT INTO ContenuCommande VALUES ('sushi.shop@ss.com', 3, TO_DATE('28/01/2020', 'DD/MM/YYYY'), 13, 2, 1);

INSERT INTO APourCategorie VALUES ('burger.king@bk.com', 'Fast Food');
INSERT INTO APourCategorie VALUES ('ferme.a.dede@fad.com', 'Cuisine');
INSERT INTO APourCategorie VALUES ('dominos.pizza@dp.com', 'Fast Food');
INSERT INTO APourCategorie VALUES ('mini.poke@mp.com', 'Thaï');
INSERT INTO APourCategorie VALUES ('sushi.shop@ss.com', 'Japonaise');

INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 12, 'Lundi',    14);
INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 12, 'Mardi',    14);
INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 12, 'Mercredi', 14);
INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 12, 'Vendredi', 14);
INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 12, 'Samedi',   14);
INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 12, 'Dimanche', 14);
INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 19, 'Lundi',    22);
INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 19, 'Mardi',    22);
INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 19, 'Mercredi', 22);
INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 19, 'Vendredi', 23);
INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 19, 'Samedi',   23);
INSERT INTO APourHoraire VALUES ('ferme.a.dede@fad.com', 19, 'Dimanche', 22);


INSERT INTO APourEvaluation(emailResto, idClient, dateCommande, heureCommande, dateEvaluation, heureEvaluation, avis, noteEval) VALUES
();




EOFMYSQL

echo "Done !"