package com.thiagoporfirio.elvivo.deprecated.models;

import com.thiagoporfirio.elvivo.domain.enums.WeekDays;

public interface IDoctorSchedule extends IDoctorSpecialtyId
{
    public Integer getId();
    public Byte getWorkPeriodId();
    public WeekDays getWeekDay();
}
