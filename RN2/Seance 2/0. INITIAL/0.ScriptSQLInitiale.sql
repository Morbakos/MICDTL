DROP TABLE MARCHE CASCADE CONSTRAINT;
DROP TABLE EMPLACEMENT CASCADE CONSTRAINT;
DROP TABLE MARCHAND CASCADE CONSTRAINT;
DROP TABLE RESERVE CASCADE CONSTRAINT;

CREATE TABLE MARCHE(
   IdMarche NUMBER(10),
   NomMarche VARCHAR2(50) NOT NULL,
   CONSTRAINT PK_MARCHE PRIMARY KEY(IdMarche)
);

CREATE TABLE EMPLACEMENT(
   IdEmplacement NUMBER(10),
   NoAllee NUMBER(10) NOT NULL,
   Metrage NUMBER(10) NOT NULL,
   IdMarche NUMBER(10) NOT NULL,
   CONSTRAINT PK_EMPLACEMENT PRIMARY KEY(IdEmplacement),
   CONSTRAINT FK_EMPLACEMENT_MARCHE FOREIGN KEY(IdMarche) REFERENCES MARCHE(IdMarche)
);

CREATE TABLE MARCHAND(
   IdMarchand NUMBER(10),
   NomMarchand VARCHAR2(50) NOT NULL,
   CONSTRAINT PK_MARCHAND PRIMARY KEY(IdMarchand)
);

-- A COMPLETER
CREATE TABLE RESERVE(
   IdEmplacement NUMBER(10),
   IdMarchand NUMBER(10),

   CONSTRAINT PK_RESERVE PRIMARY KEY(IdEmplacement, IdMarchand),
   CONSTRAINT FK_RESERVE_EMPLACEMENT FOREIGN KEY(IdEmplacement) REFERENCES EMPLACEMENT(IdEmplacement),
   CONSTRAINT FK_RESERVE_MARCHE FOREIGN KEY(IdMarchand) REFERENCES MARCHAND(IdMarchand)
);