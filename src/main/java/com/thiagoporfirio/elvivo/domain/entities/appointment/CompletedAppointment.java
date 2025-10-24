package com.thiagoporfirio.elvivo.domain.entities.appointment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "completed_appointments")
@NoArgsConstructor
@Getter
@Setter
public class CompletedAppointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "check_in_time")
    private LocalDateTime CheckInTime;
    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    /*
    private boolean isPatientSurveyCompleted;
    private boolean isDoctorSurveyCompleted;
    */
}
