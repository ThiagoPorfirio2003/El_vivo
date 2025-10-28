package com.thiagoporfirio.elvivo.domain.entities.user;

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
public class UserPersonalDataEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String dni;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public UserPersonalDataEntity(String name, String surname, LocalDate birthDate, String dni, String imgName)
    {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.dni = dni;
        this.imgName =imgName;
    }
}
