-- -----------------------------------------------------------------------------
--                Auteur: Alexis JACOB
--                Date: 18/11/2020
-- -----------------------------------------------------------------------------

ALTER SESSION SET NLS_DATE_FORMAT = 'dd/mm/yyyy';

-- -----------------------------------------------------------------------------
--                LOT 1
-- -----------------------------------------------------------------------------

-- Création des tables avec leurs clés primaires et les séquences

-- Région
DROP SEQUENCE SEQUENCE_REGION;
CREATE SEQUENCE SEQUENCE_REGION START WITH 1 MINVALUE 1;

DROP TABLE Region CASCADE CONSTRAINTS PURGE;
CREATE TABLE Region (
    Id_Reg INTEGER,
    Nom_Reg VARCHAR2(64) NOT NULL CONSTRAINT U_nom_reg UNIQUE,
    Superficie_Reg integer
);

-- Ajout de la clé primaire
ALTER TABLE Region
    ADD CONSTRAINT PK_JA_REGION PRIMARY KEY(Id_Reg);

-- ---------------------------------------------------------------------------------------------

-- Organisateur
DROP SEQUENCE SEQUENCE_ORGANISATEUR;
CREATE SEQUENCE SEQUENCE_ORGANISATEUR START WITH 1 MINVALUE 1;

DROP TABLE Organisateur CASCADE CONSTRAINTS PURGE;
CREATE TABLE Organisateur (
    Id_Org INTEGER,
    Prenom_Org VARCHAR2(32) NOT NULL,
    Nom_Org VARCHAR2(32) NOT NULL,
    Association_Org VARCHAR2(64) NOT NULL,
    Email_Org VARCHAR2(64) NOT NULL,
    Tel_Org VARCHAR2(64),
    Reg_Org integer NOT NULL
);

-- Ajout de la clé primaire et de la clé étrangère dans Organisateur
ALTER TABLE Organisateur
    ADD CONSTRAINT PK_JA_ORGANISATEUR PRIMARY KEY(Id_Org)
    ADD CONSTRAINT FK_JA_REGION_ORGANISATEUR FOREIGN KEY(Reg_Org) REFERENCES Region(Id_Reg);

-- ---------------------------------------------------------------------------------------------

-- Campagne
DROP SEQUENCE SEQUENCE_CAMPAGNE;
CREATE SEQUENCE SEQUENCE_CAMPAGNE START WITH 1 MINVALUE 1;

DROP TABLE Campagne CASCADE CONSTRAINTS PURGE;
CREATE TABLE Campagne (
    Id_Camp INTEGER,
    Nom_Camp VARCHAR(255) NOT NULL,
    NbOrganisateurs integer,
    Budgets NUMBER(10,2)
);

-- Ajout de la clé primaire
ALTER TABLE Campagne
    ADD CONSTRAINT PK_JA_CAMPAGNE PRIMARY KEY(Id_Camp);

-- ---------------------------------------------------------------------------------------------

-- Evenement
DROP SEQUENCE SEQUENCE_EVENEMENT;
CREATE SEQUENCE SEQUENCE_EVENEMENT START WITH 1 MINVALUE 1;

DROP TABLE Evenement CASCADE CONSTRAINTS PURGE;
CREATE TABLE Evenement (
    Id_Evt INTEGER,
    Nom_Evt VARCHAR(255) NOT NULL,
    Id_Camp integer NOT NULL
);

-- Ajout de la clé primaire
ALTER TABLE Evenement
    ADD CONSTRAINT PK_JA_EVENEMENT PRIMARY KEY(Id_evt)
    ADD CONSTRAINT FK_JA_EVENEMENT_ORGANISATEUR FOREIGN KEY(Id_Camp) REFERENCES Campagne(Id_Camp);

-- ---------------------------------------------------------------------------------------------

-- Collaborer
DROP TABLE Collaborer CASCADE CONSTRAINTS PURGE;
CREATE TABLE Collaborer (
    Id_Org INTEGER,
    Id_Camp INTEGER,
    DateCollaboration DATE NOT NULL
);

