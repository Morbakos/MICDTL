-- -----------------------------------------------------------------------------
--                CAS 1
-- -----------------------------------------------------------------------------

/* Création de table initiale */
create table Personne (
    Idpers integer not null,
    Nompers varchar(30) not null,
    APourChef_id integer,
    primary key (idpers)
);

/* Création de table corrigée */
create table Personne (
    Idpers integer not null,
    Nompers varchar(30) not null,
    APourChef_id integer unique, -- On rajoute ici une contrainte unique
    primary key (idpers)
);

-- -----------------------------------------------------------------------------
--                CAS 2
-- -----------------------------------------------------------------------------

-- COMMANDE A EXECUTER DANS LA CONSOLE
ALTER TABLE INTERVENTION 
  DROP CONSTRAINT PK_INTERVENTION;

ALTER TABLE INTERVENTION 
  ADD CONSTRAINT PK_INTERVENTION PRIMARY KEY (IDPERS, IDORDI, DATEINTERVENTION);

-- -----------------------------------------------------------------------------
--                CAS 3
-- -----------------------------------------------------------------------------