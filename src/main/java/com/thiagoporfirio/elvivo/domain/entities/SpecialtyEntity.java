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
    private Long id;

    private String name;
    @Column(name = "img_name")
    private String imgName;
}
