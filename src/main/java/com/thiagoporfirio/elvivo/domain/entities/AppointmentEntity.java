package com.thiagoporfirio.elvivo.domain.entities;

import com.thiagoporfirio.elvivo.utils.enums.AppointmentStates;
import com.thiagoporfirio.elvivo.utils.enums.AppointmentTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@NoArgsConstructor
@Getter
@Setter
public class AppointmentEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AppointmentTypes type;
    private AppointmentStates state;

    //Mas adelante
    //private AppointmentServices service

    @Column(name = "specialty_id")
    private Long specialtyId;
    @Column(name = "doctor_id")
    private Long doctorId;
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "requested_by_profile_id")
    private Long requestedByProfileId;

    @Column(name = "state_changed_by_profile_id")
    private Long stateChangedByProfileId;
    @Column(name = "state_changed_at")
    private LocalDateTime stateChangedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
