package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Object filedValue;

    public ResourceNotFoundException(String resourceName,String fieldName,Object filedValue){

        super(String.format("%s not found with %s : '%s' ",resourceName,fieldName,filedValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.filedValue = filedValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFiledValue() {
        return filedValue;
    }
}
