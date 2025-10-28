package com.thiagoporfirio.elvivo.domain.services.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserCredentialRepository;
import com.thiagoporfirio.elvivo.domain.exceptions.DuplicateEntityException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCredentialService
{
    private final UserCredentialRepository userCredentialRepository;

    public UserCredentialEntity findByEmail(String email)
    {
        return userCredentialRepository.findByEmail(email).orElseThrow(()->
                new EntityNotFoundException(String.format(
                        "Not found an %s with email=%s",
                        UserCredentialEntity.class.getSimpleName(),
                        email)));
    }

    /*
    public UserCredentialEntity create(String email, String encodedPassword)
    {
        var userCredentialToSave = new UserCredentialEntity();

        if(this.userCredentialRepository.existsByEmail(email))
        {
            throw new DuplicateEntityException(UserCredentialEntity.class.getSimpleName(),
                    "email", email);
        }

        userCredentialToSave.setEmail(email);
        userCredentialToSave.setPassword(encodedPassword);

        return this.userCredentialRepository.save(userCredentialToSave);
    }
    */
}
