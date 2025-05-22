-- Crear tabla si no existe
CREATE TABLE IF NOT EXISTS mensaje (
                                       idMensaje INTEGER PRIMARY KEY AUTOINCREMENT,
                                       mensaje TEXT NOT NULL,
                                       tipo TEXT NOT NULL
);

-- Insertar 10 mensajes con color
INSERT INTO mensaje (mensaje, tipo) VALUES ('Hola, ¿cómo estás?', 'verde');
INSERT INTO mensaje (mensaje, tipo) VALUES ('Nos reunimos mañana a las 10.', 'amarillo');
INSERT INTO mensaje (mensaje, tipo) VALUES ('¡Felicidades por tu logro!', 'verde');
INSERT INTO mensaje (mensaje, tipo) VALUES ('No olvides enviar el informe.', 'rojo');
INSERT INTO mensaje (mensaje, tipo) VALUES ('La reunión fue reprogramada para el viernes.', 'amarillo');
INSERT INTO mensaje (mensaje, tipo) VALUES ('Te llamo en 10 minutos.', 'amarillo');
INSERT INTO mensaje (mensaje, tipo) VALUES ('¿Puedes revisar el documento adjunto?', 'rojo');
INSERT INTO mensaje (mensaje, tipo) VALUES ('Recuerda traer tu computador portátil.', 'amarillo');
INSERT INTO mensaje (mensaje, tipo) VALUES ('Gracias por tu ayuda.', 'verde');
INSERT INTO mensaje (mensaje, tipo) VALUES ('¡Evacuar el edificio inmediatamente!', 'rojo');