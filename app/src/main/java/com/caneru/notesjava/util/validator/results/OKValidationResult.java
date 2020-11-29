package com.caneru.notesjava.util.validator.results;

import com.caneru.notesjava.util.validator.ValidationResult;

public class OKValidationResult implements ValidationResult {

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String getMessage() {
        return "Validation is OK";
    }
}
