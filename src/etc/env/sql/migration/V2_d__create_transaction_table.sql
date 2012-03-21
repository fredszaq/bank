-- Création de la table de transactions (composée d'opérations)

CREATE TABLE
	transactions(
		transaction_id SERIAL PRIMARY KEY USING INDEX TABLESPACE ts_index
		, date_init timestamp NOT NULL
		, date_valid timestamp
		, etat_id Integer
		, CONSTRAINT fk_transactions_etat FOREIGN KEY(etat_id) REFERENCES etats(etat_id)
	)
TABLESPACE
	ts_data;