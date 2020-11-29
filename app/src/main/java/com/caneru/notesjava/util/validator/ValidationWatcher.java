package com.caneru.notesjava.util.validator;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.caneru.notesjava.util.validator.listener.ValidationListener;
import com.caneru.notesjava.util.validator.results.EmptyValidationResult;
import com.caneru.notesjava.util.validator.results.OKValidationResult;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ValidationWatcher implements TextWatcher {
    private Validator validator;
    private EditText editText;
    private TextInputLayout textInputLayout;

    public ValidationWatcher(String type, EditText view) {
        editText = view;
        initializeValidator(type, view.getId());
    }

    public ValidationWatcher(String type, EditText view, TextInputLayout textInputLayout) {
        editText = view;
        this.textInputLayout = textInputLayout;
        initializeValidator(type, view.getId());
    }

    private void initializeValidator(String type, int id) {
        validator = Validator.init(type, id);
        validator.setValidationListener(new ValidationListener() {
            @Override
            public void onValidationPassed() {
                //Validation Passed
            }

            @Override
            public void onValidationFailed(String message) {
                textInputLayout.setError(message);
            }

            @Override
            public ValidationResult checkValidation() {
                ValidationResult result = Validator.getValidatorById(editText.getId()).validate(editText);
                if (result.isValid()) {
                    onValidationPassed();
                    return new OKValidationResult();
                } else {
                    onValidationFailed(result.getMessage());
                }
                return new EmptyValidationResult();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (validator.validate(editable).isValid()) {
            // OK
            if (textInputLayout != null) {
                textInputLayout.setError(null);
            }
        } else {
            editText.setError(validator.validate(editable).getMessage());
        }
    }
}
