-- On créer une table Ville

CREATE TABLE VILLE (
	idVille integer NOT NULL,
	NomVille varchar(32) NOT NULL CONSTRAINT UN_NOM_VILE UNIQUE,
	CONSTRAINTS PRIMARY KEY(idVille) 
);

-- Création d'une séquence pour assignation auto des index
CREATE SEQUENCE SEQUENCE_VILLE;

-- Création de la colonne de clé étrangère dans la table Fournisseur
ALTER TABLE FOURNISSEUR
	ADD idVille integer;

-- Remplissage de la table VILLE par les données de la table FOURNISSEUR
INSERT INTO VILLE 
	SELECT SEQUENCE_VILLE.NEXTVAL, VILLE FROM ( SELECT DISTINCT VILLEFOURN AS VILLE FROM FOURNISSEUR );

-- 