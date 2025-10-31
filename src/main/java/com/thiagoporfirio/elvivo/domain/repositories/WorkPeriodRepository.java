package com.thiagoporfirio.elvivo.domain.repositories;

import com.thiagoporfirio.elvivo.domain.entities.WorkPeriodEntity;
import com.thiagoporfirio.elvivo.domain.enums.WeekDays;
import com.thiagoporfirio.elvivo.domain.enums.WorkPeriods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkPeriodRepository extends JpaRepository<WorkPeriodEntity, Byte>
{
}
