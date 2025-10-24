package com.thiagoporfirio.elvivo.deprecated.models.appointment;

import java.time.LocalDateTime;

public interface IAppointmentDelegate
{
    public Integer getId();
    public Integer getPatientId();
    public Integer getAuthorizedPatientId();
    public LocalDateTime getValidFrom();
    public LocalDateTime getValidTo();
}
