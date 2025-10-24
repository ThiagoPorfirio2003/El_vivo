package com.thiagoporfirio.elvivo.domain.repositories.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserCredentialRepositoryTests
{
    private final UserCredentialRepository userCredentialRepository;

    @Autowired
    public UserCredentialRepositoryTests(UserCredentialRepository userCredentialRepository)
    {
        this.userCredentialRepository = userCredentialRepository;
    }

    @Test
    public void UserCredentialRepository_findByEmail_ReturnsNullEntity()
    {

    }

    @Test
    @Transactional
    public void UserCredentialRepository_findByEmail_ReturnsAnExistingEntity()
    {
        //Arrange
        var entityToCompare = new UserCredentialEntity("test981@testing.com", "abc123zxy987");
        this.userCredentialRepository.save(entityToCompare);

        //Act
        var foundEntity = this.userCredentialRepository.findByEmail(entityToCompare.getEmail()).get();

        //Assert
        Assertions.assertThat(foundEntity).isNotNull();
        Assertions.assertThat(foundEntity.getEmail()).isEqualTo(entityToCompare.getEmail());
    }
}
