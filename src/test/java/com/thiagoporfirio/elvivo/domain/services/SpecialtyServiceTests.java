package com.thiagoporfirio.elvivo.domain.services;

import com.thiagoporfirio.elvivo.domain.entities.SpecialtyEntity;
import com.thiagoporfirio.elvivo.domain.exceptions.DuplicateEntityException;
import com.thiagoporfirio.elvivo.domain.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpecialtyServiceTests
{
    @Mock
    private SpecialtyRepository specialtyRepository;

    @InjectMocks
    private SpecialtyService specialtyService;

    /*
    @BeforeEach
    public void setUp()
    {
        Mockito.doAnswer(answer ->
        {
            SpecialtyEntity specialtyEntity = answer.getArgument(0);

            specialtyEntity.setId((short)5);

            return specialtyEntity;
        }).when(this.specialtyRepository).save(Mockito.any(SpecialtyEntity.class));
    }
    */

    @Test
    public void createSpecialty_nameAlreadyExists_throwsDuplicateEntityException()
    {
        var specialtyToSave = new SpecialtyEntity("Traumatologo", "traumatologo.14214.jpg", (short)30);

        Mockito.when(this.specialtyRepository.existsByName(specialtyToSave.getName())).thenReturn(true);

        Assertions.assertThrows(DuplicateEntityException.class, ()->
            this.specialtyService.createSpecialty(specialtyToSave));
    }

    @Test
    public void createSpecialty_imgNameAlreadyExists_throwsDuplicateEntityException()
    {
        var specialtyToSave = new SpecialtyEntity("Traumatologo", "traumatologo.14214.jpg", (short)30);

        Mockito.when(this.specialtyRepository.existsByImgName(specialtyToSave.getImgName())).thenReturn(true);

        Assertions.assertThrows(DuplicateEntityException.class, ()->
                this.specialtyService.createSpecialty(specialtyToSave));
    }

    @Test
    public void createSpecialty_validData_saveSpecialtyEntitySuccessfully()
    {
        var specialtyToSave = new SpecialtyEntity("Traumatologo", "traumatologo.14214.jpg", (short)30);

        Mockito.when(this.specialtyRepository.existsByName(specialtyToSave.getName())).thenReturn(false);
        Mockito.when(this.specialtyRepository.existsByImgName(specialtyToSave.getImgName())).thenReturn(false);

        Mockito.doAnswer(answer ->
        {
            SpecialtyEntity specialtyEntity = answer.getArgument(0);

            specialtyEntity.setId((short)5);

            return specialtyEntity;
        }).when(this.specialtyRepository).save(Mockito.any(SpecialtyEntity.class));

        this.specialtyService.createSpecialty(specialtyToSave);

        Assertions.assertNotNull(specialtyToSave.getId());
        Assertions.assertEquals((short) 5,specialtyToSave.getId());

    }
}
