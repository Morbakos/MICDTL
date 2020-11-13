-- *************************
-- PC2 ORACLE
-- *************************

-- **** DEFINITON DES STRUCTURES

DROP TABLE PERSONNEL
/
CREATE TABLE PERSONNEL (
IdPersonnel INTEGER,
NomPersonnel VARCHAR(30) NOT NULL,
PrenomPersonnel VARCHAR(30) NOT NULL, 
AnneeNaissance INTEGER NOT NULL,
SalaireAnnuel NUMBER(10,2)
)
/
ALTER TABLE PERSONNEL
ADD CONSTRAINT PK_PERSONNEL PRIMARY KEY(IdPersonnel)
/


DROP TABLE EVOLUTION_SALAIRE
/
CREATE TABLE EVOLUTION_SALAIRE (
IdPersonnel INTEGER,
SalaireAnnuel NUMBER(10,2)
)
/

-- *** Données

INSERT INTO PERSONNEL (IdPersonnel, NomPersonnel, PrenomPersonnel,AnneeNaissance,SalaireAnnuel) VALUES (1, 'LEROYER','JEAN',1987,32400)
/
INSERT INTO PERSONNEL (IdPersonnel, NomPersonnel, PrenomPersonnel,AnneeNaissance,SalaireAnnuel) VALUES (2, 'PAROT','MARIE',1976,43700)
/
INSERT INTO PERSONNEL (IdPersonnel, NomPersonnel, PrenomPersonnel,AnneeNaissance,SalaireAnnuel) VALUES (3, 'LEONARDI','LUCAS',1965,27900)
/
INSERT INTO PERSONNEL (IdPersonnel, NomPersonnel, PrenomPersonnel,AnneeNaissance,SalaireAnnuel) VALUES (4, 'TRAVISON','LUCIE',1984,45999)
/
INSERT INTO PERSONNEL (IdPersonnel, NomPersonnel, PrenomPersonnel,AnneeNaissance,SalaireAnnuel) VALUES (5, 'TRAINIR','MELANIE',1995,31000)
/

-- *** Données

INSERT INTO EVOLUTION_SALAIRE (IdPersonnel,SalaireAnnuel) VALUES (2,43900)
/
INSERT INTO EVOLUTION_SALAIRE (IdPersonnel,SalaireAnnuel) VALUES (4,46200)
/
INSERT INTO EVOLUTION_SALAIRE (IdPersonnel,SalaireAnnuel) VALUES (5,31200)
/

-- ** Requête de mise à jour générant l'anomalie

UPDATE PERSONNEL
-- SET SalaireAnnuel = (SELECT SalaireAnnuel FROM EVOLUTION_SALAIRE WHERE PERSONNEL.IdPersonnel=EVOLUTION_SALAIRE.IdPersonnel)

-- Correction
SET SalaireAnnuel = (SELECT SalaireAnnuel FROM EVOLUTION_SALAIRE WHERE PERSONNEL.IdPersonnel=EVOLUTION_SALAIRE.IdPersonnel)
WHERE IdPersonnel in (SELECT IdPersonnel from EVOLUTION_SALAIRE)
/

SELECT * FROM PERSONNEL;
SELECT * FROM EVOLUTION_SALAIRE;