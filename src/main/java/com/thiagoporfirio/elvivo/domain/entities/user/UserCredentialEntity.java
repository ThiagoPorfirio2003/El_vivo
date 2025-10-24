package com.thiagoporfirio.elvivo.domain.entities.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_credentials")
@NoArgsConstructor
@Getter
@Setter
public class UserCredentialEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public UserCredentialEntity(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

}
