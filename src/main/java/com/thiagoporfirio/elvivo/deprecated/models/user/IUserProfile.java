package com.thiagoporfirio.elvivo.deprecated.models.user;

import com.thiagoporfirio.elvivo.domain.enums.UserRoles;

public interface IUserProfile
{
    public Integer getId();
    public UserRoles getUserRole();
    public boolean getIsEnabled();
    public Long getUserCredentialId();
    public Long getUserPersonalDataId();
}
