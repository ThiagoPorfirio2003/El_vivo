package com.thiagoporfirio.elvivo.deprecated.models.user;

import java.time.LocalDate;

public interface IUserPersonalData
{
    public Integer getId();
    public String getName();
    public String getSurname();
    public LocalDate getBirthDate();
    public String getDni();
    public String getImgName();

}
