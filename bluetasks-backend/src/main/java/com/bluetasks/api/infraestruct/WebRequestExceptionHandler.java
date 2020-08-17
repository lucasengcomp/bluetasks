package com.bluetasks.api.infraestruct;

import com.bluetasks.api.domain.task.DuplicateTaskException;
import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebRequestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RestResponseErrors handleException(RepositoryConstraintViolationException exception) {
        return RestResponseErrors.fromValidationErrors(exception.getErrors());
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RestResponseErrors handleException(DuplicateTaskException exception) {
        return RestResponseErrors.fromMessage(exception.getMessage());
    }
}
