package com.thiagoporfirio.elvivo.domain.repositories.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserPersonalDataEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
public class UserPersonalDataRepositoryTests
{
    private final UserPersonalDataRepository userPersonalDataRepository;

    @Autowired
    public UserPersonalDataRepositoryTests(UserPersonalDataRepository userPersonalDataRepository)
    {
        this.userPersonalDataRepository = userPersonalDataRepository;
    }

    @Test
    public void existsByDni_dniExists_returnsTrue()
    {
        String dniToFind = "49539113";

        this.userPersonalDataRepository.save(
                new UserPersonalDataEntity(
                        "Juan Manuel",
                        "Belgrano",
                        LocalDate.of(1999, 3, 14),
                        dniToFind,
                        "juan.23123.jpg"));

        var userPersonalDataExists = this.userPersonalDataRepository.existsByDni(dniToFind);

        Assertions.assertTrue(userPersonalDataExists);
    }

    @Test
    public void existsByDni_dniDoesNotExist_returnsFalse()
    {
        String dniToFind = "49539113";

        var userPersonalDataExists = this.userPersonalDataRepository.existsByDni(dniToFind);

        Assertions.assertFalse(userPersonalDataExists);
    }
}
