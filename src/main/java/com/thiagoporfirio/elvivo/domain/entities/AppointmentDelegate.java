package com.thiagoporfirio.elvivo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment_delegates")
@NoArgsConstructor
@Setter
@Getter
public class AppointmentDelegate
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "authorized_patient_id")
    private Long authorizedPatinetId;

    @Column(name = "valid_from")
    private LocalDateTime validFrom;
    @Column(name = "valid_to")
    private LocalDateTime validTo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
