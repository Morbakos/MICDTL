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
ADD CONSTRAINT CK_PERSONNEL CHECK (NomPersonnel=upper(NomPersonnel))
ADD CONSTRAINT CK_PRENOM_PERSONNEL CHECK (PrenomPersonnel=upper(PrenomPersonnel))
/

DROP SEQUENCE SeqPersonnel
/
CREATE SEQUENCE SeqPersonnel
/


INSERT INTO PERSONNEL (IdPersonnel, NomPersonnel, PrenomPersonnel,AnneeNaissance) VALUES (SeqPersonnel.NEXTVAL, 'LE ROYER','JEAN',1965)
/

-- *** Anomalie Constatée

INSERT INTO PERSONNEL (IdPersonnel, NomPersonnel, PrenomPersonnel,AnneeNaissance) VALUES (SeqPersonnel.NEXTVAL, 'Leonardie','LUCAS',1965)
/

SELECT * FROM PERSONNEL;