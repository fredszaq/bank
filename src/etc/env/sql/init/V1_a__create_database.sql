-- Fichier de création de la base de données bankroot

CREATE USER
	excilys;

ALTER ROLE 
	excilys
WITH 
	SUPERUSER;
	
CREATE DATABASE 
	bank 
OWNER 
	excilys;
	
ALTER USER 
	excilys 
WITH ENCRYPTED PASSWORD 
	'excilys';