package com.caneru.notesjava.util.validator;

import android.widget.EditText;

import androidx.databinding.BindingAdapter;

import com.caneru.notesjava.util.validator.listener.ValidationListener;
import com.caneru.notesjava.util.validator.results.EmptyValidationResult;
import com.caneru.notesjava.util.validator.results.OKValidationResult;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class ValidationBinding {

    @BindingAdapter("caneru:validation")
    public static void setValidation(TextInputEditText view, String value) {
        Validator.init(value, view.getId()).setValidationListener(new ValidationListener() {
            @Override
            public void onValidationPassed() {
                //Validation Passed
            }

            @Override
            public void onValidationFailed(String message) {
                view.setError(message);
            }

            @Override
            public ValidationResult checkValidation() {
                ValidationResult result = Validator.getValidatorById(view.getId()).validate(view);
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

    @BindingAdapter("caneru:validationWatcher")
    public static void setValidationWatcher(EditText editText, String value) {
        editText.addTextChangedListener(new ValidationWatcher(value, editText));
    }

    @BindingAdapter("caneru:validationWatcher")
    public static void setValidationWatcher(TextInputLayout textInputLayout, String value) {
        textInputLayout.getEditText().addTextChangedListener(new ValidationWatcher(value, textInputLayout.getEditText(), textInputLayout));
    }

    @BindingAdapter("caneru:validation")
    public static void setValidation(EditText view, List<String> values) {
        Validator.init(values, view.getId()).setValidationListener(new ValidationListener() {
            @Override
            public void onValidationPassed() {

            }

            @Override
            public void onValidationFailed(String message) {
                view.setError(message);
            }

            @Override
            public ValidationResult checkValidation() {
                ValidationResult result = Validator.getValidatorById(view.getId()).validate(view);
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
}
