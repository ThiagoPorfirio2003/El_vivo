package com.thiagoporfirio.elvivo.domain.repositories;

import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyEntity;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

@DataJpaTest
public class DoctorSpecialtyRepositoryTests
{
    private DoctorSpecialtyRepository doctorSpecialtyRepository;
    //private SpecialtyRepository specialtyRepository;

    @Autowired
    public DoctorSpecialtyRepositoryTests(DoctorSpecialtyRepository doctorSpecialtyRepository)
                                          //SpecialtyRepository specialtyRepository)
    {
        this.doctorSpecialtyRepository = doctorSpecialtyRepository;
        //this.specialtyRepository = specialtyRepository;
    }

    @Test
    public void findAllByDoctorSpecialtyId_DoctorId_doctorHasNoRecords_returnsEmptySet()
    {
        Integer doctorId = 6;

        Set<DoctorSpecialtyEntity> doctorSpecialtyEntities = this.doctorSpecialtyRepository.findAllByDoctorSpecialtyId_DoctorId(doctorId);

        Assertions.assertTrue(doctorSpecialtyEntities.isEmpty());
    }

    @Test
    public void findAllByDoctorSpecialtyId_DoctorId_doctorHasOneRecord_returnsSetWithIt()
    {
        Integer doctorId = 3;

        Set<DoctorSpecialtyEntity> doctorSpecialtyEntities = this.doctorSpecialtyRepository.findAllByDoctorSpecialtyId_DoctorId(doctorId);

        Assertions.assertEquals(1, doctorSpecialtyEntities.size());
        Assertions.assertEquals(doctorId.intValue(), doctorSpecialtyEntities.stream().findFirst().get().getDoctorId().intValue());
    }

    @Test
    public void findAllByDoctorSpecialtyId_DoctorId_doctorHasMultipleRecords_returnsSetWithAllOfThem()
    {
        Integer doctorId = 4;

        Set<DoctorSpecialtyEntity> doctorSpecialtyEntities = this.doctorSpecialtyRepository.findAllByDoctorSpecialtyId_DoctorId(doctorId);

        Assertions.assertTrue(doctorSpecialtyEntities.size() > 1);
        assertThat(doctorSpecialtyEntities).allMatch(doctorSpecialtyEntity -> {

            return doctorSpecialtyEntity.getDoctorId().intValue() == doctorId.intValue();
        });
    }

    @Test
    public void findAllByDoctorSpecialtyId_SpecialtyId_specialtyHasNoRecords_returnsEmptySet()
    {
        Short specialtyId = 4;

        Set<DoctorSpecialtyEntity> doctorSpecialtyEntities = this.doctorSpecialtyRepository.findAllByDoctorSpecialtyId_SpecialtyId(specialtyId);

        Assertions.assertTrue(doctorSpecialtyEntities.isEmpty());
    }

    @Test
    public void findAllByDoctorSpecialtyId_SpecialtyId_specialtyHasOneRecord_returnsSetWithAllOfThem()
    {
        Short specialtyId = 2;

        Set<DoctorSpecialtyEntity> doctorSpecialtyEntities = this.doctorSpecialtyRepository.findAllByDoctorSpecialtyId_SpecialtyId(specialtyId);

        Assertions.assertEquals(1, doctorSpecialtyEntities.size());
        Assertions.assertEquals(specialtyId.shortValue(), doctorSpecialtyEntities.stream().findFirst().get().getSpecialtyId().shortValue());
    }

    @Test
    public void findAllByDoctorSpecialtyId_SpecialtyId_specialtyHasMultipleRecords_returnsSetWithIt()
    {
        Short specialtyId = 1;

        Set<DoctorSpecialtyEntity> doctorSpecialtyEntities = this.doctorSpecialtyRepository.findAllByDoctorSpecialtyId_SpecialtyId(specialtyId);

        Assertions.assertTrue(doctorSpecialtyEntities.size() > 1);
        assertThat(doctorSpecialtyEntities).allMatch(doctorSpecialtyEntity -> {

            return doctorSpecialtyEntity.getSpecialtyId().shortValue() == specialtyId.shortValue();
        });
    }


}
