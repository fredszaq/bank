-- modification de la table etats

ALTER TABLE
	operations
DROP CONSTRAINT 
	fk_operations_operations_type;
	
ALTER TABLE
	operations
RENAME COLUMN
	operation_type_id
TO
	operation_type;
	
ALTER TABLE
	operations
ALTER COLUMN
	operation_type
TYPE
	varchar(50);
	
ALTER TABLE
	operation_types
DROP CONSTRAINT
	operation_types_pkey;
	
ALTER TABLE
	operation_types
DROP COLUMN
	operation_type_id;
	
ALTER TABLE
	operation_types
ADD CONSTRAINT 
	operation_types_pkey 
PRIMARY KEY (operation_type) USING INDEX TABLESPACE 
	ts_index;

UPDATE
	operations
SET
	operation_type = 'CREDIT'
WHERE
	operation_type = '1';
	
UPDATE
	operations
SET
	operation_type = 'DEBIT'
WHERE
	operation_type = '2';
	
	
ALTER TABLE
	operations
ADD CONSTRAINT 
	fk_operations_operations_type
FOREIGN KEY 
	(operation_type)
REFERENCES 
	operation_types(operation_type);
