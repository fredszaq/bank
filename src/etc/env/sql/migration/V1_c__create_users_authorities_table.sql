-- Fichier de création de la table authorities de la base de données bankroot

CREATE TABLE 
	users_authorities(
		authority_id Integer NOT NULL
		, login VARCHAR(50) NOT NULL
		, CONSTRAINT pk_users_authorities PRIMARY KEY(authority_id, login) USING INDEX TABLESPACE ts_index
		, CONSTRAINT fk_ua_user FOREIGN KEY(login) REFERENCES users(login)
		, CONSTRAINT fk_ua_authority FOREIGN KEY(authority_id) REFERENCES authorities(authority_id)
    )
TABLESPACE 
	ts_data;
	
