package com.caneru.notesjava.util.validator.results;

import com.caneru.notesjava.util.validator.ValidationResult;

public class EmptyValidationResult implements ValidationResult {
    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public String getMessage() {
        return "Please enter a valid data";
    }
}
