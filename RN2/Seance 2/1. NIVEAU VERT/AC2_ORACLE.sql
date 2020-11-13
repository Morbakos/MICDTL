-- *************************
-- AC2 SCRIPT  ORACLE
-- *************************

-- **** DEFINITON DES STRUCTURES


DROP TABLE PRODUIT
/
DROP TABLE FOURNISSEUR 
/

CREATE TABLE FOURNISSEUR (
IdFournisseur INTEGER,
LibelleFournisseur VARCHAR(30) NOT NULL,
VilleFournisseur VARCHAR(30) NOT NULL
)
/
ALTER TABLE FOURNISSEUR
ADD CONSTRAINT PK_FOURNISSEUR PRIMARY KEY(IdFournisseur)
/

INSERT INTO FOURNISSEUR (IdFournisseur, LibelleFournisseur, VilleFournisseur) VALUES (1, 'NIKE','PARIS')
/


CREATE TABLE PRODUIT(
IdProduit INTEGER,
LibelleProduit VARCHAR(30) NOT NULL,
IdFournisseur INTEGER)
/

ALTER TABLE PRODUIT
-- ADD CONSTRAINT PK_PRODUIT PRIMARY KEY(IdProduit)
-- Correction (à remplacer par)
ADD CONSTRAINT FK_FOURNISSEUR_PRODUIT FOREIGN KEY(IdFournisseur) REFERENCES FOURNISSEUR(IdFournisseur)
/

INSERT INTO PRODUIT (IdProduit, LibelleProduit, IdFournisseur) VALUES (1, 'Ballon Basket R300',1)
/


-- *** Anomalie Constatée

INSERT INTO PRODUIT (IdProduit, LibelleProduit, IdFournisseur) VALUES (2, 'Chaussure Running AS333',4)
/