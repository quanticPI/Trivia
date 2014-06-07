DROP TABLE IF EXISTS PREGUNTA;


CREATE TABLE usuario (
       Nombre CHAR(50) NOT NULL
     , Puntuacion_Total INT
     , Historia_Acertadas INT
     , Historia_Falladas INT
     , Deporte_Acertadas INT
     , Deporte_Falladas INT
     , Cine_Acertadas INT
     , Cine__Falladas INT
     , Musica_Acertadas INT
     , Musica__Falladas INT
     , PRIMARY KEY (Nombre)
);


CREATE TABLE Pregunta (
       ID INT NOT NULL IDENTITY PRIMARY KEY
     , Categoria CHAR(20)
     , Texto_Pregunta CHAR(500)
     , Respuesta_Correcta CHAR(500)
     , Respuesta_Falsa1 CHAR(500)
     , Respuesta_Falsa2 CHAR(500)
     , Respuesta_Falsa3 CHAR(500)
);
