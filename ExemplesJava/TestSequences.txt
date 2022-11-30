/*  SEQUENCES  */
/* Les sequences permettent de generer des numeros uniques. */
/* Elles sont souvent utilisees pour generer des cles.      */
/* Une sequence est initialisee a 0 par default et incrementee *
/* de 1 a chaque appel pour demander une nouvelle valeur. */


/* Creation d'un objet sequence  */
create sequence MiLlave;


/* Utilisation pour générer des valeurs uniques   */
create table A ( a1 int,  a2 int);
insert into A values( MiLlave.nextval, 5);

/* NOTA : l'incrément est exécuté par oracle independament de la validation
(commit) ou l'annulation (rollback) de la transaction */


/* Consultation de la valeur courante du compteur  */
select  MiLlave.currval from Dual ;
