DROP DATABASE IF EXISTS db_konohaMision;
CREATE DATABASE db_konohaMision;
USE db_konohaMision;

CREATE TABLE tbl_ninja (
  ninjaId integer PRIMARY KEY AUTO_INCREMENT,
  nombreNinja varchar(30) NOT NULL,
  rangoNinja ENUM ('gennin', 'jounin', 'yuunin') NOT NULL,
  aldea varchar(50)
);

CREATE TABLE tbl_mision (
  misionId integer PRIMARY KEY AUTO_INCREMENT,
  descripcionMision text NOT NULL,
  rangoMision ENUM ('gennin', 'jounin', 'yuunin') NOT NULL,
  recompensaMision decimal(10,2) NOT NULL
);

CREATE TABLE tbl_mision_ninja (
  ninjaId integer,
  misionId integer,
  fechaInicio date,
  fechaFin date
);

CREATE TABLE tbl_habilidad (
  ninjaId integer,
  nombreHabilidad varchar(50),
  descripcionHabilidad text
);

ALTER TABLE tbl_mision_ninja ADD FOREIGN KEY (ninjaId) REFERENCES tbl_ninja (ninjaId);

ALTER TABLE tbl_mision_ninja ADD FOREIGN KEY (misionId) REFERENCES tbl_mision (misionId);

ALTER TABLE tbl_habilidad ADD FOREIGN KEY (ninjaId) REFERENCES tbl_ninja (ninjaId);


-- select

-- Inserts

INSERT INTO tbl_ninja (nombreNinja,rangoNinja,aldea) VALUES ('Naruto Uzumaki','gennin','Konoha');
INSERT INTO tbl_ninja (nombreNinja,rangoNinja,aldea) VALUES ('Persona x','jounin','Konoha');
INSERT INTO tbl_ninja (nombreNinja,rangoNinja,aldea) VALUES ('Kakashi Hatake','yuunin','Konoha');


INSERT INTO tbl_mision (descripcionMision,rangoMision,recompensaMision) 
VALUES ('Matar a Pain','gennin',10);

INSERT INTO tbl_mision (descripcionMision,rangoMision,recompensaMision) 
VALUES ('Hacer algo Y','jounin',100);

INSERT INTO tbl_mision (descripcionMision,rangoMision,recompensaMision) 
VALUES ('Ser Kakashi Epicamente','yuunin',10000);

INSERT INTO tbl_mision_ninja (ninjaId,misionId,fechaInicio,fechaFin) VALUES (1,1,'2023-01-29','2023-01-30');
INSERT INTO tbl_mision_ninja (ninjaId,misionId,fechaInicio,fechaFin) VALUES (2,2,'2023-01-30','2023-02-05');
INSERT INTO tbl_mision_ninja (ninjaId,misionId,fechaInicio,fechaFin) VALUES (3,3,'2023-02-06','2023-02-10');

INSERT INTO tbl_habilidad(ninjaId,nombreHabilidad,descripcionHabilidad) VALUES (1,'Rasengan','Espiral de Chakra');
INSERT INTO tbl_habilidad(ninjaId,nombreHabilidad,descripcionHabilidad) VALUES (2,'Habilidad z','hace algo zzz');
INSERT INTO tbl_habilidad(ninjaId,nombreHabilidad,descripcionHabilidad) VALUES (3,'Sharinga 50%','copia ninjutsus');