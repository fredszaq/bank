-- Fichier de peuplement de la table authorities

INSERT INTO
	authorities (login, authority)
VALUES
	('stan', 'ROLE_AUTHENTICATED'),
	('fredszaq', 'ROLE_AUTHENTICATED'),
	('luc', 'ROLE_AUTHENTICATED');
	
INSERT INTO
	authorities (login, authority)
VALUES
	('stan', 'ROLE_ADMIN'),
	('fredszaq', 'ROLE_ADMIN'),
	('luc', 'ROLE_ADMIN');
