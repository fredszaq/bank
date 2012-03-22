-- Création des types d'opération

CREATE TABLE
	operation_categories(
		operation_categorie_id SERIAL PRIMARY KEY USING INDEX TABLESPACE ts_index
		, operation_categorie VARCHAR(50) NOT NULL
	)
TABLESPACE
	ts_data;
	
-- Insertion des types d'opération	

INSERT INTO
	operation_categories(operation_categorie)
VALUES
	('CARTE'),
	('VIREMENT_INTERNE'),
	('VIREMENT_EXTERNE');
	