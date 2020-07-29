package com.sakinramazan.todoassistant.todoservice.annotation.validator;

import com.sakinramazan.todoassistant.todoservice.annotation.CustomDateConstraint;
import com.sakinramazan.todoassistant.todoservice.exception.InvalidFieldException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CustomDateValidator implements
        ConstraintValidator<CustomDateConstraint, LocalDate> {

    private static final String DATE_PATTERN = "MM/dd/yyyy";

    @Override
    public void initialize(CustomDateConstraint customDate) {
    }

    @Override
    public boolean isValid(LocalDate customDateField,
                           ConstraintValidatorContext cxt) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        try {
            sdf.setLenient(false);
            Date d = sdf.parse(String.valueOf(customDateField));
            return true;
        } catch (ParseException e) {
            throw new InvalidFieldException("Date format is invalid : " + customDateField.toString());
        }
    }

}
