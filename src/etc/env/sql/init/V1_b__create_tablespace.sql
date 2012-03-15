-- Fichier de création des tablespace la base de données bankroot

CREATE TABLESPACE
	ts_index
OWNER
	excilys
LOCATION
	'/tmp/postgresql/tablespace/index';
	
CREATE TABLESPACE
	ts_data
OWNER
	excilys
LOCATION
	'/tmp/postgresql/tablespace/data';

CREATE TABLESPACE
	ts_temp
OWNER
	excilys
LOCATION
	'/tmp/postgresql/tablespace/temp';