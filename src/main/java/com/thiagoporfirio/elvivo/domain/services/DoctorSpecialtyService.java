package com.thiagoporfirio.elvivo.domain.services;

import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyEntity;
import com.thiagoporfirio.elvivo.domain.exceptions.DuplicateEntityException;
import com.thiagoporfirio.elvivo.domain.repositories.DoctorSpecialtyRepository;
import com.thiagoporfirio.elvivo.domain.repositories.SpecialtyRepository;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorSpecialtyService
{
    private final DoctorSpecialtyRepository doctorSpecialtyRepository;
    private final UserProfileRepository userProfileRepository;
    private final SpecialtyRepository specialtyRepository;


    public void save(DoctorSpecialtyEntity doctorSpecialty)
    {
        if(this.userProfileRepository.existsById(doctorSpecialty.getDoctorId()))
        {
            throw new DuplicateEntityException(
                    doctorSpecialty.getClass().getSimpleName(),
                    "doctor_id",
                    doctorSpecialty.getDoctorId().toString()
            );
        }

        if(this.specialtyRepository.existsById(doctorSpecialty.getSpecialtyId()))
        {
            throw new DuplicateEntityException(
                    doctorSpecialty.getClass().getSimpleName(),
                    "specialty_id",
                    doctorSpecialty.getSpecialtyId().toString()
            );
        }

        this.doctorSpecialtyRepository.save(doctorSpecialty);
    }
}
