package com.thiagoporfirio.elvivo.domain.repositories;

import com.thiagoporfirio.elvivo.domain.entities.SpecialtyEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

@DataJpaTest
public class SpecialtyRepositoryTests
{
    @MockitoSpyBean
    private final SpecialtyRepository specialtyRepository;

    private SpecialtyEntity specialtyEntityForTesting;

    @Autowired
    public SpecialtyRepositoryTests(SpecialtyRepository specialtyRepository)
    {
        this.specialtyRepository = specialtyRepository;
    }

    @BeforeEach
    public void setUp()
    {
        this.specialtyEntityForTesting = new SpecialtyEntity("Traumatologia", "traumatologia.312515.jpg", (short)30);

        /*
        Mockito.doAnswer(invocation->
        {
            SpecialtyEntity specialtyEntity = invocation.getArgument(0);

            specialtyEntity.setId((short)5);

            return specialtyEntity;
        }).when(this.specialtyRepository).save(Mockito.any(SpecialtyEntity.class));
        */
    }

    @Test
    public void findByName_nameDoesNotExist_returnsEmptyOptional()
    {
        //Arrange
        var inexistentName = "no_existe";

        //Act
        var isEmptyOptional = this.specialtyRepository.findByName(inexistentName).isEmpty();

        //Assert
        Assertions.assertThat(isEmptyOptional).isTrue();
    }

    @Test
    public void findByName_nameExists_returnsOptionalWithUserCredential()
    {
        //Arrange
        this.specialtyRepository.save(this.specialtyEntityForTesting);

        //Act
        var optionalEntity = this.specialtyRepository.findByName(this.specialtyEntityForTesting.getName());

        //Assert
        Assertions.assertThat(optionalEntity.isPresent()).isTrue();
        var foundEntity = optionalEntity.get();

        Assertions.assertThat(foundEntity.getId()).isNotNull();
        Assertions.assertThat(foundEntity.getName()).isEqualTo(this.specialtyEntityForTesting.getName());
    }

    @Test
    public void existsByName_nameDoesNotExist_returnsFalse()
    {
        boolean specialtyExists = this.specialtyRepository.existsByName("no_existe");

        Assertions.assertThat(specialtyExists).isFalse();
    }

    @Test
    public void existsByName_nameExists_returnsTrue()
    {
        this.specialtyRepository.save(this.specialtyEntityForTesting);

        boolean specialtyExists = this.specialtyRepository.existsByName(specialtyEntityForTesting.getName());

        Assertions.assertThat(specialtyExists).isTrue();
    }

    @Test
    public void existsImgName_imgNameDoesNotExist_returnsFalse()
    {
        boolean specialtyExists = this.specialtyRepository.existsByImgName("no_existe.jpg");

        Assertions.assertThat(specialtyExists).isFalse();
    }

    @Test
    public void existsByImgName_imgNameExists_returnsTrue()
    {
        this.specialtyRepository.save(this.specialtyEntityForTesting);

        boolean specialtyExists = this.specialtyRepository.existsByImgName(specialtyEntityForTesting.getImgName());

        Assertions.assertThat(specialtyExists).isTrue();
    }
}
