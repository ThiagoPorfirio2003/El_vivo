package com.thiagoporfirio.elvivo.domain.services.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserPersonalDataEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserProfileEntity;
import com.thiagoporfirio.elvivo.domain.exceptions.DuplicateEntityException;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserCredentialRepository;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserPersonalDataRepository;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserProfileRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserService
{
    private final UserCredentialRepository userCredentialRepository;
    private final UserPersonalDataRepository userPersonalDataRepository;
    private final UserProfileRepository userProfileRepository;

    private void validateUserCredentialToCreate(UserCredentialEntity userCredentialEntity)
    {
        if(this.userCredentialRepository.existsByEmail(userCredentialEntity.getEmail()))
        {
            throw new DuplicateEntityException(UserCredentialEntity.class.getSimpleName(), "email", userCredentialEntity.getEmail());
        }
    }

    private void validateUserPersonalDataToCreate(UserPersonalDataEntity userPersonalDataEntity)
    {
        if(this.userPersonalDataRepository.existsByDni(userPersonalDataEntity.getDni()))
        {
            throw new DuplicateEntityException(UserPersonalDataEntity.class.getSimpleName(), "dni", userPersonalDataEntity.getDni());
        }

        if(this.userPersonalDataRepository.existsByImgName(userPersonalDataEntity.getImgName()))
        {
            throw new DuplicateEntityException(UserPersonalDataEntity.class.getSimpleName(), "img_name", userPersonalDataEntity.getImgName());
        }
    }

    /*
    private void validateUserProfileToCreate(UserProfileEntity userProfileEntity)
    {
        if(this.userProfileRepository.(userPersonalDataEntity.getDni()))
        {
            throw new DuplicateEntityException(UserPersonalDataEntity.class.getSimpleName(), "dni", userPersonalDataEntity.getDni());
        }
    }
    */
    @Transactional
    public void createAccount(UserCredentialEntity userCredentialEntity,
                              UserPersonalDataEntity userPersonalDataEntity,
                              UserProfileEntity userProfileEntity)
    {
        this.validateUserCredentialToCreate(userCredentialEntity);
        this.validateUserPersonalDataToCreate(userPersonalDataEntity);

        this.userCredentialRepository.save(userCredentialEntity);
        this.userPersonalDataRepository.save(userPersonalDataEntity);

        userProfileEntity.setUserCredentialId(userCredentialEntity.getId());
        userProfileEntity.setUserPersonalDataId(userPersonalDataEntity.getId());

        this.userProfileRepository.save(userProfileEntity);
    }
}
