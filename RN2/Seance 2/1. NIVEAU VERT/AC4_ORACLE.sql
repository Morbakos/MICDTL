-- *************************
-- AC1 ORACLE
-- *************************

-- **** DEFINITON DES STRUCTURES



DROP TABLE PERSONNEL CASCADE CONSTRAINTS PURGE
/
CREATE TABLE PERSONNEL (
IdPersonnel INTEGER,
NomPrenomPersonnel VARCHAR(40),
NomPersonnel VARCHAR(30),
PrenomPersonnel VARCHAR(30), 
Sexe CHAR(1)
)
/
ALTER TABLE PERSONNEL
ADD CONSTRAINT PK_PERSONNEL PRIMARY KEY(IdPersonnel)
/

INSERT INTO PERSONNEL (IdPersonnel, NomPrenomPersonnel, Sexe) VALUES (1, 'LE ROYER,JEAN',1)
/

INSERT INTO PERSONNEL (IdPersonnel, NomPrenomPersonnel, Sexe) VALUES (2, 'PAROT,MARIE',2)
/

INSERT INTO PERSONNEL (IdPersonnel, NomPrenomPersonnel, Sexe) VALUES (3, 'LEONARDI,LUCAS',1)
/

-- *** Requête au fonctionnement partiel

/*
UPDATE PERSONNEL SET sexe = (
CASE
	WHEN PERSONNEL.sexe = 1 THEN DECODE (sexe, '1','M')
	WHEN PERSONNEL.sexe = 2 THEN DECODE (sexe, '2','F')
	ELSE NULL
END
)
;
*/
UPDATE PERSONNEL SET 
	Sexe = DECODE (Sexe, '1','M', '2','F'),
	NomPersonnel=SUBSTR(NomPrenomPersonnel,1,INSTR(NomPrenomPersonnel, ',')-1),
	PrenomPersonnel=SUBSTR(NomPrenomPersonnel,INSTR(NomPrenomPersonnel, ',')+1);
/*
PrenomPersonnel=SUBSTR(NomPrenomPersonnel,2,INSTR(NomPrenomPersonnel, ',')1)*/
SELECT * FROM PERSONNEL;