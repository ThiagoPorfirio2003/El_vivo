package com.thiagoporfirio.elvivo.domain.repositories;

import com.thiagoporfirio.elvivo.domain.entities.SpecialtyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialtyRepository extends JpaRepository<SpecialtyEntity, Long>
{
    public Optional<SpecialtyEntity> findByName(String name);
    public boolean existsByName(String name);
    public boolean existsByImgName(String imgName);
}
