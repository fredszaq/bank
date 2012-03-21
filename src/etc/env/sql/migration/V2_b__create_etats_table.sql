-- Création de la table états

CREATE TABLE 
	etats(
		etat_id SERIAL PRIMARY KEY USING INDEX TABLESPACE ts_index
		, etat VARCHAR(50) NOT NULL
    )
TABLESPACE 
	ts_data;
	
-- Insertion valeurs de base

INSERT INTO
	etats(etat)
VALUES
	('VALIDATED'),
	('WAITING');