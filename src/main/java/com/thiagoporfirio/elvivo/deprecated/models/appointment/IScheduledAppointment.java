package com.thiagoporfirio.elvivo.deprecated.models.appointment;

import java.time.LocalDateTime;

public interface IScheduledAppointment
{
    public Integer getId();
    public LocalDateTime ScheduledAt();
}
