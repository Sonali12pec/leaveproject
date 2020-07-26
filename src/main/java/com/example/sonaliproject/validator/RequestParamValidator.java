package com.example.sonaliproject.validator;


import com.example.sonaliproject.exception.ValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class RequestParamValidator {

    private static final Validator paramValidator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        paramValidator = validatorFactory.getValidator();
    }

    private RequestParamValidator() {
    }

    /**
     * throws ValidationException
     *
     * @param t
     */
    public static void validate(Object t) throws ValidationException {

        Set<ConstraintViolation<Object>> constraintViolations = paramValidator.validate(t);
        if (!constraintViolations.isEmpty()) {
            String errorMessage = constraintViolations.stream().findFirst().get().getPropertyPath() + "_" + constraintViolations.stream().findFirst().get().getMessage();
            throw new ValidationException("FIELD_VALIDATION:" + errorMessage);
        }
    }

}

