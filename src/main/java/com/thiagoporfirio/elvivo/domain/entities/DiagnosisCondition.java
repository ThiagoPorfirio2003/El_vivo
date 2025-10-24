package com.thiagoporfirio.elvivo.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnostic_conditions")
public class DiagnosisCondition
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "diagnosis_id")
    private Integer diagnosisId;

    @Column(name = "medical_condition")
    private String medicalCondition;

    private String note;
}
