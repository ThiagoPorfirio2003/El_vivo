package com.thiagoporfirio.elvivo.domain.services;

import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserProfileEntity;
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
            throw new EntityNotFoundException(String.format(
                "Not found a doctor with id=%s",
                doctorSpecialty.getDoctorId()));
        }

        if(this.specialtyRepository.existsById(doctorSpecialty.getSpecialtyId()))
        {
            throw new EntityNotFoundException(String.format(
                    "Not found a doctor with id=%s",
                    doctorSpecialty.getDoctorId()));
        }

        this.doctorSpecialtyRepository.save(doctorSpecialty);
    }
}
