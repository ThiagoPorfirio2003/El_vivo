package com.thiagoporfirio.elvivo.domain.repositories.appointment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
public class AppointmentRepositoryTests
{
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentRepositoryTests(AppointmentRepository appointmentRepository)
    {
        this.appointmentRepository = appointmentRepository;
    }

    @Test
    public void countBySpecialtyAndPatientAndDate_whenDoesNotExist_returns0()
    {
        long result = this.appointmentRepository.countBySpecialtyAndPatientAndDate((short)1,11, LocalDate.parse("2025-11-03"));

        Assertions.assertEquals(0, result);
    }

    @Test
    public void countBySpecialtyAndPatientAndDate_whenExists_returns1()
    {
        long result = this.appointmentRepository.countBySpecialtyAndPatientAndDate((short)1,7, LocalDate.parse("2025-11-03"));

        Assertions.assertEquals(1, result);
    }

    @Test
    public void findByPatientIdAndDate_noMatches_returnsEmptySet()
    {
        var appointments = this.appointmentRepository.findByPatientIdAndDate(7, LocalDate.now());

        Assertions.assertTrue(appointments.isEmpty());
    }

    @Test
    public void findByPatientIdAndDate_oneMatch_returnsSetWithOneElement()
    {
        var appointments = this.appointmentRepository.findByPatientIdAndDate(8, LocalDate.parse("2025-11-03"));

        Assertions.assertEquals(1, appointments.size());
    }

    @Test
    public void findByPatientIdAndDate_multipleMatches_returnsSetWithMultipleElements()
    {
        var appointments = this.appointmentRepository.findByPatientIdAndDate(7, LocalDate.parse("2025-11-03"));

        Assertions.assertTrue(appointments.size() > 1);
    }
}
