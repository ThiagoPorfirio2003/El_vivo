package com.thiagoporfirio.elvivo.deprecated.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
/*
@Entity
@Table(name = "appointments_delegates")
@NoArgsConstructor
@Setter
@Getter
*/
public class AppointmentDelegateEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "patient_id")
    private Integer patientId;
    @Column(name = "authorized_patient_id")
    private Integer authorizedPatientId;

    @Column(name = "valid_from")
    private LocalDateTime validFrom;
    @Column(name = "valid_to")
    private LocalDateTime validTo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
