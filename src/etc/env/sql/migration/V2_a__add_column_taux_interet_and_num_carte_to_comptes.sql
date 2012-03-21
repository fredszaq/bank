-- Ajout de la colonne taux d'intérêt à la table comptes

ALTER TABLE
	comptes
ADD COLUMN taux_interet double precision default 0 check(taux_interet between 0.00 and 100.00),
ADD COLUMN num_carte VARCHAR(50) default null;

-- Modification des comptes existants

UPDATE comptes SET taux_interet=2.5 WHERE compte_type='EPARGNE';

UPDATE comptes SET num_carte='carte_robert' WHERE compte_id='compte_courant_robert';

UPDATE comptes SET num_carte='carte_jacky' WHERE compte_id='compte_courant_jacky';