package com.thiagoporfirio.elvivo.domain.repositories;

import com.thiagoporfirio.elvivo.domain.entities.WorkPeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkPeriodRepository extends JpaRepository<WorkPeriodEntity, Byte> {
}
