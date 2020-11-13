SET FEEDBACK OFF
SET LINESIZE 150
SET PAGESIZE 40

REM **************************************************************************
REM Auteur : Jerome FESSY
REM Date de Mise à Jour : 29/08/2019
REM ***************************************************************************

DELETE AUTONOMIE;

INSERT INTO AUTONOMIE (RefAvion, Autonomie) VALUES ('Z14P1',320);
INSERT INTO AUTONOMIE (RefAvion,Autonomie) VALUES ('Z15P1',300);
INSERT INTO AUTONOMIE (RefAvion,Autonomie) VALUES ('Z16P1',160);

COMMIT;

PROMPT --> FIN DU SCRIPT

SET FEEDBACK ON