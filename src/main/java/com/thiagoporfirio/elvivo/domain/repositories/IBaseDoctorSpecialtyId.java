package com.thiagoporfirio.elvivo.domain.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.Set;

@NoRepositoryBean
public interface IBaseDoctorSpecialtyId<T>
{
    public Set<T> findAllByDoctorSpecialtyId_DoctorId(Integer doctorId);
    public Set<T> findAllByDoctorSpecialtyId_SpecialtyId(Short specialtyId);
}
