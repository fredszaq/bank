-- Création de la table de jointure

CREATE TABLE 
	comptes_operations(
		compte_id VARCHAR(50)
		, operation_id Integer
		, CONSTRAINT pk_comptes_operations PRIMARY KEY(compte_id, operation_id) USING INDEX TABLESPACE ts_index
		, CONSTRAINT fk_co_compte FOREIGN KEY(compte_id) REFERENCES comptes(compte_id)
		, CONSTRAINT fk_co_operation FOREIGN KEY(operation_id) REFERENCES operations(operation_id)
    )
TABLESPACE 
	ts_data;
