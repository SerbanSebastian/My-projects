create database if not exists websinu2;
use websinu2;


create table if not exists Utilizator(
username varchar(30) primary key,
parola varchar(30) not null,
tip integer not null,
nume varchar(30) not null,
prenume varchar(50)  not null,
adresa varchar(100) not null,
nrTelefon varchar(10) not null,
IBAN varchar(30) not null,
email varchar(30) not null,
nrContract int unique not null);

create table if not exists Profesor(
CNP varchar(30) primary key,
cursuri varchar(300),
nrMin int,
nrMax int,
departament varchar(50),
username varchar (30));

create table if not exists Student(
CNP varchar(30) primary key,
activitati varchar(300),
anStudiu int,
nivel varchar(30),
nrOreNecesare int,
specializare varchar(30),
username varchar(30));

create table if not exists Grupa(
idGrupa int auto_increment primary key,
idStudent varchar(30),
mesaj varchar(300)
);

create table if not exists Administrator(
CNP varchar(30) primary key,
username varchar(30));

create table if not exists Super_Administrator(
CNP varchar (30) primary key,
username varchar(30));

create table if not exists Curs(
idCurs int primary key,
materie varchar(30),
activitati varchar(50),
nrOre int,
pondereSeminar float(4,2),
pondereLab float(4,2),
pondereCurs float(4,2),
idProfesor varchar(30) not null);

create table if not exists Catalog(
idCurs int,
idStudent varchar(30),
nota int,
primary key (idStudent,idCurs));

create table if not exists Activitate(
idActivitate int,
idCurs int,
intervalOrar int,
dataAct date,
nrMinimPart int,
deadline date,
materie varchar(30),
nrMaximPart int,
idProfesor varchar(30) not null,
primary key (idActivitate,idCurs));

alter table Profesor add constraint  FK_username_Prof foreign key (username) references Utilizator (username);
alter table Student add constraint  FK_username_Stud foreign key (username) references Utilizator (username);
alter table Administrator add constraint  FK_username_Adm foreign key (username) references Utilizator (username);
alter table Curs add constraint FK_idProf_curs foreign key (idProfesor) references Profesor(CNP);
alter table Activitate add constraint FK_idCurs_act foreign key (idCurs) references Curs(idCurs);
alter table Activitate add constraint FK_idProf_act foreign key (idProfesor) references Profesor(CNP);
alter table Catalog add constraint FK_idCurs_cat foreign key (idCurs) references Curs(idCurs);
alter table Catalog add constraint FK_idStudent_cat foreign key (idStudent) references Student(CNP);
alter table Super_Administrator add constraint  FK_username_sup_Adm foreign key (username) references Utilizator (username);
alter table Grupa add constraint FK_idStudent_Grp foreign key (idStudent) references Student(CNP);