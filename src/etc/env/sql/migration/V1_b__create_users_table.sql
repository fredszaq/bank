-- Fichier de création de la table users de la base de données bankroot

CREATE TABLE 
	users(
		username VARCHAR(50) PRIMARY KEY USING INDEX TABLESPACE ts_index
		, password VARCHAR(50) NOT NULL
		, lastname varchar(50) NOT NULL
		, firstname varchar(50) NOT NULL
		, address varchar(150)
		, id_authorities INTEGER NOT NULL
		, CONSTRAINT fk_authorities_users FOREIGN KEY(id_authorities) REFERENCES authorities(id_authorities)
	)
TABLESPACE 
	ts_data;

	
CREATE UNIQUE INDEX 
	index_authorities_username 
ON 
	users (username,id_authorities)
TABLESPACE 
	ts_index;
	
