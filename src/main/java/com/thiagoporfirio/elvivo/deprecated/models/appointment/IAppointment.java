package com.thiagoporfirio.elvivo.deprecated.models.appointment;

import com.thiagoporfirio.elvivo.deprecated.models.IDoctorSpecialtyId;
import com.thiagoporfirio.elvivo.domain.enums.AppointmentStates;
import com.thiagoporfirio.elvivo.domain.enums.AppointmentTypes;

public interface IAppointment extends IDoctorSpecialtyId
{
    public Integer getId();
    public AppointmentTypes getType();
    public AppointmentStates getState();
    public Integer getPatientId();

    //Mas adelante
    //private AppointmentServices service
}
