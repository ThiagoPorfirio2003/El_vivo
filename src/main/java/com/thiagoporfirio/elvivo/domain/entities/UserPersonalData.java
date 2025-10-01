package com.thiagoporfirio.elvivo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_personal_data")
@NoArgsConstructor
@Setter
@Getter
public class UserPersonalData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private LocalDate birthDate;

    private String dni;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
