-- modification de la table etats

ALTER TABLE
	transactions
DROP CONSTRAINT 
	fk_transactions_etat;
	
ALTER TABLE
	transactions
RENAME COLUMN
	etat_id
TO
	etat;
	
ALTER TABLE
	transactions
ALTER COLUMN
	etat
TYPE
	varchar(50);
	
ALTER TABLE
	etats
DROP CONSTRAINT
	etats_pkey;
	
ALTER TABLE
	etats
DROP COLUMN
	etat_id;
	
ALTER TABLE
	etats
ADD CONSTRAINT 
	etats_pkey 
PRIMARY KEY (etat) USING INDEX TABLESPACE 
	ts_index;

UPDATE
	transactions
SET
	etat = 'VALIDATED'
WHERE
	etat = '1';
	
UPDATE
	transactions
SET
	etat = 'WAITING'
WHERE
	etat = '2';
	
	
ALTER TABLE
	transactions
ADD CONSTRAINT 
	fk_transactions_etat
FOREIGN KEY 
	(etat)
REFERENCES 
	etats(etat);
