package com.caneru.notesjava.util.validator.results;

import com.caneru.notesjava.util.validator.ValidationResult;

public class PasswordValidationResult implements ValidationResult {
    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public String getMessage() {
        return "Please enter a valid password";
    }
}
