-- Modification de la clef primaire users_comptes

ALTER TABLE 
	users_comptes 
DROP CONSTRAINT 
	user_comptes_pkey;
	
ALTER TABLE 
	users_comptes 
ADD PRIMARY KEY
	(login, compte_id)
USING INDEX TABLESPACE 
	ts_index;


