package com.thiagoporfirio.elvivo.domain.services.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserPersonalDataEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserProfileEntity;
import com.thiagoporfirio.elvivo.domain.enums.UserRoles;
import com.thiagoporfirio.elvivo.domain.exceptions.DuplicateEntityException;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserCredentialRepository;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserPersonalDataRepository;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserProfileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests
{
    @Mock
    private UserCredentialRepository userCredentialRepository;
    @Mock
    private UserPersonalDataRepository userPersonalDataRepository;
    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserService userService;

    private UserCredentialEntity userCredential;
    private UserPersonalDataEntity userPersonalData;

    @BeforeEach
    public void setUp()
    {
        this.userCredential = new UserCredentialEntity();
        userCredential.setEmail("test123@email.com");
        userCredential.setPassword("123password456");
        userCredential.setId(1);
        userCredential.setCreatedAt(LocalDateTime.now());

        this.userPersonalData = new UserPersonalDataEntity();
        userPersonalData.setName("Thiago Lisandro");
        userPersonalData.setSurname("Porfirio");
        userPersonalData.setDni("12345678");
        userPersonalData.setImgName("thiago.1523344.jpg");
        userPersonalData.setId(1);
        userPersonalData.setCreatedAt(LocalDateTime.now());
    }

    @Test
    public void createAccount_invalidUserCredential_throwsDuplicateEntityException()
    {
        Mockito.when(this.userCredentialRepository.existsByEmail(this.userCredential.getEmail())).thenReturn(true);

        Assertions.assertThrows(DuplicateEntityException.class,
                ()->this.userService.createAccount(this.userCredential, null, null));
    }

    @Test
    public void createAccount_dniAlreadyExists_throwsDuplicateEntityException()
    {
        Mockito.when(this.userPersonalDataRepository.existsByDni(this.userPersonalData.getDni())).thenReturn(true);

        Assertions.assertThrows(DuplicateEntityException.class,
                ()->this.userService.createAccount(this.userCredential, this.userPersonalData, null));
    }

    @Test
    public void createAccount_imgNameAlreadyExists_throwsDuplicateEntityException()
    {
        Mockito.when(this.userPersonalDataRepository.existsByDni(this.userPersonalData.getDni())).thenReturn(true);
    }

    @Test
    public void createAccount_validData_savedAllEntitiesSuccessfully()
    {
        //Arrange
        var userProfile = new UserProfileEntity(UserRoles.PATIENT, true );
        userProfile.setId(1);

        Mockito.when(this.userCredentialRepository.existsByEmail(this.userCredential.getEmail())).thenReturn(false);
        Mockito.when(this.userPersonalDataRepository.existsByDni(this.userPersonalData.getDni())).thenReturn(false);

        Mockito.when(this.userCredentialRepository.save(this.userCredential)).thenReturn(userCredential);
        Mockito.when(this.userPersonalDataRepository.save(this.userPersonalData)).thenReturn(this.userPersonalData);
        Mockito.when(this.userProfileRepository.save(userProfile)).thenReturn(userProfile);

        //Act
        this.userService.createAccount(this.userCredential, this.userPersonalData, userProfile);

        //Assert
        Assertions.assertNotNull(userProfile.getUserCredentialId());
        Assertions.assertNotNull(userProfile.getUserPersonalDataId());

        Assertions.assertEquals(this.userCredential.getId(), userProfile.getUserCredentialId());
        Assertions.assertEquals(this.userPersonalData.getId(), userProfile.getUserPersonalDataId());
    }
}
