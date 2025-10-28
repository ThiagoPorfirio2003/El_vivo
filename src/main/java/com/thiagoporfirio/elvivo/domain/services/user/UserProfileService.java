package com.thiagoporfirio.elvivo.domain.services.user;

import com.thiagoporfirio.elvivo.domain.entities.user.UserProfileEntity;
import com.thiagoporfirio.elvivo.domain.repositories.user.UserProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserProfileService
{
    private UserProfileRepository userProfileRepository;
}
