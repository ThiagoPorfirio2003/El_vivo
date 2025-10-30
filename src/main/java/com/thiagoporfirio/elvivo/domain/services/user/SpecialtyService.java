package com.thiagoporfirio.elvivo.domain.services.user;

import com.thiagoporfirio.elvivo.domain.entities.SpecialtyEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
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

        /*
        if()
        {

        }
        */
    }
}
