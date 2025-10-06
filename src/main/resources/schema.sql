CREATE TABLE user_credentials (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE user_personal_data (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    dni VARCHAR(12) NOT NULL UNIQUE,
    img_name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_profiles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(20) NOT NULL,
    is_enabled BOOLEAN NOT NULL,
    user_credential_id BIGINT UNIQUE,
    user_personal_data_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_credential_id) REFERENCES user_credentials(id),
    FOREIGN KEY (user_personal_data_id) REFERENCES user_personal_data(id)
);

CREATE TABLE appointments_delegates (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id BIGINT NOT NULL,
    authorized_patient_id BIGINT NOT NULL,
    valid_from TIMESTAMP NOT NULL,
    valid_to TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE (patient_id, authorized_patient_id),
    FOREIGN KEY (patient_id) REFERENCES user_profiles(id),
    FOREIGN KEY (authorized_patient_id) REFERENCES user_profiles(id)
);


CREATE TABLE specialties (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    img_name VARCHAR(125) NOT NULL
);

CREATE TABLE doctors_specialties (
    doctor_id BIGINT NOT NULL,
    specialty_id BIGINT NOT NULL,
    PRIMARY KEY (doctor_id, specialty_id),
    FOREIGN KEY (doctor_id) REFERENCES user_profiles(id),
    FOREIGN KEY (specialty_id) REFERENCES specialties(id)
);

CREATE TABLE doctors_schedules (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    work_period VARCHAR(20) NOT NULL,
    week_day VARCHAR(20) NOT NULL,
    doctor_id BIGINT NOT NULL,
    specialty_id BIGINT NOT NULL,
    FOREIGN KEY (doctor_id, specialty_id) REFERENCES doctors_specialties(doctor_id, specialty_id)
);

CREATE TABLE appointments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    doctor_id BIGINT NOT NULL,
    specialty_id BIGINT NOT NULL,
    patient_id BIGINT NOT NULL,
    requested_by_profile_id BIGINT NOT NULL,
    state_changed_by_profile_id BIGINT,
    state_changed_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (doctor_id, specialty_id) REFERENCES doctors_specialties(doctor_id, specialty_id),
    FOREIGN KEY (patient_id) REFERENCES user_profiles(id),
    FOREIGN KEY (requested_by_profile_id) REFERENCES user_profiles(id),
    FOREIGN KEY (state_changed_by_profile_id) REFERENCES user_profiles(id)
);

CREATE TABLE scheduled_appointments (
    id BIGINT PRIMARY KEY,
    scheduled_at TIMESTAMP NOT NULL,
    FOREIGN KEY (id) REFERENCES appointments(id)
);

CREATE TABLE walk_in_appointments (
    id BIGINT PRIMARY KEY,
    position_in_queue TINYINT NOT NULL,
    FOREIGN KEY (id) REFERENCES appointments(id)
);

CREATE TABLE invalid_appointments (
    id BIGINT PRIMARY KEY,
    reason VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES appointments(id)
);

CREATE TABLE completed_appointments (
    id BIGINT PRIMARY KEY,
    check_in_time TIMESTAMP NOT NULL,
    check_out_time TIMESTAMP NOT NULL,
    FOREIGN KEY (id) REFERENCES appointments(id)
);

CREATE TABLE diagnoses (
    id BIGINT PRIMARY KEY,
    treatment TEXT NOT NULL,
    weight_kg DECIMAL(5,2) NOT NULL,
    height_cm DECIMAL(5,2) NOT NULL,
    temperature_celcius DECIMAL(3,1) NOT NULL,
    systolic_pressure INT NOT NULL,
    diastolic_pressure INT NOT NULL,
    FOREIGN KEY (id) REFERENCES completed_appointments(id)
);


CREATE TABLE diagnostic_conditions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    diagnosis_id BIGINT NOT NULL,
    icd10_code VARCHAR(8) NOT NULL,
    note TEXT NOT NULL,
    FOREIGN KEY (diagnosis_id) REFERENCES diagnoses(id)
);