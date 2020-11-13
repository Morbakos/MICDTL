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