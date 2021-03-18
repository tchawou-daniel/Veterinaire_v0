/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de cr�ation :  27/11/2020 15:11:24                      */
/*==============================================================*/

/*==============================================================*/
/* Table : parent                                               */
/*==============================================================*/


CREATE TABLE IF NOT EXISTS parent
(
    parentid     int not null AUTO_INCREMENT primary key,
    nomparent    varchar(50),
    prenomparent varchar(50),
    typeparent   enum('HOMME','FEMME')
);

/*==============================================================*/
/* Table : typeAnimal                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS typeanimal
(
    typeanimalid  int not null AUTO_INCREMENT primary key,
    libtypeanimal varchar(100)
);

/*==============================================================*/
/* Table : animal                                          */
/*==============================================================*/

CREATE TABLE IF NOT EXISTS animal
(
    animalid     int not null AUTO_INCREMENT primary key,
    nomanimal    varchar(50),
    sexanimal    varchar(50),
    parentid     int NOT NULL REFERENCES parent (parentid),
    typeanimalid int NOT NULL REFERENCES typeanimal (typeanimalid)
);

/*==============================================================*/
/* Table : medecin                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS medecin
(
    medecinid     int not null AUTO_INCREMENT primary key,
    nommedecin    varchar(50),
    prenommedecin varchar(50),
    contact       varchar(50)
);

/*==============================================================*/
/* Table : rendezVous                                           */
/*==============================================================*/
-- nompatient-nommedecin-rdvid
CREATE TABLE IF NOT EXISTS rendezvous
(
    rdvid         int      not null AUTO_INCREMENT primary key,
    datardv       datetime NOT NULL UNIQUE,
    heuredebutrdv datetime NOT NULL UNIQUE,
    heurefinrdv   datetime NOT NULL UNIQUE,
    nomrdv        varchar(50),
    medecinid     int      NOT NULL REFERENCES medecin (medecinid),
    animalid      int      NOT NULL REFERENCES animal (animalid)
);

/*==============================================================*/
/* Table : medicament                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS medicament
(
    medicamentid  int not null AUTO_INCREMENT primary key,
    nommedicament varchar(50),
    description   varchar(250)
);

/*==============================================================*/
/* Table : ordonnance                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS ordonnance
(
    ordonnanceid int not null AUTO_INCREMENT primary key,
    nomordonnance varchar(50) UNIQUE,
    rdvid        int NOT NULL REFERENCES rendezVous (rdvid)
);


/*==============================================================*/
/* Table : prescription                                         */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS prescription
(
    prescriptionid   int not null AUTO_INCREMENT primary key,
    dateprescription datetime,
    frequencedeprise varchar(200),
    quantite         int,
    ordonnanceid     int NOT NULL REFERENCES ordonnance (ordonnanceid),
    medicamentid     int NOT NULL REFERENCES medicament (medicamentid)
);



INSERT INTO typeanimal (typeanimalid, libtypeanimal)
VALUES (1, 'chien'),
       (2, 'Lapin'),
       (3, 'cheval'),
       (4, 'veau'),
       (5, 'chat');

INSERT INTO parent (parentid, nomparent, prenomparent, typeparent)
VALUES (1, 'Popo', 'Marx', 'HOMME'),
       (2, 'Doudou', 'Scooby', 'HOMME'),
       (3, 'Case', 'Doo', 'FEMME'),
       (4, 'Momo', 'Tom', 'FEMME'),
       (5, 'Bobo', 'Joe', 'HOMME');

--(animalid, nomanimal, sexanimal, parentid, typeanimalid)
INSERT INTO animal
VALUES (1, 'Lalou', 'female', 1, 5),
       (2, 'Lili', 'female', 3, 2),
       (3, 'Lolo', 'male', 5, 1),
       (4, 'Toto', 'female', 4, 3),
       (5, 'Tati', 'male', 2, 4);

INSERT INTO medecin (medecinid, nommedecin, prenommedecin, contact)
VALUES (1, 'Kossi', 'Etiam', '0601548976'),
       (2, 'Nibaruta', 'Khelia', '0669854126'),
       (3, 'Sipe', 'Daniel', '0632106987'),
       (4, 'DAlmeida', 'Denis', '0621598742'),
       (5, 'Keza', 'Assia', '0623598741');

--(rdvid,nomrdv,datardv,heuredebutrdv,heurefinrdv,medecinid,animalid)
INSERT INTO rendezvous
VALUES (1, '12-01-21 12:32', '12-01-21 08:30', '12-01-21 09:30','Lalou~Kossi-1', 1, 4),
       (2, '18-01-21 12:32', '18-01-21 10:00', '18-01-21 11:00','Lili~Nibaruta-2', 5, 3),
       (3,'20-01-21 12:32', '20-01-21 11:00', '20-01-21 12:00','Lolo~Sipe-3', 3, 1),
       (4,'25-01-21 12:32', '25-01-21 14:00', '25-01-21 15:00','Toto~DAlmeida-4', 4, 2),
       (5, '20-01-21 12:32', '20-01-21 16:00', '20-01-21 17:00','Tati~Keza-5', 2, 5);

--(ordonnanceid,nomordonnance,rdvid)
INSERT INTO ordonnance
VALUES (1, 'SDEK63',4),
       (2, 'SDEK64',2),
       (3, 'SDEK65',5),
       (4, 'SDEK66',3),
       (5, 'SDEK67',1);

INSERT INTO medicament
VALUES (1, 'ACTI-TETRA B', 'Poudre pour solution buvable'),
       (2, 'ACTI-TETRA I', 'Solution injectable'),
       (3, 'IMALGENE 1000', 'Solution injectable'),
       (4, 'CALCIVITOL', 'Solution injectable'),
       (5, 'CALCITAT FORT', 'Solution injectable');

INSERT INTO prescription
VALUES (1, '25-01-21 15:00', 'une fois par jour', 1, 1, 1),
       (2, '18-01-21 11:00', 'une fois par jour', 1, 2, 2),
       (3, '20-01-21 17:00', 'trois fois par jour', 3, 3, 3),
       (4, '20-01-21 12:00', 'deux fois par jour', 2, 4, 4),
       (5, '12-01-21 09:30', 'deux fois par jour', 2, 5, 5);



