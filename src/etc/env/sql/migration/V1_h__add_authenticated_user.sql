-- Ajout de plusieurs utilisateurs authentifiés

-- Ajout à la table users
INSERT INTO
	users (login, password, lastname, firstname, address)
VALUES
	('robert', 'abec4c69a40a5d29fddf759532294c2f003384c9f6396d8ca54e487f604b4af8c9f0887d5ec3b782', 'Dupont', 'Robert', '43 rue Camille Desmoulins 94230 Cachan'),
	('jacky', '733ff2a136ad7ce76d0025fb645adddc520a79a7ad9087f41a18fddd82a2701ee22b4d703cbc677e', 'Moutmout', 'Jacky', '47 avenue Carnot 94230 Cachan');

INSERT INTO
	users_authorities (login, authority_id)
VALUES
	('robert', 1),
	('jacky', 1);
