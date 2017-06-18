
    drop table if exists jpa01_personne;

    create table jpa01_personne (
        ID integer not null auto_increment,
        VERSION integer not null,
        NOM varchar(30) not null unique,
        PRENOM varchar(30) not null,
        DATENAISSANCE date not null,
        MARIE bit not null,
        NBENFANTS integer not null,
        primary key (ID)
    ) ENGINE=InnoDB;
