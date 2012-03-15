-- Création de la table de comptes

CREATE TABLE 
	comptes(
		compte_id VARCHAR(50) PRIMARY KEY USING INDEX TABLESPACE ts_index
		, compte_type VARCHAR(50) NOT NULL
		, solde double precision NOT NULL
		, login VARCHAR(50)
		, CONSTRAINT fk_user_compte FOREIGN KEY(login) REFERENCES users(login)
	)
TABLESPACE 
	ts_data;

-- Création de la table de jointure user-comptes
	
CREATE TABLE
	user_comptes(
		login VARCHAR(50)
		, compte_id VARCHAR(50) PRIMARY KEY USING INDEX TABLESPACE ts_index 
		, CONSTRAINT fk_user FOREIGN KEY(login) REFERENCES users(login)
		, CONSTRAINT fk_compte FOREIGN KEY(compte_id) REFERENCES comptes(compte_id)
		
	)
TABLESPACE 
	ts_data;