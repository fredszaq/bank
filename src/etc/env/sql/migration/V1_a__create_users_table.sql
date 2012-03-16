-- Fichier de création de la table users de la base de données bankroot

CREATE TABLE 
	users(
		login VARCHAR(50) PRIMARY KEY USING INDEX TABLESPACE ts_index
		, password VARCHAR(150) NOT NULL
		, lastname varchar(50) NOT NULL
		, firstname varchar(50) NOT NULL
		, address varchar(150)
	)
TABLESPACE 
	ts_data;

	
