package com.thiagoporfirio.elvivo.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors_specialties")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@EqualsAndHashCode
public class DoctorSpecialtyEntity
{
    @EmbeddedId
    private DoctorSpecialtyId id;

    public Long getDoctorId()
    {
        return this.id.getDoctorId();
    }

    public Long getSpecialtyId()
    {
        return this.id.getSpecialtyId();
    }
}
