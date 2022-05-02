package com.ogoma.vue_starter.vue_starter.exceptions;

import com.ogoma.vue_starter.vue_starter.utils.ErrorConverter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class AppControllerAdvice extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        BindingResult result = ex.getBindingResult();
        Map<String, ArrayList<String>> errors = ErrorConverter.convert(result);
        return new ResponseEntity(errors, headers, status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Map<String, String>> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        List<Map<String, String>> errors = new ArrayList();
        ex.getConstraintViolations().forEach(v -> {
            Map<String, String> error = new HashMap<>();
            error.put(v.getPropertyPath().toString(), v.getMessage());
            errors.add(error);

        });
        return errors;
    }
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       //TODO add handling non ajax requests by calling super when request is not ajax, currently handles ajax only handle both ajax requests and not ajax requests,
        Map<String, ArrayList<String>> stringStringMap = ErrorConverter.convert(ex.getBindingResult());
        return new ResponseEntity(stringStringMap, headers, status);
    }

}
