SET FEEDBACK OFF
SET LINESIZE 150
SET PAGESIZE 40

REM **************************************************************************
REM Auteur : Jerome FESSY
REM Date de Mise à Jour : 29/08/2019
REM ***************************************************************************

ALTER SESSION SET NLS_DATE_FORMAT = 'dd/mm/yyyy HH24:MI';

PROMPT --> DEBUT DU SCRIPT


DROP TABLE AVION CASCADE CONSTRAINTS PURGE
/

PROMPT CREATION TABLE AVION

DROP SEQUENCE SEQAVION
/
CREATE SEQUENCE SEQAVION start with 0 Minvalue 0
/
CREATE TABLE AVION
(
NumAv INTEGER CONSTRAINT pk_avion PRIMARY KEY,
RefAvion CHAR(5) CONSTRAINT U_avion UNIQUE,
CapaciteAvion INTEGER,
typeAvion VARCHAR2(10),
VilleEntrepot VARCHAR2(30),
AutonomieAvion INTEGER
)
/

PROMPT INSERTION D''AVIONS

insert into avion (Numav, RefAvion, CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z1P3',2,'COUCOU','VELIZY-VILLACOUBLAY');
insert into avion (Numav, RefAvion, CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z2P4',600,'ICBM','CARPIQUET');
insert into avion (Numav, RefAvion, CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z2P5',100,'B907','CARPIQUET');
insert into avion (Numav,RefAvion,  CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z3P5',500,'A320','SAINT EXUPERY');
insert into avion (Numav,RefAvion,  CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z5P6',50,'A220','ORLY');
insert into avion (Numav,RefAvion,  CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z7P7',500,'A320','ROLLAND GARROS');
insert into avion (Numav,RefAvion,  CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z9P8',600,'ICBM','ORLY');
insert into avion (Numav,RefAvion,  CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z10P1',600,'ICBM','ROLLAND GARROS');
insert into avion (Numav, RefAvion, CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z13P1',100,'B907','ORLY');
insert into avion (Numav, RefAvion, CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z14P1',120,'AM200','ORLY');
insert into avion (Numav, RefAvion, CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z15P1',50,'AM200','ORLY');
insert into avion (Numav, RefAvion, CapaciteAvion, TypeAvion, VilleEntrepot)
values(SEQAVION.nextval,'Z16P1',180,'AM200','ORLY');


DROP TABLE AUTONOMIE PURGE
/
CREATE TABLE AUTONOMIE
(
RefAvion CHAR(5),
Autonomie INTEGER
)
/

INSERT INTO AUTONOMIE (RefAvion, Autonomie) VALUES ('Z1P3',120);
INSERT INTO AUTONOMIE (RefAvion,Autonomie) VALUES ('Z2P4',120);
INSERT INTO AUTONOMIE (RefAvion,Autonomie) VALUES ('Z2P5',160);
INSERT INTO AUTONOMIE (RefAvion,Autonomie) VALUES ('Z5P6',210);
INSERT INTO AUTONOMIE (RefAvion,Autonomie) VALUES ('Z7P7',600);

INSERT INTO AUTONOMIE (RefAvion,Autonomie) VALUES ('Z10P1',450);
INSERT INTO AUTONOMIE (RefAvion,Autonomie) VALUES ('Z3P5',600);
INSERT INTO AUTONOMIE (RefAvion,Autonomie) VALUES ('Z9P8',800);
INSERT INTO AUTONOMIE (RefAvion,Autonomie) VALUES ('Z13P1',300);

COMMIT;

PROMPT --> FIN DU SCRIPT

SET FEEDBACK ON
