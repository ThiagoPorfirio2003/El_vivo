package com.thiagoporfirio.elvivo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "diagnosis")
@NoArgsConstructor
@Getter
@Setter
public class Diagnosis
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "completed_appointment_id")
    private Long completedAppointmentId;

    private String treatment;

    /*
    @Column(name = "weightKG")
    private BigDecimal weight  Kg;

    */
    /*
    private String treatment;

    @Column(name = "icd10_code")
    private String icd10Code;

    private String note;
    */
}
