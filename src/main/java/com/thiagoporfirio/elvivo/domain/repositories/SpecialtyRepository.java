package com.thiagoporfirio.elvivo.domain.repositories;

import com.thiagoporfirio.elvivo.domain.entities.SpecialtyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<SpecialtyEntity, Long>
{
    public boolean existsByName(String name);
}
