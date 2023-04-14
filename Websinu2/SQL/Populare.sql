insert into Utilizator(username, parola, nume, prenume, adresa, nrTelefon, IBAN, email, nrContract,tip) values ("iubitelulthau69", "denisfa", "Theodor", "Atanasie", "Str. Bihor 420", "0772456983", "ROBT456678","pusilache23@yahoo.com", 42069,0);
insert into Utilizator(username, parola, nume, prenume, adresa, nrTelefon, IBAN, email, nrContract,tip) values ("iubitelulthau73", "denisfa1", "Cristiana", "Maria", "Str. Bihor 1", "0772456983", "ROBT456678","pusilache23@yahoo.com", 42070,2);
insert into Utilizator(username, parola, nume, prenume, adresa, nrTelefon, IBAN, email, nrContract,tip) values ("iubitelulthau1", "denisfa2", "Theodor", "Atanasie", "Str. Bihor 2", "0772456983", "ROBT456678","pusilache23@yahoo.com", 42071,-1);
insert into Utilizator(username, parola, nume, prenume, adresa, nrTelefon, IBAN, email, nrContract,tip) values ("iubitelulthau2", "denisfa3", "Theodor", "Atanasie", "Str. Bihor 3", "0772456983", "ROBT456678","pusilache23@yahoo.com", 42072,2);
insert into Utilizator(username, parola, nume, prenume, adresa, nrTelefon, IBAN, email, nrContract,tip) values ("iubitelulthau3", "denisfa4", "Theodor", "Atanasie", "Str. Bihor 4", "0772456983", "ROBT456678","pusilache23@yahoo.com", 42073,2);
insert into Utilizator(username, parola, nume, prenume, adresa, nrTelefon, IBAN, email, nrContract,tip) values ("iubitelulthau4", "denisfa5", "Theodor", "Atanasie", "Str. Bihor 5", "0772456983", "ROBT456678","pusilache23@yahoo.com", 42074,2);
insert into Utilizator(username, parola, nume, prenume, adresa, nrTelefon, IBAN, email, nrContract,tip) values ("iubitelulthau5", "denisfa6", "Theodor", "Atanasie", "Str. Bihor 6", "0772456983", "ROBT456678","pusilache23@yahoo.com", 42075,1);
insert into Utilizator(username, parola, nume, prenume, adresa, nrTelefon, IBAN, email, nrContract,tip) values ("iubitelulthau6", "denisfa7", "Theodor", "Atanasie", "Str. Bihor 7", "0772456983", "ROBT456678","pusilache23@yahoo.com", 42076,0);
insert into Utilizator(username, parola, nume, prenume, adresa, nrTelefon, IBAN, email, nrContract,tip) values ("iubitelulthau7", "denisf8", "Theodor", "Atanasie", "Str. Bihor 8", "0772456983", "ROBT456678","pusilache23@yahoo.com", 42077,1);
insert into Utilizator(username, parola, nume, prenume, adresa, nrTelefon, IBAN, email, nrContract,tip) values ("iubitelulthau8", "denisfa9", "Theodor", "Atanasie", "Str. Bihor 9", "0772456983", "ROBT456678","pusilache23@yahoo.com", 42078,1);
insert into Utilizator values ("iubitelulthau111", "denisfa0", 1, "Theodor", "Atanasie", "Str. Bihor 10", "0772456983", "ROBT456678","pusilache23@yahoo.com", 5);

insert into Profesor(CNP, cursuri, nrMin, nrMax, departament) values("123456789", "Algebra liniara si geometrie analitica", 10, 40, "departamentul de smecheri");
insert into Profesor(CNP, cursuri, nrMin, nrMax, departament) values("1", "Matematici Speciale", 10, 40, "departamentul de scorpii");
insert into Profesor(CNP, cursuri, nrMin, nrMax, departament) values("2", "Proiectare Logica", 5, 20, "ingineri");
insert into Profesor(CNP, cursuri, nrMin, nrMax, departament) values("3", "Programare in limbaj de asamblare", 5, 20, "ingineri");

call update_username("iubitelulthau69",0,"54354235");
call update_username("iubitelulthau7",1,"432432");
call update_username("iubitelulthau5",1,"549378");
insert into Super_Administrator(username,cnp)values("iubitelulthau1","6585638563768");
call update_prof("iubitelulthau5",10,32,"mes","cti");
call update_username("iubitelulthau2",2,"4354325243");
call update_username("iubitelulthau111",1,"5020517260044");
call update_student("iubitelulthau2","seminar,laborator,sex",2,"licenta","17","cti");