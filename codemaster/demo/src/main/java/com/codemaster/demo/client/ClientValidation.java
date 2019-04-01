package com.codemaster.demo.client;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.validator.routines.EmailValidator;

@Component
public class ClientValidation  implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ClientValidation.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Client clientValidation = (Client) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty");

    }
}
