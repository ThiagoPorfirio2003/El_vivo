package com.thiagoporfirio.elvivo.domain.services;

import com.thiagoporfirio.elvivo.domain.entities.DoctorScheduleEntity;
import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyEntity;
import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyId;
import com.thiagoporfirio.elvivo.domain.enums.WeekDays;
import com.thiagoporfirio.elvivo.domain.exceptions.DuplicateEntityException;
import com.thiagoporfirio.elvivo.domain.repositories.DoctorScheduleRepository;
import com.thiagoporfirio.elvivo.domain.repositories.DoctorSpecialtyRepository;
import com.thiagoporfirio.elvivo.domain.repositories.WorkPeriodRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DoctorScheduleServiceTests 
{
    @Mock
    private DoctorScheduleRepository doctorScheduleRepository;
    @Mock
    private DoctorSpecialtyRepository doctorSpecialtyRepository;
    @Mock
    private WorkPeriodRepository workPeriodRepository;
    
    @InjectMocks
    private DoctorScheduleService doctorScheduleService;

    private DoctorScheduleEntity doctorScheduleEntity;

    /*
        @Column(name = "work_period_id")
    private Byte workPeriodId ;
    @Column(name = "week_day")
    @Enumerated(EnumType.STRING)
    private WeekDays weekDay;

    @Embedded
    @Getter(AccessLevel.NONE)
    private DoctorSpecialtyId doctorSpecialtyId;
     */

    @BeforeEach
    public void setUp()
    {
        this.doctorScheduleEntity = new DoctorScheduleEntity();
        this.doctorScheduleEntity.setWorkPeriodId((byte)2);
        this.doctorScheduleEntity.setWeekDay(WeekDays.MONDAY);
        this.doctorScheduleEntity.setDoctorSpecialtyId(new DoctorSpecialtyId(4, (short)2));
    }

    @Test
    public void save_invalidDoctorSpecialtyId_ThrowsEntityNotFoundException()
    {
        Mockito.when(this.doctorSpecialtyRepository.existsById(new DoctorSpecialtyId(this.doctorScheduleEntity.getDoctorId(),
                this.doctorScheduleEntity.getSpecialtyId()))).thenReturn(false);

        Assertions.assertThrows(EntityNotFoundException.class, ()-> this.doctorScheduleService.save(doctorScheduleEntity));
    }

    @Test
    public void save_invalidWorkPeriodId_ThrowsEntityNotFoundException()
    {
        Mockito.when(this.doctorSpecialtyRepository.existsById(new DoctorSpecialtyId(this.doctorScheduleEntity.getDoctorId(),
                this.doctorScheduleEntity.getSpecialtyId()))).thenReturn(true);

        Mockito.when(this.workPeriodRepository.existsById(this.doctorScheduleEntity.getWorkPeriodId())).thenReturn(false);

        Assertions.assertThrows(EntityNotFoundException.class, ()-> this.doctorScheduleService.save(doctorScheduleEntity));
    }

    @Test
    public void save_duplicateDataCombination_ThrowsDuplicateEntityException()
    {
        Mockito.when(this.doctorSpecialtyRepository.existsById(new DoctorSpecialtyId(this.doctorScheduleEntity.getDoctorId(),
                this.doctorScheduleEntity.getSpecialtyId()))).thenReturn(true);

        Mockito.when(this.workPeriodRepository.existsById(this.doctorScheduleEntity.getWorkPeriodId())).thenReturn(true);

        Mockito.when(this.doctorScheduleRepository.existsByPeriodAndDayAndDoctor(
                this.doctorScheduleEntity.getWorkPeriodId(),
                this.doctorScheduleEntity.getWeekDay(),
                this.doctorScheduleEntity.getDoctorId())
        ).thenReturn(true);

        Assertions.assertThrows(DuplicateEntityException.class, ()-> this.doctorScheduleService.save(doctorScheduleEntity));
    }

    @Test
    public void save_validData_doesNotThrowsAnyException()
    {
        Mockito.when(this.doctorSpecialtyRepository.existsById(new DoctorSpecialtyId(this.doctorScheduleEntity.getDoctorId(),
                this.doctorScheduleEntity.getSpecialtyId()))).thenReturn(true);

        Mockito.when(this.workPeriodRepository.existsById(this.doctorScheduleEntity.getWorkPeriodId())).thenReturn(true);

        Mockito.when(this.doctorScheduleRepository.existsByPeriodAndDayAndDoctor(
                this.doctorScheduleEntity.getWorkPeriodId(),
                this.doctorScheduleEntity.getWeekDay(),
                this.doctorScheduleEntity.getDoctorId())
        ).thenReturn(false);

        Mockito.when(this.doctorScheduleRepository.save(this.doctorScheduleEntity))
                .thenAnswer(answer->{
                   DoctorScheduleEntity doctorSchedule = answer.getArgument(0);
                   doctorSchedule.setId(2);

                   return doctorSchedule;
                });

        Assertions.assertDoesNotThrow(()-> this.doctorScheduleService.save(this.doctorScheduleEntity));
        Assertions.assertEquals(2, this.doctorScheduleEntity.getId().intValue());
    }
}
