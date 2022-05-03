package com.ogoma.vue_starter.vue_starter.utils;

import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ErrorConverter {
    public static Map<String, ArrayList<String>> convert(Errors errors){
        Map<String, ArrayList<String>> apiErrors = new HashMap<>();
        ArrayList<String> globalErrorList = new ArrayList<>();
        errors.getFieldErrors().forEach(fieldError->{
            String field=fieldError.getField();
            String errorMessage=fieldError.getDefaultMessage();
            if(apiErrors.containsKey(field)){
                ArrayList<String> fieldErrors= apiErrors.get(field);
                fieldErrors.add(errorMessage);
                apiErrors.put(field,fieldErrors);
            }
            else {
                ArrayList<String> errorList = new ArrayList<>();
                errorList.add(errorMessage);
                apiErrors.put(field,errorList);
            }
        });
        errors.getGlobalErrors().forEach(globalError->{
            globalErrorList.add(globalError.getDefaultMessage());
            apiErrors.put("globalError",globalErrorList);
        });
        return apiErrors;
    }

}
