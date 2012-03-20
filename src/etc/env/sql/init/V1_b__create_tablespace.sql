-- Fichier de création des tablespace la base de données bankroot

CREATE TABLESPACE
	ts_index
OWNER
	excilys
LOCATION
	'/var/lib/postgresql/8.4/tablespace/index';
	
CREATE TABLESPACE
	ts_data
OWNER
	excilys
LOCATION
	'/var/lib/postgresql/8.4/tablespace/data';