package com.thiagoporfirio.elvivo.domain.repositories;

import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyEntity;
import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorSpecialtyRepository extends JpaRepository<DoctorSpecialtyEntity, DoctorSpecialtyId>, IBaseDoctorSpecialtyId<DoctorSpecialtyEntity>
{

}
