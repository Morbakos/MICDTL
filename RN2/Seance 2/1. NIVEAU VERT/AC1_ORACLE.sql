-- *************************
-- AC1 ORACLE
-- *************************

-- **** DEFINITON DES STRUCTURES



DROP TABLE PERSONNEL
/
CREATE TABLE PERSONNEL (
IdPersonnel INTEGER,
NomPersonnel VARCHAR(30) NOT NULL,
PrenomPersonnel VARCHAR(30) NOT NULL, 
AnneeNaissance INTEGER NOT NULL
)
/
ALTER TABLE PERSONNEL
ADD CONSTRAINT PK_PERSONNEL PRIMARY KEY(IdPersonnel)

-- Correction
ADD CONSTRAINT U_PERSONNEL UNIQUE(NomPersonnel,PrenomPersonnel, AnneeNaissance
/


DROP SEQUENCE SeqPersonnel
/
CREATE SEQUENCE SeqPersonnel
/


INSERT INTO PERSONNEL (IdPersonnel, NomPersonnel, PrenomPersonnel,AnneeNaissance) VALUES (SeqPersonnel.NEXTVAL, 'LEONARDI','LUCAS',1965)
/

-- *** Anomalie Constatée

INSERT INTO PERSONNEL (IdPersonnel, NomPersonnel, PrenomPersonnel,AnneeNaissance) VALUES (SeqPersonnel.NEXTVAL, 'LEONARDI','LUCAS',1965)
/
INSERT INTO PERSONNEL (IdPersonnel, NomPersonnel, PrenomPersonnel,AnneeNaissance) VALUES (SeqPersonnel.NEXTVAL, 'LEONARDI','LUCAS',1965)
/