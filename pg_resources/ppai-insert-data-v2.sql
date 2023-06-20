INSERT INTO cliente (dni, nombreCompleto, nroCelular) VALUES (41033888, 'Manuel Ponja', 15403512), 
                                                             (44472055, 'Maria Lazarte', 104191555),
                                                             (44813774, 'Rosario Palmieri', 12720189),
                                                             (44472050, 'Luz Lopez', 117847322),
                                                             (45678948, 'Juan Ramirez', 107412654),
                                                             (44297679, 'Exequiel Souza', 15458647),
                                                             (40219242, 'Romina Morales', 15203122);


INSERT INTO estado (nombre) VALUES ('Iniciada'), 
                                   ('Finalizada'), 
                                   ('EnCurso'), 
                                   ('Descartada'),
                                   ('PteEscucha'), 
                                   ('Correcta'), 
                                   ('ConObservacion'),
                                   ('Cancelada');


INSERT INTO llamada (descripcionoperador, duracion, encuestaenviada, cliente_id, estadoactual_id) VALUES ('No pasó por operador', 15, true, 4, 2),
                                                                                                         ('Anulación de la tarjeta por robo', 10, true, 5, 5),
                                                                                                         ('Desbloqueo de la tarjeta por pago de deudas', 20, true, 2, 7),
                                                                                                         ('No pasó por operador', 2, true, 3, 2),
                                                                                                         ('Solicitud de nueva tarjeta por robo', 10, false, 1, 6),
                                                                                                         ('No pasó por operador', 7, false, 2, 8),
                                                                                                         ('Solicitud de nueva tarjeta por pérdida', 15, true, 2, 5),
                                                                                                         ('No pasó por operador', 5, false, 4, 2),
                                                                                                         ('Solicitud de nueva tarjeta por robo', 7, true, 6, 4),
                                                                                                         ('Solicitud de nueva tarjeta por robo', 13, true, 7, 2),
                                                                                                         ('No pasó por operador', 6, true, 6, 4),
                                                                                                         ('Anulación de la tarjeta por robo', 12, true, 1, 4),
                                                                                                         ('No pasó por operador', 4, true, 3, 2);


INSERT INTO encuesta (descripcion, fechaFinVigencia) VALUES ('Satisfaccion del Cliente', '2023-12-12'),
                                                            ('Facilidad y Eficiencia de Utilización del Sistema', '2023-12-12'),
                                                            ('Trato del Operador', '2023-12-12'),
                                                            ('Aspectos del Sistema Automatizado', '2023-12-12');


INSERT INTO pregunta (pregunta) VALUES ('¿Con que frecuencia utilizas nuestro sistema automatizado?'), -- ENCUESTA 1
                                       ('¿Que tan satisfecho estás con la capacidad del sistema para resolver tus problemas?'),
                                       ('¿El sistema automatizado fue capaz de proporcionar respuestas utiles a tus preguntas?'),

                                       ('¿Que tan facil fue navegar y utilizar nuestro sistema automatizado?'), -- ENCUESTA 2
                                       ('¿En que medida el sistema automatizado cumplio tus expectativas de rapidez de respuesta?'),
                                       ('¿Recomendarias nuestro sistema automatizado de atencion al cliente a otras personas?'),

                                       ('¿El operador pudo proporcionar la informacion que necesitabas?'), -- ENCUESTA 3
                                       ('¿Que tanto conocimiento demostro el operador sobre el tema?'),
                                       ('¿El operador con el que te comunicaste, fue amable y cortes en todo momento?'),

                                       ('¿Cual fue el aspecto mas destacado de nuestro sistema automatizado?'), -- ENCUESTA 4
                                       ('¿Que puntaje le darias a la experiencia de utilizacion de nuestro sistema?');


INSERT INTO encuesta_pregunta (encuesta_id, pregunta_id) VALUES (1, 1),
                                                                (1, 2),
                                                                (1, 3),

                                                                (2, 4),
                                                                (2, 5),
                                                                (2, 6),

                                                                (3, 7),
                                                                (3, 8),
                                                                (3, 9),

                                                                (4, 10),
                                                                (4, 11);


