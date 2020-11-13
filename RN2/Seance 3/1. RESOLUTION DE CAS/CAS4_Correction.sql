
-- -----------------------------------------------------------------------------
--      Auteur : Fessy
-- -----------------------------------------------------------------------------


-- -----------------------------------------------------------------------------
--       ETAPE 1 : CREATION DE LA TABLE VILLE ET D'UNE SEQUENCE POUR IDVILLE
-- -----------------------------------------------------------------------------
DROP TABLE VILLE CASCADE CONSTRAINTS PURGE;

DROP SEQUENCE SEQVILLE;
CREATE SEQUENCE SEQVILLE START WITH 0 MINVALUE 0;

CREATE TABLE VILLE
   (
    IDVILLE NUMBER(2)  NOT NULL,
    NOMVILLE VARCHAR(32)  NOT NULL CONSTRAINT UN_NOMVILLE UNIQUE,
   CONSTRAINT PK_VILLE PRIMARY KEY (IDVILLE)  
   ) ;


-- -----------------------------------------------------------------------------
--       ETAPE 2 : AJOUT DE LA COLONNE  IDVILLE CLE ETRANGERE DANS LA TABLE FOURNISSEUR
-- -----------------------------------------------------------------------------


ALTER TABLE FOURNISSEUR ADD
IDVILLE INTEGER;

 


-- -----------------------------------------------------------------------------
--       MIGRATION DES VILLES DE LA TABLE FOURNISSEUR VERS LA TABLE VILLE
-- -----------------------------------------------------------------------------

INSERT INTO VILLE (IDVILLE, NOMVILLE)
SELECT SEQVILLE.NEXTVAL, VILLE
FROM (SELECT DISTINCT UPPER(TRIM(VILLEFOURN)) AS VILLE FROM FOURNISSEUR);

-- -----------------------------------------------------------------------------
--       MISE A JOUR DE LA COLONNE IDVILLE DE FOURNISSEUR A PARTIR DES VALEURS DANS VILLE
-- -----------------------------------------------------------------------------

UPDATE FOURNISSEUR F
SET IDVILLE = (SELECT IDVILLE FROM VILLE  V WHERE V.NOMVILLE = F.VILLEFOURN);


-- -----------------------------------------------------------------------------
--       AJOUT DE LA CONTRAINTE D'INTEGRITE REFERENTIELLE ENTRE VILLE ET FOURNISSEUR
-- -----------------------------------------------------------------------------


ALTER TABLE FOURNISSEUR ADD
     CONSTRAINT FK_FOURNISSEUR_VILLE
          FOREIGN KEY (IDVILLE) REFERENCES VILLE(IDVILLE);


-- -----------------------------------------------------------------------------
--       SUPPRESSION DE LA COLONNE NOMVILLE DE FOURNISSEUR DEVENUE OBSOLETE
-- -----------------------------------------------------------------------------

ALTER TABLE FOURNISSEUR 
DROP COLUMN VILLEFOURN;



-- -----------------------------------------------------------------------------
--                FIN DE MODIFICATION
-- -----------------------------------------------------------------------------

