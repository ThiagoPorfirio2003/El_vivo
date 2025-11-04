package com.thiagoporfirio.elvivo.domain.repositories;

import com.thiagoporfirio.elvivo.domain.entities.DoctorScheduleEntity;
import com.thiagoporfirio.elvivo.domain.enums.WeekDays;
import com.thiagoporfirio.elvivo.domain.enums.WorkPeriods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorScheduleRepository extends JpaRepository<DoctorScheduleEntity, Integer>, IDoctorSpecialtyIdExtended<DoctorScheduleEntity>
{

    @Query("""
    SELECT COUNT(d)
    FROM DoctorScheduleEntity d
    WHERE d.workPeriodId = :period_id
      AND d.weekDay = :day
      AND d.doctorSpecialtyId.doctorId = :doctorId
    """)
    public long countByPeriodAndDayAndDoctor(
            @Param("period_id") Byte workPeriodId,
            @Param("day") WeekDays weekDay,
            @Param("doctor_id") Integer doctorId);

    /*
      @Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
            User findByLastnameOrFirstname(@Param("lastname") String lastname,
                                 @Param("firstname") String firstname);
     */
}
