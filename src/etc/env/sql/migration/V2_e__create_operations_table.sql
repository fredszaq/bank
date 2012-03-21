-- Création operations table

CREATE TABLE
	operations(
		operation_id SERIAL PRIMARY KEY USING INDEX TABLESPACE ts_index
		, compte_id VARCHAR(50)
		, transaction_id Integer
		, montant double precision NOT NULL check(montant>0)
		, operation_type_id Integer
		, CONSTRAINT fk_operations_operations_type FOREIGN KEY(operation_type_id) REFERENCES operation_types(operation_type_id)
		, CONSTRAINT fk_operations_transactions FOREIGN KEY(transaction_id) REFERENCES transactions(transaction_id)
		, CONSTRAINT fk_operations_comptes FOREIGN KEY(compte_id) REFERENCES comptes(compte_id)
	)
TABLESPACE
	ts_data;