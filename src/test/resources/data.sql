INSERT INTO user_credentials (email, password)
VALUES
    ('LucasAdmin@gmail.com', '{bcrypt}$2a$10$A1B2C3D4E5F6G7H8I9J0K1'), -- Clave: Lucas123
    ('DiegoAdmin@gmail.com', '{bcrypt}$2a$10$K2L3M4N5O6P7Q8R9S0T1U2'), -- Clave: Diego123
    ('MariaDoctor@gmail.com', '{bcrypt}$2a$10$U3V4W5X6Y7Z8A9B0C1D2E3'), -- Clave: Maria123
    ('CarlosDoctor@gmail.com', '{bcrypt}$2a$10$F4G5H6I7J8K9L0M1N2O3P4'), -- Clave: Carlos123
    ('LuciaDoctor@gmail.com', '{bcrypt}$2a$10$Q5R6S7T8U9V0W1X2Y3Z4A5'), -- Clave: Lucia123
    ('PedroDoctor@gmail.com', '{bcrypt}$2a$10$B6C7D8E9F0G1H2I3J4K5L6'), -- Clave: Pedro123
    ('SofiaPatient@gmail.com', '{bcrypt}$2a$10$M7N8O9P0Q1R2S3T4U5V6W7'), -- Clave: Sofia123
    ('JuanPatient@gmail.com', '{bcrypt}$2a$10$X8Y9Z0A1B2C3D4E5F6G7H8'), -- Clave: Juan123
    ('ValentinaPatient@gmail.com', '{bcrypt}$2a$10$I9J0K1L2M3N4O5P6Q7R8S9'), -- Clave: Valentina123
    ('BrunoPatient@gmail.com', '{bcrypt}$2a$10$T0U1V2W3X4Y5Z6A7B8C9D0'), -- Clave: Bruno123
    ('CamilaPatient@gmail.com', '{bcrypt}$2a$10$E1F2G3H4I5J6K7L8M9N0O1'), -- Clave: Camila123
    ('FrancoPatient@gmail.com', '{bcrypt}$2a$10$P2Q3R4S5T6U7V8W9X0Y1Z2'), -- Clave: Franco123
    ('JulietaPatient@gmail.com', '{bcrypt}$2a$10$A3B4C5D6E7F8G9H0I1J2K3'), -- Clave: Julieta123
    ('LautaroPatient@gmail.com', '{bcrypt}$2a$10$L4M5N6O7P8Q9R0S1T2U3V4'), -- Clave: Lautaro123
    ('MartinaPatient@gmail.com', '{bcrypt}$2a$10$W5X6Y7Z8A9B0C1D2E3F4G5'), -- Clave: Martina123
    ('RenataPatient@gmail.com', '{bcrypt}$2a$10$H6I7J8K9L0M1N2O3P4Q5R6'); -- Clave: Renata123

INSERT INTO user_personal_data (name, surname, birth_date, dni, img_name)
VALUES
    ('Lucas', 'Gomez', '1988-03-21', '32145678', '1730304701.jpg'),
    ('Diego', 'Martinez', '1980-06-17', '28745693', '1730304702.jpg'),
    ('Maria', 'Lopez', '1991-07-12', '29874561', '1730304703.jpg'),
    ('Carlos', 'Fernandez', '1985-11-05', '31258963', '1730304704.jpg'),
    ('Lucia', 'Garcia', '1989-10-21', '31987456', '1730304705.jpg'),
    ('Pedro', 'Silva', '1982-04-07', '29874125', '1730304706.jpg'),
    ('Sofia', 'Ramirez', '1998-02-14', '41589632', '1730304707.jpg'),
    ('Juan', 'Perez', '1997-09-30', '40125896', '1730304708.jpg'),
    ('Valentina', 'Morales', '2000-01-08', '42789631', '1730304709.jpg'),
    ('Bruno', 'Sanchez', '1999-04-22', '42987563', '1730304710.jpg'),
    ('Camila', 'Torres', '2001-06-11', '43895621', '1730304711.jpg'),
    ('Franco', 'Diaz', '1996-08-19', '39852147', '1730304712.jpg'),
    ('Julieta', 'Acosta', '2002-10-03', '44123698', '1730304713.jpg'),
    ('Lautaro', 'Benitez', '1995-12-25', '38741236', '1730304714.jpg'),
    ('Martina', 'Dominguez', '1994-03-09', '37641258', '1730304715.jpg'),
    ('Renata', 'Herrera', '2003-05-15', '45236987', '1730304716.jpg');

INSERT INTO user_profiles (role, is_enabled, user_credential_id, user_personal_data_id)
VALUES
    ('ADMIN', TRUE, 1, 1),
    ('ADMIN', TRUE, 2, 2),
    ('DOCTOR', TRUE, 3, 3),
    ('DOCTOR', TRUE, 4, 4),
    ('DOCTOR', TRUE, 5, 5),
    ('DOCTOR', TRUE, 6, 6),
    ('PATIENT', TRUE, 7, 7),
    ('PATIENT', TRUE, 8, 8),
    ('PATIENT', TRUE, 9, 9),
    ('PATIENT', TRUE, 10, 10),
    ('PATIENT', TRUE, 11, 11),
    ('PATIENT', TRUE, 12, 12),
    ('PATIENT', TRUE, 13, 13),
    ('PATIENT', TRUE, 14, 14),
    ('PATIENT', TRUE, 15, 15),
    ('PATIENT', TRUE, 16, 16);

INSERT INTO specialties (name, img_name, avg_appointment_minutes)
VALUES
    ('Otorrinolaringólogo', 'Otorrinolaringologo.jpg', 20),
    ('Pediatra', 'Pediatra.jpg', 30),
    ('Médico Generalista', 'Medico Generalista.jpg', 35),
    ('Traumatólogo', 'Traumatologo.jpg', 25);

INSERT INTO work_periods (name, start_time, end_time)
VALUES
    ('MORNING', '08:00:00', '12:00:00'),
    ('NOON', '12:00:00', '16:00:00'),
    ('AFTERNOON', '16:00:00', '20:00:00');

INSERT INTO doctors_specialties (doctor_id, specialty_id)
VALUES
    (3,1),
    (4,2);

INSERT INTO doctors_schedules (work_period_id, week_day, doctor_id, specialty_id)
VALUES
    -- Doctor con id 3
    (1, 'MONDAY', 3, 1),
    (2, 'WEDNESDAY', 3, 1),
    (3, 'FRIDAY', 3, 1),

    -- Doctor con id 4
    (1, 'MONDAY', 4, 2),
    (2, 'MONDAY', 4, 2),
    (3, 'TUESDAY', 4, 2),
    (1, 'THURSDAY', 4, 2),
    (2, 'THURSDAY', 4, 2);