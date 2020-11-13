
-- -----------------------------------------------------------------------------
--      Auteur : Fessy
-- SCRIPT PROCESSUS POUR NORMALISER LA TABLE FOURNISSEUR
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


-- A COMPLETER
 


-- -----------------------------------------------------------------------------
--       ETAPE 3 :MIGRATION DES VILLES DE LA TABLE FOURNISSEUR VERS LA TABLE VILLE
-- -----------------------------------------------------------------------------

INSERT INTO VILLE (IDVILLE, NOMVILLE)
SELECT SEQVILLE.NEXTVAL, VILLE
FROM (SELECT DISTINCT UPPER(TRIM(VILLEFOURN)) AS VILLE FROM FOURNISSEUR);

-- -----------------------------------------------------------------------------
--       ETAPE 4 : MISE A JOUR DE LA COLONNE IDVILLE DE FOURNISSEUR A PARTIR DES VALEURS DANS VILLE
-- -----------------------------------------------------------------------------

-- A COMPLETER


-- -----------------------------------------------------------------------------
--       ETAPE 5 :AJOUT DE LA CONTRAINTE D'INTEGRITE REFERENTIELLE ENTRE VILLE ET FOURNISSEUR
-- -----------------------------------------------------------------------------

-- A COMPLETER SI PAS DEJA FAIT A L'ETAPE 2


-- -----------------------------------------------------------------------------
--       ETAPE 6 : SUPPRESSION DE LA COLONNE NOMVILLE DE FOURNISSEUR DEVENUE OBSOLETE
-- -----------------------------------------------------------------------------

 
-- A COMPLETER



-- -----------------------------------------------------------------------------
--                FIN DE MODIFICATION
-- -----------------------------------------------------------------------------

