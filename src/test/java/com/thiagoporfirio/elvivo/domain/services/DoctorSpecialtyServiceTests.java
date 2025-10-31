package com.thiagoporfirio.elvivo.domain.services;

import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyEntity;
import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyId;
import com.thiagoporfirio.elvivo.domain.exceptions.DuplicateEntityException;
import com.thiagoporfirio.elvivo.domain.repositories.DoctorSpecialtyRepository;
import com.thiagoporfirio.elvivo.domain.repositories.SpecialtyRepository;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserProfileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DoctorSpecialtyServiceTests
{
    @Mock
    private DoctorSpecialtyRepository doctorSpecialtyRepository;
    @Mock
    private UserProfileRepository userProfileRepository;
    @Mock
    private SpecialtyRepository specialtyRepository;

    @InjectMocks
    private DoctorSpecialtyService doctorSpecialtyService;

    private DoctorSpecialtyEntity doctorSpecialtyEntity;

    @BeforeEach
    public void setUp()
    {
        this.doctorSpecialtyEntity = new DoctorSpecialtyEntity();
        this.doctorSpecialtyEntity.setDoctorSpecialtyId(new DoctorSpecialtyId(2,(short)2));
    }

    @Test
    public void save_invalidDoctorId_throwsDuplicateEntityException()
    {
        Mockito.when(this.userProfileRepository.existsById(this.doctorSpecialtyEntity.getDoctorId())).thenReturn(true);

        Assertions.assertThrows(DuplicateEntityException.class, ()-> this.doctorSpecialtyService.save(this.doctorSpecialtyEntity));
    }

    @Test
    public void save_invalidSpecialtyId_throwsDuplicateEntityException()
    {
        Mockito.when(this.specialtyRepository.existsById(this.doctorSpecialtyEntity.getSpecialtyId())).thenReturn(true);

        Assertions.assertThrows(DuplicateEntityException.class, ()-> this.doctorSpecialtyService.save(this.doctorSpecialtyEntity));
    }

    @Test
    public void save_invalidSpecialtyId_doesNotThrowAnyException()
    {
        Mockito.when(this.userProfileRepository.existsById(this.doctorSpecialtyEntity.getDoctorId())).thenReturn(false);
        Mockito.when(this.specialtyRepository.existsById(this.doctorSpecialtyEntity.getSpecialtyId())).thenReturn(false);
        Mockito.when(this.doctorSpecialtyRepository.save(this.doctorSpecialtyEntity)).thenReturn(this.doctorSpecialtyEntity);

        Assertions.assertDoesNotThrow(()-> this.doctorSpecialtyService.save(this.doctorSpecialtyEntity));
    }
}
