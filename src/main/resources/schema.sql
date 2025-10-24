CREATE TABLE user_credentials (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE user_personal_data (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    dni VARCHAR(12) NOT NULL UNIQUE,
    img_name VARCHAR(50) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_profiles (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(20) NOT NULL,
    is_enabled BOOLEAN NOT NULL,
    user_credential_id INTEGER UNIQUE,
    user_personal_data_id INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_credential_id) REFERENCES user_credentials(id),
    FOREIGN KEY (user_personal_data_id) REFERENCES user_personal_data(id),
    UNIQUE (role, user_personal_data_id)
);

--CREATE TABLE appointments_delegates (
--    id INTEGER AUTO_INCREMENT PRIMARY KEY,
--    patient_id INTEGER NOT NULL,
--    authorized_patient_id INTEGER NOT NULL,
--    valid_from TIMESTAMP NOT NULL,
--    valid_to TIMESTAMP NOT NULL,
--    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
--    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
--    FOREIGN KEY (patient_id) REFERENCES user_profiles(id),
--    FOREIGN KEY (authorized_patient_id) REFERENCES user_profiles(id),
--    UNIQUE (patient_id, authorized_patient_id)
--);

CREATE TABLE specialties (
    id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    img_name VARCHAR(125) NOT NULL UNIQUE,
    avg_appointment_minutes INT NOT NULL DEFAULT 30
);

CREATE TABLE work_periods(
    id TINYINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL
);

CREATE TABLE doctors_specialties (
    doctor_id INTEGER NOT NULL,
    specialty_id INTEGER NOT NULL,
    PRIMARY KEY (doctor_id, specialty_id),
    FOREIGN KEY (doctor_id) REFERENCES user_profiles(id),
    FOREIGN KEY (specialty_id) REFERENCES specialties(id)
);

CREATE TABLE doctors_schedules (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    work_period_id TINYINT NOT NULL,
    week_day VARCHAR(20) NOT NULL,
    doctor_id INTEGER NOT NULL,
    specialty_id SMALLINT NOT NULL,
    FOREIGN KEY (doctor_id, specialty_id) REFERENCES doctors_specialties(doctor_id, specialty_id),
    FOREIGN KEY (work_period_id) REFERENCES work_periods(id),
    UNIQUE (work_period_id, week_day, doctor_id)
);

CREATE TABLE appointments (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    doctor_id INTEGER NOT NULL,
    specialty_id SMALLINT NOT NULL,
    patient_id INTEGER NOT NULL,
--    requested_by_profile_id INTEGER NOT NULL,
--    state_changed_by_profile_id INTEGER,
--    state_changed_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (doctor_id, specialty_id) REFERENCES doctors_specialties(doctor_id, specialty_id),
    FOREIGN KEY (patient_id) REFERENCES user_profiles(id)--,
--    FOREIGN KEY (requested_by_profile_id) REFERENCES user_profiles(id),
--    FOREIGN KEY (state_changed_by_profile_id) REFERENCES user_profiles(id)
);

CREATE TABLE scheduled_appointments (
    id BIGINT PRIMARY KEY,
    scheduled_at TIMESTAMP NOT NULL,
    FOREIGN KEY (id) REFERENCES appointments(id)
);

CREATE TABLE walk_in_appointments (
    id INTEGER PRIMARY KEY,
    position_in_queue TINYINT NOT NULL,
    FOREIGN KEY (id) REFERENCES appointments(id)
);

CREATE TABLE invalid_appointments (
    id INTEGER PRIMARY KEY,
    reason VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id) REFERENCES appointments(id)
);

CREATE TABLE completed_appointments (
    id INTEGER PRIMARY KEY,
    check_in_time TIMESTAMP NOT NULL,
    check_out_time TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id) REFERENCES appointments(id)
);

CREATE TABLE diagnoses (
    id INTEGER PRIMARY KEY,
    treatment TEXT NOT NULL,
    weight_kg DECIMAL(5,3) NOT NULL,
    height_cm DECIMAL(5,2) NOT NULL,
    temperature_celcius DECIMAL(3,1) NOT NULL,
    systolic_pressure INTEGER NOT NULL,
    diastolic_pressure INT NOT NULL,
    FOREIGN KEY (id) REFERENCES completed_appointments(id)
);


CREATE TABLE diagnostic_conditions (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    diagnosis_id INTEGER NOT NULL,
    medical_condition VARCHAR(255) NOT NULL,
    note TEXT NOT NULL,
    FOREIGN KEY (diagnosis_id) REFERENCES diagnoses(id)
);