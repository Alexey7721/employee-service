package com.employee.service.anotations.impl;

import com.employee.service.anotations.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValid implements ConstraintValidator<PhoneNumber, String> {
   private String phoneNubberPattern;

   public void initialize(PhoneNumber constraint) {
      this.phoneNubberPattern = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
   }

   public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
      Pattern pattern = Pattern.compile(phoneNubberPattern);
      Matcher matcher = pattern.matcher(phoneNumber);
      return matcher.matches();
   }
}
