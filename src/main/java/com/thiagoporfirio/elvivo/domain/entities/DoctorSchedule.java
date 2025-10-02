package com.thiagoporfirio.elvivo.domain.entities;

import com.thiagoporfirio.elvivo.utils.enums.WeekDays;
import com.thiagoporfirio.elvivo.utils.enums.WorkPeriods;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors_scheludes")
@NoArgsConstructor
@Getter
@Setter
public class DoctorSchedule
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "work_period")
    private WorkPeriods workPeriod;

    @Column(name = "week_day")
    private WeekDays weekDay;

    @Column(name = "doctor_specialty_id")
    private Long doctorSpecialtyId;
}
