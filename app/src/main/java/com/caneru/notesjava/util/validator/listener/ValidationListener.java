package com.caneru.notesjava.util.validator.listener;

import com.caneru.notesjava.util.validator.ValidationResult;

public interface ValidationListener {

    public void onValidationPassed();
    public void onValidationFailed(String message);
    public ValidationResult checkValidation();
}
