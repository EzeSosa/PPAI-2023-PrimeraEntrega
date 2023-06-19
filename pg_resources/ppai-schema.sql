CREATE DATABASE gestionllamadas;
\c gestionllamadas

CREATE TABLE cliente (idCliente SERIAL,
                      CONSTRAINT pk_idCliente PRIMARY KEY (idCliente),
                      nombre VARCHAR(50),
                      apellido VARCHAR(50),
                      nroDoc NUMERIC(8),
                      nroTelefono NUMERIC(11));


CREATE TABLE estado (idEstado SERIAL,
                     CONSTRAINT pk_idEstado PRIMARY KEY (idEstado),
                     nombre VARCHAR(25));


CREATE TABLE llamada (idLlamada SERIAL,
                      CONSTRAINT pk_idLlamada PRIMARY KEY (idLlamada),
                      descripcionOperador VARCHAR(100),
                      detalleAccionRequerida VARCHAR(100),
                      duracion INTEGER,
                      encuestaEnviada BOOLEAN,
                      observacionAuditor VARCHAR(100),
                      idEstado INTEGER,
                      idCliente INTEGER,
                      CONSTRAINT fk_llamada_estado FOREIGN KEY (idEstado) REFERENCES Estado(idEstado),
                      CONSTRAINT fk_llamada_cliente FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente));


CREATE TABLE cambioestado (idCambioEstado SERIAL,
                           CONSTRAINT pk_idCambioEstado PRIMARY KEY (idCambioEstado),
                           fechaCambioEstado DATE,
                           horaCambioEstado TIME,
                           idEstado INTEGER,
                           idLlamada INTEGER,
                           FOREIGN KEY (idEstado) REFERENCES Estado(idEstado),
                           FOREIGN KEY (idLlamada) REFERENCES Llamada(idLlamada));


CREATE TABLE encuesta  (idEncuesta SERIAL,
                        CONSTRAINT pk_idEncuesta PRIMARY KEY (idEncuesta),
                        descripcion VARCHAR(100),
                        fechaFinVigencia DATE);


CREATE TABLE pregunta (idPregunta SERIAL,
                       CONSTRAINT pk_idPregunta PRIMARY KEY (idPregunta),
                       descripcion VARCHAR(120),
                       idEncuesta INTEGER,
                       CONSTRAINT fk_pregunta_Encuesta FOREIGN KEY (idEncuesta) REFERENCES Encuesta(idEncuesta));


CREATE TABLE respuestaposible (idRespuestaPosible SERIAL,
                               CONSTRAINT pk_idRespuestaPosible PRIMARY KEY (idRespuestaPosible),
                               descripcion VARCHAR(50),
                               valor INTEGER,
                               idPregunta INTEGER,
                               CONSTRAINT fk_respuestaposible_pregunta FOREIGN KEY (idPregunta) REFERENCES Pregunta(idPregunta));


CREATE TABLE respuestadecliente (idRespuestaCliente SERIAL,
                                 CONSTRAINT pk_idRespuestaCliente PRIMARY KEY (idRespuestaCliente),
                                 fechaEncuesta DATE,
                                 idRespuestaPosible INTEGER,
                                 idLlamada INTEGER,
                                 FOREIGN KEY (idLlamada) REFERENCES Llamada(idLlamada),
                                 CONSTRAINT fk_respuestaDeCliente_respuestaPosible FOREIGN KEY (idRespuestaPosible) REFERENCES RespuestaPosible(idRespuestaPosible));