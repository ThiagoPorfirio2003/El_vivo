package com.thiagoporfirio.elvivo.domain.repositories;

import com.thiagoporfirio.elvivo.domain.entities.DoctorScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorScheduleRepository extends JpaRepository<DoctorScheduleEntity, Integer>, IDoctorSpecialtyIdExtended<DoctorScheduleEntity> {
}
