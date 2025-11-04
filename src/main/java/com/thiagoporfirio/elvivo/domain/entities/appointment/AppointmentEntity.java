package com.thiagoporfirio.elvivo.domain.entities.appointment;

import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyId;
import com.thiagoporfirio.elvivo.domain.enums.AppointmentStates;
import com.thiagoporfirio.elvivo.domain.enums.AppointmentTypes;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@NoArgsConstructor
@Getter
@Setter
public class AppointmentEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AppointmentTypes type;
    @Enumerated(EnumType.STRING)
    private AppointmentStates state;

    @Column(name = "appointment_date")
    private LocalDate date;
    @Column(name = "appointment_time")
    private LocalTime time;

    @Column(name = "work_period_id")
    private Byte workPeriodId;

    //Mas adelante
    //private AppointmentServices service

    @Embedded
    @Getter(AccessLevel.NONE)
    private DoctorSpecialtyId doctorSpecialtyId;

    @Column(name = "patient_id")
    private Integer patientId;

    /*
    @Column(name = "requested_by_profile_id")
    private Long requestedByProfileId;
    */

    /*
    @Column(name = "state_changed_by_profile_id")
    private Long stateChangedByProfileId;
    */
    /*
    @Column(name = "state_changed_at")
    private LocalDateTime stateChangedAt;
    */

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Integer getDoctorId()
    {
        return this.doctorSpecialtyId.getDoctorId();
    }

    public Short getSpecialtyId()
    {
        return this.doctorSpecialtyId.getSpecialtyId();
    }
}
