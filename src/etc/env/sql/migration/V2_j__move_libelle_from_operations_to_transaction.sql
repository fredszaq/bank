-- Création de la colonne libellé sur la table transaction

ALTER TABLE transactions ADD COLUMN libelle VARCHAR(150);

-- Déplacement des libellés courant sur la nouvelle table

UPDATE transactions SET libelle=(
	SELECT libelle FROM operations WHERE operations.transaction_id = transactions.transaction_id LIMIT 1
);

-- Suppression de la colonne libelle de la table opérations

ALTER TABLE operations DROP COLUMN libelle;