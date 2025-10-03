package com.thiagoporfirio.elvivo.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnostic_conditions")
public class DiagnosisConditions
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "diagnosis_id")
    private Long diagnosisId;

    @Column(name = "icd10_code")
    private String icd10Code;

    private String note;
}
