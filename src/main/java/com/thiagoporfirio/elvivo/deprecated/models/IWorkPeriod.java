package com.thiagoporfirio.elvivo.deprecated.models;

import com.thiagoporfirio.elvivo.domain.enums.WorkPeriods;

import java.time.LocalDateTime;

public interface IWorkPeriod
{
    public Byte getId();
    public WorkPeriods getName();
    public LocalDateTime getStartTime();
    public LocalDateTime getEndTime();
}
