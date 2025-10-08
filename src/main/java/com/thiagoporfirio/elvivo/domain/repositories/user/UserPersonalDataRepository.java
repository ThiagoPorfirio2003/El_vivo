package com.thiagoporfirio.elvivo.domain.repositories.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserPersonalDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersonalDataRepository extends JpaRepository<UserPersonalDataEntity, Long>
{
    public boolean existsByDni(String dni);
}
