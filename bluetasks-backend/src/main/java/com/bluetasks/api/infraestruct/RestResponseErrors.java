package com.bluetasks.api.infraestruct;

import lombok.Getter;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class RestResponseErrors {

    @Getter
    private String error;

    private RestResponseErrors() {
    }

    public static RestResponseErrors fromValidationErrors(Errors errors) {
        RestResponseErrors responseErrors = new RestResponseErrors();

        StringBuilder stringBuilder = new StringBuilder();

        for (ObjectError error : errors.getAllErrors()) {
            stringBuilder.append(error.getDefaultMessage()).append(". \n");
        }
        responseErrors.error = stringBuilder.toString();

        return responseErrors;
    }
}

