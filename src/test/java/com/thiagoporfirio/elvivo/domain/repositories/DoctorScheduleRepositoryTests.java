package com.thiagoporfirio.elvivo.domain.repositories;

import com.thiagoporfirio.elvivo.domain.entities.DoctorScheduleEntity;
import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyEntity;
import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DoctorScheduleRepositoryTests
{
    private DoctorScheduleRepository doctorScheduleRepository;

    @Autowired
    public DoctorScheduleRepositoryTests(DoctorScheduleRepository doctorScheduleRepository)
    {
        this.doctorScheduleRepository = doctorScheduleRepository;
    }

    @Test
    public void findAllByDoctorSpecialtyId_DoctorId_doctorHasNoRecords_returnsEmptySet()
    {
        Integer doctorId = 6;

        Set<DoctorScheduleEntity> doctorScheduleEntities = this.doctorScheduleRepository.findAllByDoctorSpecialtyId_DoctorId(doctorId);

        Assertions.assertTrue(doctorScheduleEntities.isEmpty());
    }

    @Test
    public void findAllByDoctorSpecialtyId_DoctorId_doctorHasMultipleRecords_returnsSetWithAllOfThem()
    {
        Integer doctorId = 4;

        Set<DoctorScheduleEntity> doctorScheduleEntities = this.doctorScheduleRepository.findAllByDoctorSpecialtyId_DoctorId(doctorId);

        Assertions.assertTrue(doctorScheduleEntities.size() > 1);
        assertThat(doctorScheduleEntities).allMatch(doctorScheduleEntity -> {

            return doctorScheduleEntity.getDoctorId().intValue() == doctorId.intValue();
        });
    }

    @Test
    public void findAllByDoctorSpecialtyId_SpecialtyId_specialtyHasNoRecords_returnsEmptySet()
    {
        Short specialtyId = 4;

        Set<DoctorScheduleEntity> doctorScheduleEntities = this.doctorScheduleRepository.findAllByDoctorSpecialtyId_SpecialtyId(specialtyId);

        Assertions.assertTrue(doctorScheduleEntities.isEmpty());
    }

    @Test
    public void findAllByDoctorSpecialtyId_SpecialtyId_specialtyHasMultipleRecords_returnsSetWithAllOfThem()
    {
        Short specialtyId = 1;

        Set<DoctorScheduleEntity> doctorScheduleEntities = this.doctorScheduleRepository.findAllByDoctorSpecialtyId_SpecialtyId(specialtyId);

        Assertions.assertTrue(doctorScheduleEntities.size() > 1);
        assertThat(doctorScheduleEntities).allMatch(doctorScheduleEntity -> {

            return doctorScheduleEntity.getSpecialtyId().shortValue() == specialtyId.shortValue();
        });
    }

    //    public Set<T> findAllByDoctorSpecialtyId(DoctorSpecialtyId doctorSpecialtyId);

    @Test
    public void findAllByDoctorSpecialtyId_doctorSpecialtyIdHasNoRecords_returnsEmptySet()
    {
        var doctorSpecialtyId = new DoctorSpecialtyId(6,(short)4);

        var doctorScheduleEntities = this.doctorScheduleRepository.findAllByDoctorSpecialtyId(doctorSpecialtyId);

        Assertions.assertTrue(doctorScheduleEntities.isEmpty());
    }

    @Test
    public void findAllByDoctorSpecialtyId_doctorSpecialtyIdHasMultipleRecords_returnsSetWithAllOfThem()
    {
        var doctorSpecialtyId = new DoctorSpecialtyId(4,(short)2);

        var doctorScheduleEntities = this.doctorScheduleRepository.findAllByDoctorSpecialtyId(doctorSpecialtyId);

        Assertions.assertTrue(doctorScheduleEntities.size() > 1);
        assertThat(doctorScheduleEntities).allMatch(doctorScheduleEntity -> {

            return doctorScheduleEntity.getDoctorId().intValue() == doctorSpecialtyId.getDoctorId().intValue() &&
                    doctorScheduleEntity.getSpecialtyId().intValue() == doctorSpecialtyId.getSpecialtyId().intValue();
        });
    }
}
