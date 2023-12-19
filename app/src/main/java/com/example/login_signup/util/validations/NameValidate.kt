package com.example.login_signup.util.validations

import com.example.login_signup.R
import com.example.login_signup.util.UiText

class NameValidate : BaseUseCase<String, ValidationResult> {
    override fun execute(input: String): ValidationResult {
        if (input.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.cannot_be_blank)
            )
        }
        if (!Validations.isName(input)) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.thats_not_valid_email)
            )
        }
        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}