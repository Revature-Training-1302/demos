package com.revature.Validator;

import com.revature.entity.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

// implement the Validator interface to make sure we can check the data to make sure it's
// "valid". And the meaning of valid is up to us.
public class AccountValidator implements org.springframework.validation.Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        // making sure we're working with an instance of the account class
        return clazz.equals(Account.class);
    }

    @Override
    // target is the object that we are verifying
    public void validate(Object target, Errors errors) {
        // check some different fields:
        // reject or throw an error if a given field is empty or is just white space
        // If the name field is empty, add an error that says the name field is empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
        Account account = (Account) target;
        if(account.getName().contains("$")) {
            errors.reject("name", "Can't contain $");
        }
        if(account.getId() < 0) {
            errors.reject("id", "Id cannot be negative");
        }
    }

    public boolean testString(String s) {
        for (int i = 0; i < s.length(); i ++) {
            int ascii = (int) s.charAt(i);
            if (ascii == 4) return false;
        }
        return true;
    }
}