-- Ajout de la clé primaire
ALTER TABLE Collaborer
    ADD CONSTRAINT PK_JA_COLLABORER PRIMARY KEY(Id_Org, Id_Camp)
    ADD CONSTRAINT FK_JA_COLLABORER_ORG FOREIGN KEY(Id_Org) REFERENCES Organisateur(Id_Org)
    ADD CONSTRAINT FK_JA_COLLABORER_CAMP FOREIGN KEY(Id_Camp) REFERENCES Campagne(Id_Camp);

-- ---------------------------------------------------------------------------------------------

-- Assister
DROP TABLE Assister CASCADE CONSTRAINTS PURGE;
CREATE TABLE Assister (
    Id_Org INTEGER,
    Id_Evt INTEGER,
    Presence NUMBER(1) NOT NULL
);

-- Ajout de la clé primaire
ALTER TABLE Assister
    ADD CONSTRAINT PK_JA_ASSISTER PRIMARY KEY(Id_Org, Id_Evt)
    ADD CONSTRAINT FK_JA_ASSISTER_ORG FOREIGN KEY(Id_Org) REFERENCES Organisateur(Id_Org)
    ADD CONSTRAINT FK_JA_ASSISTER_EVT FOREIGN KEY(Id_Evt) REFERENCES Evenement(Id_Evt);


-- -----------------------------------------------------------------------------
--                LOT 2
-- -----------------------------------------------------------------------------

-- Population de la base
-- Ajout de 3 régions
INSERT INTO Region (Id_Reg, Nom_Reg, Superficie_Reg)
VALUES (SEQUENCE_REGION.NEXTVAL, 'Île de France', 4500);
INSERT INTO Region (Id_Reg, Nom_Reg, Superficie_Reg)
VALUES (SEQUENCE_REGION.NEXTVAL, 'PACA', 16300);
INSERT INTO Region (Id_Reg, Nom_Reg, Superficie_Reg)
VALUES (SEQUENCE_REGION.NEXTVAL, 'Haut de france', 44500);

-- Ajout de 5 organisateurs
INSERT INTO Organisateur (Id_Org, Prenom_Org, Nom_Org, Association_Org, Email_Org, Tel_Org, Reg_Org)
VALUES (SEQUENCE_ORGANISATEUR.NEXTVAL, 'Alexis', 'Jacob', 'GIE', 'ajacob@gie.fr', '0628788024', 1);
INSERT INTO Organisateur (Id_Org, Prenom_Org, Nom_Org, Association_Org, Email_Org, Tel_Org, Reg_Org)
VALUES (SEQUENCE_ORGANISATEUR.NEXTVAL, 'Gavin', 'Sertix', 'GIE', 'gsertix@gie.fr', '', 1);
INSERT INTO Organisateur (Id_Org, Prenom_Org, Nom_Org, Association_Org, Email_Org, Tel_Org, Reg_Org)
VALUES (SEQUENCE_ORGANISATEUR.NEXTVAL, 'Thomas', 'Shelby', 'Antoil', 'contact@antoil.com', '', 2);
INSERT INTO Organisateur (Id_Org, Prenom_Org, Nom_Org, Association_Org, Email_Org, Tel_Org, Reg_Org)
VALUES (SEQUENCE_ORGANISATEUR.NEXTVAL, 'Juan', 'Gomez', 'GNIE', 'gomez@gnie.fr', '', 2);
INSERT INTO Organisateur (Id_Org, Prenom_Org, Nom_Org, Association_Org, Email_Org, Tel_Org, Reg_Org)
VALUES (SEQUENCE_ORGANISATEUR.NEXTVAL, 'Stan', 'Foster', 'GIE', 'sfoster@gie.fr', '', 2);

