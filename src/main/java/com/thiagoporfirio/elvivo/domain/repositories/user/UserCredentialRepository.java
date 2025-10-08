package com.thiagoporfirio.elvivo.domain.repositories.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredentialEntity, Long>
{
    public Optional<UserCredentialEntity> findByEmail(String email);
    public boolean existsByEmail(String email);
}
