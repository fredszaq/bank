--modification table comptes
ALTER table comptes ADD column solde2 bigint;
update comptes SET solde2=solde*100;
ALTER table comptes DROP column solde;
ALTER table comptes RENAME COLUMN solde2 TO solde;

--modification table operation 
ALTER table operations ADD column montant2 bigint;
update operations SET montant2=montant*100;
ALTER table operations DROP column montant;
ALTER table operations RENAME COLUMN montant2 TO montant;