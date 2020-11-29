package com.caneru.notesjava.util.validator.results;

import com.caneru.notesjava.util.validator.ValidationResult;

public class EmailValidationResult implements ValidationResult {
    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public String getMessage() {
        return "Not a valid e-mail";
    }
}
