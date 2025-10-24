package com.thiagoporfirio.elvivo.deprecated.models;

import java.math.BigDecimal;

public interface IDiagnosis
{
    public Integer getId();
    public String getTreatment();
    public BigDecimal getWeightKg();
    public BigDecimal getHeightCm();
    public BigDecimal getTemperatureCelcius();
    public Short getSystolicPressure();
    public Short getDiastolicPressure();
}
