package com.thiagoporfirio.elvivo.deprecated.models.appointment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
@Entity
@Table(name = "walk_in_appointments")
@NoArgsConstructor
@Getter
@Setter
*/
public class WalkInAppointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "position_in_queue")
    private byte positionInQueue;
}
