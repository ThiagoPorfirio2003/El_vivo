package com.thiagoporfirio.elvivo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class DoctorSpecialtyId
{
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Column(name = "specialty_id")
    private Short specialtyId;
}