package com.practice.exercise.infrastructure.configuration.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class Error {

    private HttpStatus status;
    private List<String> errors;

    public Error() {
    }

    public Error(HttpStatus status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
