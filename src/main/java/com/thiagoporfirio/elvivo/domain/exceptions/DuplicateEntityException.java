package com.thiagoporfirio.elvivo.domain.exceptions;

public class DuplicateEntityException extends RuntimeException
{
    public DuplicateEntityException(String entityName, String attributeName, String attributeValue)
    {
        super(String.format("An %s already exists with %s=%s", entityName, attributeName, attributeValue));
    }
}
