CREATE DATABASE club_nautico;
USE club_nautico;

CREATE TABLE socio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL
);

CREATE TABLE barco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(50) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    numero_amarre VARCHAR(50) NOT NULL,
    cuota DECIMAL(10, 2) NOT NULL,
    socio_id BIGINT,
    FOREIGN KEY (socio_id) REFERENCES socio(id)
);

CREATE TABLE salida (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora_salida DATETIME NOT NULL,
    destino VARCHAR(255) NOT NULL,
    barco_id BIGINT,
    FOREIGN KEY (barco_id) REFERENCES barco(id)
);

CREATE TABLE patron (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100),
apellido_patron VARCHAR(100) NOT NULL,
barco_id BIGINT,
 FOREIGN KEY (barco_id) REFERENCES barco(id)
);

INSERT INTO socio (nombre, apellidos, direccion) VALUES 
('Juan', 'Perez', 'Calle Pepe 432'),
('María', 'Gomez', 'Avenida Siempreviva 742'),
('Carlos', 'Lopez', 'Paseo de la Reforma 45'),
('Ana', 'Martinez', 'Boulevard del Mar 67');


INSERT INTO barco (matricula, nombre, numero_amarre, cuota, socio_id) VALUES 
('DCR189', 'El Velero Feliz', 'A1', 1500.50, 1),
('CHZ726', 'Navegante Intrépido', 'B2', 2000.75, 2),
('MUI590', 'Marinero Solitario', 'C3', 1750.00, 3),
('GHI101', 'Océano Azul', 'D4', 2200.25, 4);


INSERT INTO patron (nombre, apellido_patron, barco_id) VALUES 
('Juan', 'Perez', 1),
('María', 'Gomez', 2),
('Carlos', 'Lopez', 3),
('Ana', 'Martinez', 4);


INSERT INTO salida (fecha_hora_salida, destino, barco_id) VALUES 
('2024-05-10 08:30:00', 'Isla Paradisiaca', 1),
('2024-05-15 10:00:00', 'Bahía Tranquila', 2),
('2024-05-20 12:45:00', 'Puerto Escondi');
