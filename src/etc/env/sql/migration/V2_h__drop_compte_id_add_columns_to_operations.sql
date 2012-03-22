-- suppression de la colonne compte_id de la table operations

ALTER TABLE operations DROP COLUMN compte_id;

-- Ajout du libellé pour les opérations

ALTER TABLE operations ADD COLUMN libelle VARCHAR(150);


-- Ajout de la colonne operation_categorie_id

ALTER TABLE operations ADD COLUMN operation_categorie_id Integer;
ALTER TABLE operations ADD CONSTRAINT fk_operations_operations_categorie FOREIGN KEY(operation_categorie_id) REFERENCES operation_categories(operation_categorie_id);
		