--Lot 1--

--On supprime toutes les tables déjà existantes--

DROP TABLE GROUPETRAVAIL CASCADE CONSTRAINTS PURGE;
DROP TABLE MEETING CASCADE CONSTRAINTS PURGE;
DROP TABLE COLLABORATEUR CASCADE CONSTRAINTS PURGE;
DROP TABLE SERVICE CASCADE CONSTRAINTS PURGE;
DROP TABLE ADHERER CASCADE CONSTRAINTS PURGE;
DROP TABLE PARTICIPER CASCADE CONSTRAINTS PURGE;

--On crée toutes les tables et les contraintes--

--Creation de la table GROUPETRAVAIL--

CREATE TABLE GROUPETRAVAIL(
  Id_GrpTrav INTEGER,
  Nom_GrpTrav Varchar(20) NOT NULL, --On doit savoir le nom du groupe
  Capacite INTEGER NOT NULL, --On doit savoir la capacite
  TarifPlace FLOAT NOT NULL --On doit savoir le tarif meme si 0
);

--On ajoute des contraintes sur la table GROUPETRAVAIL

ALTER TABLE GROUPETRAVAIL
  ADD CONSTRAINT PK_GM_ID_GRP PRIMARY KEY(Id_GrpTrav); --Cle Primaire

--Creation de la table MEETING--

CREATE TABLE MEETING(
  Id_Meeting INTEGER,
  Intitule_Meeting Varchar(20) NOT NULL --On doit savoir le nom du meeting
);

--On ajoute des contraintes sur la table MEETING

ALTER TABLE MEETING
  ADD CONSTRAINT PK_GM_ID_MEET PRIMARY KEY(Id_Meeting); --Cle Primaire

--Creation de la table COLLABORATEUR--

CREATE TABLE COLLABORATEUR(
  Id_Collab INTEGER,
  Nom_Collab Varchar(20) NOT NULL, --On doit au moins savoir qui est le collaborateur
  Prenom_Collab Varchar(20) NOT NULL,
  Adresse_Collab Varchar(20),
  Tel_Collab INTEGER UNIQUE, --on ne peut avoir 2 personnes ayant le même numéro
  Mail_Collab Varchar(20)
);

--On ajoute des contraintes sur la table COLLABORATEUR

ALTER TABLE COLLABORATEUR
  ADD CONSTRAINT PK_GM_ID_COLLAB PRIMARY KEY(Id_Collab); --Cle Primaire

  --Creation de la table SERVICE--

CREATE TABLE SERVICE(
  Id_Service INTEGER,
  Nom_Service Varchar(20) UNIQUE NOT NULL, --un service a un seul et unique nom
  Batiment_Service Varchar(20)
);

--On ajoute des contraintes sur la table SERVICE

ALTER TABLE SERVICE
  ADD CONSTRAINT PK_GM_ID_SERVICE PRIMARY KEY(Id_Service);

  --Creation de la table ADHERER--

CREATE TABLE ADHERER(
  IdAd_GrpTrav INTEGER,
  IdAd_Collab INTEGER,
  DataAdhesion Varchar(20) NOT NULL --il doit forcement y avoir une date d'adhesion
);

--On ajoute des contraintes sur la table ADHERER

ALTER TABLE ADHERER
  ADD CONSTRAINT FK_GM_IDAD_GRP FOREIGN KEY(IdAd_GrpTrav) GROUPETRAVAIL(Id_GrpTrav)
  ADD CONSTRAINT FK_GM_IDAD_COLLAB FOREIGN KEY(IdAd_Collab) COLLABORATEUR(Id_Collab);

--Creation de la table PARTICIPER--

CREATE TABLE PARTICIPER(
  IdPa_Meeting INTEGER,
  IdPa_Collab INTEGER,
  Presence Varchar(20) NOT NULL --on doit savoir si présent ou non
);

--On ajoute des contraintes sur la table PARTICIPER

ALTER TABLE PARTICIPER
  ADD CONSTRAINT FK_GM_IDPA_MEET FOREIGN KEY(IdPa_Meeting) MEETING(Id_Meeting)
  ADD CONSTRAINT FK_GM_IDPA_COLLAB FOREIGN KEY(IdPa_Collab) COLLABORATEUR(Id_Collab);


--Jeu d'essai--

INSERT INTO GROUPETRAVAIL VALUES (1, "nomGroupe", 10, 5);
INSERT INTO MEETING VALUES (1, "Reunion");
INSERT INTO COLLABORATEUR VALUES (12, "Machin", "Truc", "4 rue de nulle part", 0600000000, "Machin.truc@mail.com");
INSERT INTO SERVICE VALUES (2,"Service marketing", "Bâtiment A");
INSERT INTO ADHERER VALUES (1,12, "10/12/2019");
INSERT INTO PARTICIPER VALUES (1,12, "O");
