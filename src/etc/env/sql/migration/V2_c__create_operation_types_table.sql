-- Création des types d'opération

CREATE TABLE
	operation_types(
		operation_type_id SERIAL PRIMARY KEY USING INDEX TABLESPACE ts_index
		, operation_type VARCHAR(50) NOT NULL
	)
TABLESPACE
	ts_data;
	
-- Insertion des types d'opération	

INSERT INTO
	operation_types(operation_type)
VALUES
	('CREDIT'),
	('DEBIT');
	