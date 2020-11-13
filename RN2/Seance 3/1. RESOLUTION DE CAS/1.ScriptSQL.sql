REM Script A exécuter

drop table Personne purge;

create table Personne (
        Idpers integer not null,
        Nompers varchar(30) not null,
        APourChef_id integer,
        primary key (idpers)
    );

alter table Personne 
        add constraint FK_personne_personne 
        foreign key (APourChef_id) 
        references Personne(idpers);

insert into Personne (IdPers,Nompers) 
values (1,'ACHET') ;
insert into Personne (IdPers,Nompers) 
values (2,'PASTOR') ;
insert into Personne (IdPers,Nompers, APourChef_id) 
values (3,'URTU',1) ;
insert into Personne (IdPers,Nompers, APourChef_id) 
values (4,'VALIU',2) ;

