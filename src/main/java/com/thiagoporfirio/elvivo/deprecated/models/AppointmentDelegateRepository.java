package com.thiagoporfirio.elvivo.deprecated.models;

import java.util.Optional;
import java.util.Set;

public interface AppointmentDelegateRepository// extends JpaRepository<AppointmentDelegateEntity, Long>
{
    public Set<AppointmentDelegateEntity> findAllByPatientId(Long patientId);
    public Set<AppointmentDelegateEntity> findAllByAuthorizedPatientId(Long authorizedPatientId);

    public Optional<AppointmentDelegateEntity> findByPatientIdAndAuthorizedPatientId(Long patientId, Long authorizedPatientId);
    public boolean existsByPatientIdAndAuthorizedPatientId(Long patientId, Long authorizedPatientId);
}
