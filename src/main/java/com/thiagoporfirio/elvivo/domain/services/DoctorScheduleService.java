package com.thiagoporfirio.elvivo.domain.services;

import com.thiagoporfirio.elvivo.domain.entities.DoctorScheduleEntity;
import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyEntity;
import com.thiagoporfirio.elvivo.domain.entities.DoctorSpecialtyId;
import com.thiagoporfirio.elvivo.domain.entities.WorkPeriodEntity;
import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
import com.thiagoporfirio.elvivo.domain.exceptions.DuplicateEntityException;
import com.thiagoporfirio.elvivo.domain.repositories.DoctorScheduleRepository;
import com.thiagoporfirio.elvivo.domain.repositories.DoctorSpecialtyRepository;
import com.thiagoporfirio.elvivo.domain.repositories.WorkPeriodRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorScheduleService
{
    private final DoctorScheduleRepository doctorScheduleRepository;
    private final DoctorSpecialtyRepository doctorSpecialtyRepository;
    private final WorkPeriodRepository workPeriodRepository;

    public void save(DoctorScheduleEntity doctorScheduleEntity)
    {
        if(!this.doctorSpecialtyRepository.existsById(new DoctorSpecialtyId(
                doctorScheduleEntity.getDoctorId(), doctorScheduleEntity.getSpecialtyId())))
        {
            throw new EntityNotFoundException(String.format(
                    "Not found an %s with id=%s",
                    doctorScheduleEntity.getClass().getSimpleName(),
                    String.format("(%s, %s)", doctorScheduleEntity.getDoctorId().toString(), doctorScheduleEntity.getSpecialtyId().toString())));
        }

        if(!this.workPeriodRepository.existsById(doctorScheduleEntity.getWorkPeriodId()))
        {
            throw new EntityNotFoundException(String.format(
                "Not found an %s with work_period_id=%s",
                    doctorScheduleEntity.getClass().getSimpleName(),
                    doctorScheduleEntity.getWorkPeriodId()));
        }

        if(this.doctorScheduleRepository.countByPeriodAndDayAndDoctor(
                doctorScheduleEntity.getWorkPeriodId(),
                doctorScheduleEntity.getWeekDay(),
                doctorScheduleEntity.getDoctorId()) > 0)
        {
            throw new DuplicateEntityException(
                    doctorScheduleEntity.getClass().getSimpleName(),
                    "(work_period_id, week_day, doctor_id)",
                    String.format("(%s, %s, %s)",
                            doctorScheduleEntity.getWorkPeriodId().toString(),
                            doctorScheduleEntity.getWeekDay().name(),
                            doctorScheduleEntity.getDoctorId().toString())
            );
        }

        this.doctorScheduleRepository.save(doctorScheduleEntity);
    }
}
