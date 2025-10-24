package com.thiagoporfirio.elvivo.servicies.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserPersonalDataEntity;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserPersonalDataRepository;
import com.thiagoporfirio.elvivo.domain.exceptions.DuplicateEntityException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UserPersonalDataService
{
    private final UserPersonalDataRepository userPersonalDataRepository;


    /*
    public UserPersonalDataEntity create(String name, String surname, LocalDate birthDate, String dni, String imgName)
    {
        var userPersonalDataToSave = new UserPersonalDataEntity();

        if(this.userPersonalDataRepository.existsByDni(dni))
        {
            throw new DuplicateEntityException(UserPersonalDataEntity.class.getSimpleName(), "dni", dni);
        }

        userPersonalDataToSave.setName(name);
        userPersonalDataToSave.setSurname(surname);
        userPersonalDataToSave.setBirthDate(birthDate);
        userPersonalDataToSave.setImgName(imgName);

        return this.userPersonalDataRepository.save(userPersonalDataToSave);
    }
    */
}
