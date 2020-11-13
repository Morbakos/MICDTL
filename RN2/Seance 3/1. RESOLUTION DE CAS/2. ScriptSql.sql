ALTER SESSION SET NLS_DATE_FORMAT = 'dd/mm/yyyy';

-- -----------------------------------------------------------------------------
--            
-- -----------------------------------------------------------------------------
--      Auteur : Fessy
-- -----------------------------------------------------------------------------

DROP TABLE ORDINATEUR CASCADE CONSTRAINTS;

DROP TABLE PERSONNEL CASCADE CONSTRAINTS;

DROP TABLE INTERVENTION CASCADE CONSTRAINTS;


-- -----------------------------------------------------------------------------
--       TABLE : ORDINATEUR
-- -----------------------------------------------------------------------------

CREATE TABLE ORDINATEUR
   (
    IDORDI NUMBER(2)  NOT NULL,
    LIBELLEORDI VARCHAR(32)  NOT NULL,
   CONSTRAINT PK_ORDINATEUR PRIMARY KEY (IDORDI)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : PERSONNEL
-- -----------------------------------------------------------------------------

CREATE TABLE PERSONNEL
   (
    IDPERS NUMBER(2)  NOT NULL,
    NOMPERS VARCHAR(32)  NOT NULL,
    PRENOMPERS VARCHAR(32)  NOT NULL,
   CONSTRAINT PK_PERSONNEL PRIMARY KEY (IDPERS)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : INTERVENTION
-- -----------------------------------------------------------------------------

CREATE TABLE INTERVENTION
   (
    IDPERS NUMBER(2)  NOT NULL,
    IDORDI NUMBER(2)  NOT NULL,
    DATEINTERVENTION DATE  NOT NULL,
    TYPEINTERVENTION VARCHAR(15)  NOT NULL,
   CONSTRAINT PK_INTERVENTION PRIMARY KEY (IDPERS, IDORDI)  
   ) ;


-- -----------------------------------------------------------------------------
--       CREATION DES REFERENCES DE TABLE
-- -----------------------------------------------------------------------------


ALTER TABLE INTERVENTION ADD (
     CONSTRAINT FK_INTERVENTION_PERSONNEL
          FOREIGN KEY (IDPERS)
               REFERENCES PERSONNEL (IDPERS))   ;

ALTER TABLE INTERVENTION ADD (
     CONSTRAINT FK_INTERVENTION_ORDINATEUR
          FOREIGN KEY (IDORDI)
               REFERENCES ORDINATEUR (IDORDI))   ;


-- -----------------------------------------------------------------------------
--                FIN DE GENERATION
-- -----------------------------------------------------------------------------

-- -----------------------------------------------------------------------------
--                COMMANDE A EXECUTER DANS LA CONSOLE
-- -----------------------------------------------------------------------------

/*ALTER TABLE INTERVENTION 
  DROP CONSTRAINT PK_INTERVENTION;

ALTER TABLE INTERVENTION 
  ADD CONSTRAINT PK_INTERVENTION PRIMARY KEY (IDPERS, IDORDI, DATEINTERVENTION);*/