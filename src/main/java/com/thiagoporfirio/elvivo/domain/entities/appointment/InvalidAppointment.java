package com.thiagoporfirio.elvivo.domain.entities.appointment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "invalid_appointments")
@NoArgsConstructor
@Getter
@Setter
public class InvalidAppointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String reason;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
