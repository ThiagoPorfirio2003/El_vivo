package com.thiagoporfirio.elvivo.domain.repositories.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserPersonalDataEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserProfileEntity;
import com.thiagoporfirio.elvivo.domain.enums.UserRoles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

@DataJpaTest
public class UserProfileRepositoryTests
{
    private final UserProfileRepository userProfileRepository;
    private final UserCredentialRepository userCredentialRepository;
    private final UserPersonalDataRepository userPersonalDataRepository;
    private UserProfileEntity userProfileForTesting;

    @Autowired
    public UserProfileRepositoryTests(UserProfileRepository userProfileRepository,
                                      UserPersonalDataRepository userPersonalDataRepository,
                                      UserCredentialRepository userCredentialRepository)
    {
        this.userProfileRepository = userProfileRepository;
        this.userCredentialRepository = userCredentialRepository;
        this.userPersonalDataRepository = userPersonalDataRepository;
    }

    @BeforeEach
    public void setUp()
    {
        var userCredential = this.userCredentialRepository.save(new UserCredentialEntity("exist@gmail.com", "1234pass425"));
        var userPersonalData = this.userPersonalDataRepository.save(new UserPersonalDataEntity(
                "Juan", "Gonzales", LocalDate.now(), "54810092", "juan.43562.jpg"
        ));

        this.userProfileForTesting = new UserProfileEntity(
                UserRoles.PATIENT,
                true,
                userCredential.getId(),
                userPersonalData.getId()
        );
        this.userProfileRepository.save(this.userProfileForTesting);
    }

    @Test
    public void findUserRoleById_idDoesNotExist_returnsEmptyOptional()
    {
        Optional<UserRoles> role = this.userProfileRepository.findUserRoleById(this.userProfileForTesting.getId()+1);

        Assertions.assertTrue(role.isEmpty());
    }

    @Test
    public void findUserRoleById_idExists_returnsOptionalWithRole()
    {
        Optional<UserRoles> role = this.userProfileRepository.findUserRoleById(this.userProfileForTesting.getId());

        Assertions.assertTrue(role.isPresent());
        Assertions.assertEquals(this.userProfileForTesting.getUserRole(), role.get());
    }
}
