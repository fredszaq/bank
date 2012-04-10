ALTER TABLE users_authorities RENAME TO  utilisateur_droit;
ALTER TABLE users RENAME TO  utilisateur;
ALTER TABLE authorities RENAME TO  droit;
ALTER TABLE users_comptes RENAME TO utilisateur_compte;
ALTER TABLE comptes RENAME TO  compte;
ALTER TABLE comptes_operations RENAME TO  compte_operation;
ALTER TABLE operations RENAME TO  operation;
ALTER TABLE operation_types RENAME TO  operation_type;
ALTER TABLE transactions RENAME TO  transaction;
ALTER TABLE compte_types RENAME TO  compte_type;
ALTER TABLE etats RENAME TO  etat;
ALTER TABLE transaction_categories RENAME TO transaction_categorie;

ALTER TABLE utilisateur_droit DROP CONSTRAINT pk_users_authorities;
ALTER TABLE utilisateur_droit DROP CONSTRAINT fk_ua_authority;
ALTER TABLE utilisateur_droit DROP CONSTRAINT fk_ua_user;
ALTER TABLE droit DROP CONSTRAINT authorities_pkey;
ALTER TABLE utilisateur_compte DROP CONSTRAINT fk_compte;
ALTER TABLE utilisateur_compte DROP CONSTRAINT fk_user;
ALTER TABLE utilisateur_compte DROP CONSTRAINT users_comptes_pkey;
ALTER TABLE compte_operation DROP CONSTRAINT pk_comptes_operations;
ALTER TABLE compte_operation DROP CONSTRAINT fk_co_compte;
ALTER TABLE compte_operation DROP CONSTRAINT fk_co_operation ;
ALTER TABLE utilisateur DROP CONSTRAINT users_pkey;
ALTER TABLE compte DROP CONSTRAINT comptes_pkey;
ALTER TABLE compte DROP CONSTRAINT fk_compte_types;
ALTER TABLE operation DROP CONSTRAINT operations_pkey;
ALTER TABLE operation DROP CONSTRAINT fk_operations_operations_type;
ALTER TABLE operation DROP CONSTRAINT fk_operations_transactions;
ALTER TABLE operation_type DROP CONSTRAINT operation_types_pkey;
ALTER TABLE transaction DROP CONSTRAINT transactions_pkey;
ALTER TABLE transaction DROP CONSTRAINT fk_transactions_categories;
ALTER TABLE transaction DROP CONSTRAINT fk_transactions_etat;
ALTER TABLE compte_type DROP CONSTRAINT compte_types_pkey;
ALTER TABLE etat DROP CONSTRAINT etats_pkey;
ALTER TABLE transaction_categorie DROP CONSTRAINT transaction_categories_pkey;

ALTER TABLE utilisateur ADD CONSTRAINT pk_utilisateur PRIMARY KEY (login) USING INDEX TABLESPACE ts_index;
ALTER TABLE droit ADD CONSTRAINT pk_droit PRIMARY KEY (authority_id) USING INDEX TABLESPACE ts_index;
ALTER TABLE utilisateur_droit ADD CONSTRAINT pk_utilisateur_droit PRIMARY KEY (authority_id, login) USING INDEX TABLESPACE ts_index;
ALTER TABLE compte ADD CONSTRAINT pk_compte PRIMARY KEY (compte_id) USING INDEX TABLESPACE ts_index;
ALTER TABLE utilisateur_compte ADD CONSTRAINT pk_utilisateur_compte PRIMARY KEY (login, compte_id) USING INDEX TABLESPACE ts_index;
ALTER TABLE compte_operation ADD CONSTRAINT pk_compte_operation PRIMARY KEY (compte_id, operation_id) USING INDEX TABLESPACE ts_index;
ALTER TABLE operation ADD CONSTRAINT pk_operation PRIMARY KEY (operation_id) USING INDEX TABLESPACE ts_index;
ALTER TABLE operation_type ADD CONSTRAINT pk_operation_type PRIMARY KEY (operation_type) USING INDEX TABLESPACE ts_index;
ALTER TABLE transaction ADD CONSTRAINT pk_transaction PRIMARY KEY (transaction_id) USING INDEX TABLESPACE ts_index;
ALTER TABLE compte_type ADD CONSTRAINT pk_compte_type PRIMARY KEY (compte_type) USING INDEX TABLESPACE ts_index;
ALTER TABLE etat ADD CONSTRAINT pk_etat PRIMARY KEY (etat) USING INDEX TABLESPACE ts_index;
ALTER TABLE transaction_categorie ADD CONSTRAINT pk_transaction_categorie PRIMARY KEY (transaction_categorie) USING INDEX TABLESPACE ts_index;

ALTER TABLE utilisateur_droit ADD CONSTRAINT fk_utilisateur_droit_droit FOREIGN KEY (authority_id) REFERENCES droit(authority_id);
ALTER TABLE utilisateur_droit ADD CONSTRAINT fk_utilisateur_droit_utilisateur FOREIGN KEY (login) REFERENCES utilisateur(login);
ALTER TABLE utilisateur_compte ADD CONSTRAINT fk_utilisateur_compte_compte FOREIGN KEY (compte_id) REFERENCES compte(compte_id);
ALTER TABLE utilisateur_compte ADD CONSTRAINT fk_utilisateur_compte_utilisateur FOREIGN KEY (login) REFERENCES utilisateur(login);
ALTER TABLE compte_operation ADD CONSTRAINT fk_compte_operation_compte FOREIGN KEY (compte_id) REFERENCES compte(compte_id);
ALTER TABLE compte_operation ADD CONSTRAINT fk_compte_operation_operation FOREIGN KEY (operation_id) REFERENCES operation(operation_id);
ALTER TABLE operation ADD CONSTRAINT fk_operation_transaction FOREIGN KEY (transaction_id) REFERENCES transaction(transaction_id);
ALTER TABLE operation ADD CONSTRAINT fk_operation_operation_type FOREIGN KEY (operation_type) REFERENCES operation_type(operation_type);
ALTER TABLE transaction ADD CONSTRAINT fk_transaction_transaction_categorie FOREIGN KEY (transaction_categorie) REFERENCES transaction_categorie(transaction_categorie);
ALTER TABLE transaction ADD CONSTRAINT fk_transaction_etat FOREIGN KEY (etat) REFERENCES etat(etat);
ALTER TABLE compte ADD CONSTRAINT fk_comtpe_comtpe_type FOREIGN KEY (compte_type) REFERENCES compte_type(compte_type);