package com.thiagoporfirio.elvivo.domain.entities;

import com.thiagoporfirio.elvivo.domain.enums.WorkPeriods;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "work_periods")
@NoArgsConstructor
@Getter
@Setter
public class WorkPeriodEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    @Enumerated(EnumType.STRING)
    private WorkPeriods name;

    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;
}
