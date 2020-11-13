
-- -----------------------------------------------------------------------------
--      Auteur : Fessy
-- -----------------------------------------------------------------------------

DROP TABLE FOURNISSEUR CASCADE CONSTRAINTS PURGE;

-- -----------------------------------------------------------------------------
--       TABLE : FOURNISSEUR
-- -----------------------------------------------------------------------------

CREATE TABLE FOURNISSEUR
   (
    IDFOURN INTEGER  NOT NULL,
    NOMFOURN VARCHAR(32)  NOT NULL,
    VILLEFOURN VARCHAR(20),
   CONSTRAINT PK_FOURNISSEUR PRIMARY KEY (IDFOURN)  
   ) ;

-- -----------------------------------------------------------------------------
--       CONTRAINTE UNIQUE DE LA TABLE FOURNISSEUR
-- -----------------------------------------------------------------------------

ALTER TABLE FOURNISSEUR 
     ADD CONSTRAINT UN_FOURNISSEUR  UNIQUE(NOMFOURN)
    ;


-- -----------------------------------------------------------------------------
--       INSERTION DONNEES TABLES FOURNISSEUR
-- -----------------------------------------------------------------------------

INSERT INTO FOURNISSEUR (IDFOURN, NOMFOURN, VILLEFOURN) VALUES (10,'ORANGE', 'PARIS');
INSERT INTO FOURNISSEUR (IDFOURN, NOMFOURN, VILLEFOURN) VALUES (11,'SFR', 'Paris');
INSERT INTO FOURNISSEUR (IDFOURN, NOMFOURN, VILLEFOURN) VALUES (12,'CARREFOUR', 'PARIZ');
INSERT INTO FOURNISSEUR (IDFOURN, NOMFOURN, VILLEFOURN) VALUES (15,'FRANCE2', ' PARIS');
INSERT INTO FOURNISSEUR (IDFOURN, NOMFOURN, VILLEFOURN) VALUES (16,'FRANCE3', 'PARRiS ');
INSERT INTO FOURNISSEUR (IDFOURN, NOMFOURN, VILLEFOURN) VALUES (25,'PEUGEOT', 'PARRISS');















-- -----------------------------------------------------------------------------
--       EXTRACTION DE DONNEES AVEC SOUNDEX ET TRIM
-- -----------------------------------------------------------------------------

--SELECT * FROM FOURNISSEUR WHERE SOUNDEX(VILLEFOURN) = SOUNDEX('PARIS');


-- -----------------------------------------------------------------------------
--       NETTOYAGE DE LA BASE
-- -----------------------------------------------------------------------------


--UPDATE FOURNISSEUR SET VILLEFOURN=UPPER(TRIM(VILLEFOURN));
--UPDATE FOURNISSEUR SET VILLEFOURN='PARIS' WHERE SOUNDEX(VILLEFOURN) = SOUNDEX('PARIS');