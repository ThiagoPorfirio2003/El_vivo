package com.thiagoporfirio.elvivo.deprecated.models.appointment;

import java.time.LocalDateTime;

public interface ICompletedAppointment
{
    public Integer getId();
    public LocalDateTime getCheckInTime();
    public LocalDateTime getCheckOutTime();
}
