-- Insertion d'opérations pour robert

-- Création de deux transactions
INSERT INTO
	transactions(date_init, etat_id)
VALUES
	('2012-03-21', 1), -- validated
	('2012-03-22', 2); -- waiting

-- Création des opérations
	
INSERT INTO
	operations (transaction_id, montant, operation_type_id, operation_categorie_id, libelle)
VALUES
	(1, 42, 2, 2, 'me voici tout défriqué, je suis un épargnant parfait'), -- virement interne de 42€ (débit)
	(1, 42, 1, 2, 'me voici tout défriqué, je suis un épargnant parfait'), -- virement interne de 42€ (crédit)
	(2, 24, 2, 1, 'je paye par carte'); -- paiement carte de 24€ en attente (débit)
	
-- Jointure compte/opération
	
INSERT INTO
	comptes_operations (compte_id, operation_id)
VALUES
	('compte_courant_robert', 1),
	('compte_epargne_robert', 2),
	('compte_courant_jacky', 3);
	

