package com.thiagoporfirio.elvivo.domain.services.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserCredentialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserCredentialServiceTests
{
    @Mock
    private UserCredentialRepository userCredentialRepository;

    @InjectMocks
    private UserCredentialService userCredentialService;

    @Test
    public void findByEmail_emailFound_returnsUserCredential()
    {
        var userCredential = new UserCredentialEntity();

        userCredential.setId(1);
        userCredential.setEmail("emailExists@gmail.com");
        userCredential.setPassword("password1234");
        userCredential.setCreatedAt(LocalDateTime.now());

        Mockito.when(userCredentialRepository.findByEmail(userCredential.getEmail()))
                .thenReturn(Optional.of(userCredential));

        var userCredentialFound = this.userCredentialService.findByEmail(userCredential.getEmail());

        Assertions.assertNotNull(userCredentialFound);
        Assertions.assertEquals(userCredential.getEmail(), userCredentialFound.getEmail());
    }

    @Test
    public void findByEmail_emailNotFound_throwsEntityNotFoundException()
    {
        var emailToFind = "doesNotExist@gmail.com";

        Mockito.when(this.userCredentialRepository.findByEmail(emailToFind)).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, ()-> this.userCredentialService.findByEmail(emailToFind));
    }
}
