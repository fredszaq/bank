-- Fichier de création de la table authorities de la base de données bankroot

CREATE TABLE 
	authorities(
		authority_id SERIAL PRIMARY KEY USING INDEX TABLESPACE ts_index
		, login VARCHAR(50) NOT NULL
		, authority VARCHAR(50) NOT NULL
		, CONSTRAINT fk_authorities_users FOREIGN KEY(login) REFERENCES users(login)
    )
TABLESPACE 
	ts_data;

CREATE UNIQUE INDEX 
	index_authorities_login 
ON 
	authorities (login,authority)
TABLESPACE 
	ts_index;
	
