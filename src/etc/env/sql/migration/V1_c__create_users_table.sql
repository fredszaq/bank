-- Fichier de création des tables de la base de données bankroot

CREATE TABLE 
	authorities(
		id_authorities SERIAL PRIMARY KEY USING INDEX TABLESPACE ts_index
		, authority VARCHAR(50) NOT NULL
    )
TABLESPACE 
	ts_data;

CREATE TABLE 
	users(
		id_user SERIAL PRIMARY KEY USING INDEX TABLESPACE ts_index
		, username VARCHAR(50) NOT NULL
		, password VARCHAR(50) NOT NULL
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
	
