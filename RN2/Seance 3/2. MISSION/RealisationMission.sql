-- -----------------------------------------------------------------------------
--                QUESTION 1
-- -----------------------------------------------------------------------------


-- On créer la table qui permettra de gérer les historiques
DROP TABLE HISTORIQUE_SALAIRE;
CREATE TABLE HISTORIQUE_SALAIRE (
	idHistoriqueSalaire integer CONSTRAINT PK_HOSTORIQUE_SALAIRE PRIMARY KEY,
	MatriculePilote integer NOT NULL,
	DateSalaire DATE NOT NULL,
	Salaire integer NOT NULL
);

-- On créer la séquence pour avoir un id unique
DROP SEQUENCE SEQUENCE_HISTORIQUE_SALAIRE;
CREATE SEQUENCE SEQUENCE_HISTORIQUE_SALAIRE START WITH 1 MINVALUE 1;

-- Ajout de la clé étrangère de la tabl HISTORIQUE_SALAIRE
ALTER TABLE HISTORIQUE_SALAIRE 
	ADD CONSTRAINT FK_HISTORIQUE_SALAIRE_PILOTE FOREIGN KEY(MatriculePilote) REFERENCES PILOTE(Matricule);

-- On créer le trigger pour ajouter les données ou les modifiers
CREATE OR REPLACE TRIGGER trigger_historique_salaire 
    BEFORE UPDATE ON PILOTE 
FOR EACH ROW
    BEGIN
        INSERT INTO HISTORIQUE_SALAIRE (idHistoriqueSalaire, MatriculePilote, DateSalaire, Salaire) 
        VALUES ( SEQUENCE_HISTORIQUE_SALAIRE.NEXTVAL, :OLD.Matricule, SYSDATE, :OLD.Salaire );
    END;
/

-- -----------------------------------------------------------------------------
--                QUESTION 2
-- -----------------------------------------------------------------------------

-- Voir image Q2 jointe à l'archive pour le schéma

-- On créé la table typeAvion
DROP TABLE TYPEAVION;
CREATE TABLE TYPEAVION (
    idTypeAvion integer,
    designation VARCHAR2(10) CONSTRAINT U_designation_avion UNIQUE,
    CONSTRAINT PK_TYPEAVION PRIMARY KEY (idTypeAvion)
);

-- On créé une séquence pour TypeAvion
DROP SEQUENCE SEQUENCE_TYPE_AVION;
CREATE SEQUENCE SEQUENCE_TYPE_AVION START WITH 1 MINVALUE 1;

-- On insert les données dans TYPEAVION
INSERT INTO TYPEAVION (idTypeAvion, designation)
SELECT SEQUENCE_TYPE_AVION.NEXTVAL, designation
FROM (SELECT DISTINCT UPPER(TRIM(type)) AS designation FROM avion);

-- On drop la table QUALIFICATIONS et on la recréée
DROP TABLE QUALIFICATIONS;
CREATE TABLE QUALIFICATIONS (
    MatriculePilote integer,
    idTypeAvion integer,
    CONSTRAINT PK_QUALIFICATION PRIMARY KEY (MatriculePilote, idTypeAvion),
    CONSTRAINT FK_QUALIFICATION_PILOTE FOREIGN KEY(MatriculePilote) REFERENCES PILOTE(Matricule),
    CONSTRAINT FK_QUALIFICATION_AVION FOREIGN KEY(idTypeAvion) REFERENCES TypeAvion(idTypeAvion)
);

-- On créé une table tempo avec sa séquence pour insérer les données
DROP SEQUENCE SEQUENCE_TEMPO;
CREATE SEQUENCE SEQUENCE_TEMPO START WITH 1 MINVALUE 1;

DROP TABLE TABLE_TEMP_DONNEES;
CREATE TABLE TABLE_TEMP_DONNEES (
    idDonnee integer CONSTRAINT PK_TABLE_TEMP_DONNEE PRIMARY KEY,
    TypeAvion VARCHAR2(10) not null,
    NomPrenomPilote VARCHAR2(25) NOT NULL
);

-- Insertion des données dans la table tempo

-- Section BOEING
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'B747', 'DUPOND,REMY');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'B747', 'OLIVER,PIERRE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'B747', 'RAZLI,EMILIE');

insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'B907', 'DUPOND,REMY');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'B907', 'OLIVER,PIERRE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'B907', 'RAZLI,EMILIE');

insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'B807', 'DUPOND,REMY');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'B807', 'RAZLI,EMILIE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'B807', 'SABLEAU,BOBY');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'B807', 'MACLEON,JULIE');

-- Section AIRBUS
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'A320', 'CITRAE,LOUISE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'A320', 'BUOIN,MARISE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'A320', 'RAZLI,EMILIE');

insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'A220', 'CITRAE,LOUISE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'A220', 'BUOIN,MARISE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'A220', 'SABLEAU,BOBY');

insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'A380', 'OLIVER,PIERRE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'A380', 'BUOIN,MARISE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'A380', 'DATRU,CAROLINE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'A380', 'AMANDIER,PAUL');

-- Section DOUGLAS
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'ICBM', 'CITRAE,LOUISE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'ICBM', 'SOBLET,JEAN');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'ICBM', 'RAZLI,EMILIE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'ICBM', 'DATRU,CAROLINE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'ICBM', 'OLIVER,JEAN');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'ICBM', 'AMANDIER,PAUL');

-- Section ATR
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'AR2', 'SOBLET,JEAN');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'AR2', 'TRALY,MARIE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'AR2', 'OLIVER,JEAN');

insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'AJ3000', 'SOBLET,JEAN');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'AJ3000', 'OLIVER,JEAN');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'AJ3000', 'FRONA,FIONA');

insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'AJ2000', 'SOBLET,JEAN');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'AJ2000', 'TRALY,MARIE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'AJ2000', 'FRONA,FIONA');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'AJ2000', 'MACLEON,JULIE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'AJ2000', 'AMANDIER,PAUL');

-- Section CONVAIR
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'CR299', 'CITRAE,LOUISE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'CR299', 'OLIVER,PIERRE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'CR299', 'TRALY,MARIE');

insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'CR120', 'CITRAE,LOUISE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'CR120', 'TRALY,MARIE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'CR120', 'DATRU,CAROLINE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'CR120', 'SABLEAU,BOBY');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'CR120', 'FRONA,FIONA');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'CR120', 'MACLEON,JULIE');
insert into TABLE_TEMP_DONNEES (idDonnee, TypeAvion, NomPrenomPilote) 
values(SEQUENCE_TEMPO.NEXTVAL, 'CR120', 'AMANDIER,PAUL');

-- Insertion des données réelles dans la table qualification
INSERT INTO QUALIFICATIONS (MatriculePilote, idTypeAvion)
SELECT Matricule, idTypeAvion
FROM (
    SELECT DISTINCT Matricule AS Matricule, idTypeAvion AS idTypeAvion FROM pilote, TABLE_TEMP_DONNEES, TypeAvion WHERE (
        pilote.NomPrenomPilote = TABLE_TEMP_DONNEES.NomPrenomPilote AND TABLE_TEMP_DONNEES.typeAvion = typeAvion.designation
    )
);

DROP SEQUENCE SEQUENCE_TEMPO;
DROP TABLE TABLE_TEMP_DONNEES;