INSERT INTO respuestaposible (descripcion, valor) VALUES ('Ocasionalmente', 1), ('Semanalmente', 2), ('Diariamente', 3), -- PREGUNTA 1
                                                         ('Insatisfecho', 1), ('Neutral', 2), ('Satisfecho', 3), -- PREGUNTA 2
                                                         ('Nunca', 1), ('Algunas veces', 2), ('La mayoria de veces', 3), ('Siempre', 4), -- PREGUNTA 3

                                                         ('Dificil', 1), ('Normal', 2), ('Facil', 3), -- PREGUNTA 4
                                                         ('No cumplio mis expectativas', 1), ('Cumplio mis expectativas', 2), ('Supero mis expectativas', 3), -- PREGUNTA 5
                                                         ('Definitivamente no', 1), ('No estoy seguro/a', 2), ('Definitivamente si', 3), -- PREGUNTA 6

                                                         ('No pudo', 1), ('Pudo a medias', 2), ('Si pudo', 3), -- PREGUNTA 7
                                                         ('Poco', 1), ('Regular', 2), ('Bastante', 3), ('Mucho', 4), -- PREGUNTA 8
                                                         ('No fue amable', 1), ('Tuvo un trato normal', 2), ('Fue amable', 3), -- PREGUNTA 9

                                                         ('Rapidez de respuesta', 1), ('Facilidad de uso', 2), ('Disponibilidad', 3), ('No tuvo aspectos destacables', 4), -- PREGUNTA 10
                                                         ('Malo', 1), ('Regular', 2), ('Bueno', 3), ('Excelente', 4); -- PREGUNTA 11
           

INSERT INTO pregunta_respuestaposible (pregunta_id, respuesta_id) VALUES (1, 1), (1, 2), (1, 3), -- ENCUESTA 1
                                                                         (2, 4), (2, 5), (2, 6),
                                                                         (3, 7), (3, 8), (3, 9), (3, 10),

                                                                         (4, 11), (4, 12), (4, 13), -- ENCUESTA 2
                                                                         (5, 14), (5, 15), (5, 16),
                                                                         (6, 17), (6, 18), (6, 19),

                                                                         (7, 20), (7, 21), (7, 22), -- ENCUESTA 3
                                                                         (8, 23), (8, 24), (8, 25), (8, 26),
                                                                         (9, 27), (9, 28), (9, 29),

                                                                         (10, 30), (10, 31), (10, 32), (10, 33), -- ENCUESTA 4
                                                                         (11, 34), (11, 35), (11, 36), (11, 37);


INSERT INTO respuestadecliente (fechaencuesta, respuestaseleccionada_id) VALUES ('2023-05-09', 3), -- LLAMADA 1 - ENCUESTA 1
                                                                                ('2023-05-09', 6),
                                                                                ('2023-05-09', 10),

                                                                                ('2023-05-10', 21), -- LLAMADA 2 - ENCUESTA 3
                                                                                ('2023-05-10', 24),
                                                                                ('2023-05-10', 28),

                                                                                ('2023-04-05', 22), -- LLAMADA 3 - ENCUESTA 3
                                                                                ('2023-04-05', 25),
                                                                                ('2023-04-05', 29),
                                                                                
                                                                                ('2023-04-17', 31), -- LLAMADA 4 - ENCUESTA 4
                                                                                ('2023-04-17', 36),

                                                                                ('2023-04-11', 13), -- LLAMADA 7 - ENCUESTA 2
                                                                                ('2023-04-11', 16),
                                                                                ('2023-04-11', 19),

                                                                                ('2023-05-12', 12), -- LLAMADA 9 - ENCUESTA 2
                                                                                ('2023-05-12', 15),
                                                                                ('2023-05-12', 18),

                                                                                ('2023-03-11', 2), -- LLAMADA 10 - ENCUESTA 1
                                                                                ('2023-03-11', 5),
                                                                                ('2023-03-11', 9),

                                                                                ('2023-03-16', 32), -- LLAMADA 11 - ENCUESTA 4
                                                                                ('2023-03-16', 37),

                                                                                ('2023-06-05', 1), -- LLAMADA 12, ENCUESTA 1
                                                                                ('2023-06-05', 6),
                                                                                ('2023-06-05', 9),

                                                                                ('2023-06-18', 33), -- LLAMADA 13, ENCUESTA 4
                                                                                ('2023-06-18', 34);


