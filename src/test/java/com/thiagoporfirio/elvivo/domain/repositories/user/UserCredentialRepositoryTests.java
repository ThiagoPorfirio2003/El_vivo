package com.thiagoporfirio.elvivo.domain.repositories.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserCredentialRepositoryTests
{
    private final UserCredentialRepository userCredentialRepository;

    @Autowired
    public UserCredentialRepositoryTests(UserCredentialRepository userCredentialRepository)
    {
        this.userCredentialRepository = userCredentialRepository;
    }

    @Test
    public void findByEmail_emailDoesNotExist_returnsEmptyOptional()
    {
        //Arrange
        var emailToFind = "doesnotexist@gmail.com";

        //Act
        var isEmptyOptional = this.userCredentialRepository.findByEmail(emailToFind).isEmpty();

        //Assert
        Assertions.assertThat(isEmptyOptional).isTrue();
    }

    @Test
    public void findByEmail_emailExists_returnsOptionalWithUserCredential()
    {
        //Arrange
        var entityToCompare = new UserCredentialEntity("test981@testing.com", "abc123zxy987");
        this.userCredentialRepository.save(entityToCompare);

        //Act
        var optionalEntity = this.userCredentialRepository.findByEmail(entityToCompare.getEmail());

        //Assert
        Assertions.assertThat(optionalEntity.isPresent()).isTrue();
        var foundEntity = optionalEntity.get();

        Assertions.assertThat(foundEntity.getId()).isNotNull();
        Assertions.assertThat(foundEntity.getEmail()).isEqualTo(entityToCompare.getEmail());
    }

    @Test
    public void existsByEmail_emailDoesNotExist_returnsFalse()
    {
        var userCredentialExists = this.userCredentialRepository.existsByEmail("doesNotExist@gmail.com");

        Assertions.assertThat(userCredentialExists).isFalse();
    }

    @Test
    public void existsByEmail_emailExists_returnsTrue()
    {
        var entityToCompare = new UserCredentialEntity("test981@testing.com", "abc123zxy987");
        this.userCredentialRepository.save(entityToCompare);

        var userCredentialExists = this.userCredentialRepository.existsByEmail(entityToCompare.getEmail());

        Assertions.assertThat(userCredentialExists).isTrue();
    }
}
