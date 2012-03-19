-- Enlevation de la colonne login de la table users

ALTER TABLE comptes DROP COLUMN login;

-- Ajout des comptes associés aux utilisateurs robert et jacky

INSERT INTO
	comptes (compte_id, compte_type, solde)
VALUES
	('compte_epargne_robert', 'EPARGNE', 1200.54),
	('compte_courant_robert', 'COURANT', 354),
	('compte_courant_jacky', 'COURANT', 7467.32);

-- Renommage table user_comptes en users_comptes
	
ALTER TABLE user_comptes RENAME TO users_comptes;

-- Ajout des liens users/comptes

INSERT INTO
	users_comptes (login, compte_id)
VALUES
	('robert', 'compte_epargne_robert'),
	('robert', 'compte_courant_robert'),
	('jacky', 'compte_courant_jacky');
