package com.thiagoporfirio.elvivo.domain.repositories.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserProfileEntity;
import com.thiagoporfirio.elvivo.domain.enums.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Integer>
{
    @Query("SELECT u.userRole FROM UserProfileEntity u WHERE u.id = :id")
    public Optional<UserRoles> findUserRoleById(Integer id);

    //public Optional<UserProfileEntity> findByUserCredentialId(Integer userCredentialId);
    //public boolean existsByUserCredentialId(Integer userCredentialId);

    //public Optional<UserProfileEntity> findByUserRoleAndUserPersonalDataId(UserRoles userRole, Integer userPersonalDataId);
    //public boolean existsByUserRoleAndUserPersonalDataId(UserRoles userRole, Integer userPersonalDataId);
}
