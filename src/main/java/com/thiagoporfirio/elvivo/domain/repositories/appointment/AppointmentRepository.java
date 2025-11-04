package com.thiagoporfirio.elvivo.domain.repositories.appointment;

import com.thiagoporfirio.elvivo.domain.entities.appointment.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Set;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer>
{
    @Query("""
            SELECT COUNT(a)
            FROM AppointmentEntity a
            WHERE a.doctorSpecialtyId.specialtyId = :specialtyId
                AND a.patientId = :patientId
                AND a.date = :date
            """)
    public long countBySpecialtyAndPatientAndDate(
            Short specialtyId,
            Integer patientId,
            LocalDate date);

    public Set<AppointmentEntity> findByPatientIdAndDate(Integer patientId, LocalDate date);
}
