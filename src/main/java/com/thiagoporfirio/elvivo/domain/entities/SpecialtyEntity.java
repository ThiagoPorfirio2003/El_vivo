package com.thiagoporfirio.elvivo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "specialties")
@NoArgsConstructor
@Setter
@Getter
public class SpecialtyEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String name;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "avg_appointment_minutes")
    private Short avgAppointmentMinutes;

    public SpecialtyEntity(String name, String imgName, Short avgAppointmentMinutes)
    {
        this.name = name;
        this.imgName = imgName;
        this.avgAppointmentMinutes = avgAppointmentMinutes;
    }
}
