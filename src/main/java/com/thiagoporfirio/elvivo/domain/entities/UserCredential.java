package com.thiagoporfirio.elvivo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_credentials")
@NoArgsConstructor
@Getter
@Setter
public class UserCredential
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
