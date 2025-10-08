package com.thiagoporfirio.elvivo.domain.repositories.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserProfileEntity;
import com.thiagoporfirio.elvivo.utils.enums.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long>
{
    public Optional<UserProfileEntity> findByUserCredentialId(Long userCredentialId);
    public boolean existsByUserCredentialId(Long userCredentialId);

    public Optional<UserProfileEntity> findByUserRoleAndUserPersonalDataId(UserRoles userRole, Long userPersonalDataId);
    public boolean existsByUserRoleAndUserPersonalDataId(UserRoles userRole, Long userPersonalDataId);
}
