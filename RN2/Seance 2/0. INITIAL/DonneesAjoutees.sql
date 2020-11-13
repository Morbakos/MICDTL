INSERT INTO MARCHE (IdMarche, NomMarche) VALUES (1, 'BAYEUX PLACE ST PATRICE');
INSERT INTO MARCHAND ( IdMarchand,NomMarchand) VALUES (1, 'LA FERME BIO');
INSERT INTO MARCHAND ( IdMarchand,NomMarchand) VALUES (2, 'OEUF COCOTTE BIO');

-- 2 emplacements(100,200) de 3 mètres linéaires sur le marché de BAYEUX dans l'allée 10
INSERT INTO EMPLACEMENT (IdEmplacement,IdMarche,NoAllee,Metrage) VALUES (100,1,10,3);
INSERT INTO EMPLACEMENT (IdEmplacement,IdMarche,NoAllee,Metrage) VALUES (200,1,10,3);

-- 1 réservation sur l'emplacement 100 du marché de Bayeux pour la Ferme Bio
INSERT INTO RESERVE (IdMarchand,IdEmplacement) VALUES (1,100);