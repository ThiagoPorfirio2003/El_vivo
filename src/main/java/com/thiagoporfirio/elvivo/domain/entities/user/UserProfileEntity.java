package com.thiagoporfirio.elvivo.domain.entities.user;

import com.thiagoporfirio.elvivo.domain.enums.UserRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_profiles")
@NoArgsConstructor
@Setter
@Getter
public class UserProfileEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private UserRoles userRole;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "user_credential_id")
    private Integer userCredentialId;

    @Column(name = "user_personal_data_id")
    private Integer userPersonalDataId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