INSERT INTO llamada_respuestadecliente (llamada_id, respuestasdeencuesta_id) VALUES (1, 1),
                                                                                    (1, 2),
                                                                                    (1, 3),
                                                                                    
                                                                                    (2, 4),
                                                                                    (2, 5),
                                                                                    (2, 6),

                                                                                    (3, 7),
                                                                                    (3, 8),
                                                                                    (3, 9),

                                                                                    (4, 10),
                                                                                    (4, 11),

                                                                                    (7, 12),
                                                                                    (7, 13),
                                                                                    (7, 14),

                                                                                    (9, 15),
                                                                                    (9, 16),
                                                                                    (9, 17),

                                                                                    (10, 18),
                                                                                    (10, 19),
                                                                                    (10, 20),

                                                                                    (11, 21),
                                                                                    (11, 22),

                                                                                    (12, 23),
                                                                                    (12, 24),
                                                                                    (12, 25),

                                                                                    (13, 26),
                                                                                    (13, 27);


INSERT INTO cambioestado (fechahorafin, fechahorainicio, estado_id) VALUES 
    ('2023-05-09 15:59', '2023-05-09 15:44', 1), -- LLAMADA 1
    (NULL, '2023-05-09 15:59', 2),
    
    ('2023-05-10 17:05', '2023-05-10 17:00', 1), -- LLAMADA 2
    ('2023-05-10 17:10', '2023-05-10 17:05', 3),
    ('2023-05-10 20:00', '2023-05-10 17:10', 2),
    (NULL, '2023-05-10 20:00', 5),

    ('2023-04-01 10:07', '2023-04-01 10:00', 1), -- LLAMADA 3
    ('2023-04-01 10:20', '2023-04-01 10:07', 3),
    ('2023-04-02 08:00', '2023-04-01 10:20', 2),
    ('2023-04-02 09:05', '2023-04-02 08:00', 5),
    (NULL, '2023-04-02 09:05', 7),
    
    ('2023-04-17 19:25', '2023-04-17 19:23', 1), -- LLAMADA 4
    (NULL, '2023-04-17 19:25', 2),

    ('2023-04-20 11:03', '2023-04-20 11:00', 1), -- LLAMADA 5
    ('2023-04-20 11:10', '2023-04-20 11:03', 3),
    ('2023-04-21 09:05', '2023-04-20 11:10', 2),
    ('2023-04-21 10:00', '2023-04-20 09:05', 5),
    (NULL, '2023-04-21 10:00', 6),

    ('2023-04-05 07:35', '2023-04-05 07:30', 1), -- LLAMADA 6
    ('2023-04-05 07:37', '2023-04-05 07:35', 3),
    (NULL, '2023-04-05 07:37', 8),

    ('2023-04-11 12:30', '2023-04-11 12:20', 1), -- LLAMADA 7
    ('2023-04-11 12:35', '2023-04-11 12:30', 3),
    ('2023-04-14 08:00', '2023-04-11 12:35', 2),
    (NULL, '2023-04-14 08:00', 5),

    ('2023-05-17 09:04', '2023-05-17 09:00', 1), -- LLAMADA 8
    (NULL, '2023-05-17 09:04', 2),

    ('2023-05-11 10:05', '2023-05-11 10:01', 1), -- LLAMADA 9
    ('2023-05-11 10:08', '2023-05-11 10:05', 3),
    ('2023-05-12 08:05', '2023-05-11 10:08', 2),
    (NULL, '2023-05-12 08:05', 4),

    ('2023-03-10 16:21', '2023-03-10 16:16', 1), -- LLAMADA 10
    ('2023-03-10 16:29', '2023-03-10 16:21', 3),
    (NULL, '2023-03-10 16:29', 2),

    ('2023-03-15 19:01', '2023-03-15 18:55', 1), -- LLAMADA 11
    ('2023-03-16 09:05', '2023-03-15 19:01', 2),
    (NULL, '2023-03-16 09:05', 4),

    ('2023-06-05 10:11', '2023-06-05 10:08', 1), -- LLAMADA 12
    ('2023-06-05 10:20', '2023-06-05 10:11', 3),
    ('2023-06-06 09:05', '2023-06-05 10:20', 2),
    (NULL, '2023-06-06 09:05', 4),

    ('2023-06-18 13:09', '2023-06-18 13:05', 1), -- LLAMADA 13
    (NULL, '2023-06-18 13:09', 2);


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
                                                                      (8, 27),

                                                                      (9, 28),
                                                                      (9, 29),
                                                                      (9, 30),
                                                                      (9, 31),
                                                                      
                                                                      (10, 32),
                                                                      (10, 33),
                                                                      (10, 34),
                                                                      
                                                                      (11, 35),
                                                                      (11, 36),
                                                                      (11, 37),

                                                                      (12, 38),
                                                                      (12, 39),
                                                                      (12, 40),
                                                                      (12, 41),

                                                                      (13, 42),
                                                                      (13, 43);