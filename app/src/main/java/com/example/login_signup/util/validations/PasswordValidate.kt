package com.example.login_signup.util.validations

import com.example.login_signup.R
import com.example.login_signup.util.UiText

class PasswordValidate : BaseUseCase<String, ValidationResult> {
    override fun execute(input: String): ValidationResult {
        if (input.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.password_must_short_8),
            )
        }

        if (!Validations.isPasswordValid(input)) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.password_contain_least_one_letter_digit),
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}