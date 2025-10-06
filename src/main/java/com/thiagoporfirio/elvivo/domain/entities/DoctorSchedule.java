package com.thiagoporfirio.elvivo.domain.entities;

import com.thiagoporfirio.elvivo.utils.enums.WeekDays;
import com.thiagoporfirio.elvivo.utils.enums.WorkPeriods;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;

@Entity
@Table(name = "doctors_schedules")
@NoArgsConstructor
@Getter
@Setter
public class DoctorSchedule
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "work_period")
    @Enumerated(EnumType.STRING)
    private WorkPeriods workPeriod;
    @Column(name = "week_day")
    @Enumerated(EnumType.STRING)
    private WeekDays weekDay;

    @Embedded
    @Getter(AccessLevel.NONE)
    private DoctorSpecialtyId doctorSpecialtyId;

    public Long getDoctorId()
    {
        return this.doctorSpecialtyId.getDoctorId();
    }

    public Long getSpecialtyId()
    {
        return this.doctorSpecialtyId.getSpecialtyId();
    }
}
