-- Création de la colonne transaction_categorie_id sur la table transaction

ALTER TABLE transactions ADD COLUMN transaction_categorie_id Integer;

-- Récupération des catégories enregistrées

UPDATE transactions SET transaction_categorie_id=(
	SELECT operation_categorie_id FROM operations WHERE operations.transaction_id = transactions.transaction_id LIMIT 1
);

--ALTER TABLE operations DROP CONSTRAINT fk_operations_operations_categorie;

-- Drop de la colonne sur la table opérations
ALTER TABLE operations DROP COLUMN operation_categorie_id;

-- Renommage de la table operations_categories
ALTER TABLE operation_categories RENAME TO  transaction_categories;
ALTER TABLE transaction_categories RENAME COLUMN operation_categorie_id TO transaction_categorie_id;
ALTER TABLE transaction_categories RENAME COLUMN operation_categorie TO transaction_categorie;

-- Rajout de la contrainte d'intégrité
ALTER TABLE transactions ADD CONSTRAINT fk_transactions_categories FOREIGN KEY(transaction_categorie_id) REFERENCES transaction_categories(transaction_categorie_id);
