INSERT INTO cliente (dni, nombreCompleto, nroCelular) VALUES (41033888, 'Manuel Ponja', 15403512), 
                                                                   (44472055, 'Maria Lazarte', 104191555),
                                                                   (44813774, 'Rosario Palmieri', 12720189),
                                                                   (44472050, 'Luz Lopez', 117847322),
                                                                   (45678948, 'Juan Ramirez', 107412654);


INSERT INTO estado (nombre) VALUES ('Iniciada'), 
                                   ('Finalizada'), 
                                   ('EnCurso'), 
                                   ('Descartada'),
                                   ('PteEscucha'), 
                                   ('Correcta'), 
                                   ('ConObservacion'),
                                   ('Cancelada');


INSERT INTO llamada (duracion, encuestaenviada, cliente_id, estadoactual_id) VALUES (15, true, 4, 2),
                                                                                    (10, true, 5, 5),
                                                                                    (5, true, 2, 7),
                                                                                    (3, true, 3, 2),
                                                                                    (1, false, 1, 6),
                                                                                    (9, false, 2, 8),
                                                                                    (11, true, 2, 5),
                                                                                    (5, false, 4, 2);


INSERT INTO encuesta (descripcion, fechaFinVigencia) VALUES ('Satisfaccion del Cliente', '2023-10-01'),
                                                            ('Trato del Operador', '2023-10-01'),
                                                            ('Duracion de la Llamada', '2023-10-01');


INSERT INTO pregunta (pregunta) VALUES ('¿Que puntaje recibe esta llamada en cuanto a su satisfaccion?'),
                                       ('¿Volverias a utilizar este servicio?'),
                                       ('¿El operador con el que te comunicaste, fue amable y cortes en todo momento?'),
                                       ('¿Consideras que tus preguntas fueron resueltas de manera satisfactoria?'),
                                       ('En una escala de Malo a Excelente, ¿Consideraste que el operador demostro un buen conocimiento sobre el tema?'),
                                       ('¿La voz del operador fue clara?'),
                                       ('¿La duracion de la llamada fue apropiada para resolver tus inquietudes?'),
                                       ('¿Has finalizado la llamada antes de tiempo?');

INSERT INTO encuesta_pregunta (encuesta_id, pregunta_id) VALUES (1, 1),
                                                                (1, 2),
                                                                (2, 3),
                                                                (2, 4),
                                                                (2, 5),
                                                                (2, 6),
                                                                (3, 7),
                                                                (3, 8);

INSERT INTO respuestaposible (descripcion, valor) VALUES ('Malo', 1), ('Regular', 2), ('Bueno', 3), ('Excelente', 4),
                                                         ('Si', 1), ('No', 2);
           

INSERT INTO pregunta_respuestaposible (pregunta_id, respuesta_id) VALUES (1, 1), (1, 2), (1, 3), (1, 4),
                                                                         (2, 5), (2, 6),
                                                                         (3, 5), (3, 6),
                                                                         (4, 5), (4, 6),
                                                                         (5, 1), (5, 2), (5, 3), (5, 4),
                                                                         (6, 5), (6, 6),
                                                                         (7, 5), (7, 6),
                                                                         (8, 5), (8, 6);


INSERT INTO respuestadecliente (fechaencuesta, respuestaseleccionada_id) VALUES ('2023-05-12', 4),
                                                                                ('2023-05-12', 5),
                                                                                ('2023-05-24', 5),
                                                                                ('2023-05-24', 6),
                                                                                ('2023-06-01', 5),
                                                                                ('2023-06-01', 5),
                                                                                ('2023-06-01', 4),
                                                                                ('2023-06-01', 5);

INSERT INTO llamada_respuestadecliente (llamada_id, respuestasdeencuesta_id) VALUES (1, 1),
                                                                                    (1, 2),
                                                                                    (2, 3),
                                                                                    (2, 4),
                                                                                    (3, 5),
                                                                                    (3, 6),
                                                                                    (3, 7),
                                                                                    (3, 8);


INSERT INTO cambioestado (fechahorafin, fechahorainicio, estado_id) VALUES 
    ('2023-05-09 15:48', '2023-05-09 15:44', 1),
    (NULL, '2023-05-09 15:48', 2),
    
    ('2023-05-10 17:05', '2023-05-10 17:00', 1),
    ('2023-05-10 17:09', '2023-05-10 17:05', 3),
    ('2023-05-10 20:00', '2023-05-10 17:09', 2),
    (NULL, '2023-05-10 20:00', 5),

    ('2023-04-01 10:07', '2023-04-01 10:00', 1),
    ('2023-04-01 10:20', '2023-04-01 10:07', 3),
    ('2023-04-02 08:00', '2023-04-01 10:20', 2),
    ('2023-04-02 09:05', '2023-04-02 08:00', 5),
    (NULL, '2023-04-02 09:05', 7),
    
    ('2023-04-17 19:25', '2023-04-17 19:23', 1),
    (NULL, '2023-04-17 19:25', 2),

    ('2023-04-20 11:03', '2023-04-20 11:00', 1),
    ('2023-04-20 11:10', '2023-04-20 11:03', 3),
    ('2023-04-21 09:05', '2023-04-20 11:10', 2),
    ('2023-04-21 10:00', '2023-04-20 09:05', 5),
    (NULL, '2023-04-21 10:00', 6),

    ('2023-04-05 07:35', '2023-04-05 07:30', 1),
    ('2023-04-05 07:37', '2023-04-05 07:35', 3),
    (NULL, '2023-04-05 07:37', 8),

    ('2023-04-11 12:30', '2023-04-11 12:20', 1),
    ('2023-04-11 12:35', '2023-04-11 12:30', 3),
    ('2023-04-14 08:00', '2023-04-11 12:35', 2),
    (NULL, '2023-04-14 08:00', 5),

    ('2023-05-17 09:01', '2023-05-17 09:00', 1),
    (NULL, '2023-05-17 09:01', 2);


INSERT INTO llamada_cambioestado (llamada_id, cambioestado_id) VALUES (1, 1),
                                                                      (1, 2),
                                                                      (2, 3),
                                                                      (2, 4),
                                                                      (2, 5),
                                                                      (2, 6),
                                                                      (3, 7),
                                                                      (3, 8),
                                                                      (3, 9),
                                                                      (3, 10),
                                                                      (3, 11),
                                                                      (4, 12),
                                                                      (4, 13),
                                                                      (5, 14),
                                                                      (5, 15),
                                                                      (5, 16),
                                                                      (5, 17),
                                                                      (5, 18),
                                                                      (6, 19),
                                                                      (6, 20),
                                                                      (6, 21),
                                                                      (7, 22),
                                                                      (7, 23),
                                                                      (7, 24),
                                                                      (7, 25),
                                                                      (8, 26),
                                                                      (8, 27);