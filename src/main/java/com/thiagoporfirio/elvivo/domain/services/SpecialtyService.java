package com.thiagoporfirio.elvivo.domain.services;

import com.thiagoporfirio.elvivo.domain.entities.SpecialtyEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserPersonalDataEntity;
import com.thiagoporfirio.elvivo.domain.exceptions.DuplicateEntityException;
import com.thiagoporfirio.elvivo.domain.repositories.SpecialtyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpecialtyService
{
    private final SpecialtyRepository specialtyRepository;

    private void validateToCreate(SpecialtyEntity specialtyEntity)
    {
        if(this.specialtyRepository.existsByName(specialtyEntity.getName()))
        {
            throw new DuplicateEntityException(SpecialtyEntity.class.getSimpleName(), "name", specialtyEntity.getName());
        }

        if(this.specialtyRepository.existsByImgName(specialtyEntity.getImgName()))
        {
            throw new DuplicateEntityException(SpecialtyEntity.class.getSimpleName(), "img_name", specialtyEntity.getImgName());
        }
    }

    public void createSpecialty(SpecialtyEntity specialtyEntity)
    {
        this.validateToCreate(specialtyEntity);

        this.specialtyRepository.save(specialtyEntity);
    }
}
