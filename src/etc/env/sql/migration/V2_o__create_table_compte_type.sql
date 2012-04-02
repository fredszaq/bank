-- Création de la table compte type

CREATE TABLE
	compte_types(
		compte_type varchar(50) NOT NULL PRIMARY KEY
	)
	
TABLESPACE
	ts_data;
	
-- Insertion valeurs de base

INSERT INTO
	compte_types(compte_type)
VALUES
	('COURANT'),
	('EPARGNE');
	
ALTER TABLE
	comptes
ADD CONSTRAINT 
	fk_compte_types
FOREIGN KEY 
	(compte_type)
REFERENCES 
	compte_types(compte_type);