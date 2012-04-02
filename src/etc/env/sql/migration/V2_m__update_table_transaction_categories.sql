-- modification de la table etats

ALTER TABLE
	transactions
DROP CONSTRAINT 
	fk_transactions_categories;
	
ALTER TABLE
	transactions
RENAME COLUMN
	transaction_categorie_id
TO
	transaction_categorie;
	
ALTER TABLE
	transactions
ALTER COLUMN
	transaction_categorie
TYPE
	varchar(50);
	
ALTER TABLE
	transaction_categories
DROP CONSTRAINT
	operation_categories_pkey;
	
ALTER TABLE
	transaction_categories
DROP COLUMN
	transaction_categorie_id;
	
ALTER TABLE
	transaction_categories
ADD CONSTRAINT 
	transaction_categories_pkey 
PRIMARY KEY (transaction_categorie) USING INDEX TABLESPACE 
	ts_index;

UPDATE
	transactions
SET
	transaction_categorie = 'CARTE'
WHERE
	transaction_categorie = '1';
	
UPDATE
	transactions
SET
	transaction_categorie = 'VIREMENT_INTERNE'
WHERE
	transaction_categorie = '2';

UPDATE
	transactions
SET
	transaction_categorie = 'VIREMENT_EXTERNE'
WHERE
	transaction_categorie = '3';
	
	
ALTER TABLE
	transactions
ADD CONSTRAINT 
	fk_transactions_categories
FOREIGN KEY 
	(transaction_categorie)
REFERENCES 
	transaction_categories(transaction_categorie);
