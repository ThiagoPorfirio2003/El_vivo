package com.thiagoporfirio.elvivo.domain.repositories;

import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyId;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Set;

@NoRepositoryBean
public interface IDoctorSpecialtyIdExtended <T> extends IBaseDoctorSpecialtyId<T>
{
    public Set<T> findAllByDoctorSpecialtyId(DoctorSpecialtyId doctorSpecialtyId);
}
