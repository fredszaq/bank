-- Fichier de création de la table users de la base de données bankroot

CREATE TABLE 
	users(
		login VARCHAR(50) PRIMARY KEY USING INDEX TABLESPACE ts_index
		, password VARCHAR(150) NOT NULL
		, lastname varchar(50) NOT NULL
		, firstname varchar(50) NOT NULL
		, address varchar(150)
		, authority_id INTEGER NOT NULL
		, CONSTRAINT fk_authorities_users FOREIGN KEY(authority_id) REFERENCES authorities(authority_id)
	)
TABLESPACE 
	ts_data;

	
CREATE UNIQUE INDEX 
	index_authorities_login 
ON 
	users (login,authority_id)
TABLESPACE 
	ts_index;
	
