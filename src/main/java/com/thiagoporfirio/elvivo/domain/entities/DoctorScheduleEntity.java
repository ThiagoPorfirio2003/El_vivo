package com.thiagoporfirio.elvivo.domain.entities;

import com.thiagoporfirio.elvivo.domain.enums.WeekDays;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors_schedules")
@NoArgsConstructor
@Getter
@Setter
public class DoctorScheduleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "work_period_id")
    private Byte workPeriodId ;
    @Column(name = "week_day")
    @Enumerated(EnumType.STRING)
    private WeekDays weekDay;

    @Embedded
    @Getter(AccessLevel.NONE)
    private DoctorSpecialtyId doctorSpecialtyId;

    public Integer getDoctorId()
    {
        return this.doctorSpecialtyId.getDoctorId();
    }

    public Short getSpecialtyId()
    {
        return this.doctorSpecialtyId.getSpecialtyId();
    }
}