-- Ajout de campagnes
INSERT INTO Campagne (Id_Camp, Nom_Camp, NbOrganisateurs, Budgets)
VALUES (SEQUENCE_CAMPAGNE.NEXTVAL, 'Raise funds !', 1, 8000.20);
INSERT INTO Campagne (Id_Camp, Nom_Camp, NbOrganisateurs, Budgets)
VALUES (SEQUENCE_CAMPAGNE.NEXTVAL, 'Raise funds 2 !', 8, 8000.20);
INSERT INTO Campagne (Id_Camp, Nom_Camp, NbOrganisateurs, Budgets)
VALUES (SEQUENCE_CAMPAGNE.NEXTVAL, 'Raise funds  3!', 7, 8000.20);

-- Ajout d'evenements
INSERT INTO Evenement (Id_Evt, Nom_Evt, Id_Camp)
VALUES (SEQUENCE_EVENEMENT.NEXTVAL, 'Teleton 1', 1);
INSERT INTO Evenement (Id_Evt, Nom_Evt, Id_Camp)
VALUES (SEQUENCE_REGION.NEXTVAL, 'Trileton 1', 2);
INSERT INTO Evenement (Id_Evt, Nom_Evt, Id_Camp)
VALUES (SEQUENCE_REGION.NEXTVAL, 'Megaton 1', 2);


-- Ajout de collaboration
INSERT INTO Collaborer (Id_Org, Id_Camp, DateCollaboration)
VALUES (1, 3, '20/05/2020');
INSERT INTO Collaborer (Id_Org, Id_Camp, DateCollaboration)
VALUES (4, 1, '13/12/2010');
INSERT INTO Collaborer (Id_Org, Id_Camp, DateCollaboration)
VALUES (3, 2, '10/05/2018');

-- Ajout de participations
INSERT INTO Assister (Id_Org, Id_evt, Presence)
VALUES (1, 3, 1);
INSERT INTO Assister (Id_Org, Id_evt, Presence)
VALUES (1, 2, 0);
INSERT INTO Assister (Id_Org, Id_evt, Presence)
VALUES (1, 1, 0);
INSERT INTO Assister (Id_Org, Id_evt, Presence)
VALUES (2, 2, 1);
INSERT INTO Assister (Id_Org, Id_evt, Presence)
VALUES (2, 3, 1);
INSERT INTO Assister (Id_Org, Id_evt, Presence)
VALUES (3, 2, 0);


-- Requete de jointure
-- Cette requete permet de sélectionner toutes les régions des organisateurs
SELECT
    org.Nom_Org,
    org.Prenom_Org,
    org.Association_Org,
    org.Email_Org,
    reg.Nom_Reg
FROM 
    Organisateur org
JOIN Region reg
    ON org.Reg_Org = reg.Id_Reg;

-- Requete de groupement
-- Cette requete permet de sélectionner toutes les régions des organisateurs, groupés par associations
SELECT
    org.Nom_Org,
    org.Prenom_Org,
    org.Association_Org,
    org.Email_Org,
    reg.Nom_Reg
FROM 
    Organisateur org
JOIN Region reg
    ON org.Reg_Org = reg.Id_Reg
GROUP BY 
    org.Association_Org, reg.Nom_Reg;

-- Requete d'exclusion
-- Cette requête permet de sélectionner tous les organisateurs qui n'ont pas participés à la campagne N°3
SELECT 
    org.Id_Org,
    org.Nom_Org,
    org.Prenom_Org,
    org.Association_Org,
    org.Email_Org
FROM
    Organisateur org
WHERE
    org.Id_Org NOT IN (select Id_Org FROM Collaborer WHERE Collaborer.Id_Camp = 3);

-- Requete au choix
-- Cette requête permet de sélectionner tous les organisateurs qui n'ont pas participé à l'événement 1
SELECT 
    org.Id_Org,
    org.Nom_Org,
    org.Prenom_Org,
    org.Association_Org,
    org.Email_Org
FROM
    Organisateur org
WHERE
    org.Id_Org NOT IN (select Id_Org FROM Assister WHERE Assister.Id_Evt = 1);